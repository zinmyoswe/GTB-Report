CREATE OR REPLACE PACKAGE                      FIN_TRADE_FINANCE_SPBX AS 

  PROCEDURE FIN_TRADE_FINANCE_SPBX(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );

END FIN_TRADE_FINANCE_SPBX;
/


CREATE OR REPLACE PACKAGE BODY                                                                       FIN_TRADE_FINANCE_SPBX AS

  -------------------------------------------------------------------------------------
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
-------------------------------------------------------------------------------------
  
  outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array
	vi_BranchCode	   	Varchar2(5);              -- Input to procedure
	vi_Currency		    Varchar2(3);		    	    -- Input to procedure
  vi_OpenDate		    Varchar2(10);		    	    -- Input to procedure
  vi_EndDate		    Varchar2(10);		    	    -- Input to procedure

-------------------------------------------------------------------------------
    -- GET LC Outstanding Information
-------------------------------------------------------------------------------
    CURSOR ExtractData (ci_BranchCode	   	Varchar2,
      ci_Currency	   	Varchar2,
      ci_OpenDate	   	Varchar2,	
			ci_EndDate		Varchar2) IS
       select dcmmt.date_opnd, 
           dcmmt.applicant_name, 
           dcmmt.dc_ref_num, 
           dcmmt.open_value, 
           dcmmt.DATE_CLSD,
           dcmmt.confirmation_reqd_flg,
           nvl((select bctt.br_name 
                from  tbaadm.bct bctt
                where dcmmt.ADVISING_BANK_CODE = bctt.bank_code
                and   dcmmt.ADVISING_BRANCH_CODE = bctt.BR_CODE
            ),' ') as br_name,
            nvl((select tfatt.NAME
                 from  tbaadm.tfat tfatt
                 where tfatt.addr_b2kid = dcmmt.DC_B2KID
                 and tfatt.ADDR_TYPE = 'S'
                 and tfatt.BANK_ID = '01'
                 and tfatt.ADDR_ID = 'DCOUPY'),' ')
             as  SomeName,
             nvl((select cdtyy.COMMODITY_DESC || cdtyy.ALT1_COMMODITY_DESC 
                  from   tbaadm.cdty cdtyy
                  where  dcmmt.COMMODITY_CODE = cdtyy.COMMODITY_CODE
                  and cdtyy.BANK_ID = '01'),' ') 
              as Comodity_DESC,
             /* nvl(( select 
                           fbmm.BILL_DATE
                    from 
                           tbaadm.fei feii, tbaadm.fbm fbmm
                    where  feii.lc_number = dcmmt.DC_REF_NUM
                    and    feii.BILL_ID = fbmm.BILL_ID),'')
                as BillDate*/
              dcmmt.expiry_date
      
    from tbaadm.dcmm dcmmt
    where TO_DATE( CAST ( ci_OpenDate AS VARCHAR(10) ) , 'dd-MM-yyyy' ) <= dcmmt.date_opnd
    and TO_DATE( CAST ( ci_EndDate AS VARCHAR(10) ) , 'dd-MM-yyyy' ) >= dcmmt.date_opnd
    and dcmmt.actl_crncy_code = upper(ci_Currency)
    and dcmmt.sol_id like    '%' || ci_BranchCode || '%'
    and dcmmt.del_flg = 'N'
    and dcmmt.bank_id = '01';
         

  PROCEDURE FIN_TRADE_FINANCE_SPBX(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 ) IS
      
       v_openDate tbaadm.dcmm.date_opnd%type;
       v_appName tbaadm.dcmm.applicant_name%type; 
       v_LCNo tbaadm.dcmm.dc_ref_num%type; 
       v_LCAmt tbaadm.dcmm.open_value%type; 
       v_closeDate tbaadm.dcmm.DATE_CLSD%type;
       v_confimationReqFlg tbaadm.dcmm.confirmation_reqd_flg%type;
       v_advBank tbaadm.bct.br_name%type;
       v_beneficiaryName tbaadm.tfat.name%type;
       v_commdity tbaadm.cdty.COMMODITY_DESC%type;
       v_billDate tbaadm.fbm.BILL_DATE%type;
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
    vi_OpenDate:=outArr(0);		    
    vi_EndDate:=outArr(1);
    vi_Currency:=outArr(2);		   
     vi_BranchCode:=outArr(3);
 --------------------------------------------------------------------------------------
 if( vi_OpenDate is null or vi_EndDate is null or vi_Currency is null or vi_BranchCode is null  ) then
        --resultstr := 'No Data For Report';
        out_rec:= ( '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || 0 || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-'  );
        --dbms_output.put_line(out_rec);
        out_retCode:= 1;
        RETURN;        
  end if;
 
 
 if vi_BranchCode is null or vi_branchCode = '' then
     vi_BranchCode := '';
  end if;
  
 ------------------------------------------------------------------------------------
------------------ExtractData---------------------------------------   
    IF NOT ExtractData%ISOPEN THEN
		--{
			BEGIN
			--{
				OPEN ExtractData (vi_BranchCode,
      vi_Currency,
      vi_OpenDate,	
			vi_EndDate);	
			--}
			END;

		--}
		END IF;
    
    IF ExtractData%ISOPEN THEN
		--{
			FETCH	ExtractData
			INTO	 v_openDate, v_appName, v_LCNo, v_LCAmt, 
            v_closeDate, v_confimationReqFlg, v_advBank,v_beneficiaryName,v_commdity,v_billDate;
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

    out_rec:=	(v_openDate            || '|' ||
          v_LCNo      			         || '|' ||
					v_appName      			       || '|' ||
          v_beneficiaryName          || '|' ||
          v_LCAmt      			         || '|' ||
          v_advBank                  || '|' ||
          v_confimationReqFlg        || '|' ||
          v_commdity                 || '|' ||
					v_billDate                 || '|' ||
          v_closeDate	               || '|' ||
          Project_Bank_Name          || '|' ||
          Project_Image_Name);
  
			dbms_output.put_line(out_rec);
  END FIN_TRADE_FINANCE_SPBX;

END FIN_TRADE_FINANCE_SPBX;
/
