CREATE OR REPLACE PACKAGE                      FIN_POGC_OUTSTANDING_LISTING AS 

 
 PROCEDURE FIN_POGC_OUTSTANDING_LISTING(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );

END FIN_POGC_OUTSTANDING_LISTING;
 
 
/


CREATE OR REPLACE PACKAGE BODY                                                                                            FIN_POGC_OUTSTANDING_LISTING AS

-------------------------------------------------------------------------------------
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
-------------------------------------------------------------------------------------
  
  outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array
--	vi_StartDate	   	Varchar2(10);               -- Input to procedure
  --vi_EndDate        Varchar2(10);               -- Input to procedure
    vi_SchmCode       Varchar2(20);
    vi_SOL_ID		      Varchar2(5);		    	       -- Input to procedure
    vi_currency		    Varchar2(3);		    	       -- Input to procedure
    dd                Varchar2(20);
 
-----------------------------------------------------------------------------
-- CURSOR declaration FIN_DRAWING_SPBX CURSOR
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- CURSOR ExtractData
-----------------------------------------------------------------------------
CURSOR ExtractData (/*ci_StartDate VARCHAR2,ci_EndDate VARCHAR2,*/ci_currency VARCHAR2,ci_SchmCode VARCHAR2, ci_SOL_ID VARCHAR2) IS

select trim(dst.INSTRMNT_ALPHA) || trim(dst.INSTRMNT_NUM)  AS "PONumber",
          DST.DD_AMT AS "TranAmt",
          dst.issue_date AS "AssignDate",
          DST.ISSU_BR_CODE AS "IssueBrCode",
          DST.PAYEE_BR_CODE AS "PayeeBrCode",
          DST.PAYING_BR_CODE as "PayingBrCode" ,
          DST.DD_NUM as "DD"
from tbaadm.dst dst, tbaadm.ddc ddc 
where  trim(ddc.dd_num) = trim(dst.dd_num)
and ddc.DD_CRNCY_CODE = dst.dd_crncy_code
and ddc.tran_date =dst.issue_date
and DST.SCHM_CODE = UPPER(ci_SchmCode)
and DST.DD_STATUS = 'U'
and ddc.DD_CRNCY_CODE =UPPER(ci_currency)
and ddc.init_sol_id =ci_SOL_ID
and DST.DEL_FLG = 'N'
AND DDC.DEL_FLG = 'N'
AND DDC.BANK_ID = '01'
and dst.bank_id = '01'
ORDER BY trim(dst.INSTRMNT_ALPHA),trim(dst.INSTRMNT_NUM),dst.issue_date;

/*SELECT -- ddc.* 
 distinct 
          trim(DDC.INSTRMNT_ALPHA) || trim(DDC.INSTRMNT_NUM) || trim(DST.DD_NUM)  AS "PONumber",
          DST.DD_AMT AS "TranAmt",
          dst.issue_DATE AS "AssignDate",
          DST.ISSU_BR_CODE AS "IssueBrCode",
          DST.PAYEE_BR_CODE AS "PayeeBrCode",
          DST.PAYING_BR_CODE as "PayingBrCode",
          DST.DD_NUM
FROM      TBAADM.DDC DDC , tbaadm.dst DST
where       DST.DD_STATUS = 'U'
--AND       TRIM(DST.DD_NUM) = TRIM(DDC.DD_NUM)
AND       DST.SCHM_CODE = UPPER(ci_SchmCode)
--and       CTD.PART_TRAN_TYPE = 'C'
AND       DDC.SOL_ID = ci_SOL_ID
and dst.ISSU_BR_CODE = substr(ci_SOL_ID,1,3)
--AND       dst.SOL_ID = '30200'
AND       DST.DEL_FLG = 'N'
AND       DDC.DEL_FLG = 'N'
AND       DDC.BANK_ID = '01'
and       DDC.DD_CRNCY_CODE =upper(ci_currency)
and       dst.DD_CRNCY_CODE =upper(ci_currency)
ORDER BY DST.DD_NUM;*/



  PROCEDURE FIN_POGC_OUTSTANDING_LISTING(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 ) AS
      
    
     
      v_TranAmt             TBAADM.CTD_DTD_ACLI_VIEW.TRAN_AMT%type;
      v_PONumber            varchar(50);
      v_TranDate            TBAADM.DDC.TRAN_DATE%type;
      v_IssueBrCode         TBAADM.DST.ISSU_BR_CODE%type;
      v_PayeeBrCode         TBAADM.DST.PAYEE_BR_CODE%type;
      v_PayingBrCode        TBAADM.DST.PAYING_BR_CODE%type;
      v_BranchName          tbaadm.sol.sol_desc%type;
      v_BankAddress         varchar(200);
      v_BankPhone           TBAADM.BRANCH_CODE_TABLE.PHONE_NUM%type;
      v_BankFax             TBAADM.BRANCH_CODE_TABLE.FAX_NUM%type;
      Project_Bank_Name     varchar2(100);
      Project_Image_Name    varchar2(100);
        
        
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
    
   -- vi_StartDate  :=  outArr(0);	
   -- vi_EndDate    :=  outArr(1);  
    		
    vi_currency   :=  outArr(0);
    vi_SchmCode   :=  outArr(1);
    vi_SOL_ID     :=  outArr(2);
  
  ------------------------------------------------------------------------------------------------------------------------
  
  if( vi_currency is null or vi_SchmCode is null or vi_SOL_ID is null  ) then
        --resultstr := 'No Data For Report';
        out_rec:= ( 0 || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-'|| '-'|| '-' );
        --dbms_output.put_line(out_rec);
        out_retCode:= 1;
        RETURN;        
  end if;
  
  
  ---------------------------------------------------------------------------------------------------------------
   
      IF vi_SchmCode = 'Gift Cheque' then
      vi_SchmCode := 'DDGC';
      END IF;
      IF vi_SchmCode = 'Payment Order' then
      vi_SchmCode := 'DDPO';
      END IF;
   
       IF NOT ExtractData%ISOPEN THEN
        --{
          BEGIN
          --{
            OPEN ExtractData ( vi_currency,vi_SchmCode,	vi_SOL_ID);
          --}
          END;
    
        --}
        END IF;
        
        IF ExtractData%ISOPEN THEN
        --{
          FETCH	ExtractData
          INTO	 v_PONumber,v_TranAmt,v_TranDate,v_IssueBrCode,v_PayeeBrCode,v_PayingBrCode,dd;
          
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
        
  -- GET BANK INFORMATION
-------------------------------------------------------------------------------
       BEGIN
       SELECT 
       sol.sol_desc,sol.addr_1 || sol.addr_2 || sol.addr_3,bct.PHONE_NUM, bct.FAX_NUM
       into
       v_BranchName, v_BankAddress, v_BankPhone, v_BankFax
         FROM
        tbaadm.sol,tbaadm.bct 
        WHERE sol.SOL_ID = vi_SOL_ID  ------branch_code 
        AND bct.br_code = sol.br_code
        and bct.bank_code = '112';
        EXCEPTION   
        WHEN NO_DATA_FOUND THEN
          v_BranchName   := '' ;
          v_BankAddress  := '' ;
          v_BankPhone    := '' ;
          v_BankFax      := '' ;
   END;
--------------------------------------------------------------------------------  

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
    
    
    -----------------------------------------------------------------------------------
    -- out_rec variable retrieves the data to be sent to LST file with pipe seperation
    ------------------------------------------------------------------------------------
    out_rec:=	(
          v_TranAmt              || '|' ||
          v_PONumber             || '|' ||
          to_char(to_date(v_TranDate,'dd/Mon/yy'), 'dd/MM/yyyy')      || '|' ||
          v_IssueBrCode          || '|' ||
          v_PayeeBrCode          || '|' ||
          v_PayingBrCode         || '|' ||
          v_BranchName	         || '|' ||
					v_BankAddress      	   || '|' ||
					v_BankPhone            || '|' ||
          v_BankFax              || '|' ||
          Project_Bank_Name      || '|' ||
          Project_Image_Name
          );
  
			dbms_output.put_line(out_rec);
      
  END FIN_POGC_OUTSTANDING_LISTING;

END FIN_POGC_OUTSTANDING_LISTING;
/
