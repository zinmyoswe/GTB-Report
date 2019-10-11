CREATE OR REPLACE PACKAGE                      FIN_DRAWING_ENCASH_SUMMARY AS 
PROCEDURE FIN_DRAWING_ENCASH_SUMMARY(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );

END FIN_DRAWING_ENCASH_SUMMARY;
/


CREATE OR REPLACE PACKAGE BODY                                                                                                                                                                  FIN_DRAWING_ENCASH_SUMMARY AS

-------------------------------------------------------------------------------------
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
-------------------------------------------------------------------------------------
  
  outArr			tbaadm.basp0099.ArrayType;   -- Input Parse Array
	vi_TranDate	   	Varchar2(20);              -- Input to procedure
	vi_other_bank		Varchar2(30);		    	     -- Input to procedure
-------------------------------------------------------------------------------
    -- GET Remittance Information
-------------------------------------------------------------------------------

Cursor ExtractData(ci_TranDate Varchar2 ,ci_other_bank Varchar2)
IS
select case when Drawing.Drawing_id is null then 0 else Drawing.Drawing_id end as Drawing_id,
       case when Encash.Encash_id is null then 0 else Encash.Encash_id end as Encash_id,
       sol.sol_id,sol.sol_desc,
       Drawing.Drawing_Amount,
       Encash.Encash_Amount,
       Drawing.Commission
from 
(select sol_id,sol_desc from tbaadm.sol sol where sol.bank_code ='116')sol
left join
(select count(ctd.tran_id) as Drawing_id,
        ctd.dth_init_sol_id as SOL_ID,
        sum(ctd.tran_amt) as Drawing_Amount,
        sum(CXL.ACTUAL_AMT_COLL) as Commission
      
from 
    CUSTOM.custom_ctd_dtd_acli_view ctd,TBAADM.CXL cxl
where
    ctd.tran_date = TO_DATE(ci_TranDate, 'dd-MM-yyyy' )
    and (ctd.tran_sub_type = 'RI' or ctd.tran_sub_type = 'CI')
    and  ctd.rpt_code in ('IBREM','REMIT','REMIB') --REMIB 
    and ctd.bank_code = ci_other_bank
    and ((ctd.branch_code = cxl.event_id and (cxl.chrg_rpt_code='COMCH' or cxl.chrg_rpt_code is null)) or cxl.event_id = 'ZERO')
    and ctd.dth_init_sol_id !='20300'
    and ctd.vfd_user_id is not null
    and ctd.pstd_user_id is not null
    AND trim(cxl.CHRG_TRAN_ID)  = trim(ctd.TRAN_ID)
    AND cxl.CHRG_TRAN_DATE = ctd.TRAN_DATE
    and cxl.chrg_acid in (select acid from tbaadm.gam where gam.sol_id ='10100')
    and (trim(ctd.tran_id),ctd.tran_date,trim(ctd.part_tran_srl_num)) NOT IN (select trim(CONT_TRAN_ID),atd.cont_tran_date,trim(atd.cont_part_tran_srl_num) 
        from TBAADM.ATD atd
        where atd.cont_tran_date = TO_DATE(ci_TranDate, 'dd-MM-yyyy' ) )
  group by ctd.dth_init_sol_id
--order by sol.br_open_date,ctd.dth_init_sol_id
union all 
select count(ctd.tran_id) as Drawing_id,
      ctd.dth_init_sol_id as SOL_ID,
      sum(ctd.tran_amt) as Drawing_Amount,
      sum(CXL.ACTUAL_AMT_COLL) as Commission
      
from 
    CUSTOM.custom_ctd_dtd_acli_view ctd,TBAADM.CXL cxl
where
    ctd.tran_date = TO_DATE(ci_TranDate, 'dd-MM-yyyy' )
    and (ctd.tran_sub_type = 'BI' or ctd.tran_sub_type = 'RI')
    and  ctd.rpt_code in ('IBREM','REMIT','REMIB') --REMIB 
    and ctd.bank_code = ci_other_bank
    and(((cxl.chrg_rpt_code='COMCH' or cxl.chrg_rpt_code is null) and (cxl.tran_rmks ='OTHER BANK' or  cxl.tran_rmks ='Other Bank')) or cxl.event_id = 'ZERO')
    and ctd.dth_init_sol_id ='20300'
    and ctd.vfd_user_id is not null
    and ctd.pstd_user_id is not null
    AND trim(cxl.CHRG_TRAN_ID)  = trim(ctd.TRAN_ID)
    AND cxl.CHRG_TRAN_DATE = ctd.TRAN_DATE
    and (cxl.chrg_acid in (select acid from tbaadm.gam where gam.sol_id ='20300') or cxl.chrg_acid in (select acid from tbaadm.gam where gam.sol_id ='10100'))
    and (trim(ctd.tran_id),ctd.tran_date,trim(ctd.part_tran_srl_num)) NOT IN (select trim(CONT_TRAN_ID),atd.cont_tran_date,trim(atd.cont_part_tran_srl_num) 
        from TBAADM.ATD atd
        where atd.cont_tran_date = TO_DATE(ci_TranDate, 'dd-MM-yyyy' )  )
  group by ctd.dth_init_sol_id)Drawing
on Drawing.sol_id = sol.sol_id
left join
(select count(ctd.tran_id) as Encash_id,
      ctd.dth_init_sol_id as SOL_ID,
      sum(ctd.tran_amt) as Encash_Amount
      
from 
    CUSTOM.custom_ctd_dtd_acli_view ctd
where
   ctd.tran_date = TO_DATE(ci_TranDate, 'dd-MM-yyyy' )
    and (ctd.tran_sub_type = 'BI' or ctd.tran_sub_type = 'CI')
    and  ctd.rpt_code in ('IBREM','REMIB')
    and ctd.bank_code = ci_other_bank
    and ctd.part_tran_type='C'
    and ctd.dth_init_sol_id !='20300'
    and ctd.uad_module_key is not null
   and ctd.uad_module_id is not null
    and (trim(ctd.tran_id),ctd.tran_date,trim(ctd.part_tran_srl_num)) NOT IN (select trim(CONT_TRAN_ID),atd.cont_tran_date,trim(atd.cont_part_tran_srl_num) 
        from TBAADM.ATD atd
        where atd.cont_tran_date = TO_DATE(ci_TranDate, 'dd-MM-yyyy' ) )
  group by ctd.dth_init_sol_id
union all
select count(ctd.tran_id) as Encash_id,
      ctd.dth_init_sol_id as SOL_ID,
      sum(ctd.tran_amt) as Encash_Amount
      
from 
    CUSTOM.custom_ctd_dtd_acli_view ctd
where
    ctd.tran_date = TO_DATE(ci_TranDate, 'dd-MM-yyyy' )
    and ctd.part_tran_type = 'D'
    and  ctd.rpt_code in ('IBREM','REMIB')
    and ctd.bank_code = ci_other_bank
    and ctd.dth_init_sol_id ='20300'
    and ctd.uad_module_key is not null
   and ctd.uad_module_id is not null
    and (trim(ctd.tran_id),ctd.tran_date,trim(ctd.part_tran_srl_num)) NOT IN (select trim(CONT_TRAN_ID),atd.cont_tran_date,trim(atd.cont_part_tran_srl_num) 
        from TBAADM.ATD atd
        where atd.cont_tran_date = TO_DATE(ci_TranDate, 'dd-MM-yyyy' )  )
  group by ctd.dth_init_sol_id) Encash
on Encash.sol_id = sol.sol_id
order by sol.sol_desc;

  PROCEDURE FIN_DRAWING_ENCASH_SUMMARY(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 ) AS
-------------------------------------------------------------
	--Variable declaration
-------------------------------------------------------------
    v_drawing_Count CUSTOM.custom_ctd_dtd_acli_view.tran_id%type;
    v_Encash_Count CUSTOM.custom_ctd_dtd_acli_view.tran_id%type;
    v_sol_id  tbaadm.sol.sol_id%type;
    v_AGD_BR_name tbaadm.sol.sol_desc%type;
    v_drawing_amt CUSTOM.custom_ctd_dtd_acli_view.tran_amt%type;
    v_Encash_amt CUSTOM.custom_ctd_dtd_acli_view.tran_amt%type;
    v_Commission TBAADM.CXL.ACTUAL_AMT_COLL%type;
    Project_Bank_Name   varchar2(100);
    Project_Image_Name  varchar2(100);
     
     BEGIN
    ------------------------------------------------------------------------------
          -- Out Ret code is the code which controls
          -- the while loop,it can have values 0,1
          -- 0 - The while loop is being executed
          -- 1 - Exit
  ------------------------------------------------------------------------------
		out_retCode := 0;
		out_rec := NULL;
    
    tbaadm.basp0099.formInputArr(inp_str, outArr);    
  ------------------------------------------------------------------------------
		-- Parsing the i/ps from the string
	------------------------------------------------------------------------------
     vi_TranDate := outArr(0);
     vi_other_bank := outArr(1);
     -----------------------------------------------------------------------------
     
     if( vi_TranDate is null or vi_other_bank is null) then
        --resultstr := 'No Data For Report';
        out_rec:= ( 0 || '|' || 0 || '|' || '-' || '|' || '-' || '|' || 0 || '|' || 0 || '|' || 0);
		
        --dbms_output.put_line(out_rec);
        out_retCode:= 1;
        RETURN;        
  end if;
     
     ---------------------------------------------------------------------------------
     IF vi_other_bank ='KBZ' then
       vi_other_bank := '109';
    ELSIf vi_other_bank ='AYA' then
        vi_other_bank := '117';
    ELSIf vi_other_bank ='AGD' then
        vi_other_bank := '116';
    ELSIf vi_other_bank ='MWD' then
        vi_other_bank := '104';
    ELSIf vi_other_bank ='CB' then
        vi_other_bank := '115';
    ELSIf vi_other_bank ='SMIDB' then
        vi_other_bank := '111';
    ELSIf vi_other_bank ='RDB' then
        vi_other_bank := '113';
    ELSIf vi_other_bank ='CHDB' then
        vi_other_bank := '121';
    ELSIf vi_other_bank ='Innwa' then
        vi_other_bank := '114';
    ELSIf vi_other_bank ='Shwe' then
        vi_other_bank := '123';
    ELSIf vi_other_bank ='MABL' then
        vi_other_bank := '118';
    ELSIf vi_other_bank ='May(MALAYSIA)' then
        vi_other_bank := 'MY02';
    ELSIf vi_other_bank ='May(SINGAPORE)' then
        vi_other_bank := 'MY01';
    ELSIf vi_other_bank ='UOB' then
        vi_other_bank := 'UO01';
    ELSIf vi_other_bank ='DBS' then
        vi_other_bank := 'DB01';
    ELSIf vi_other_bank ='BKK' then
        vi_other_bank := 'BK03';
    ELSIf vi_other_bank ='OCBC' then
        vi_other_bank := 'OC01';
    ELSIf vi_other_bank ='SIAM' then
        vi_other_bank := 'SC03';
    ELSE 
        vi_other_bank := '' ;
    END IF;
    
     IF NOT ExtractData%ISOPEN THEN
        --{
          BEGIN
          --{
            OPEN ExtractData (vi_TranDate, vi_other_bank );
          --}      
          END;
        --}
        END IF;
      
        IF ExtractData%ISOPEN THEN
        --{
          FETCH	ExtractData
          INTO  v_drawing_Count, v_Encash_Count, v_sol_id, v_AGD_BR_name,v_drawing_amt,v_Encash_amt,v_Commission;
      ------------------------------------------------------------------------------
          -- Here it is checked whether the cursor has fetched
          -- something or not if not the cursor is closed
          -- and the out ret code is made equal to 1
      ------------------------------------------------------------------------------
          IF ExtractData%NOTFOUND THEN
          --{
            CLOSE ExtractData;
            out_retCode:= 1;
            RETURN;
          --}
          END IF;
        --}
        END IF;
-------------------------------------------------------------------------------
    -- GET BANK NAME AND IMAGE NAME 
------------------------------------------------------------------------------- 
   BEGIN 
      select  Upper(Bank_Name), lower(bank_short_name)|| '.jpg'
              into Project_Bank_Name, Project_Image_Name
      from TBAADM.bank_code_table 
      where bank_code = '112' 
      and del_flg= 'N'
      and bank_id = '01';
     EXCEPTION
      WHEN NO_DATA_FOUND THEN
          SELECT project_bank_name, project_image_name INTO Project_Bank_Name, Project_Image_Name
          FROM CUSTOM."CUST_BANK_INFO"
          where project_bank_code = '112';
   END;  
------------------------------------------------------------------------------- 
--------------------------------------------------------------------------------
-- out_rec variable retrieves the data to be sent to LST file with pipe seperation
--------------------------------------------------------------------------------

    out_rec:= (    
                   v_drawing_Count   || '|' ||
                   v_Encash_Count    || '|' || 
                   v_sol_id          || '|' ||
                   v_AGD_BR_name     || '|' ||
                   v_drawing_amt     || '|' ||
                   v_Encash_amt       || '|' || 
                   v_Commission      || '|' || 
                   Project_Bank_Name     || '|' || 
                   Project_Image_Name
               ); 
  
			dbms_output.put_line(out_rec);
     
  END FIN_DRAWING_ENCASH_SUMMARY;

END FIN_DRAWING_ENCASH_SUMMARY;
/
