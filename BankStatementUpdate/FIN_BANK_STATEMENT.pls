CREATE OR REPLACE PACKAGE                                                                                                                                                                                                                                                                                                       FIN_BANK_STATEMENT AS 

     -- subtype limited_string is CLOB  ;
   PROCEDURE FIN_BANK_STATEMENT(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT varchar2  );

END FIN_BANK_STATEMENT;
/


CREATE OR REPLACE PACKAGE BODY                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     FIN_BANK_STATEMENT AS

-------------------------------------------------------------------------------------
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
-------------------------------------------------------------------------------------
  --3021210106578
  outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array

	vi_startDate		Varchar2(10);		    	    -- Input to procedure
  vi_endDate		  Varchar2(10);		    	    -- Input to procedure
  vi_AccountNo		Varchar2(20);		    	    -- Input to procedure
  

 
  num number;
  dobal Number := 0;		    	  
  --result_rec Varchar2(30000);
  OpeningAmount Number := 0;
  OpenDate		Varchar2(10);		    	
  v_schm_type Varchar2(10);	
  v_schm_code Varchar2(10);	
  v_joint_nrc Varchar2(100);	
  v_joint_name Varchar2(100);
  v_joint_cif Varchar2(30);
  v_type Varchar2(50);	
  v_acid  Varchar2(50);
  v_id number(20);
  
   
   v_tran_date CUSTOM.CUSTOM_CTD_DTD_ACLI_VIEW.tran_date%type;
    v_tran_amt CUSTOM.CUSTOM_CTD_DTD_ACLI_VIEW.tran_amt%type;
    v_tran_type CUSTOM.CUSTOM_CTD_DTD_ACLI_VIEW.tran_type%type;
    v_part_tran_type CUSTOM.CUSTOM_CTD_DTD_ACLI_VIEW.part_tran_type%type; 
    v_tran_particular varchar2(200);
    v_AccountNumber varchar2(200);
    v_AccountJoin varchar2(200);
    v_AccountName varchar2(300);
    v_Cur TBAADM.GENERAL_ACCT_MAST_TABLE.ACCT_crncy_code%type;
    v_Address varchar2(1000);
    v_Nrc CRMUSER.ACCOUNTS.UNIQUEID%type;
    v_Bal TBAADM.GENERAL_ACCT_MAST_TABLE.clr_bal_amt%type;
    v_PhoneNumber crmuser.phoneemail.phoneno%type;
    v_FaxNumber CRMUSER.address.faxno%type;
    v_BranchName tbaadm.sol.sol_desc%type;
    v_BankAddress varchar(200);
    v_instrmnt_num CUSTOM.CUSTOM_CTD_DTD_ACLI_VIEW.instrmnt_num%type;
    
    v_BankPhone VARCHAR(50);
    v_BankFax VARCHAR(50);
    v_WithdrawCount number :=0;
    v_DepositCount number :=0;
    v_SanctionLimit TBAADM.GENERAL_ACCT_MAST_TABLE.SANCT_LIM%type;
    v_ExpiredDate  TBAADM.LA_ACCT_MAST_TABLE.EI_PERD_END_DATE%type;
     Result_Flg varchar2(100);
         Project_Bank_Name      varchar2(100);
    Project_Image_Name     varchar2(100);
  
  
-----------------------------------------------------------------------------
-- CURSOR declaration FIN_DRAWING_SPBX CURSOR
-----------------------------------------------------------------------------
-----------------------------------------------------------------------------
-- CURSOR ExtractData
-----------------------------------------------------------------------------
CURSOR ExtractData (ci_startDate VARCHAR2, ci_endDate VARCHAR2, ci_AccountNo VARCHAR2,ci_OpenDate VARCHAR2,ci_dobal number)  IS
select *
    from (
      select  
                TO_DATE( CAST ( ci_OpenDate AS VARCHAR(10) ) , 'dd-Mon-yy' ) as TranDate,
                ci_dobal as dobalamt,
                null as TranAmt,
                null as tranType,
                null  as partTranType,
               'Opening Balance' as tran_particular,
                null as instrmnt,
                0 as ForSort,
                v_AccountNumber as AccountNumber,
                v_AccountName as AccountName,
               -- v_Cur as Cur,
                v_Address as Address,
                v_Nrc as Nrc,
                v_PhoneNumber as PhoneNumber,
                v_FaxNumber    			as FaxNumber,
                --v_BranchName	as  BranchName,
                v_BankAddress      			as  BankAddress,
                v_BankPhone as  BankPhone,
                v_BankFax as  BankFax,
                v_SanctionLimit as SanctionLimit, 
                v_ExpiredDate as ExpiredDate
    
        from    dual
        
        union all  
        
         select b.TranDate as TranDate ,
                bankstatement_essential.CUSTOM_DOBAMOUNT(b.partTranType,b.TranAmt) as dobalamt,
                b.TranAmt as TranAmt,
                b.tranType as tranType,
                b.partTranType as partTranType,
                b.tran_particular as tran_particular,
                b.instrmnt as instrmnt,
                rownum as ForSort,
                null as AccountNumber,
                null as AccountName,
                --null as Cur,
                null as Address,
                null as Nrc,
                null as PhoneNumber,
                null    			as FaxNumber,
               -- null	as  BranchName,
                null      			as  BankAddress,
                null as  BankPhone,
                null as  BankFax,
                null as SanctionLimit, 
                null as ExpiredDate
         from (
                select 
                cdav.value_date as TranDate ,
                bankstatement_essential.CUSTOM_DOBAMOUNT(cdav.part_tran_type,cdav.tran_amt) as dobalamt,
                cdav.tran_amt as TranAmt,
                cdav.tran_type as tranType,
                cdav.part_tran_type as partTranType,
                cdav.tran_particular as tran_particular,
                cdav.instrmnt_num as instrmnt,
                cdav.rcre_time,
                cdav.tran_id,
                rownum as ForSort
                --gam.sol_id
              from 
                tbaadm.general_acct_mast_table gam,TBAADM.CTD_DTD_ACLI_VIEW cdav
              where 
                gam.acid = cdav.acid
                And Gam.Foracid = ci_AccountNo
                --and cdav.value_date between TO_DATE( CAST ('30-04-2017' AS VARCHAR(10) ) , 'dd-MM-yyyy' ) 
               -- and TO_DATE( CAST ( ci_endDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                And ((Cdav.Value_Date Between To_Date( Cast (ci_startDate As Varchar(10) ) , 'dd-MM-yyyy' ) 
                  And To_Date( Cast ( ci_endDate As Varchar(10) ) , 'dd-MM-yyyy' ))Or((Cdav.Tran_Date Between To_Date( Cast (ci_startDate As Varchar(10) ) , 'dd-MM-yyyy' ) 
                    And To_Date( Cast ( ci_endDate As Varchar(10) ) , 'dd-MM-yyyy' ))))
                and gam.del_flg != 'Y'
              --  and gam.acct_cls_flg != 'Y'
                and gam.SCHM_TYPE  NOT in ('OAB','OAP','DDA')
                --and cdav.part_tran_type = 'C'
                and gam.bank_id ='01'
                and cdav.pstd_date is not null
                and (trim (cdav.tran_id),trim(cdav.part_tran_srl_num),cdav.tran_date) NOT IN (select trim(atd.cont_tran_id), trim(atd.cont_part_tran_srl_num),atd.cont_tran_date
                                                                                              from TBAADM.ATD atd
                                                                                              where atd.cont_tran_date >= TO_DATE( CAST (ci_startDate  AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                                              and atd.cont_tran_date <= TO_DATE( CAST ( ci_endDate  AS VARCHAR(10) ) , 'dd-MM-yyyy' ) )--Without Reversal
              order by TranDate,cdav.rcre_time,cdav.tran_id,tran_particular)b
              order by forsort

            )t
  
      order by t.forsort;
   -------------------------
  PROCEDURE FIN_BANK_STATEMENT(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT varchar2  ) AS     

   
    
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
   
--------------------------------------------------------------------------------------------
if( vi_startDate is null or vi_endDate is null or vi_AccountNo is null ) then
        --resultstr := 'No Data For Report';
        out_rec:= ( '-' || '|' || 0 || '|' || '-' || '|' || '-' || '|' || '-' || '|' ||
            		0 || '|' || '-' || '|' ||'-' || '|' || '-' || '|' || '-' || '|' || 
					'-' || '|' || '-' || '|' || '-' || '|' ||'-'|| '|' || '-' || '|' ||
					'-'|| '|' || '-'|| '|' || 0 || '|' || 0 || '|' || '-' || '|' || '-');
        --dbms_output.put_line(out_rec);
        out_retCode:= 1;
        RETURN;        
  end if;

 
----------------------------------------------------------------------------

  Begin   
      
     select  tran_date_bal,eod_date INTO OpeningAmount,OpenDate
     from tbaadm.eab,tbaadm.general_acct_mast_table gam
     where gam.acid = tbaadm.eab.acid
     and gam.SCHM_TYPE  NOT in ('OAB','OAP','DDA')
     and eod_date = ( select  eod_date   from(
          select eod_date
          from tbaadm.eab ,tbaadm.general_acct_mast_table gam
          where tbaadm.eab.eod_date < TO_DATE( CAST ( vi_startDate AS VARCHAR(10) ) , 'dd-MM-yyyy' ) 
          and gam.acid = tbaadm.eab.acid
          and gam.foracid = vi_AccountNo
          order by eod_date desc)
          where rownum =1)
     and gam.foracid = vi_AccountNo;    
     EXCEPTION
        WHEN NO_DATA_FOUND THEN
          OpeningAmount := 0.00;  
   end;
   
  
    begin
        delete from CUSTOM.bankstatement_dobal; 
         commit;
    
    Result_Flg := bankstatement_essential.TODAYDOBAL(OpeningAmount);
    end;
    
    --performance tuning
    begin
    select 
    general_acct_mast_table.foracid as "AccountNumber",
    general_acct_mast_table.acct_name || ', '||(select 
                                                LISTAGG(cmg.cust_name, ',') WITHIN GROUP (ORDER BY aas.acct_poa_as_srl_num)as "AcountName"
                                              from 
                                              TBAADM.aas aas ,crmuser.cmg cmg
                                              where 
                                             general_acct_mast_table.acid = aas.acid
                                             and cmg.cust_id= aas.cust_id
                                             and aas.del_flg ='N'
                                                and aas.acct_poa_as_srl_num <> 001
                                              ) 
                                              as AcountName,
  general_acct_mast_table.acct_crncy_code as "Currency",
  sol.sol_desc as BranchName,
  sol.addr_1 || sol.addr_2 || sol.addr_3 as BankAddress,
  bct.PHONE_NUM as BankPhone, 
  bct.FAX_NUM as BankFax,
    (select 
    address.address_line1 ||'/'|| address.address_line2 || address.address_line3 || address.city || address.state || address.country as address
    from
    CRMUSER.address address
    where 
     general_acct_mast_table.cif_id     = address.orgkey 
    and (address.addresscategory='Mailing' or address.addresscategory='Registered')
    ) as Address,
  (select 
      address.faxnolocalcode||address.faxnocountrycode||address.faxnocitycode||address.faxno as "FaxNumber" 
      from CRMUSER.address address
      where 
      general_acct_mast_table.cif_id     = address.orgkey 
      and (address.addresscategory='Mailing' or address.addresscategory='Registered')
  ) as FaxNumber,
  ( SELECT Pe.Phoneno FROM Crmuser.Phoneemail PE 
            WHERE Pe.Phoneoremail  = 'PHONE'
           and Pe.Preferredflag = 'Y'
           AND  PE.ORGKEY = general_acct_mast_table.Cif_Id) 
    As Phonenumber,
    (  select ACCOUNTS.uniqueid as NRC
  from 
  CRMUSER.ACCOUNTS ACCOUNTS
  where 
  ACCOUNTS.orgkey = general_acct_mast_table.cif_id 
  and rownum = 1) as NRC,
  general_acct_mast_table.SANCT_LIM as SanctionLimit,
  general_acct_mast_table.schm_type as schm_type,
  general_acct_mast_table.schm_code as schm_code
 
  into   v_AccountNumber,v_AccountName,v_Cur,   v_BranchName, v_BankAddress, v_BankPhone, v_BankFax,v_Address, v_FaxNumber,  v_PhoneNumber,v_Nrc,
   v_SanctionLimit,v_schm_type,v_schm_code

  from 
  tbaadm.general_acct_mast_table general_acct_mast_table , tbaadm.sol sol, tbaadm.bct bct
  where 
  general_acct_mast_table.foracid = vi_AccountNo
  and general_acct_mast_table.del_flg != 'Y'
   AND bct.br_code = sol.br_code
   and  sol.sol_id = general_acct_mast_table.sol_id
  and general_acct_mast_table.bank_id ='01'
  order by general_acct_mast_table.acct_opn_date desc;
  EXCEPTION
        WHEN NO_DATA_FOUND THEN
         v_AccountNumber  := '';
         v_AccountName    := '';
         v_Cur            := '';
         v_BranchName     := '';
         v_BankAddress    := '';
         v_BankPhone      := '';
         v_BankFax        := '';
         v_Address        := '';
         v_FaxNumber      := '';
         v_PhoneNumber    := '';
         v_Nrc            := '';
         v_SanctionLimit  := 0.00;
         v_schm_type      := '';
         v_schm_code      := '';
END;

 
begin
if v_schm_type = 'LAA' then
  select   
   lam.EI_PERD_END_DATE as "ExpiredDate"
   into v_ExpiredDate
  from 
   TBAADM.GENERAL_ACCT_MAST_TABLE gam ,TBAADM.LA_ACCT_MAST_TABLE lam
  where
   gam.DEL_FLG = 'N' 
   and lam.acid = gam.acid   
   and gam.ACCT_CLS_FLG = 'N' 
   and gam.bank_id = '01'
   and gam.foracid = vi_AccountNo;
   
 else if v_schm_type = 'ODA' or v_schm_code = 'AGDOD' then
      Select  Lim_Exp_Date  Into V_Expireddate From (Select   
     max(lht.LIM_EXP_DATE) as   Lim_Exp_Date    
      from 
      TBAADM.gam gam ,TBAADM.lht lht
      where
      gam.DEL_FLG = 'N' 
      and lht.acid = gam.acid   
      and gam.ACCT_CLS_FLG = 'N' 
      and gam.bank_id = '01'
      And Gam.Foracid = Vi_Accountno
      and lht.Serial_Num In (Select Max(lht1.Serial_Num) From 
                            TBAADM.gam gam1 ,TBAADM.lht lht1
                            Where
                            Gam1.Del_Flg = 'N' 
                            And Lht1.Acid = Gam1.Acid   
                            And Gam1.Acct_Cls_Flg = 'N' 
                            And Gam1.Foracid = Vi_Accountno
                            And Gam1.Bank_Id = '01')
      order by lht.rcre_time desc)
      where rownum = 1;
      
      --3240011000091018
      
      --select * from tbaadm.lht order by lht.rcre_time desc;
      
   end if;   
   end if; 
   
   EXCEPTION
      WHEN NO_DATA_FOUND THEN
        v_ExpiredDate := null;
END;



 IF NOT ExtractData%ISOPEN THEN
		--{
			BEGIN
			--{
				OPEN ExtractData(vi_startDate , vi_endDate, vi_AccountNo,OpenDate,OpeningAmount);
			--}
			END;

		--}
		END IF;
    IF ExtractData%ISOPEN Then
   

      FETCH	ExtractData INTO	 v_tran_date,dobal,v_tran_amt,v_tran_type,v_part_tran_type,v_tran_particular,v_instrmnt_num,v_id,
        v_AccountNumber ,
				 v_AccountName ,
         --v_Cur ,
					v_Address ,
          v_Nrc ,
          v_PhoneNumber ,
          v_FaxNumber    			,
					--v_BranchName	,
					v_BankAddress      			,
					v_BankPhone ,
          v_BankFax ,
          v_SanctionLimit , 
          v_ExpiredDate
          ;
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
    
  ------------------------------------------------------------------------------
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
    out_rec :=	(to_char(to_date(v_tran_date,'dd/Mon/yy'), 'dd/MM/yyyy')||'|' ||
                v_tran_amt 	                || '|' || 
                v_tran_type 	              || '|' || 
                v_part_tran_type 	          || '|' || 
               v_tran_particular            || '|' || 
                dobal                       ||'|'|| 
               v_AccountNumber              || '|' ||
               v_AccountName                || '|' ||
               v_Cur                        ||'|'||
                v_Address                   || '|' ||
                v_Nrc   --	|| ', ' ||-- v_joint_nrc	
                                            || '|' ||
                v_PhoneNumber               || '|' ||
                v_FaxNumber    		         	|| '|' ||
                v_BranchName	              || '|' ||
                v_BankAddress      			    || '|' ||
                v_BankPhone                 || '|' ||
                v_BankFax                   ||'|'||
                v_SanctionLimit             ||'|'|| 
                to_char(to_date(v_ExpiredDate,'dd/Mon/yy'), 'dd Mon,yyyy')||'|'|| 
                v_instrmnt_num              ||'|'|| 
                Project_Bank_Name           ||'|'|| 
                Project_Image_Name    
          );
     
  
			dbms_output.put_line(out_rec);
 
    
  END FIN_BANK_STATEMENT;

END FIN_BANK_STATEMENT;
/
