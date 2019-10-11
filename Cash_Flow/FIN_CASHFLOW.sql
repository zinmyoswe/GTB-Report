CREATE OR REPLACE PACKAGE                                           FIN_CASHFLOW
AS
PROCEDURE FIN_CASHFLOW(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );
END FIN_CASHFLOW;
/


CREATE OR REPLACE PACKAGE BODY                                                                                                                                                                                                                                                                                                                                                                                                                                                    FIN_CASHFLOW AS
--{
	-------------------------------------------------------------------------------------
  --updated by Saung Hnin Oo (24-4-2017)
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
	-------------------------------------------------------------------------------------
	outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array
	v_SelectedDate	   	Varchar2(15);               	-- Input to procedure
  v_BranchCode	   	Varchar2(15);               	-- Input to procedure
  
    num number;
    
    CURSOR ExtractData (	
			ci_BranchCode VARCHAR2)   IS      
       select 
         BRANCH_CODE_TABLE.BR_SHORT_NAME as "BranchName",
         BRANCH_CODE_TABLE.BR_ADDR_1 as "Bank_Address",
         BRANCH_CODE_TABLE.PHONE_NUM as "Bank_Phone",
         BRANCH_CODE_TABLE.FAX_NUM as "Bank_Fax"         
      from
         TBAADM.SERVICE_OUTLET_TABLE SERVICE_OUTLET_TABLE ,
         TBAADM.BRANCH_CODE_TABLE BRANCH_CODE_TABLE
      where
         SERVICE_OUTLET_TABLE.SOL_ID = ci_BranchCode
         and SERVICE_OUTLET_TABLE.BR_CODE = BRANCH_CODE_TABLE.BR_CODE
         and SERVICE_OUTLET_TABLE.DEL_FLG = 'N'
         and BRANCH_CODE_TABLE.BANK_CODE = '112'
         and SERVICE_OUTLET_TABLE.BANK_ID = '01';
         
         
      CURSOR ExtractDataHO (	
			ci_BranchCode VARCHAR2)  IS      
       select 
         BRANCH_CODE_TABLE.BR_SHORT_NAME as "BranchName",
         BRANCH_CODE_TABLE.BR_ADDR_1 as "Bank_Address",
         BRANCH_CODE_TABLE.PHONE_NUM as "Bank_Phone",
         BRANCH_CODE_TABLE.FAX_NUM as "Bank_Fax"         
      from
         TBAADM.SERVICE_OUTLET_TABLE SERVICE_OUTLET_TABLE ,
         TBAADM.BRANCH_CODE_TABLE BRANCH_CODE_TABLE
      where
         SERVICE_OUTLET_TABLE.SOL_ID = '10000'
         and SERVICE_OUTLET_TABLE.BR_CODE = BRANCH_CODE_TABLE.BR_CODE
         and SERVICE_OUTLET_TABLE.DEL_FLG = 'N'
         and BRANCH_CODE_TABLE.BANK_CODE = '112'
         and SERVICE_OUTLET_TABLE.BANK_ID = '01';
-----------------------------------------------------------------------------
-- Procedure declaration FIN_Training_SPBX Procedure
-----------------------------------------------------------------------------
	PROCEDURE FIN_CASHFLOW(	inp_str     IN VARCHAR2,
				out_retCode OUT NUMBER,
				out_rec     OUT VARCHAR2)

	IS
  
 
	--{
	-------------------------------------------------------------
	--Variable declaration
	-------------------------------------------------------------
 
  ca_db_amount	      	Number(20,2);
  ca_cr_amount		      Number(20,2); 
  loan_db_amount		    Number(20,2); 
  loan_cr_amount	    	Number(20,2); 
  ir_db_amount		      tbaadm.gstt.tot_cash_Cr_amt%type;  
  ir_cr_amount		      Number(20,2);
  cbm_db_amount		      Number(20,2);
  cbm_cr_amount		      Number(20,2);
  meb_db_amount		      Number(20,2);
  meb_cr_amount		      tbaadm.gstt.TOT_cash_DR_AMT%type; 
  expense_db_amount	  	Number(20,2);
  expense_cr_amount		  Number(20,2);
  other_db_amount	    	Number(20,2);
  other_cr_amount		    Number(20,2);
  cash_in_hand_bal      TBAADM.eab.value_date_tot_tran%type  ;
 pre_cash_in_hand_bal   TBAADM.eab.value_date_tot_tran%type ;
  pre_eod_date          tbaadm.eab.eod_date%type;
  
      v_BranchName          tbaadm.sol.sol_desc%type;
      v_BankAddress         varchar(200);
      v_BankPhone           TBAADM.BRANCH_CODE_TABLE.PHONE_NUM%type;
      v_BankFax             TBAADM.BRANCH_CODE_TABLE.FAX_NUM%type;
      Project_Bank_Name     varchar2(100);
      Project_Image_Name    varchar2(100);
  ---------------------
 BEGIN
	--{
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
		v_SelectedDate:=outArr(0);
    v_BranchCode:=outArr(1);		
------------------------------------------------------------------------------------------------

if( v_SelectedDate is null) then
        --resultstr := 'No Data For Report';
        out_rec:= ( 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0
                   || '|'  || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || '-' || '|' || '-' || '|' || '-' || '|' || '-' || '|' || 
                     '-' || '|' || 0 || '|' || 0 );
        --dbms_output.put_line(out_rec);
        out_retCode:= 1;
        RETURN;        
  end if;


------------------------------------------------------------------------------------------------
if v_BranchCode is not null then
    
    IF NOT ExtractData%ISOPEN THEN
		--{
			BEGIN
			--{
				OPEN ExtractData (v_BranchCode);
			--}
			END;

		--}
		END IF;
    
    IF ExtractData%ISOPEN THEN
		--{
			FETCH	ExtractData
		INTO
         v_BranchName, v_BankAddress, v_BankPhone, v_BankFax;
      

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
    ELSE --branchcode is null
    IF NOT ExtractDataHO%ISOPEN THEN
		--{
			BEGIN
			--{
				OPEN ExtractDataHO(v_BranchCode);
			--}
			END;

		--}
		END IF;
    
    IF ExtractDataHO%ISOPEN THEN
		--{
			FETCH	ExtractDataHO
		INTO
         v_BranchName, v_BankAddress, v_BankPhone, v_BankFax;
      

			------------------------------------------------------------------
			-- Here it is checked whether the cursor has fetched
			-- something or not if not the cursor is closed
			-- and the out ret code is made equal to 1
			------------------------------------------------------------------
			IF ExtractDataHO%NOTFOUND THEN
			--{
				CLOSE ExtractDataHO;
				out_retCode:= 1;
				RETURN;
			--}
			END IF;
		--}
    END IF;

	end if;
    -----------------------------------------------------
		-- Checking whether the cursor is open if not
		-- it is opened
		-----------------------------------------------------
    ----------------------for other Branch---------------------------
  if v_BranchCode is null or v_BranchCode ='' then
        v_BranchCode := '';
  end if;
  ------------------------------------------------------
--if v_BranchCode is not null or v_BranchCode != '' then
  begin
select nvl(sum(amt)/1000000,0.00) into ca_db_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.tot_cash_Cr_amt)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
 AND coa.group_code  in ('L11','L13','L15','L17','L17','L18','L19','L20','L21','L22','L23','L24','L25','L26')
group by coa.cur
    
  )q); 
 EXCEPTION
      WHEN NO_DATA_FOUND THEN
        ca_db_amount := 0.00;  
 end;  
  
  begin   
select nvl(sum(amt)/1000000,0.00) into ca_cr_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.TOT_cash_DR_AMT)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
 AND coa.group_code  in ('L11','L13','L15','L17','L17','L18','L19','L20','L21','L22','L23','L24','L25','L26')
group by coa.cur
  )q);
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        ca_cr_amount := 0.00;  
 end;  
  ---------------CASA,Fixed,SpecialSavings---------------------
  begin
select nvl(sum(amt)/1000000,0.00) into loan_db_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.tot_cash_Cr_amt)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
AND coa.group_code  in ('A21','A23','A24','A25','A26','A27','A28')
group by coa.cur
    
  )q);
 EXCEPTION
      WHEN NO_DATA_FOUND THEN
        loan_db_amount := 0.00;  
 end; 
 
 begin
 select nvl(sum(amt)/1000000,0.00) into loan_cr_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.TOT_cash_DR_AMT)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
AND coa.group_code  in ('A21','A23','A24','A25','A26','A27','A28')
group by coa.cur
  )q);
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        loan_cr_amount := 0.00;
  end;      
  -------------Loan,OD,HP----------------
 begin
  select nvl(sum(amt)/1000000,0.00) into ir_db_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.tot_cash_Cr_amt)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
 AND coa.group_code  in ('L54')
  group by coa.cur
  )q);
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        ir_db_amount := 0.00;  
 end; 
 begin 
  select nvl(sum(amt)/1000000,0.00) into ir_cr_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.TOT_cash_DR_AMT)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
 AND coa.group_code  in ('L54')
  group by coa.cur
  )q);
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        ir_cr_amount := 0.00;  
  end;      
  ------------------IR--------------
  begin
 select nvl(sum(amt)/1000000,0.00) into cbm_db_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.tot_cash_Cr_amt)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)

and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
   AND coa.group_code  in ('A04')
  group by coa.cur
  )q);
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        cbm_db_amount := 0.00;  
  end;
  
  begin
 select nvl(sum(amt)/1000000,0.00) into cbm_cr_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.TOT_cash_DR_AMT)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
   AND coa.group_code  in ('A04')
  group by coa.cur
  )q);
   EXCEPTION
      WHEN NO_DATA_FOUND THEN
        cbm_cr_amount := 0.00;
  end;
  ---------------------Account with CBM--------------
  begin
  select nvl(sum(amt)/1000000,0.00) into meb_db_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.tot_cash_Cr_amt)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
   and coa.group_code in ( 'A06')
   and coa.gl_sub_head_code not in ('10110','10111','10112','10113')
  group by coa.cur
  )q);

  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        meb_db_amount := 0.00;
  end;  
  
  begin
select nvl(sum(amt)/1000000,0.00) into meb_cr_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.TOT_cash_DR_AMT)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
   and coa.group_code in ( 'A06')
   and coa.gl_sub_head_code not in ('10110','10111','10112','10113')
  group by coa.cur
  )q);
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        meb_cr_amount := 0.00;
  end;      
  ---------------------Account with MEB----------------
  
   --------------------Other Bank--------------
  begin
  
  select nvl(sum(amt)/1000000,0.00) into other_db_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.TOT_cash_DR_AMT)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
   and coa.group_code in ( 'A07')
   and coa.gl_sub_head_code not in ('10110','10111','10112','10113')
  group by coa.cur
  )q);
  
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        other_db_amount := 0.00;
  end;  
  
  begin
 select nvl(sum(amt)/1000000,0.00) into other_cr_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
from(
SELECT  sum(gstt.TOT_cash_DR_AMT)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE( v_SelectedDate, 'dd-MM-yyyy' )
   and coa.group_code in ( 'A07')
   and coa.gl_sub_head_code not in ('10110','10111','10112','10113')
  group by coa.cur
  )q);
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        other_cr_amount := 0.00;
  end;      
  ---------------------Other Bank----------------
  
 begin

 select nvl(sum(amt)/1000000,0.00) into expense_db_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
 
 FROM(
select 
case when sum(gstt.tot_clg_Cr_amt + gstt.tot_xfer_Cr_amt) > sum(gstt.tot_clg_dr_amt + gstt.tot_xfer_dr_amt) then
sum(gstt.tot_clg_Cr_amt + gstt.tot_xfer_Cr_amt) - sum(gstt.tot_clg_dr_amt + gstt.tot_xfer_dr_amt) 
else 0 end as amt,
coa.cur
from tbaadm.gstt,custom.coa_mp coa
where coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and coa.group_code not in ('A01','A02','A03')
and gstt.BAL_DATE = TO_DATE(v_SelectedDate, 'dd-MM-yyyy' )  group by 'A81', 'INTERSOL RECONCILIATION',coa.cur
union
SELECT  sum(gstt.TOT_cash_CR_AMT)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE(v_SelectedDate, 'dd-MM-yyyy' )
 and (( coa.group_code not in ( 'L11','L13','L15','L17','L17','L18','L19','L20','L21','L22','L23','L24','L25','L26',
'L54','A01','A02','A03','A21','A23','A24','A25','A26','A27','A28','A04','A06','A07')
  ) or (coa.gl_sub_head_code in ('10110','10111','10112','10113')))
  group by coa.cur
)q 
   )T ;
  

  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        expense_db_amount := 0.00;
  end;
 --------------------------------------------------------------------------- 
  begin
  select nvl(sum(amt)/1000000,0.00) into expense_cr_amount
from(
select CASE WHEN q.cur = 'MMK' THEN q.amt
  ELSE q.amt * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS amt 
 
 FROM(
select 
case when sum(gstt.tot_clg_dr_amt + gstt.tot_xfer_dr_amt) > sum(gstt.tot_clg_cr_amt + gstt.tot_xfer_cr_amt) then
sum(gstt.tot_clg_dr_amt + gstt.tot_xfer_dr_amt) - sum(gstt.tot_clg_cr_amt + gstt.tot_xfer_cr_amt) 
else 0 end as amt,
coa.cur
from tbaadm.gstt,custom.coa_mp coa
where coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and coa.group_code not in ('A01','A02','A03')
and gstt.BAL_DATE = TO_DATE(v_SelectedDate, 'dd-MM-yyyy' )  group by 'A81', 'INTERSOL RECONCILIATION',coa.cur
union
SELECT  sum(gstt.TOT_cash_DR_AMT)  as amt,coa.cur
   FROM  tbaadm.gstt,custom.coa_mp coa
   WHERE  coa.gl_sub_head_code = gstt.gl_sub_head_code
and coa.cur = gstt.crncy_code 
and gstt.sol_id like   '%' || v_BranchCode || '%'
and( gstt.tot_cash_dr_amt >0 or gstt.tot_cash_cr_amt>0)
and gstt.BAL_DATE = TO_DATE(v_SelectedDate, 'dd-MM-yyyy' )
 and (( coa.group_code not in ( 'L11','L13','L15','L17','L17','L18','L19','L20','L21','L22','L23','L24','L25','L26',
'L54','A01','A02','A03','A21','A23','A24','A25','A26','A27','A28','A04','A06','A07')
  ) or (coa.gl_sub_head_code in ('10110','10111','10112','10113')))
  group by coa.cur
)q 
   )T ;
  EXCEPTION
      WHEN NO_DATA_FOUND THEN
        expense_cr_amount := 0.00;
  end;
  ----------------------------------------------- Pre Cash in Hand----------------------------------------------
BEGIN
     select  nvl(sum(t.Dr_amt),0.00) into pre_cash_in_hand_bal 
      from (       
        
        SELECT CASE WHEN q.cur = 'MMK' THEN q.cashinhAND
               ELSE q.cashinhAND * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST (  v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS DR_amt
              from 
              (SELECT    
                sum(gstt.tot_dr_bal-gstt.tot_cr_bal) as cashinhAND,gstt.crncy_code as cur
              FROM 
                 TBAADM.GL_SUB_HEAD_TRAN_TABLE gstt ,custom.coa_mp coa
              WHERE
                gstt.gl_sub_head_code = coa.gl_sub_head_code
                AND (gstt.BAL_DATE,gstt.sol_id,coa.group_code) in ( 
                           SELECT  Max(q.BAL_DATE) , q.sol_id ,q.group_code
                          FROM(
                            SELECT BAL_DATE,gstt.sol_id,coa1.group_code
                            FROM tbaadm.gstt,custom.coa_mp coa1
                            WHERE tbaadm.gstt.BAL_DATE < TO_DATE( CAST ( v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )    
                            --AND tbaadm.gstt.END_BAL_DATE >= TO_DATE( CAST ( '11-04-2017' AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                            And Coa1.Gl_Sub_Head_Code = Gstt.Gl_Sub_Head_Code
                            --AND gstt.SOL_ID like   '%' || v_BranchCode || '%'
                            AND gstt.crncy_code  = coa1.cur
                            AND coa1.group_code in ('A01','A02','A03')
                            --AND rownum =1
                            order by BAL_DATE desc)q
                            group by  q.sol_id ,q.group_code
                            )
                 AND gstt.SOL_ID like   '%' || v_BranchCode || '%'
                 AND (gstt.tot_cr_bal > 0 or gstt.tot_dr_bal > 0)
                 AND gstt.DEL_FLG = 'N' 
                 AND gstt.BANK_ID = '01'
                 AND gstt.crncy_code = coa.cur
                 And Coa.Group_Code In ('A01','A02','A03') Group By Gstt.Crncy_Code)Q)T
   ;
       
        EXCEPTION
      WHEN NO_DATA_FOUND THEN
        pre_cash_in_hand_bal := 0.00;  
          END;
  ---------------------------------------------------Cash in Hand----------------------------------------------
  BEGIN

SELECT sum(cashinhAND)  into cash_in_hand_bal FROM ( 
SELECT    
  sum(gstt.tot_dr_bal-gstt.tot_cr_bal) as cashinhAND
FROM 
   TBAADM.GL_SUB_HEAD_TRAN_TABLE gstt ,tbaadm.gl_sub_head_table gsh,custom.coa_mp coa
WHERE
  gstt.gl_sub_head_code = gsh.gl_sub_head_code
   AND gstt.sol_id=gsh.sol_id
   AND gsh.gl_sub_head_code = coa.gl_sub_head_code
   AND gstt.BAL_DATE <= TO_DATE( CAST ( v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
   AND gstt.END_BAL_DATE >= TO_DATE( CAST ( v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
   --AND gstt.BAL_DATE = TO_DATE( CAST ( v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' ) 
   AND gstt.SOL_ID like   '%' || v_BranchCode || '%'
   AND (gstt.tot_cr_bal > 0 or gstt.tot_dr_bal > 0)
   AND gstt.DEL_FLG = 'N' 
   AND gstt.BANK_ID = '01'
   AND gsh.crncy_code = gstt.crncy_code
   AND gstt.crncy_code = coa.cur
   AND coa.group_code in ('A01')
   
   UNION 
   
   SELECT    
  sum(gstt.tot_dr_bal-gstt.tot_cr_bal) as cashatatm --into v_openingamount
FROM 
   TBAADM.GL_SUB_HEAD_TRAN_TABLE gstt ,tbaadm.gl_sub_head_table gsh,custom.coa_mp coa
WHERE
  gstt.gl_sub_head_code = gsh.gl_sub_head_code
   AND gstt.sol_id=gsh.sol_id
   AND gsh.gl_sub_head_code = coa.gl_sub_head_code
   AND gstt.BAL_DATE <= TO_DATE( CAST ( v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
   AND gstt.END_BAL_DATE >= TO_DATE( CAST ( v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )
   AND gstt.SOL_ID  like   '%' || v_BranchCode || '%'
   AND (gstt.tot_cr_bal > 0 or gstt.tot_dr_bal > 0)
   AND gstt.DEL_FLG = 'N' 
   AND gstt.BANK_ID = '01'
   AND gsh.crncy_code = gstt.crncy_code
   AND gstt.crncy_code = coa.cur
   AND coa.group_code in ('A03')); 
       
        EXCEPTION
      WHEN NO_DATA_FOUND THEN
        cash_in_hand_bal := 0.00;  
                  
    END; 
    	dbms_output.put_line('MoeHtet'||cash_in_hand_bal);  
  ------------------------------------------------------------------------------------------------
  ----------------------------------------------Pre Eod date--------------------------------------
  BEGIN
           
           SELECT max(bal_date) into pre_eod_date
   from tbaadm.gstt gstt where          
  gstt.SOL_ID like '%'|| v_BranchCode ||'%'
  and gstt.bal_date < TO_DATE( CAST ( v_SelectedDate AS VARCHAR(10) ) , 'dd-MM-yyyy' )  order by bal_date desc  ;   
          END;
--end if;
--------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------
    -- GET BANK INFORMATION
-------------------------------------------------------------------------------
 BEGIN
  SELECT sol.sol_desc,sol.addr_1 || sol.addr_2 || sol.addr_3,bct.PHONE_NUM, bct.FAX_NUM
   into  v_BranchName, v_BankAddress, v_BankPhone, v_BankFax
   FROM tbaadm.sol,tbaadm.bct 
   WHERE sol.SOL_ID = v_BranchCode 
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
  
  -----------------------------------------------------------------------------------------------------------------------------------------
 
  ----------------Expense---------------------
    -----------------------------------------------------------------------------------
			--  out_rec variable retrieves the data to be sent to LST file with pipe seperation
			------------------------------------------------------------------------------------
			out_rec :=	(	 ca_db_amount	||'|'||
                   ca_cr_amount	||'|'||
                   loan_db_amount	||'|'||
                   loan_cr_amount	||'|'|| 
                   ir_db_amount	||'|'||
                   ir_cr_amount	||'|'|| 
                   cbm_db_amount	||'|'||
                   cbm_cr_amount	||'|'||
                   meb_db_amount	||'|'||
                   meb_cr_amount	||'|'|| 
                   expense_db_amount	||'|'||
                   expense_cr_amount	||'|'||
                    cash_in_hand_bal/1000000 || '|' ||
                pre_cash_in_hand_bal/1000000 || '|' || 
                trim(to_char(to_date(pre_eod_date,'dd-Mon-yy'), 'dd-MM-yyyy')  ) || '|' ||   
          other_db_amount       || '|' ||
          other_cr_amount       || '|' || 
          v_BranchName	        || '|' ||
					v_BankAddress      	  || '|' ||
					v_BankPhone           || '|' ||
          v_BankFax             || '|' ||
          Project_Bank_Name     || '|' ||
          Project_Image_Name    
          
           );

			dbms_output.put_line(out_rec);  
      RETURN;

	--}-end for procedure
	END FIN_CASHFLOW;

--}--end package
END FIN_CASHFLOW;

------------------------------------------------------------------
-- Execution grants are given to tbaadm, tbagen, tbautil
-- Synonym is made for TBAGEN.FIN_Training_SPBX
------------------------------------------------------------------
/
