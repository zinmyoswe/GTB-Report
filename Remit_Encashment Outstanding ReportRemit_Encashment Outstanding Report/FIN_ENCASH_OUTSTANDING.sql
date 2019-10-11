CREATE OR REPLACE PACKAGE                                                         FIN_ENCASH_OUTSTANDING AS 

  PROCEDURE FIN_ENCASH_OUTSTANDING(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );

END FIN_ENCASH_OUTSTANDING;
/


CREATE OR REPLACE PACKAGE BODY                                                                                                                                                                                                                                               FIN_ENCASH_OUTSTANDING AS


-------------------------------------------------------------------------------------
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
-------------------------------------------------------------------------------------
  
  outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array
	vi_branchCode		Varchar2(5);		    	            -- Input to procedure
  vi_StartDate Varchar2(10);
  vi_EndDate Varchar2(10);
  vi_other_bank Varchar2(30);

-------------------------------------------------------------------------------
    -- GET Remittance Information
-------------------------------------------------------------------------------
    CURSOR ExtractData (	 ci_StartDate Varchar2 , ci_EndDate Varchar2,ci_other_bank varchar2,ci_branchCode		Varchar2) IS
     select 
           CTD_DTD_ACLI_VIEW.TRAN_ID , 
           (select bct.br_name from tbaadm.bct bct where bct.br_code = CTD_DTD_ACLI_VIEW.branch_code )as "Drawing Bank",
           (select sol.sol_desc from tbaadm.sol sol where sol.sol_id = ctd_dtd_acli_view.dth_init_sol_id) as "Drawee Bank",
           ctd_dtd_acli_view.tran_rmks as "Name",
           CTD_DTD_ACLI_VIEW.TRAN_AMT as "Tran_Amt" , 
           CTD_DTD_ACLI_VIEW.TRAN_DATE as "TRAN_DATE" ,  
            (select CTH_DTH_VIEW.REMARKS from custom.custom_CTH_DTH_VIEW CTH_DTH_VIEW  
           where TRIM(CTD_DTD_ACLI_VIEW.TRAN_ID) = trim(CTH_DTH_VIEW.TRAN_ID)
            and CTH_DTH_VIEW.TRAN_DATE = CTD_DTD_ACLI_VIEW.TRAN_DATE) as "fax_no" ,
            CTD_DTD_ACLI_VIEW.REF_NUM as "Phone_No"
        from 
           custom.CUSTOM_CTD_DTD_ACLI_VIEW CTD_DTD_ACLI_VIEW
        where CTD_DTD_ACLI_VIEW.TRAN_DATE >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' ) 
           and CTD_DTD_ACLI_VIEW.TRAN_DATE <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' )
           and CTD_DTD_ACLI_VIEW.bank_code =ci_other_bank
           and CTD_DTD_ACLI_VIEW.DTH_INIT_SOL_ID !='20300'
           and  CTD_DTD_ACLI_VIEW.DTH_INIT_SOL_ID like   '%' || ci_branchCode || '%'
           AND CTD_DTD_ACLI_VIEW.RPT_CODE = 'IBREM'
           and CTD_DTD_ACLI_VIEW.tran_sub_type in ('BI','CI')
           and CTD_DTD_ACLI_VIEW.uad_module_key is not null
          and CTD_DTD_ACLI_VIEW.uad_module_id is not null
           AND (TRIM(CTD_DTD_ACLI_VIEW.TRAN_ID),CTD_DTD_ACLI_VIEW.Tran_date) NOT IN(SELECT TRIM(T.TRAN_ID),t.Tran_date
                                                      FROM TBAADM.TCT T
                                                      WHERE ENTITY_CRE_FLG = 'Y' 
                                                      AND DEL_FLG = 'N'
                                                      and T.TRAN_DATE >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' ) 
                                                      and T.TRAN_DATE <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' ))
           and (trim(CTD_DTD_ACLI_VIEW.tran_id),CTD_DTD_ACLI_VIEW.tran_date) NOT IN 
                                                      (select trim(CONT_TRAN_ID),cont_tran_date 
                                                      from TBAADM.ATD atd 
                                                      where cont_tran_date >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' )
                                                      and cont_tran_date <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' )) 
      order by  CTD_DTD_ACLI_VIEW.tran_id,CTD_DTD_ACLI_VIEW.TRAN_DATE;
-------------------------------------------------------------------------------------------------------------------------------------------------
CURSOR ExtractDataInterBank (	 ci_StartDate Varchar2 , ci_EndDate Varchar2,ci_branchCode		Varchar2) IS
     select 
           CTD_DTD_ACLI_VIEW.TRAN_ID , 
           (select bct.br_name from tbaadm.bct bct where bct.br_code = CTD_DTD_ACLI_VIEW.branch_code )as "Drawing Bank",
           (select sol.sol_desc from tbaadm.sol sol where sol.sol_id = ctd_dtd_acli_view.dth_init_sol_id) as "Drawee Bank",
           ctd_dtd_acli_view.tran_rmks as "Name",
           CTD_DTD_ACLI_VIEW.TRAN_AMT as "Tran_Amt" , 
           CTD_DTD_ACLI_VIEW.TRAN_DATE as "TRAN_DATE" ,  
            (select CTH_DTH_VIEW.REMARKS from custom.custom_CTH_DTH_VIEW CTH_DTH_VIEW  
           where TRIM(CTD_DTD_ACLI_VIEW.TRAN_ID) = trim(CTH_DTH_VIEW.TRAN_ID)
            and CTH_DTH_VIEW.TRAN_DATE = CTD_DTD_ACLI_VIEW.TRAN_DATE) as "fax_no" ,
            CTD_DTD_ACLI_VIEW.REF_NUM as "Phone_No"
        from 
           custom.CUSTOM_CTD_DTD_ACLI_VIEW CTD_DTD_ACLI_VIEW
        where CTD_DTD_ACLI_VIEW.TRAN_DATE >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' ) 
           and CTD_DTD_ACLI_VIEW.TRAN_DATE <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' )
           and CTD_DTD_ACLI_VIEW.DTH_INIT_SOL_ID !='20300'
           and  CTD_DTD_ACLI_VIEW.DTH_INIT_SOL_ID like   '%' || ci_branchCode || '%'
           AND CTD_DTD_ACLI_VIEW.RPT_CODE = 'IBREM'
           and CTD_DTD_ACLI_VIEW.tran_sub_type in ('BI','CI')
           and CTD_DTD_ACLI_VIEW.uad_module_key is not null
          and CTD_DTD_ACLI_VIEW.uad_module_id is not null
           AND (TRIM(CTD_DTD_ACLI_VIEW.TRAN_ID),CTD_DTD_ACLI_VIEW.Tran_date) NOT IN(SELECT TRIM(T.TRAN_ID),t.Tran_date
                                                      FROM TBAADM.TCT T
                                                      WHERE ENTITY_CRE_FLG = 'Y' 
                                                      AND DEL_FLG = 'N'
                                                      and T.TRAN_DATE >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' ) 
                                                      and T.TRAN_DATE <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' ))
           and (trim(CTD_DTD_ACLI_VIEW.tran_id),CTD_DTD_ACLI_VIEW.tran_date) NOT IN 
                                                      (select trim(CONT_TRAN_ID),cont_tran_date 
                                                      from TBAADM.ATD atd 
                                                      where cont_tran_date >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' )
                                                      and cont_tran_date <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' )) 
      order by  CTD_DTD_ACLI_VIEW.tran_id,CTD_DTD_ACLI_VIEW.TRAN_DATE;
       
-------------------------------------------------------------------------------------------------------------------------------------------------
CURSOR ExtractDataAGD (	 ci_StartDate Varchar2 , ci_EndDate Varchar2,ci_branchCode		Varchar2) IS
select 
           CTD_DTD_ACLI_VIEW.TRAN_ID , 
           (select sol.sol_desc from tbaadm.sol sol where sol.sol_id = ctd_dtd_acli_view.dth_init_sol_id) as "Drawing Bank",
           (select bct.br_name from tbaadm.bct bct where bct.br_code = CTD_DTD_ACLI_VIEW.branch_code ) as "Drawee Bank",
           ctd_dtd_acli_view.tran_rmks as "Name",
           CTD_DTD_ACLI_VIEW.TRAN_AMT as "Tran_Amt" , 
           CTD_DTD_ACLI_VIEW.TRAN_DATE as "TRAN_DATE" ,  
           (select CTH_DTH_VIEW.REMARKS from custom.custom_CTH_DTH_VIEW CTH_DTH_VIEW  
           where TRIM(CTD_DTD_ACLI_VIEW.TRAN_ID) = trim(CTH_DTH_VIEW.TRAN_ID)
            and CTH_DTH_VIEW.TRAN_DATE = CTD_DTD_ACLI_VIEW.TRAN_DATE) as "fax_no" ,
            CTD_DTD_ACLI_VIEW.REF_NUM as "Phone_No"
        from 
           custom.CUSTOM_CTD_DTD_ACLI_VIEW CTD_DTD_ACLI_VIEW 
        where CTD_DTD_ACLI_VIEW.TRAN_DATE >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' ) 
           and CTD_DTD_ACLI_VIEW.TRAN_DATE <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' ) 
           and CTD_DTD_ACLI_VIEW.bank_code ='112'
           and CTD_DTD_ACLI_VIEW.branch_code !='203'
           and CTD_DTD_ACLI_VIEW.branch_code = (select sol.micr_branch_code
                                                from tbaadm.sol sol ,tbaadm.bct bct
                                                where sol.micr_branch_code = bct.br_code
                                                and sol.bank_code = bct.bank_code
                                                and sol.bank_code ='112'
                                                and bct.br_short_name =sol.abbr_br_name
                                                and sol.sol_id like   '%' || ci_branchCode || '%'
                                                and sol.sol_id !='20300')
           AND CTD_DTD_ACLI_VIEW.RPT_CODE  = 'REMIT'
           and CTD_DTD_ACLI_VIEW.tran_sub_type in ('RI','CI')
           and CTD_DTD_ACLI_VIEW.uad_module_key is not null
          and CTD_DTD_ACLI_VIEW.uad_module_id is not null
           AND (TRIM(CTD_DTD_ACLI_VIEW.TRAN_ID),CTD_DTD_ACLI_VIEW.Tran_date) NOT IN(SELECT TRIM(T.TRAN_ID),t.Tran_date
                                                      FROM TBAADM.TCT T
                                                      WHERE ENTITY_CRE_FLG = 'Y' 
                                                      AND DEL_FLG = 'N'
                                                      and T.TRAN_DATE >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' )
                                                      and T.TRAN_DATE <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' ) )
           AND (TRIM(CTD_DTD_ACLI_VIEW.TRAN_ID),CTD_DTD_ACLI_VIEW.Tran_date) NOT IN(SELECT TRIM(T.contra_TRAN_ID),t.contra_Tran_date
                                                      FROM TBAADM.TCT T
                                                      WHERE ENTITY_CRE_FLG = 'Y' 
                                                      AND DEL_FLG = 'N'
                                                      and T.contra_TRAN_DATE >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' )
                                                      and T.contra_TRAN_DATE <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' ) )
           and (trim(CTD_DTD_ACLI_VIEW.tran_id),CTD_DTD_ACLI_VIEW.tran_date) NOT IN 
                                                      (select trim(CONT_TRAN_ID),cont_tran_date 
                                                      from TBAADM.ATD atd 
                                                      where cont_tran_date >= TO_DATE(ci_StartDate, 'dd-MM-yyyy' )
                                                      and cont_tran_date <= TO_DATE(ci_EndDate, 'dd-MM-yyyy' ) ) 
order by  CTD_DTD_ACLI_VIEW.tran_id,CTD_DTD_ACLI_VIEW.TRAN_DATE;
-------------------------------------------------------------------------------------------------------------------------------------------------

  PROCEDURE FIN_ENCASH_OUTSTANDING(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 ) AS


-------------------------------------------------------------
	--Variable declaration
-------------------------------------------------------------
     v_tran_id tbaadm.CTH_DTH_VIEW.TRAN_ID%type; 
     v_drawing_bank Varchar(100);
     v_drawee_bank Varchar(100);
     v_name custom.CUSTOM_CTD_DTD_ACLI_VIEW.tran_rmks%type;
     v_TranAmt TBAADM.CTD_DTD_ACLI_VIEW.TRAN_AMT%type;
     v_TranDate tbaadm.CTD_DTD_ACLI_VIEW.TRAN_DATE%type;
      v_faxNo custom.custom_CTH_DTH_VIEW.REMARKS%type;
     v_BranchName TBAADM.BRANCH_CODE_TABLE.BR_SHORT_NAME%type;
      v_BankAddress TBAADM.BRANCH_CODE_TABLE.BR_ADDR_1%type;
     v_BankPhone TBAADM.BRANCH_CODE_TABLE.PHONE_NUM%type;
     v_BankFax TBAADM.BRANCH_CODE_TABLE.FAX_NUM%type;
     v_phone_num custom.CUSTOM_CTD_DTD_ACLI_VIEW.REF_NUM%type;
     Project_Bank_Name  varchar2(100);
     Project_Image_Name varchar2(100);


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
    
  
	
    vi_StartDate := outArr(0);
    vi_EndDate := outArr(1);
    vi_other_bank := outArr(2);
    	vi_branchCode:=outArr(3);
    
    ---
    
     IF vi_branchCode IS  NULL or vi_branchCode = ''  THEN
  vi_branchCode := '';
  END IF;
  -------------------------------------------------------------------
    if( vi_StartDate is null or vi_EndDate is null  or vi_other_bank is null) then
        --resultstr := 'No Data For Report';
        out_rec:= ( '-' || '|' || 0 || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' );
		
        --dbms_output.put_line(out_rec);
        out_retCode:= 1;
        RETURN;        
  end if;
    
    
    -----------------------------------------------------------------------
     IF vi_other_bank ='KBZ' then
       vi_other_bank := '109';
    ELSIf vi_other_bank ='AYA' then
        vi_other_bank := '117';
    ELSIf vi_other_bank ='AGD' then
        vi_other_bank := '112';
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
    end if;
		--{
 ------------------------------------------------------------------------------  
   IF vi_other_bank like 'Inter Branches' then
     IF NOT ExtractDataAGD%ISOPEN THEN
			BEGIN
			--{
				OPEN ExtractDataAGD ( vi_StartDate, vi_EndDate, vi_branchCode);	
			--}
			END;

		--}
		END IF;
    
    IF ExtractDataAGD%ISOPEN THEN
		--{
			FETCH	ExtractDataAGD
			INTO	  v_tran_id,v_drawing_bank,v_drawee_bank,v_name,v_TranAmt,v_TranDate, v_faxNo,v_phone_num;
      
			------------------------------------------------------------------
			-- Here it is checked whether the cursor has fetched
			-- something or not if not the cursor is closed
			-- and the out ret code is made equal to 1
			------------------------------------------------------------------
			IF ExtractDataAGD%NOTFOUND THEN
			--{
				CLOSE ExtractDataAGD;
				out_retCode:= 1;
				RETURN;
			--}
			END IF;
		--}
    END IF;
    ELSIF vi_other_bank = 'Inter Bank' then
        IF NOT ExtractDataInterBank%ISOPEN THEN
		--{
			BEGIN
			--{
				OPEN ExtractDataInterBank ( vi_StartDate, vi_EndDate, vi_branchCode);	
			--}
			END;

		--}
		END IF;
    
    IF ExtractDataInterBank%ISOPEN THEN
		--{
			FETCH	ExtractDataInterBank
			INTO	  v_tran_id,v_drawing_bank,v_drawee_bank,v_name,v_TranAmt,v_TranDate, v_faxNo,v_phone_num;
      
			------------------------------------------------------------------
			-- Here it is checked whether the cursor has fetched
			-- something or not if not the cursor is closed
			-- and the out ret code is made equal to 1
			------------------------------------------------------------------
			IF ExtractDataInterBank%NOTFOUND THEN
			--{
				CLOSE ExtractDataInterBank;
				out_retCode:= 1;
				RETURN;
			--}
			END IF;
		--}
    END IF;
    ELSIF ( vi_other_bank not like 'Inter Branches' or vi_other_bank not like 'Inter Bank') then
    IF NOT ExtractData%ISOPEN THEN
		--{
			BEGIN
			--{
				OPEN ExtractData ( vi_StartDate, vi_EndDate,vi_other_bank, vi_branchCode);	
			--}
			END;

		--}
		END IF;
    
    IF ExtractData%ISOPEN THEN
		--{
			FETCH	ExtractData
			INTO	  v_tran_id,v_drawing_bank,v_drawee_bank,v_name,v_TranAmt,v_TranDate, v_faxNo,v_phone_num;
      
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
    
  
    END IF;


      
-------------------------------------------------------------------------------
    -- GET BANK INFORMATION
-------------------------------------------------------------------------------
If vi_branchCode is not null then
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
end if;
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
-----------------------------------------------------------------------------------
--  out_rec variable retrieves the data to be sent to LST file with pipe seperation
------------------------------------------------------------------------------------

    out_rec:=	(
          v_tran_id                           || '|' ||
          v_drawing_bank                      || '|' ||
          v_drawee_bank                       || '|' ||
          v_name                              || '|' ||
					v_TranAmt      		                  || '|' ||
             to_char(to_date(v_TranDate,'dd/Mon/yy'), 'dd/MM/yyyy')   	|| '|' ||
          v_faxNo                             || '|' ||
          v_BranchName                        || '|' ||
          v_BankAddress                       || '|' ||
          v_BankPhone                         || '|' ||
          v_BankFax                           || '|' ||
          v_phone_num                         || '|' ||
          Project_Bank_Name                   || '|' ||
          Project_Image_Name
        );
  
			dbms_output.put_line(out_rec);

  END FIN_ENCASH_OUTSTANDING;

END FIN_ENCASH_OUTSTANDING;
/
