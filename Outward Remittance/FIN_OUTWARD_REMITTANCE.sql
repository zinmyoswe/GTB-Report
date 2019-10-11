CREATE OR REPLACE PACKAGE                                           FIN_OUTWARD_REMITTANCE AS 

   PROCEDURE FIN_OUTWARD_REMITTANCE(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );
END FIN_OUTWARD_REMITTANCE;
/


CREATE OR REPLACE PACKAGE BODY                                                                                                                                      FIN_OUTWARD_REMITTANCE AS

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
-- CURSOR declaration FIN_OUTWARD_REMITTANCE CURSOR
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- CURSOR ExtractData
--------------------------------------------------------------------------
    CURSOR ExtractData (	
			ci_startDate	    	VARCHAR2,
      ci_endDate          VARCHAR2,
      ci_CurrencyCode     VARCHAR2,
      ci_Branchcode       VARCHAR2)
 
   IS 
   
select cgm.collection_id        as OTTNo,
       cgm.party_name           as BOName,
       Nvl((select gam.foracid from tbaadm.gam gam where gam.acid = cgm.oper_acid),' ')            as BOAccount,
       nvl(cgm.party_addr1,' ') ||' '||  nvl(cgm.party_addr2,' ') ||' '|| nvl(cgm.party_addr3,' ') as Address,
       cgm.collection_cntry_code as currency,
       cgm.collection_amt        as Amount, 
       nvl(( select cxl.actual_amt_coll 
             from tbaadm.cxl cxl  
             where chd.tran_id = cxl.chrg_tran_id 
             and   cxl.chrg_tran_date = cgm.date_of_remit
             and  cxl.tran_rmks = 'COMMISSION'),0.00)
                                   as Income,--in (select ptt.tran_remarks from tbaadm.ptt ptt where ptt.event_type = 'FBCH' and event_id = 'TTOUS' and ptt.del_flg = 'N')
       nvl(( select cxl.actual_amt_coll 
             from tbaadm.cxl cxl  
             where chd.tran_id = cxl.chrg_tran_id 
             and   cxl.chrg_tran_date = cgm.date_of_remit
             and  cxl.tran_rmks = 'FIXED CHARG'),0.00) 
                                   as SwiftCharge,
       cgm.notl_conv_rate          as Rate,
       cgm.corr_bank_name          as BankName,
       cgm.other_party_name        as BENEName,
       nvl((select fci.account_num from tbaadm.fci fci where fci.bill_id = cgm.collection_id   ),0000000000)            as BENEAccNum,
       nvl(cgm.other_party_addr_1,' ') ||' '||  nvl(cgm.other_party_addr_2,' ') ||' '|| nvl(cgm.other_party_addr_3,' ') as OtherAddress
       from   tbaadm.cgm cgm , tbaadm.chd chd 
       where  cgm.bank_id = '01'
       and    cgm.sol_id = chd.sol_id
       and    cgm.SOL_ID  LIKE '%' || ci_Branchcode || '%'
       and    cgm.collection_id = chd.collection_id
       and    cgm.collection_code = 'TTOUS'
       and    cgm.date_of_remit >= tO_DATE( ci_startDate,'dd-MM-yyyy')
       and    cgm.date_of_remit <= tO_DATE( ci_endDate,'dd-MM-yyyy')
       and    cgm.collection_crncy LIKE '%' || upper(ci_CurrencyCode)|| '%';

  PROCEDURE FIN_OUTWARD_REMITTANCE(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 ) AS
      
      OTTNo                 VARCHAR2(100);
      BOName                VARCHAR2(200);
      BOAccount             VARCHAR2(200);         
      Address               VARCHAR2(200);
      currency              VARCHAR2(200);
      Amount                Number(20,2);
      Income                VARCHAR2(200);
      SwiftCharge           VARCHAR2(200);
      Rate                  VARCHAR2(200);
      BankName              VARCHAR2(200);
      BENEName              VARCHAR2(200);
      ENEAccNum             VARCHAR2(200);
      OtherAddress          VARCHAR2(200);
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
       INTO	       OTTNo,
       BOName,
       BOAccount,
       Address,
       currency,
       Amount,
       Income,
       SwiftCharge,
       Rate,
       BankName,
       BENEName,
       ENEAccNum,
       OtherAddress;
      

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
                              
          OTTNo   			        || '|' ||
					BOName              	|| '|' ||
          BOAccount             || '|' ||
          Address      		      || '|' ||
					currency	            || '|' ||
          Amount                || '|' ||
          Income                || '|' ||
          SwiftCharge           || '|' ||
          Rate                  || '|' ||
          BankName              || '|' ||
          BENEName              || '|' ||
          ENEAccNum             || '|' ||
          OtherAddress          || '|' ||
          v_BranchName	        || '|' ||
					v_BankAddress      	  || '|' ||
					v_BankPhone           || '|' ||
          v_BankFax             || '|' ||
          Project_Bank_Name     || '|' ||
          Project_Image_Name
            );
  
			dbms_output.put_line(out_rec);
      
 END FIN_OUTWARD_REMITTANCE;

END FIN_OUTWARD_REMITTANCE;
/
