CREATE OR REPLACE PACKAGE                                           FIN_BANK_GUARANTEE AS 

  PROCEDURE FIN_BANK_GUARANTEE(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );
 

END FIN_BANK_GUARANTEE;
/


CREATE OR REPLACE PACKAGE BODY 
                                                                      FIN_BANK_GUARANTEE AS
-------------------------------------------------------------------------------------
	-- VAIABLE declaration
	-- This cursor will fetch all the data based on the main query
-------------------------------------------------------------------------------------

  outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array

	vi_startDate		VARCHAR2(20);		    	    -- Input to procedure
  vi_endDate		  VARCHAR2(20);		    	    -- Input to procedure
  vi_CurrencyCode VARCHAR2(10);              -- Input to procedure
  vi_Branchcode		VARCHAR2(20);		    	    -- Input to procedure
  
  -----------------------------------------------------------------------------
-- CURSOR declaration FIN_BANK_GUARANTEE CURSOR
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- CURSOR ExtractData
--------------------------------------------------------------------------
    CURSOR ExtractData (	
			ci_start_date	    	VARCHAR2,
      ci_end_date       VARCHAR2,
      ci_CurrencyCode   VARCHAR2,
      ci_branch_code    VARCHAR2)
 
   IS 
   select bgm.issue_date as TranDate,
       bgm.BG_SRL_Num as GteeNo,
       (select acct_name from tbaadm.gam gam where gam.acid = bgm.oper_acid and gam.bank_id = '01' and gam.entity_cre_flg = 'Y')
       as ApplicantName,
       fat.name as BeneName,
       bgm.crncy_code as Currency,
       bgm.bg_amt as GteeAmt,
       bgm.bg_expiry_date as ExpiredDate,
       bgm.invocn_date as CancelDate,
       bgm.bg_perd_mths || 'M'as GteePeriod
 
       
from   tbaadm.bgm bgm, tbaadm.tfat fat
where  bgm.bg_b2kid = fat.addr_b2kid
and    bgm.rcre_time = fat.rcre_time
and    bgm.issue_date >= TO_DATE(cast(ci_start_date as VARCHAR2(20)),'dd-MM-yyyy')
and    bgm.issue_date <= TO_DATE(cast(ci_end_date as VARCHAR2(20)),'dd-MM-yyyy')
and    bgm.sol_id  LIKE '%' || ci_branch_code || '%' 
and    fat.name is not null
and    fat.addr_id  = 'BGOTPY'
and    fat.addr_type = 'S'
and    bgm.bank_id = '01'
and    bgm.crncy_code= upper(ci_CurrencyCode)
and    bgm.entity_cre_flg = 'Y';
----------------------------------------------------------------------------------------------

  PROCEDURE FIN_BANK_GUARANTEE(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 ) AS

      TranDate              VARCHAR2(20);
      GteeNo                VARCHAR2(100);
      ApplicantName         VARCHAR2(200);
      BeneName              VARCHAR2(200);
      Currency              VARCHAR2(20);
      GteeAmt               Number(20,2);
      ExpiredDate           VARCHAR2(20);
      CancelDate            VARCHAR2(20);
      GteePeriod            VARCHAR2(20);
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
    
  
     vi_startDate     := outArr(0);
     vi_endDate  	    :=outArr(1);
     vi_CurrencyCode  :=outArr(2);
     vi_BranchCode    :=outArr(3); 
  --------------------------------------------------------------------

     IF NOT ExtractData%ISOPEN THEN 
		  	BEGIN
		
				  OPEN ExtractData (	vi_startDate,vi_endDate,vi_CurrencyCode,vi_branchCode);
        END;	
		 END IF;
        -----------------------------------------------------
		-- Checking whether the cursor is open if not
		-- it is opened
		-----------------------------------------------------
    ----------------------for other Branch---------------------------
 if vi_BranchCode is null or vi_BranchCode ='' then
        vi_BranchCode := '';
  end if;
  ------------------------------------------------------

     IF ExtractData%ISOPEN THEN                             
			 FETCH	ExtractData
       INTO	 TranDate, 
            GteeNo,
            ApplicantName,
            BeneName,
            Currency,
            GteeAmt,
            ExpiredDate,
            CancelDate,
            GteePeriod;
      

			------------------------------------------------------------------
			-- Here it is checked whether the cursor has fetched
			-- something or not if not the cursor is closed
			-- and the out ret code is made equal to 1
			------------------------------------------------------------------
			   IF ExtractData%NOTFOUND THEN 
				 CLOSE ExtractData;
			  	out_retCode:= 1;
			  	RETURN;
		
		   	END IF;	  
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
 
      out_rec:=	(
                              
          TranDate   			      || '|' ||
					GteeNo              	|| '|' ||
          ApplicantName         || '|' ||
          BeneName      		    || '|' ||
					Currency	            || '|' ||
          GteeAmt               || '|' ||
          ExpiredDate           || '|' ||
          CancelDate            || '|' ||
          GteePeriod            || '|' ||
          v_BranchName	        || '|' ||
					v_BankAddress      	  || '|' ||
					v_BankPhone           || '|' ||
          v_BankFax             || '|' ||
          Project_Bank_Name     || '|' ||
          Project_Image_Name
         );
  
			dbms_output.put_line(out_rec);
      
  END FIN_BANK_GUARANTEE;

END FIN_BANK_GUARANTEE;
/
