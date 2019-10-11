CREATE OR REPLACE PACKAGE                                                                                   FIN_LEDGER_BALANCE_BY_GRADE AS 

  PROCEDURE FIN_LEDGER_BALANCE_BY_GRADE(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );

END FIN_LEDGER_BALANCE_BY_GRADE;
/


CREATE OR REPLACE PACKAGE BODY                                                                                                                                                                                                                                               FIN_LEDGER_BALANCE_BY_GRADE AS

  -------------------------------------------------------------------------------------
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
-------------------------------------------------------------------------------------
  
  outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array
	vi_currency	   	Varchar2(5);              -- Input to procedure
	vi_startAmount		Varchar2(50);		    	    -- Input to procedure
  vi_endAmount		  Varchar2(50);		    	    -- Input to procedure
  vi_branchCode		Varchar2(5);		    	    -- Input to procedure
  vi_SchemeType		Varchar2(5);		    	    -- Input to procedure
  vi_SchemeCode		Varchar2(6);		    	    -- Input to procedure
    vi_EOD_DATE	   	Varchar2(20);               -- Input to procedure
-----------------------------------------------------------------------------
-- CURSOR declaration FIN_DRAWING_SPBX CURSOR
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- CURSOR ExtractData
-----------------------------------------------------------------------------

  CURSOR ExtractData (ci_EOD_DATE VARCHAR2,	ci_branchCode VARCHAR2, ci_startAmount VARCHAR2, ci_endAmount VARCHAR2,
      ci_currency VARCHAR2,ci_SchemeType VARCHAR2, ci_SchemeCode VARCHAR2
			 )
  IS
  select *
  from (select 
   gam.FORACID as AccountNo , 
   gam.ACCT_NAME as AcctName , 
   nvl((select eab.tran_date_bal 
    from  tbaadm.eab eab
    where  eab.EOD_DATE <= TO_DATE(ci_EOD_DATE, 'dd-MM-yyyy' )
    and eab.end_eod_date >= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' )
    and eab.acid = gam.acid
   ),0) as Balance  ,
   gam.clr_bal_amt as Today_bal
  from 
    TBAADM.GENERAL_ACCT_MAST_TABLE gam
  where
   gam.del_flg = 'N'
   and gam.bank_id = '01'
   and gam.acct_crncy_code  = upper(ci_currency)
   and gam.SCHM_TYPE =upper( ci_SchemeType )
   and gam.SCHM_CODE  like   '%' || ci_SchemeCode || '%' 
   and gam.SOL_ID =   ci_branchCode
   and gam.acct_opn_date <= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' )
   and gam.acid not in (  select gam1.acid
                          from 
                            TBAADM.GENERAL_ACCT_MAST_TABLE gam1
                          where                    
                             gam1.del_flg = 'N'
                             and gam1.bank_id = '01'
                             and gam1.acct_crncy_code  = upper(ci_currency )
                             and gam1.SCHM_TYPE =upper( ci_SchemeType )
                             and gam1.SCHM_CODE  like   '%' || ci_SchemeCode || '%' 
                             and gam1.SOL_ID =   ci_branchCode
                             --and gam1.acct_opn_date <= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' )
                             and gam1.acct_cls_date <= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' ) )
      )s
   where s.Balance >= ci_startAmount
   and s.Balance <= ci_endAmount ;
   
/*  union all
select 
   gam.FORACID as "Account No." , 
   gam.ACCT_NAME as "Name" , 
   gam.clr_bal_amt as "Balance" ,
   gam.clr_bal_amt as "Today_bal"
  
from 
   TBAADM.GENERAL_ACCT_MAST_TABLE gam
 
 
where
   gam.acct_cls_flg = 'N'
   and gam.del_flg = 'N'
   and gam.bank_id = '01'
   and gam.acct_crncy_code  = upper(ci_currency )
   and gam.SCHM_TYPE =upper( ci_SchemeType )
   and gam.SCHM_CODE  like   '%' || ci_SchemeCode || '%' 
   and gam.SOL_ID =   ci_branchCode
   and gam.CLR_BAL_AMT >= ci_startAmount
   and gam.CLR_BAL_AMT <= ci_endAmount
    and gam.clr_bal_amt <> 0
   --and gam.foracid ='3440005000001018'
   and gam.acct_opn_date <=TO_DATE( ci_EOD_DATE, 'dd-MM-yyyy' ) 
   and gam.acid not in (select eab.acid 
                        from TBAADM.GENERAL_ACCT_MAST_TABLE gam ,tbaadm.eab
                        where gam.acct_cls_flg = 'N'
                        and gam.acid = tbaadm.eab.acid
                        and gam.del_flg = 'N'
                        and gam.bank_id = '01'
                        and gam.CLR_BAL_AMT >= ci_startAmount
                        and gam.CLR_BAL_AMT <= ci_endAmount
                        and eab.Tran_date_bal >= ci_startAmount
                        and eab.Tran_date_bal <= ci_endAmount
                        and gam.acct_crncy_code  = upper(ci_currency )
                        and eab.eab_crncy_code  = upper(ci_currency )
                        and gam.SCHM_TYPE =upper( ci_SchemeType )
                        and gam.SCHM_CODE  like   '%' || ci_SchemeCode || '%' 
                        and gam.SOL_ID =   ci_branchCode
                        --and gam.foracid ='3440005000001018'
                      and eab.EOD_DATE <= TO_DATE( ci_EOD_DATE, 'dd-MM-yyyy' )
                      and eab.end_eod_date >= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' ));*/
   
-----------------------------------------------------------------------------------------------------------


  CURSOR ExtractDatawithoutamt (ci_EOD_DATE VARCHAR2,	ci_branchCode VARCHAR2,
      ci_currency VARCHAR2,ci_SchemeType VARCHAR2, ci_SchemeCode VARCHAR2
			 )
  IS
  select 
   gam.FORACID as AccountNo , 
   gam.ACCT_NAME as AcctName , 
   nvl((select eab.tran_date_bal 
    from  tbaadm.eab eab
    where  eab.EOD_DATE <= TO_DATE(ci_EOD_DATE, 'dd-MM-yyyy' )
    and eab.end_eod_date >= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' )
    and eab.acid = gam.acid
   ),0) as Balance  ,
   gam.clr_bal_amt as Today_bal
  from 
    TBAADM.GENERAL_ACCT_MAST_TABLE gam
  where
   gam.del_flg = 'N'
   and gam.bank_id = '01'
   and gam.acct_crncy_code  = upper(ci_currency)
   and gam.SCHM_TYPE =upper( ci_SchemeType )
   and gam.SCHM_CODE  like   '%' || ci_SchemeCode || '%' 
   and gam.SOL_ID =   ci_branchCode
   and gam.acct_opn_date <= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' )
   and gam.acid not in (  select gam1.acid
                          from 
                            TBAADM.GENERAL_ACCT_MAST_TABLE gam1
                          where                    
                             gam1.del_flg = 'N'
                             and gam1.bank_id = '01'
                             and gam1.acct_crncy_code  = upper(ci_currency )
                             and gam1.SCHM_TYPE =upper( ci_SchemeType )
                             and gam1.SCHM_CODE  like   '%' || ci_SchemeCode || '%' 
                             and gam1.SOL_ID =   ci_branchCode
                            -- and gam1.acct_opn_date <= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' )
                             and gam1.acct_cls_date <= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' ) );
                          
 /*  union all
select 
   gam.FORACID as "Account No." , 
   gam.ACCT_NAME as "Name" , 
   gam.clr_bal_amt as "Balance" ,
   gam.clr_bal_amt as "Today_bal"
  
from 
   TBAADM.GENERAL_ACCT_MAST_TABLE gam
 
 
where
   gam.acct_cls_flg = 'N'
   and gam.del_flg = 'N'
   and gam.bank_id = '01'
   and gam.acct_crncy_code  = upper(ci_currency )
   and gam.SCHM_TYPE =upper( ci_SchemeType )
   and gam.SCHM_CODE  like   '%' || ci_SchemeCode || '%' 
   and gam.SOL_ID =   ci_branchCode
    and gam.clr_bal_amt <> 0
   --and gam.foracid ='3440005000001018'
   and gam.acct_opn_date <=TO_DATE( ci_EOD_DATE, 'dd-MM-yyyy' ) 
   and gam.acid not in (select eab.acid 
                        from TBAADM.GENERAL_ACCT_MAST_TABLE gam ,tbaadm.eab
                        where gam.acct_cls_flg = 'N'
                        and gam.acid = tbaadm.eab.acid
                        and gam.del_flg = 'N'
                        and gam.bank_id = '01'
                        and gam.acct_crncy_code  = upper(ci_currency )
                        and eab.eab_crncy_code  = upper(ci_currency )
                        and gam.SCHM_TYPE =upper( ci_SchemeType )
                        and gam.SCHM_CODE  like   '%' || ci_SchemeCode || '%' 
                        and gam.SOL_ID =   ci_branchCode
                        --and gam.foracid ='3440005000001018'
                      and eab.EOD_DATE <= TO_DATE( ci_EOD_DATE, 'dd-MM-yyyy' )
                      and eab.end_eod_date >= TO_DATE(ci_EOD_DATE , 'dd-MM-yyyy' ));*/

------------------------------------------------------------------------------------------------------------

  PROCEDURE FIN_LEDGER_BALANCE_BY_GRADE(inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 ) AS
      
      v_accountNo TBAADM.GENERAL_ACCT_MAST_TABLE.FORACID%type;
      v_name TBAADM.GENERAL_ACCT_MAST_TABLE.ACCT_NAME%type;
      v_balanceAmt TBAADM.GENERAL_ACCT_MAST_TABLE.CLR_BAL_AMT%type; 
      v_Today_bal tbaadm.gam.clr_bal_amt%type;
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
   
     vi_EOD_DATE       :=outArr(0);	
     vi_startAmount    :=outArr(1);		
     vi_endAmount      :=outArr(2);	
     vi_currency       :=outArr(3);
     vi_SchemeType	   :=outArr(4);	
     vi_SchemeCode	   :=outArr(5);
     vi_branchCode     :=outArr(6);	
    
    if( vi_EOD_DATE is null or vi_currency is null or vi_SchemeType is null or vi_branchCode is null    ) then
        --resultstr := 'No Data For Report';
        out_rec:= ( '-' || '|' || '-' || '|' || 0 || '|' || '-' || '|' || 
		           '-' || '|' || '-' || '|' || '-' );                    
				   
        --dbms_output.put_line(out_rec);
        out_retCode:= 1;
        RETURN;        
  end if;
   
   IF vi_SchemeCode IS  NULL or vi_SchemeCode = ''  THEN
  vi_SchemeCode := '';
  END IF;
  
   IF (vi_startAmount IS  NULL OR vi_startAmount = '') or ( vi_endAmount IS  NULL OR vi_endAmount = '')THEN
    --IF vi_endAmount IS  NULL OR vi_endAmount = '' THEN
   --{
   
  ----------------------------------------------------
    IF NOT ExtractDatawithoutamt%ISOPEN THEN
		--{
			BEGIN
			--{
				OPEN ExtractDatawithoutamt (	
         vi_EOD_DATE,vi_branchCode  ,vi_currency , vi_SchemeType , vi_SchemeCode
			 );
			--}
			END;

		--}
		END IF;
    
    IF ExtractDatawithoutamt%ISOPEN THEN
		--{
			FETCH	ExtractDatawithoutamt
			INTO	v_accountNo, v_name, v_balanceAmt,v_Today_bal;
      

			------------------------------------------------------------------
			-- Here it is checked whether the cursor has fetched
			-- something or not if not the cursor is closed
			-- and the out ret code is made equal to 1
			------------------------------------------------------------------
			IF ExtractDatawithoutamt%NOTFOUND THEN
			--{
				CLOSE ExtractDatawithoutamt;
				out_retCode:= 1;
				RETURN;
			--}
			END IF;
		--}
    END IF;

    
  ElSE
   IF NOT ExtractData%ISOPEN THEN
		--{
			BEGIN
			--{
				OPEN ExtractData (	vi_EOD_DATE,
         vi_branchCode , 
      vi_startAmount , vi_endAmount
      ,vi_currency , vi_SchemeType , vi_SchemeCode
			 );
			--}
			END;

		--}
		END IF;
    
    IF ExtractData%ISOPEN THEN
		--{
			FETCH	ExtractData
			INTO	v_accountNo, v_name, v_balanceAmt,v_Today_bal;
      

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

    End If;
    

-------------------------------------------------------------------------------
    -- GET BANK INFORMATION
-------------------------------------------------------------------------------
      BEGIN
  SELECT sol.sol_desc,sol.addr_1 || sol.addr_2 || sol.addr_3,bct.PHONE_NUM, bct.FAX_NUM
   into  v_BranchName, v_BankAddress, v_BankPhone, v_BankFax
   FROM tbaadm.sol,tbaadm.bct 
   WHERE sol.SOL_ID = '10000' 
   AND bct.br_code = sol.br_code
   and bct.bank_code = '112';
    EXCEPTION   
      WHEN NO_DATA_FOUND THEN
          v_BranchName   := '' ;
          v_BankAddress  := '' ;
          v_BankPhone    := '' ;
          v_BankFax      := '' ;
   END;
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
    
    
--------------------------------------------------------------------------------------   
    if( TO_DATE( sysdate, 'dd-MM-yyyy' ) like TO_DATE( vi_EOD_DATE, 'dd-MM-yyyy' ) ) then
         out_rec:=	(v_accountNo      			|| '|' ||
          v_name      			|| '|' ||
					v_Today_bal	|| '|' ||
					v_BranchName	    || '|' ||
          v_BankAddress     || '|' ||
          v_BankPhone       || '|' ||
          v_BankFax         || '|' ||
          Project_Bank_Name || '|' ||
          Project_Image_Name    ); 
    else 
        out_rec:=	(v_accountNo      			|| '|' ||
          v_name      			|| '|' ||
					v_balanceAmt	|| '|' ||
				v_BranchName	    || '|' ||
          v_BankAddress     || '|' ||
          v_BankPhone       || '|' ||
          v_BankFax         || '|' ||
          Project_Bank_Name || '|' ||
          Project_Image_Name    ); 
    end if;
      
    -----------------------------------------------------------------------------------
    -- out_rec variable retrieves the data to be sent to LST file with pipe seperation
    ------------------------------------------------------------------------------------
  
  
			dbms_output.put_line(out_rec);
  END FIN_LEDGER_BALANCE_BY_GRADE;

END FIN_LEDGER_BALANCE_BY_GRADE;
/
