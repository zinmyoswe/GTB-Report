CREATE OR REPLACE PACKAGE        FIN_LG_STAT_DOMESTIC_UPDATE AS 

   PROCEDURE FIN_LG_STAT_DOMESTIC_UPDATE(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );

END FIN_LG_STAT_DOMESTIC_UPDATE;
/


CREATE OR REPLACE PACKAGE BODY                                                                                                                                                                         FIN_LG_STAT_DOMESTIC_UPDATE AS

-------------------------------------------------------------------------------------
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
-------------------------------------------------------------------------------------
  --3021210106578
  outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array

	vi_startDate		Varchar2(10);		    	    -- Input to procedure
  vi_endDate		  Varchar2(10);		    	    -- Input to procedure
  vi_AccountNo		Varchar2(25);		    	    -- Input to procedure
  vi_currency	   	Varchar2(3);               -- Input to procedure
  vi_branchcode  Varchar2(5);                -- Input to procedure
  
  v_cur Varchar2(20);
  v_rate decimal(18,2);
  num number;
  dobal custom.CUSTOM_CTD_DTD_ACLI_VIEW.tran_amt%type := 0;		    	  
  result_rec Varchar2(30000);
  OpeningAmount custom.CUSTOM_CTD_DTD_ACLI_VIEW.TRAN_AMT%type;
  OpenDate		Varchar2(10);		
  rate decimal(18,2);
   


-----------------------------------------------------------------------------
-- CURSOR ExtractData
-----------------------------------------------------------------------------
CURSOR ExtractData (ci_startDate VARCHAR2, ci_endDate VARCHAR2, ci_AccountNo VARCHAR2,ci_currency VARCHAR2,ci_SOL_ID varchar2)  IS
  select *
   from (
       select    TO_DATE( CAST ( OpenDate AS VARCHAR(10) ) , 'dd-Mon-yy' ) as tran_date,
                '' as tran_id,
                'Opening Balance' as tran_particular,
                 OpeningAmount as aa,
                 null as CrAmt,
                 null as dramt,
                 nvl((SELECT r.VAR_CRNCY_UNITS 
                                      FROM TBAADM.RTH r
                                      where trim(r.fxd_crncy_code) = trim(ci_currency) and r.Rtlist_date = TO_DATE( CAST (  OpenDate  AS VARCHAR(10) ) , 'dd-Mon-yy' )
                                      and  r.RATECODE = 'NOR'
                                      and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                      and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                            FROM TBAADM.RTH a
                                                                            where a.Rtlist_date = TO_DATE( CAST (  OpenDate  AS VARCHAR(10) ) , 'dd-Mon-yy' )
                                                                            and  a.RATECODE = 'NOR'
                                                                            and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                            group by a.fxd_crncy_code
                                          )),0.00) as rate,
                 null  as tellerNo,
                 null  as currency,
                 null as brname,
                 null as foracid,
                 0 as ForSort
         from    dual
        
  union all
   
  select   t.tran_date,
           trim(t.tran_id) as tran_id, 
           t.tran_particular   as tran_particular,
           case t.part_tran_type when 'C' then (sldomestic_essential.CUSTOM_DOBAMOUNT(t.part_tran_type,t.cr_amt)) else(sldomestic_essential.CUSTOM_DOBAMOUNT(t.part_tran_type,t.dr_amt)) end as aa,
           case t.part_tran_type when 'C' then t.cr_amt else 0 end as CrAmt,
           case t.part_tran_type when 'D' then t.Dr_amt else 0 end as drAmt,
           T.rate ,
           t.tellerNo,
           T.Currency,
            t.abbr_br_name,
           T.FORACID,
          rownum as ForSort
  from (
      select q.tran_date ,
             q.tran_id , 
             q.tran_particular,
             q.part_tran_type,
             sum(q.CR_amt)      as cr_amt,
             sum(q.DR_amt)      as dr_amt,
             q.rate ,
             q.tellerNo,
             q.Currency,
             q.abbr_br_name,
             q.foracid
        from
        (select 
              cdav.tran_date ,
              cdav.tran_id ,
              cdav.tran_particular,
              CDAV.part_tran_type,
              case cdav.part_tran_type when 'C' then cdav.tran_amt else 0 end as CR_amt,
              case cdav.part_tran_type when 'D' then cdav.tran_amt else 0 end as DR_amt,
              nvl((SELECT r.VAR_CRNCY_UNITS 
                                      FROM TBAADM.RTH r
                                      where trim(r.fxd_crncy_code) = trim(cdav.TRAN_CRNCY_CODE) and r.Rtlist_date = TO_DATE( CAST (  cdav.tran_date  AS VARCHAR(10) ) , 'dd-Mon-yy' )
                                      and  r.RATECODE = 'NOR'
                                      and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                      and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                            FROM TBAADM.RTH a
                                                                            where a.Rtlist_date = TO_DATE( CAST (  cdav.tran_date  AS VARCHAR(10) ) , 'dd-Mon-yy' )
                                                                            and  a.RATECODE = 'NOR'
                                                                            and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                            group by a.fxd_crncy_code
                                          )),0.00) as rate,
             cdav.entry_user_id  as tellerNo,
             cdav.TRAN_CRNCY_CODE as Currency,
            (select sol.sol_desc from tbaadm.upr,tbaadm.sol where sol.sol_id = upr.sol_id and upr.user_id = cdav.entry_user_id) as abbr_br_name,
            gam.foracid
        from 
        tbaadm.general_acct_mast_table gam,custom.CUSTOM_CTD_DTD_ACLI_VIEW cdav,tbaadm.sol sol
        where 
        gam.acid = cdav.acid
        and gam.sol_id = sol.sol_id
        and cdav.sol_id = sol.sol_id
        and gam.gl_sub_head_code = trim(ci_AccountNo)
        and gam.gl_sub_head_code = cdav.gl_sub_head_code
        and cdav.tran_date between TO_DATE( ci_startDate, 'dd-MM-yyyy' ) 
        and TO_DATE(ci_endDate, 'dd-MM-yyyy' )
        and cdav.TRAN_CRNCY_CODE= Upper(ci_currency )
        and gam.acct_crncy_code = upper(ci_currency)
        and gam.del_flg != 'Y'
        and cdav.del_flg = 'N'
        and gam.sol_id  like   '%' || ci_SOL_ID || '%'
        and cdav.sol_id  like   '%' ||ci_SOL_ID || '%'
        --and gam.acct_cls_flg != 'Y'
        and gam.bank_id ='01'
        and gam.sol_id = cdav.sol_id
        and (trim (cdav.tran_id),cdav.tran_date,trim(cdav.part_tran_srl_num)) NOT IN (select trim(CONT_TRAN_ID),cont_tran_date,trim(cont_part_tran_srl_num) from TBAADM.ATD atd
          where atd.cont_tran_date >= TO_DATE(ci_startDate, 'dd-MM-yyyy' ) 
         and atd.cont_tran_date <= TO_DATE(ci_endDate, 'dd-MM-yyyy' ) )
        ) q
        group by q.tran_id,  q.rate,q.tran_particular,q.part_tran_type, q.tellerNo, q.tran_date,q.abbr_br_name,q.foracid,q.currency
        order by q.tran_date,q.tran_id
      )t
      order by ForSort,tran_date,tran_id
  )t
  order by t.forsort
           ;       

---------------------------------------------------------------------------------------------
 
  PROCEDURE FIN_LG_STAT_DOMESTIC_UPDATE(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 ) AS
      
    v_tran_id TBAADM.CTD_DTD_ACLI_VIEW.tran_id%type;
    v_tran_date TBAADM.CTD_DTD_ACLI_VIEW.tran_date%type;
    v_tran_amt TBAADM.CTD_DTD_ACLI_VIEW.tran_amt%type;
    v_tran_amt_mmk TBAADM.CTD_DTD_ACLI_VIEW.tran_amt%type;
    v_teller_no TBAADM.CTD_DTD_ACLI_VIEW.entry_user_id%type;
    v_part_tran_type TBAADM.CTD_DTD_ACLI_VIEW.part_tran_type%type; 
    v_tran_amt_dr TBAADM.CTD_DTD_ACLI_VIEW.tran_amt%type; 
    v_tran_particular TBAADM.CTD_DTD_ACLI_VIEW.tran_particular%type;
    v_AccountNumber TBAADM.GENERAL_ACCT_MAST_TABLE.FORACID%type;
    v_AccountName TBAADM.GENERAL_ACCT_MAST_TABLE.ACCT_NAME%type;
    v_Cur TBAADM.GENERAL_ACCT_MAST_TABLE.ACCT_crncy_code%type;
    v_Address varchar2(200);
    v_Nrc CRMUSER.ACCOUNTS.UNIQUEID%type;
    v_Bal TBAADM.GENERAL_ACCT_MAST_TABLE.clr_bal_amt%type;
    v_foracid varchar2(20);
    v_PhoneNumber varchar2(50);
    v_FaxNumber varchar2(50);
    v_BranchName TBAADM.BRANCH_CODE_TABLE.BR_SHORT_NAME%type;
    v_BankAddress TBAADM.BRANCH_CODE_TABLE.BR_ADDR_1%type;
    v_BankPhone TBAADM.BRANCH_CODE_TABLE.PHONE_NUM%type;
    v_BankFax TBAADM.BRANCH_CODE_TABLE.FAX_NUM%type;
    v_sol_id  TBAADM.sol.sol_desc%type;
    v_gl_desc TBAADM.gsh.gl_sub_head_desc %type;
      Result_Flg varchar2(100);
    
  BEGIN
      -------------------------------------------------------------
          -- Out Ret code is the code which controls
          -- the while loop,it can have values 0,1
          -- 0 - The while loop is being executed
          -- 1 - Exit
        -------------------------------------------------------------
		out_retCode := 0;
		out_rec := NULL;
    
     tbaadm.basp0099.formInputArr(inp_str, outArr);
    
    --------------------------------------
		-- Parsing the i/ps from the string
		--------------------------------------
    
    vi_startDate  :=  outArr(0);		
    vi_endDate    :=  outArr(1);		
    vi_AccountNo	:=  outArr(2);
    vi_currency := outArr(3);
    vi_branchcode := outArr(4);
    
  IF vi_branchcode IS  NULL or vi_branchcode = ''  THEN
  vi_branchcode := '';
  END IF;
  --------------------------------------------------------------------
 IF vi_branchcode IS  NULL or vi_branchcode = ''  THEN
  v_gl_desc := '';
  END IF;
-----------------------------------------------------------------------------------

  begin  
    select 
     sum(cashinhand),bal_date INTO OpeningAmount,OpenDate
from 
(select    
  sum(gstt.tot_cr_bal - gstt.tot_dr_bal) as cashinhand,BAL_DATE 
from 
   TBAADM.GL_SUB_HEAD_TRAN_TABLE gstt
where gstt.BAL_DATE <= TO_DATE( vi_startDate, 'dd-MM-yyyy' )-1  --take care here
   and gstt.end_BAL_DATE >= TO_DATE( vi_startDate, 'dd-MM-yyyy' ) -1  -- take care here
   and gstt.SOL_ID like   '%' || vi_branchcode || '%'
   and (gstt.tot_cr_bal > 0 or gstt.tot_dr_bal > 0)
   and gstt.DEL_FLG = 'N' 
   and gstt.BANK_ID = '01'
   and  gstt.gl_sub_head_code = vi_AccountNo
   and gstt.crncy_code = upper(vi_currency)  group by BAL_DATE)
   group by bal_date;
   
  
   EXCEPTION
      WHEN NO_DATA_FOUND THEN
        OpeningAmount := 0.00;  
        OpenDate := '';
   end;
   
    begin
    Result_Flg := sldomestic_essential.TODAYDOBAL(OpeningAmount);
  end;
   
   
IF NOT ExtractData%ISOPEN THEN
		--{
			BEGIN
			--{
				OPEN ExtractData( vi_startDate,vi_endDate , vi_AccountNo, vi_currency , vi_branchcode) ;
			--}
			END;

		--}
		END IF;
    IF ExtractData%ISOPEN Then
      FETCH	ExtractData INTO	v_tran_date, v_tran_id,v_tran_particular,dobal,v_tran_amt,v_tran_amt_dr,
      v_rate,v_teller_no,v_cur,v_sol_id,v_foracid,num;
     	------------------------------------------------------------------
			-- Here it is checked whether the cursor has fetched
			-- something or not if not the cursor is closed
			-- and the out ret code is made equal to 1
			------------------------------------------------------------------
      IF ExtractData%NOTFOUND THEN
			--{
				CLOSE ExtractData;
				out_retCode:= 1;
				RETURN;
			--}
			END IF;   
      
		--}
    END IF;
    
   -------------------------------------------------------------------
 begin
 --if vi_branchcode is not null then
   select gl_sub_head_desc
                 into v_gl_desc 
   from tbaadm.gsh 
   where gl_sub_head_code = vi_AccountNo
    and gsh.crncy_code = vi_currency 
    and gsh.sol_id like '%' || vi_branchcode || '%'  
     and rownum =1 ;
 EXCEPTION
      WHEN NO_DATA_FOUND THEN
        v_gl_desc := 'No GL';

 --end if;
end ; 
   --------------------------------------------------------------------
   
   
     BEGIN
-------------------------------------------------------------------------------
    -- GET BANK INFORMATION
-------------------------------------------------------------------------------
   if vi_branchcode is not null then
      select 
         BRANCH_CODE_TABLE.BR_SHORT_NAME as "BranchName",
         BRANCH_CODE_TABLE.BR_ADDR_1 as "Bank_Address",
         BRANCH_CODE_TABLE.PHONE_NUM as "Bank_Phone",
         BRANCH_CODE_TABLE.FAX_NUM as "Bank_Fax"
         INTO
         v_BranchName, v_BankAddress, v_BankPhone, v_BankFax
      from
         TBAADM.SERVICE_OUTLET_TABLE SERVICE_OUTLET_TABLE ,
         TBAADM.BRANCH_CODE_TABLE BRANCH_CODE_TABLE
      where
         SERVICE_OUTLET_TABLE.SOL_ID = vi_branchcode
         and SERVICE_OUTLET_TABLE.BR_CODE = BRANCH_CODE_TABLE.BR_CODE
         and SERVICE_OUTLET_TABLE.DEL_FLG = 'N'
         and SERVICE_OUTLET_TABLE.BANK_ID = '01';
        end if; 
  END;
    
 
 
  
    -----------------------------------------------------------------------------------
    -- out_rec variable retrieves the data to be sent to LST file with pipe seperation
    ------------------------------------------------------------------------------------
    out_rec:=	(to_char(to_date(v_tran_date,'dd/Mon/yy'), 'dd/MM/yyyy')||'|' ||
          v_tran_id 	|| '|' || 
          v_tran_particular || '|' || 
          v_tran_amt 	|| '|' || 
          v_tran_amt_dr 	|| '|' || 
          dobal 	|| '|' || 
          v_rate 	|| '|' || 
          v_teller_no || '|' || 
          v_BranchName	|| '|' ||
					v_BankAddress      			|| '|' ||
					v_BankPhone || '|' ||
          v_BankFax || '|' ||
          v_cur ||'|'||
          v_sol_id ||'|'||
          v_gl_desc ||'|'||
          v_foracid);
  
			dbms_output.put_line(out_rec);
    
  END FIN_LG_STAT_DOMESTIC_UPDATE;

END FIN_LG_STAT_DOMESTIC_UPDATE;
/
