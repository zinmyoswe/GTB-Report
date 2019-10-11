/*
 * Generated by JasperReports - 12/20/17 9:40 AM
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;

import com.infy.finacle.finrpt.utils.*;
import net.sf.jasperreports.engine.*;
import com.infy.finacle.finrpt.ireport.*;
import java.util.*;
import com.infy.finacle.finrpt.*;
import net.sf.jasperreports.engine.data.*;


/**
 *
 */
class AccountOpenListing_1513739455277_933409 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_FIN_REPORT_TYPE = null;
    private JRFillParameter parameter_REPORT_FILE_RESOLVER = null;
    private JRFillParameter parameter_FIN_OUT_REC = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_FIN_REPORT_DESC = null;
    private JRFillParameter parameter_FIN_SER_FINQUERY = null;
    private JRFillParameter parameter_FINRPT_DEFAULT_FORMAT = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_FIN_DB_CONN = null;
    private JRFillParameter parameter_FIN_REPOS_FILE = null;
    private JRFillParameter parameter_FIN_OUT_RETCODE = null;
    private JRFillParameter parameter_P_StartDate = null;
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_FIN_REPORT_TO = null;
    private JRFillParameter parameter_P_Currency = null;
    private JRFillParameter parameter_FIN_BANKREPOS_PARAM = null;
    private JRFillParameter parameter_FIN_IMG_PATH = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_P_EndDate = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_FIN_REPOS_LIST = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_FIN_SESSION_ID = null;
    private JRFillParameter parameter_SchmCode = null;
    private JRFillParameter parameter_FIN_TEMPLATE_PATH = null;
    private JRFillParameter parameter_FIN_APP_UTIL = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_P_SchmType = null;
    private JRFillParameter parameter_FIN_JASPER_PATH = null;
    private JRFillParameter parameter_FIN_INP_STR = null;
    private JRFillParameter parameter_P_BranchCode = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_AccountNumber = null;
    private JRFillField field_BankFax = null;
    private JRFillField field_v_NRC_Number = null;
    private JRFillField field_v_OpenAmount = null;
    private JRFillField field_PhoneNumber = null;
    private JRFillField field_BankName = null;
    private JRFillField field_v_Currency = null;
    private JRFillField field_BranchAddress = null;
    private JRFillField field_BranchName = null;
    private JRFillField field_ImageName = null;
    private JRFillField field_FaxNumber = null;
    private JRFillField field_Address = null;
    private JRFillField field_AccountName = null;
    private JRFillField field_OpenDate = null;
    private JRFillField field_BankPhone = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_FIN_REPOSITORY = null;
    private JRFillVariable variable_TODAY = null;
    private JRFillVariable variable_FIN_DB_CONN = null;


    /**
     *
     */
    void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    void initParams(Map pm)
    {
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_FIN_REPORT_TYPE = (JRFillParameter)pm.get("FIN_REPORT_TYPE");
        parameter_REPORT_FILE_RESOLVER = (JRFillParameter)pm.get("REPORT_FILE_RESOLVER");
        parameter_FIN_OUT_REC = (JRFillParameter)pm.get("FIN_OUT_REC");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_FIN_REPORT_DESC = (JRFillParameter)pm.get("FIN_REPORT_DESC");
        parameter_FIN_SER_FINQUERY = (JRFillParameter)pm.get("FIN_SER_FINQUERY");
        parameter_FINRPT_DEFAULT_FORMAT = (JRFillParameter)pm.get("FINRPT_DEFAULT_FORMAT");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_FIN_DB_CONN = (JRFillParameter)pm.get("FIN_DB_CONN");
        parameter_FIN_REPOS_FILE = (JRFillParameter)pm.get("FIN_REPOS_FILE");
        parameter_FIN_OUT_RETCODE = (JRFillParameter)pm.get("FIN_OUT_RETCODE");
        parameter_P_StartDate = (JRFillParameter)pm.get("P_StartDate");
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_FIN_REPORT_TO = (JRFillParameter)pm.get("FIN_REPORT_TO");
        parameter_P_Currency = (JRFillParameter)pm.get("P_Currency");
        parameter_FIN_BANKREPOS_PARAM = (JRFillParameter)pm.get("FIN_BANKREPOS_PARAM");
        parameter_FIN_IMG_PATH = (JRFillParameter)pm.get("FIN_IMG_PATH");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_P_EndDate = (JRFillParameter)pm.get("P_EndDate");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_FIN_REPOS_LIST = (JRFillParameter)pm.get("FIN_REPOS_LIST");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_FIN_SESSION_ID = (JRFillParameter)pm.get("FIN_SESSION_ID");
        parameter_SchmCode = (JRFillParameter)pm.get("SchmCode");
        parameter_FIN_TEMPLATE_PATH = (JRFillParameter)pm.get("FIN_TEMPLATE_PATH");
        parameter_FIN_APP_UTIL = (JRFillParameter)pm.get("FIN_APP_UTIL");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_P_SchmType = (JRFillParameter)pm.get("P_SchmType");
        parameter_FIN_JASPER_PATH = (JRFillParameter)pm.get("FIN_JASPER_PATH");
        parameter_FIN_INP_STR = (JRFillParameter)pm.get("FIN_INP_STR");
        parameter_P_BranchCode = (JRFillParameter)pm.get("P_BranchCode");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    void initFields(Map fm)
    {
        field_AccountNumber = (JRFillField)fm.get("AccountNumber");
        field_BankFax = (JRFillField)fm.get("BankFax");
        field_v_NRC_Number = (JRFillField)fm.get("v_NRC_Number");
        field_v_OpenAmount = (JRFillField)fm.get("v_OpenAmount");
        field_PhoneNumber = (JRFillField)fm.get("PhoneNumber");
        field_BankName = (JRFillField)fm.get("BankName");
        field_v_Currency = (JRFillField)fm.get("v_Currency");
        field_BranchAddress = (JRFillField)fm.get("BranchAddress");
        field_BranchName = (JRFillField)fm.get("BranchName");
        field_ImageName = (JRFillField)fm.get("ImageName");
        field_FaxNumber = (JRFillField)fm.get("FaxNumber");
        field_Address = (JRFillField)fm.get("Address");
        field_AccountName = (JRFillField)fm.get("AccountName");
        field_OpenDate = (JRFillField)fm.get("OpenDate");
        field_BankPhone = (JRFillField)fm.get("BankPhone");
    }


    /**
     *
     */
    void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
        variable_FIN_REPOSITORY = (JRFillVariable)vm.get("FIN_REPOSITORY");
        variable_TODAY = (JRFillVariable)vm.get("TODAY");
        variable_FIN_DB_CONN = (JRFillVariable)vm.get("FIN_DB_CONN");
    }


    /**
     *
     */
    Object evaluate(int id)
    {
        Object value = null;

        if (id == 0)
        {
            value = (java.lang.String)("");
        }
        else if (id == 1)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 2)
        {
            value = (java.lang.String)("../images");
        }
        else if (id == 3)
        {
            value = (java.lang.String)("../jrxml");
        }
        else if (id == 4)
        {
            value = (java.lang.String)("");
        }
        else if (id == 5)
        {
            value = (java.lang.String)("");
        }
        else if (id == 6)
        {
            value = (java.lang.String)("");
        }
        else if (id == 7)
        {
            value = (java.lang.String)("");
        }
        else if (id == 8)
        {
            value = (java.lang.String)("");
        }
        else if (id == 9)
        {
            value = (java.lang.String)("");
        }
        else if (id == 10)
        {
            value = (java.lang.String)("CUSTOM|FIN_ACCOUNT_OPEN_LISTING.FIN_ACCOUNT_OPEN_LISTING%3%CUSTOM::|where%StartDate%=%((java.lang.String)parameter_P_StartDate.getValue())%Parameter%Date::and%EndDate%=%((java.lang.String)parameter_P_EndDate.getValue())%Parameter%Date::and%Currency%=%((java.lang.String)parameter_P_Currency.getValue())%Parameter%String::and%SchmType%=%((java.lang.String)parameter_P_SchmType.getValue())%Parameter%String::and%SchmCode%=%((java.lang.String)parameter_SchmCode.getValue())%Parameter%String::and%BranchCode%=%((java.lang.String)parameter_P_BranchCode.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_StartDate%java.sql.Timestamp%10%!NULL!%StartDate@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_EndDate%java.sql.Timestamp%10%!NULL!%EndDate@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_Currency%java.lang.String%100%!NULL!%Currency@DBQUERY%PRODUCT!@!Cntry_Crncy_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_SchmType%java.lang.String%100%!NULL!%SchmType@DBQUERY%PRODUCT!@!Schm_Type_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::SchmCode%java.lang.String%100%!NULL!%Schm Code@DBQUERY%PRODUCT!@!SchemeCodes_List1#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_BranchCode%java.lang.String%100%!NULL!%BranchCode@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_ACCOUNT_OPEN_LISTING.FIN_ACCOUNT_OPEN_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_ACCOUNT_OPEN_LISTING.FIN_ACCOUNT_OPEN_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 11)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_StartDate.getValue()) + "!" +((java.lang.String)parameter_P_EndDate.getValue()) + "!" +((java.lang.String)parameter_P_Currency.getValue()) + "!" +((java.lang.String)parameter_P_SchmType.getValue()) + "!" +((java.lang.String)parameter_SchmCode.getValue()) + "!" +((java.lang.String)parameter_P_BranchCode.getValue()));
        }
        else if (id == 12)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 13)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 14)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 15)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 16)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 17)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 18)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 19)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 20)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 21)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 22)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 23)
        {
            value = (java.lang.String)(((java.lang.String)field_BankName.getValue()) +" (" + ((java.lang.String)field_BranchName.getValue()) + ")");
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.String)field_BankPhone.getValue()));
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_BankFax.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.String)field_BranchAddress.getValue()));
        }
        else if (id == 27)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_ImageName.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 28)
        {
            value = (java.lang.String)("Listing For "+((((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("TDA")) ? 
"Fixed Deposit" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("SBA"))? 
"Saving" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("LAA"))? 
"Loan" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("CAA"))?
"Current" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("OAB"))?
"Office":"Unknown")+" Account Opening (All) From "+((java.lang.String)parameter_P_StartDate.getValue())+" To "+((java.lang.String)parameter_P_EndDate.getValue()));
        }
        else if (id == 29)
        {
            value = (java.util.Date)(new Date());
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.String)field_AccountNumber.getValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.String)(((java.lang.String)field_AccountName.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.String)field_v_NRC_Number.getValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(((java.lang.String)field_Address.getValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)(((java.lang.String)field_OpenDate.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_PhoneNumber.getValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.String)field_FaxNumber.getValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Currency.getValue()));
        }
        else if (id == 38)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_OpenAmount.getValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)("Page No. : " + ((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)("Total (" +((java.lang.Integer)variable_REPORT_COUNT.getValue())+ ") Record Listed.");
        }

        return value;
    }


    /**
     *
     */
    Object evaluateOld(int id)
    {
        Object value = null;

        if (id == 0)
        {
            value = (java.lang.String)("");
        }
        else if (id == 1)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 2)
        {
            value = (java.lang.String)("../images");
        }
        else if (id == 3)
        {
            value = (java.lang.String)("../jrxml");
        }
        else if (id == 4)
        {
            value = (java.lang.String)("");
        }
        else if (id == 5)
        {
            value = (java.lang.String)("");
        }
        else if (id == 6)
        {
            value = (java.lang.String)("");
        }
        else if (id == 7)
        {
            value = (java.lang.String)("");
        }
        else if (id == 8)
        {
            value = (java.lang.String)("");
        }
        else if (id == 9)
        {
            value = (java.lang.String)("");
        }
        else if (id == 10)
        {
            value = (java.lang.String)("CUSTOM|FIN_ACCOUNT_OPEN_LISTING.FIN_ACCOUNT_OPEN_LISTING%3%CUSTOM::|where%StartDate%=%((java.lang.String)parameter_P_StartDate.getValue())%Parameter%Date::and%EndDate%=%((java.lang.String)parameter_P_EndDate.getValue())%Parameter%Date::and%Currency%=%((java.lang.String)parameter_P_Currency.getValue())%Parameter%String::and%SchmType%=%((java.lang.String)parameter_P_SchmType.getValue())%Parameter%String::and%SchmCode%=%((java.lang.String)parameter_SchmCode.getValue())%Parameter%String::and%BranchCode%=%((java.lang.String)parameter_P_BranchCode.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_StartDate%java.sql.Timestamp%10%!NULL!%StartDate@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_EndDate%java.sql.Timestamp%10%!NULL!%EndDate@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_Currency%java.lang.String%100%!NULL!%Currency@DBQUERY%PRODUCT!@!Cntry_Crncy_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_SchmType%java.lang.String%100%!NULL!%SchmType@DBQUERY%PRODUCT!@!Schm_Type_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::SchmCode%java.lang.String%100%!NULL!%Schm Code@DBQUERY%PRODUCT!@!SchemeCodes_List1#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_BranchCode%java.lang.String%100%!NULL!%BranchCode@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_ACCOUNT_OPEN_LISTING.FIN_ACCOUNT_OPEN_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_ACCOUNT_OPEN_LISTING.FIN_ACCOUNT_OPEN_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 11)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_StartDate.getValue()) + "!" +((java.lang.String)parameter_P_EndDate.getValue()) + "!" +((java.lang.String)parameter_P_Currency.getValue()) + "!" +((java.lang.String)parameter_P_SchmType.getValue()) + "!" +((java.lang.String)parameter_SchmCode.getValue()) + "!" +((java.lang.String)parameter_P_BranchCode.getValue()));
        }
        else if (id == 12)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 13)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 14)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 15)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 16)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 17)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 18)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 19)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 20)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 21)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 22)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 23)
        {
            value = (java.lang.String)(((java.lang.String)field_BankName.getOldValue()) +" (" + ((java.lang.String)field_BranchName.getOldValue()) + ")");
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.String)field_BankPhone.getOldValue()));
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_BankFax.getOldValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.String)field_BranchAddress.getOldValue()));
        }
        else if (id == 27)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_ImageName.getOldValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 28)
        {
            value = (java.lang.String)("Listing For "+((((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("TDA")) ? 
"Fixed Deposit" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("SBA"))? 
"Saving" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("LAA"))? 
"Loan" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("CAA"))?
"Current" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("OAB"))?
"Office":"Unknown")+" Account Opening (All) From "+((java.lang.String)parameter_P_StartDate.getValue())+" To "+((java.lang.String)parameter_P_EndDate.getValue()));
        }
        else if (id == 29)
        {
            value = (java.util.Date)(new Date());
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.String)field_AccountNumber.getOldValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.String)(((java.lang.String)field_AccountName.getOldValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.String)field_v_NRC_Number.getOldValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(((java.lang.String)field_Address.getOldValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)(((java.lang.String)field_OpenDate.getOldValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_PhoneNumber.getOldValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.String)field_FaxNumber.getOldValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Currency.getOldValue()));
        }
        else if (id == 38)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_OpenAmount.getOldValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)("Page No. : " + ((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)("Total (" +((java.lang.Integer)variable_REPORT_COUNT.getOldValue())+ ") Record Listed.");
        }

        return value;
    }


    /**
     *
     */
    Object evaluateEstimated(int id)
    {
        Object value = null;

        if (id == 0)
        {
            value = (java.lang.String)("");
        }
        else if (id == 1)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 2)
        {
            value = (java.lang.String)("../images");
        }
        else if (id == 3)
        {
            value = (java.lang.String)("../jrxml");
        }
        else if (id == 4)
        {
            value = (java.lang.String)("");
        }
        else if (id == 5)
        {
            value = (java.lang.String)("");
        }
        else if (id == 6)
        {
            value = (java.lang.String)("");
        }
        else if (id == 7)
        {
            value = (java.lang.String)("");
        }
        else if (id == 8)
        {
            value = (java.lang.String)("");
        }
        else if (id == 9)
        {
            value = (java.lang.String)("");
        }
        else if (id == 10)
        {
            value = (java.lang.String)("CUSTOM|FIN_ACCOUNT_OPEN_LISTING.FIN_ACCOUNT_OPEN_LISTING%3%CUSTOM::|where%StartDate%=%((java.lang.String)parameter_P_StartDate.getValue())%Parameter%Date::and%EndDate%=%((java.lang.String)parameter_P_EndDate.getValue())%Parameter%Date::and%Currency%=%((java.lang.String)parameter_P_Currency.getValue())%Parameter%String::and%SchmType%=%((java.lang.String)parameter_P_SchmType.getValue())%Parameter%String::and%SchmCode%=%((java.lang.String)parameter_SchmCode.getValue())%Parameter%String::and%BranchCode%=%((java.lang.String)parameter_P_BranchCode.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_StartDate%java.sql.Timestamp%10%!NULL!%StartDate@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_EndDate%java.sql.Timestamp%10%!NULL!%EndDate@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_Currency%java.lang.String%100%!NULL!%Currency@DBQUERY%PRODUCT!@!Cntry_Crncy_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_SchmType%java.lang.String%100%!NULL!%SchmType@DBQUERY%PRODUCT!@!Schm_Type_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::SchmCode%java.lang.String%100%!NULL!%Schm Code@DBQUERY%PRODUCT!@!SchemeCodes_List1#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_BranchCode%java.lang.String%100%!NULL!%BranchCode@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_ACCOUNT_OPEN_LISTING.FIN_ACCOUNT_OPEN_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_ACCOUNT_OPEN_LISTING.FIN_ACCOUNT_OPEN_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 11)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_StartDate.getValue()) + "!" +((java.lang.String)parameter_P_EndDate.getValue()) + "!" +((java.lang.String)parameter_P_Currency.getValue()) + "!" +((java.lang.String)parameter_P_SchmType.getValue()) + "!" +((java.lang.String)parameter_SchmCode.getValue()) + "!" +((java.lang.String)parameter_P_BranchCode.getValue()));
        }
        else if (id == 12)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 13)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 14)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 15)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 16)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 17)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 18)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 19)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 20)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 21)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 22)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 23)
        {
            value = (java.lang.String)(((java.lang.String)field_BankName.getValue()) +" (" + ((java.lang.String)field_BranchName.getValue()) + ")");
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.String)field_BankPhone.getValue()));
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_BankFax.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.String)field_BranchAddress.getValue()));
        }
        else if (id == 27)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_ImageName.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 28)
        {
            value = (java.lang.String)("Listing For "+((((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("TDA")) ? 
"Fixed Deposit" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("SBA"))? 
"Saving" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("LAA"))? 
"Loan" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("CAA"))?
"Current" : (((java.lang.String)parameter_P_SchmType.getValue()).toUpperCase().equals("OAB"))?
"Office":"Unknown")+" Account Opening (All) From "+((java.lang.String)parameter_P_StartDate.getValue())+" To "+((java.lang.String)parameter_P_EndDate.getValue()));
        }
        else if (id == 29)
        {
            value = (java.util.Date)(new Date());
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.String)field_AccountNumber.getValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.String)(((java.lang.String)field_AccountName.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.String)field_v_NRC_Number.getValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(((java.lang.String)field_Address.getValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)(((java.lang.String)field_OpenDate.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_PhoneNumber.getValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.String)field_FaxNumber.getValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Currency.getValue()));
        }
        else if (id == 38)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_OpenAmount.getValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)("Page No. : " + ((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)("Total (" +((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue())+ ") Record Listed.");
        }

        return value;
    }


}
