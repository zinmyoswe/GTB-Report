CREATE OR REPLACE PACKAGE                                                  FIN_ACCOUNT_CLOSE_LISTING AS 

 PROCEDURE FIN_ACCOUNT_CLOSE_LISTING(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );

END FIN_ACCOUNT_CLOSE_LISTING;
 
/


CREATE OR REPLACE PACKAGE BODY                                                                                                                            FIN_ACCOUNT_CLOSE_LISTING AS


-------------------------------------------------------------------------------------
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
-------------------------------------------------------------------------------------
  
  outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array
	vi_currency	   	Varchar2(3);              -- Input to procedure
	vi_startDate		Varchar2(10);		    	    -- Input to procedure
  vi_endDate		  Varchar2(10);		    	    -- Input to procedure
  vi_branchCode		Varchar2(5);		    	    -- Input to procedure
  vi_SchemeType		Varchar2(3);		    	    -- Input to procedure
  vi_SchemCode    Varchar2(10);

    
-----------------------------------------------------------------------------
-- CURSOR declaration FIN_DRAWING_SPBX CURSOR
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- CURSOR ExtractData
-----------------------------------------------------------------------------
CURSOR ExtractData (	
			ci_startDate VARCHAR2, ci_endDate VARCHAR2, ci_branchCode VARCHAR2, 
      ci_SchemeType VARCHAR2,ci_currency VARCHAR2,ci_SchemCode VARCHAR2)
  IS
 SELECT
   GENERAL_ACCT_MAST_TABLE.FORACID as "AccountNumber" , 
   GENERAL_ACCT_MAST_TABLE.ACCT_NAME as "AccountName" , 
   GENERAL_ACCT_MAST_TABLE.ACCT_CLS_DATE as "CloseDate" 
 
from 
   TBAADM.GENERAL_ACCT_MAST_TABLE GENERAL_ACCT_MAST_TABLE 
where
   GENERAL_ACCT_MAST_TABLE.ACCT_CLS_DATE >= TO_DATE( CAST ( ci_startDate AS VARCHAR(10) ) , 'dd-MM-yyyy' ) 
   and GENERAL_ACCT_MAST_TABLE.ACCT_CLS_DATE <= TO_DATE( CAST ( ci_endDate AS VARCHAR(10) ) , 'dd-MM-yyyy' ) 
   and GENERAL_ACCT_MAST_TABLE.SCHM_TYPE = UPPER(ci_SchemeType)
   and GENERAL_ACCT_MAST_TABLE.SOL_ID = ci_branchCode
   and GENERAL_ACCT_MAST_TABLE.DEL_FLG = 'N' 
   and GENERAL_ACCT_MAST_TABLE.SCHM_CODE = Upper(ci_SchemCode)
   --and (GENERAL_ACCT_MAST_TABLE.ACCT_CLS_FLG = 'Y' or GENERAL_ACCT_MAST_TABLE.DEL_FLG is not null) --Corrected by MHKK
   and GENERAL_ACCT_MAST_TABLE.acct_cls_date is not null
   and GENERAL_ACCT_MAST_TABLE.Bank_id = '01'
   and GENERAL_ACCT_MAST_TABLE.ACCT_CRNCY_CODE =UPPER(ci_currency )

order by 
   GENERAL_ACCT_MAST_TABLE.ACCT_CLS_DATE asc,GENERAL_ACCT_MAST_TABLE.FORACID ASC;
   
-----------------------------------------------------------------------------
-- CURSOR ExtractData
-----------------------------------------------------------------------------
CURSOR ExtractDataCode (	
			ci_startDate VARCHAR2, ci_endDate VARCHAR2, ci_branchCode VARCHAR2, 
      ci_SchemeType VARCHAR2,ci_currency VARCHAR2)
  IS
 SELECT
   GENERAL_ACCT_MAST_TABLE.FORACID as "AccountNumber" , 
   GENERAL_ACCT_MAST_TABLE.ACCT_NAME as "AccountName" , 
   GENERAL_ACCT_MAST_TABLE.ACCT_CLS_DATE as "CloseDate" 
 
from 
   TBAADM.GENERAL_ACCT_MAST_TABLE GENERAL_ACCT_MAST_TABLE 
where
   GENERAL_ACCT_MAST_TABLE.ACCT_CLS_DATE >= TO_DATE( CAST ( ci_startDate AS VARCHAR(10) ) , 'dd-MM-yyyy' ) 
   and GENERAL_ACCT_MAST_TABLE.ACCT_CLS_DATE <= TO_DATE( CAST ( ci_endDate AS VARCHAR(10) ) , 'dd-MM-yyyy' ) 
   and GENERAL_ACCT_MAST_TABLE.SCHM_TYPE = UPPER(ci_SchemeType)
   and GENERAL_ACCT_MAST_TABLE.SOL_ID = ci_branchCode
   and GENERAL_ACCT_MAST_TABLE.DEL_FLG = 'N' 
   --and (GENERAL_ACCT_MAST_TABLE.ACCT_CLS_FLG = 'Y' or GENERAL_ACCT_MAST_TABLE.DEL_FLG is not null)--Corrected by MHKK
    and GENERAL_ACCT_MAST_TABLE.acct_cls_date is not null
   and GENERAL_ACCT_MAST_TABLE.Bank_id = '01'
   and GENERAL_ACCT_MAST_TABLE.ACCT_CRNCY_CODE =UPPER(ci_currency )

order by 
   GENERAL_ACCT_MAST_TABLE.ACCT_CLS_DATE asc,GENERAL_ACCT_MAST_TABLE.FORACID ASC;
   
   
  PROCEDURE FIN_ACCOUNT_CLOSE_LISTING(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 ) AS
      
      v_AccountNumber  TBAADM.GENERAL_ACCT_MAST_TABLE.FORACID%type;
      v_AccountName TBAADM.GENERAL_ACCT_MAST_TABLE.ACCT_NAME%type;
      v_CloseDate Date;
    v_BranchName tbaadm.sol.sol_desc%type;
    v_BankAddress varchar(200);
    v_BankPhone TBAADM.BRANCH_CODE_TABLE.PHONE_NUM%type;
    v_BankFax TBAADM.BRANCH_CODE_TABLE.FAX_NUM%type;
      Project_Bank_Name      varchar2(100);
     Project_Image_Name     varchar2(100);
      
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
    
    vi_startDate  :=outArr(0);		
    vi_endDate    :=outArr(1);		    	
    vi_SchemeType	:=outArr(2);	
    vi_SchemCode  :=outArr(3);
    vi_currency   :=outArr(4);
    vi_branchCode :=outArr(5);
  -----------------------------------------------------------------------------------------------------------------
  
   if( vi_startDate is null or vi_endDate is null or vi_SchemeType is null or vi_currency is null or vi_branchCode
   is null ) then
        --resultstr := 'No Data For Report';
        out_rec:= ( '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-'  );
        --dbms_output.put_line(out_rec);
        out_retCode:= 1;
        RETURN;        
  end if;

  
  ---------------------------------------------------------------------------------------------------------------------
 
    
     IF vi_SchemCode IS NULL OR vi_SchemCode = '' THEN
     --{
          IF NOT ExtractDataCode%ISOPEN THEN
          --{
            BEGIN
            --{
              OPEN ExtractDataCode (	
            vi_startDate , vi_endDate  , vi_branchCode , 
            vi_SchemeType ,vi_currency);
            --}
            END;
      
          --}
          END IF;
          
          IF ExtractDataCode%ISOPEN THEN
          --{
            FETCH	ExtractDataCode
            INTO	v_AccountNumber, 
                  v_AccountName ,v_CloseDate ;
            
      
            ------------------------------------------------------------------
            -- Here it is checked whether the cursor has fetched
            -- something or not if not the cursor is closed
            -- and the out ret code is made equal to 1
            ------------------------------------------------------------------
            IF ExtractDataCode%NOTFOUND THEN
            --{
              CLOSE ExtractDataCode;
              out_retCode:= 1;
              RETURN;
            --}
            END IF;
          --}
          END IF;
      
      ELSE 
        
        --{
          IF NOT ExtractData%ISOPEN THEN
          --{
            BEGIN
            --{
              OPEN ExtractData (	
            vi_startDate , vi_endDate  , vi_branchCode , 
            vi_SchemeType ,vi_currency,vi_SchemCode);
            --}
            END;
      
          --}
          END IF;
          
          IF ExtractData%ISOPEN THEN
          --{
            FETCH	ExtractData
            INTO	v_AccountNumber, 
                  v_AccountName ,v_CloseDate ;
            
      
            ------------------------------------------------------------------
            -- Here it is checked whether the cursor has fetched
            -- something or not if not the cursor is closed
            -- and the out ret code is made equal to 1
            ------------------------------------------------------------------
            IF ExtractData%NOTFOUND THEN
            --{
            BEGIN
        
                 INSERT INTO CUSTOM.CUST_REPORT_LOG (userid,parameter1,parameter2,parameter3,parameter4,parameter5,parameter6,printeddate,flag01,reportname)
                 VALUES('',outArr(0),outArr(1),outArr(2),outArr(3),outArr(4),outArr(5),sysdate,out_retCode,'FIN_ACCOUNT_ClOSE_LISTING');
                 Exception
                   when others then
                    dbms_output.put_line('No Tables'); 
           END;
         commit;
              CLOSE ExtractData;
              out_retCode:= 1;
              RETURN;
            --}
            END IF;
          --}
          END IF;
         --}
      END IF;
-------------------------------------------------------------------------------
    -- GET BANK INFORMATION
-------------------------------------------------------------------------------
 BEGIN
  SELECT sol.sol_desc,sol.addr_1 || sol.addr_2 || sol.addr_3,bct.PHONE_NUM, bct.FAX_NUM
   into  v_BranchName, v_BankAddress, v_BankPhone, v_BankFax
   FROM tbaadm.sol,tbaadm.bct 
   WHERE sol.SOL_ID = vi_BranchCode 
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
------------------------------------------------------------------------------- 

-------------------------------------------------------------------------------
    -- Report Log
------------------------------------------------------------------------------- 

  BEGIN
  --dbms_output.put_line('inserted'); 
   INSERT INTO CUSTOM.CUST_REPORT_LOG (userid,parameter1,parameter2,parameter3,parameter4,parameter5,parameter6,printeddate,flag01,reportname)
   VALUES('',outArr(0),outArr(1),outArr(2),outArr(3),outArr(4),outArr(5),sysdate,out_retCode,'FIN_ACCOUNT_CLOSE_LISTING');
   Exception
   when others then
    dbms_output.put_line('There is no Table'); 
    --create table
  
  END;
  
   commit;
--------------------------------------------------------------------------------

 
     out_rec:=	(
					v_AccountNumber         || '|' ||  
					v_AccountName      			|| '|' ||
           to_char(to_date(v_CloseDate,'dd/Mon/yy'), 'dd/MM/yyyy')      			|| '|' ||
					v_BranchName	          || '|' ||
					v_BankAddress      			|| '|' ||
					v_BankPhone             || '|' ||
          v_BankFax                || '|' ||
          Project_Bank_Name        || '|' ||
          Project_Image_Name);
  
			dbms_output.put_line(out_rec);
 
  END FIN_ACCOUNT_CLOSE_LISTING;

END FIN_ACCOUNT_CLOSE_LISTING;
/
