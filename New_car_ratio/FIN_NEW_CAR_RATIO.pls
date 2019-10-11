CREATE OR REPLACE PACKAGE                             FIN_NEW_CAR_RATIO AS 

  PROCEDURE FIN_NEW_CAR_RATIO(	inp_str      IN  VARCHAR2,
			out_retCode  OUT NUMBER,
			out_rec      OUT VARCHAR2 );  

END FIN_NEW_CAR_RATIO;
/


CREATE OR REPLACE PACKAGE BODY                                                                                                                                                                                                                                                                                                                                                                                                                                                                                FIN_NEW_CAR_RATIO AS
--{
	-------------------------------------------------------------------------------------
  --updated by Saung Hnin Oo (15-5-2017)
	-- Cursor declaration
	-- This cursor will fetch all the data based on the main query
	-------------------------------------------------------------------------------------
  
	outArr			tbaadm.basp0099.ArrayType;  -- Input Parse Array
	vi_Date	   	Varchar2(15);               -- Input to procedure

  

CURSOR ExtractData (ci_Date VARCHAR2)  
IS
select NVL(sum(P.CapitalMMK_amt),0.00)      as CapitalMMK_amt ,
       NVL(sum(P.CapitalFCY_amt),0.00)       as CapitalFCY_amt,
       NVL(sum(P.Retained_earning),0.00)     as Retained_earning,
       NVL(sum(P.statutory_reserve),0.00)    as statutory_reserve,
       NVL(sum(P.Profit_lossL40),0.00)       as Profit_lossL40,
       NVL(sum(P.Profit_lossA50),0.00)       as Profit_lossA50,
       NVL(sum(P.General_Loss),0.00)         as General_Loss,
       NVL(sum(P.CashIn_Kyat) ,0.00)         as CashIn_Kyat,
       NVL(sum(P.CashIn_Kyat1),0.00)         as CashIn_Kyat1,
       NVL(sum(P.CashIn_Kyat2),0.00)         as CashIn_Kyat2,
       -- sum(P.Direct_Claim_CBM) as Direct_Claim_CBM,
       NVL(sum(P.Direct_Claim_CBM1),0.00)    as Direct_Claim_CBM1,
       NVL(sum(P.Direct_Claim_CBM2),0.00)    as Direct_Claim_CBM2,
       NVL(sum(P.Government),0.00)           as Government,
       NVL(sum(P.Cash_Items),0.00)           as Cash_Items,
       NVL(sum(P.Cash_Items1),0.00)          as Cash_Items1,
       NVL(sum(P.Cash_Items2),0.00)          as Cash_Items2,
       NVL(sum(P.Mortgage_Loans),0.00)       as Mortgage_Loans,
       NVL(sum(P.Mortgage_Loans1),0.00)      as Mortgage_Loans1, 
       NVL(sum(P.AllAssets),0.00)            as AllAssets, 
      NVL( sum(P.Less_age),0.00)             as Less_age
     

from (

       select 
         CASE WHEN T.g_code ='L01'  and t.cur='MMK'  THEN (T.Balance)  else 0 END as CapitalMMK_amt,
         CASE WHEN T.g_code ='L01'  and t.cur<>'MMK'  THEN (T.Balance) else 0  END as CapitalFCY_amt,
         
         CASE WHEN T.g_code ='L03'   THEN (T.Balance) else 0   END as Retained_earning,
         
         CASE WHEN T.g_code ='L02'  and T.gl_sub_head_code in ('70021')  THEN (T.Balance) else 0 END as statutory_reserve,
         
         CASE WHEN T.g_code ='L40'   THEN (T.Balance) else 0   END as Profit_lossL40,
         CASE WHEN T.g_code ='A50'   THEN (T.Balance) else 0   END as Profit_lossA50,
         
         CASE WHEN T.g_code ='L02' and T.gl_sub_head_code in ('70061')  THEN (T.Balance) else 0   END as General_Loss,
         
         CASE WHEN T.g_code  = 'A01'  THEN (T.Balance) else 0   END as CashIn_Kyat,
         CASE WHEN T.g_code  = 'A02'   THEN (T.Balance) else 0   END as CashIn_Kyat1,
         CASE WHEN T.g_code  = 'A03'   THEN (T.Balance)  else 0  END as CashIn_Kyat2,
         
        --CASE WHEN T.g_code ='A65'    THEN (T.Balance)    END as Direct_Claim_CBM,   A65 '10327010091','10327010101' Look in Sub Query
         CASE WHEN T.g_code ='A04'    THEN (T.Balance) else 0   END as Direct_Claim_CBM1,
         CASE WHEN T.g_code ='A05'    THEN (T.Balance) else 0   END as Direct_Claim_CBM2,
         
         CASE WHEN T.g_code ='A11'   THEN (T.Balance)  else 0  END as  Government,

         CASE WHEN T.g_code ='A22'    THEN (T.Balance) else 0   END as Cash_Items,
         CASE WHEN T.g_code ='A31'    THEN (T.Balance) else 0   END as Cash_Items1,
         CASE WHEN T.g_code ='A67'    THEN (T.Balance)  else 0  END as Cash_Items2,
        
         
         CASE WHEN T.g_code ='A24' 		and T.gl_sub_head_code = 'Housing Loan'  THEN (T.Balance)  else 0  END as Mortgage_Loans,
         CASE WHEN T.g_code ='A25' 		and T.gl_sub_head_code = '10508'  THEN (T.Balance) else 0   END as Mortgage_Loans1,
         
         CASE WHEN T.g_code  Like 'A%'   THEN T.Balance else 0   END as AllAssets,
         CASE WHEN T.g_code ='A90'   THEN (T.Balance) else 0   END as Less_age
         
         
    from (
        SELECT  q.g_code,q.cur,
        CASE WHEN q.cur = 'MMK' THEN q.Balance
         when  q.gl_sub_head_code = '70002' and  q.Balance <> 0 THEN TO_NUMBER('4138000000')
             ELSE q.Balance * NVL((SELECT r.VAR_CRNCY_UNITS 
                                        FROM TBAADM.RTH r
                                        where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST ( ci_Date AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                        and  r.RATECODE = 'NOR'
                                        and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                        and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                              FROM TBAADM.RTH a
                                                                              where a.Rtlist_date = TO_DATE( CAST ( ci_Date AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                              and  a.RATECODE = 'NOR'
                                                                              and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                              group by a.fxd_crncy_code
                                            )
                                      ),1) END AS Balance ,q.gl_sub_head_code 
            
          FROM
            (SELECT   coa.group_code as g_code,  gstt.crncy_code     AS cur,  
             case when coa.group_code like 'A%' then (gstt.tot_dr_bal -gstt.tot_cr_bal) else (gstt.tot_cr_bal -gstt.tot_dr_bal) end AS Balance , gstt.gl_sub_head_code as gl_sub_head_code
                    FROM   tbaadm.gstt gstt,  custom.coa_mp coa      
                    WHERE coa.gl_sub_head_code = gstt.gl_sub_head_code
                    and coa.cur = gstt.crncy_code
                    AND gstt.bal_date         <= TO_DATE( CAST (ci_Date AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                    AND gstt.END_BAL_DATE     >=TO_DATE( CAST (ci_Date AS  VARCHAR(10) ) , 'dd-MM-yyyy' )
                    AND gstt.del_flg           = 'N'
                    AND gstt.bank_id           = '01'
                       )q
              )T
  )P;
       
-----------------------------------------------------------------------------
-- Procedure declaration FIN_Training_SPBX Procedure
-----------------------------------------------------------------------------
	
    
PROCEDURE FIN_NEW_CAR_RATIO(
    inp_str IN VARCHAR2,
    out_retCode OUT NUMBER,
    out_rec OUT VARCHAR2 )
AS
        v_Capital_amt          Number(20,2);
        v_CapitalFCY_amt       Number(20,2);
        v_Retained_earning     Number(20,2);
        v_statutory_reserve    Number(20,2);
        v_Profit_lossL40       Number(20,2);
        v_Profit_lossA50       Number(20,2);
        v_General_Loss         Number(20,2);
        
        v_CashIn_KyatA01       Number(20,2);
        v_CashIn_KyatA02       Number(20,2);
        v_CashIn_KyatA03       Number(20,2);
       
        v_Direct_Claim_CBM     Number(20,2);
        v_Direct_Claim_CBMA04  Number(20,2);
        v_Direct_Claim_CBMA05  Number(20,2);
        v_DC_Government        Number(20,2);
        
        v_Cash_ItemsA22        Number(20,2);
        v_Cash_ItemsA31        Number(20,2);
        v_Cash_ItemsA67        Number(20,2);
        
        v_Mortgage_LoansA24    Number(20,2);
        v_Mortgage_LoansA25    Number(20,2);
        
        v_AllOtherAssets       Number(20,2);  
         v_Less_age            Number(20,2);
         
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
		 vi_Date := outArr(0);
	
------------------------------------------------------------------------------------------------

 if(vi_Date  is null ) then
        --resultstr := 'No Data For Report';
         out_rec:= ( 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 
							            0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 0 || '|' || 
										0 || '|' || 0 );
		
        --dbms_output.put_line(out_rec);
        out_retCode:= 1;
        RETURN;        
  end if;
  
-----------------------------------------------
-- Query for CBM with Account Number
-----------------------------------------------
Begin
SELECT nvl(abs(SUM(NVL(P.BALANCE,0))),0.00) AS Direct_ClaimCBM into v_Direct_Claim_CBM
FROM (
      SELECT q.cur,
      CASE WHEN q.cur = 'MMK' THEN q.Balance
      ELSE q.Balance * NVL((SELECT r.VAR_CRNCY_UNITS 
                                FROM TBAADM.RTH r
                                where trim(r.fxd_crncy_code) = trim(q.cur) and r.Rtlist_date = TO_DATE( CAST ( vi_Date AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                and  r.RATECODE = 'NOR'
                                and trim(r.VAR_CRNCY_CODE) = 'MMK' 
                                and (fxd_crncy_code, rtlist_num) in (SELECT a.fxd_crncy_code,Max(A.rtlist_num)
                                                                      FROM TBAADM.RTH a
                                                                      where a.Rtlist_date = TO_DATE( CAST ( vi_Date AS VARCHAR(10) ) , 'dd-MM-yyyy' )
                                                                      and  a.RATECODE = 'NOR'
                                                                      and trim(a.VAR_CRNCY_CODE) = 'MMK' 
                                                                      group by a.fxd_crncy_code
                                    )
                              ),1) END AS Balance 
    
  FROM
    (
      select eab.tran_date_bal AS Balance, eab.eab_crncy_code AS CUR

         FROM  TBAADM.EAB EAB, TBAADM.GAM GAM, custom.coa_mp coa
         WHERE EAB.ACID = GAM.ACID 
         and  gam.gl_sub_head_code = coa.gl_sub_head_code
         and  gam.acct_crncy_code = coa.cur
         and  coa.group_code in ('A65')
         AND   EAB.EOD_DATE <= TO_DATE(CAST(vi_Date AS VARCHAR(10)),'dd-MM-yyyy')
         AND   EAB.END_EOD_DATE >=  TO_DATE(CAST(vi_Date AS VARCHAR(10)),'dd-MM-yyyy')
         AND   (GAM.FORACID LIKE ('%10327010091' ) or GAM.FORACID LIKE ('%10327010101' ))
         AND   GAM.DEL_FLG = 'N'
         AND   GAM.ENTITY_CRE_FLG = 'Y'
         AND   EAB.BANK_ID = '01'
         AND   GAM.BANK_ID = '01')Q
    )P;
     EXCEPTION
      WHEN NO_DATA_FOUND THEN
       v_Direct_Claim_CBM := 0.00;
    END;
------------------------------------------------------------------------------------------------
IF NOT ExtractData%ISOPEN THEN
    --{
    BEGIN
      --{
      OPEN ExtractData ( vi_Date );
      --}
    END;
    --}
  END IF;
  IF ExtractData%ISOPEN THEN
    --{
    FETCH ExtractData
    INTO        v_Capital_amt, v_CapitalFCY_amt, v_Retained_earning, v_statutory_reserve,
                v_Profit_lossL40, v_Profit_lossA50, v_General_Loss, v_CashIn_KyatA01,
                v_CashIn_KyatA02, v_CashIn_KyatA03,v_Direct_Claim_CBMA04,v_Direct_Claim_CBMA05,
                v_DC_Government, v_Cash_ItemsA22,v_Cash_ItemsA31,v_Cash_ItemsA67,
                v_Mortgage_LoansA24,v_Mortgage_LoansA25,
                v_AllOtherAssets , v_Less_age  ;
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
      --}'
    END IF;
    --}
  END IF;
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
-----------------------------------------------------------------------------
-- out_rec variable retrieves the data to be sent to LST file with pipe seperation
--------------------------------------------------------------------------------

   out_rec:= (  v_Capital_amt/1000         || '|' ||
                v_CapitalFCY_amt/1000      || '|' ||
                v_Retained_earning/1000    || '|' ||
                v_statutory_reserve/1000   || '|' ||
                v_Profit_lossL40/1000      || '|' ||
                v_Profit_lossA50/1000      || '|' ||
                v_General_Loss/1000        || '|' ||
                v_CashIn_KyatA01/1000      || '|' ||
                v_CashIn_KyatA02/1000      || '|' ||
                v_CashIn_KyatA03/1000      || '|' ||
                v_Direct_Claim_CBM/1000    || '|' ||
                v_Direct_Claim_CBMA04/1000 || '|' ||
                v_Direct_Claim_CBMA05/1000 || '|' ||
                v_DC_Government/1000       || '|' ||
                v_Cash_ItemsA22/1000       || '|' ||
                v_Cash_ItemsA31/1000       || '|' ||
                v_Cash_ItemsA67/1000       || '|' ||
                v_Mortgage_LoansA24/1000   || '|' ||
                v_Mortgage_LoansA25/1000   || '|' ||
                v_AllOtherAssets/1000      || '|' ||
                v_Less_age/1000            || '|' ||
                Project_Bank_Name          || '|' ||
                Project_Image_Name  ); 
  
			dbms_output.put_line(out_rec);
      RETURN;

	
	END FIN_NEW_CAR_RATIO;


END FIN_NEW_CAR_RATIO;
/
