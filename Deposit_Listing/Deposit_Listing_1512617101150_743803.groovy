/*
 * Generated by JasperReports - 12/7/17 9:55 AM
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
class Deposit_Listing_1512617101150_743803 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_P_END_DATE = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_FIN_REPORT_TYPE = null;
    private JRFillParameter parameter_REPORT_FILE_RESOLVER = null;
    private JRFillParameter parameter_FIN_OUT_REC = null;
    private JRFillParameter parameter_FIN_SORT_LIST = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_FIN_REPORT_DESC = null;
    private JRFillParameter parameter_FIN_SER_FINQUERY = null;
    private JRFillParameter parameter_FINRPT_DEFAULT_FORMAT = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_FIN_ALREADY_SORTED = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_FIN_DB_CONN = null;
    private JRFillParameter parameter_FIN_REPOS_FILE = null;
    private JRFillParameter parameter_FIN_OUT_RETCODE = null;
    private JRFillParameter parameter_P_SCHM_CODE = null;
    private JRFillParameter parameter_P_START_DATE = null;
    private JRFillParameter parameter_P_SOL_ID = null;
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_FIN_REPORT_TO = null;
    private JRFillParameter parameter_P_Currency = null;
    private JRFillParameter parameter_FIN_BANKREPOS_PARAM = null;
    private JRFillParameter parameter_FIN_IMG_PATH = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_FIN_REPOS_LIST = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_FIN_SESSION_ID = null;
    private JRFillParameter parameter_FIN_TEMPLATE_PATH = null;
    private JRFillParameter parameter_FIN_APP_UTIL = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_P_ENTRY_USER_ID = null;
    private JRFillParameter parameter_FIN_JASPER_PATH = null;
    private JRFillParameter parameter_FIN_INP_STR = null;
    private JRFillParameter parameter_P_SCHM_TYPE = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_v_BankFax = null;
    private JRFillField field_v_accountNumber = null;
    private JRFillField field_v_enteredBy = null;
    private JRFillField field_Project_Bank_Name = null;
    private JRFillField field_v_entryDate = null;
    private JRFillField field_v_BankPhone = null;
    private JRFillField field_v_entryNumber = null;
    private JRFillField field_Project_Image_Name = null;
    private JRFillField field_v_accountName = null;
    private JRFillField field_v_amount = null;
    private JRFillField field_v_BankAddress = null;
    private JRFillField field_v_BranchName = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_FIN_REPOSITORY = null;
    private JRFillVariable variable_TODAY = null;
    private JRFillVariable variable_FIN_DB_CONN = null;
    private JRFillVariable variable_Grand_amount = null;


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
        parameter_P_END_DATE = (JRFillParameter)pm.get("P_END_DATE");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_FIN_REPORT_TYPE = (JRFillParameter)pm.get("FIN_REPORT_TYPE");
        parameter_REPORT_FILE_RESOLVER = (JRFillParameter)pm.get("REPORT_FILE_RESOLVER");
        parameter_FIN_OUT_REC = (JRFillParameter)pm.get("FIN_OUT_REC");
        parameter_FIN_SORT_LIST = (JRFillParameter)pm.get("FIN_SORT_LIST");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_FIN_REPORT_DESC = (JRFillParameter)pm.get("FIN_REPORT_DESC");
        parameter_FIN_SER_FINQUERY = (JRFillParameter)pm.get("FIN_SER_FINQUERY");
        parameter_FINRPT_DEFAULT_FORMAT = (JRFillParameter)pm.get("FINRPT_DEFAULT_FORMAT");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_FIN_ALREADY_SORTED = (JRFillParameter)pm.get("FIN_ALREADY_SORTED");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_FIN_DB_CONN = (JRFillParameter)pm.get("FIN_DB_CONN");
        parameter_FIN_REPOS_FILE = (JRFillParameter)pm.get("FIN_REPOS_FILE");
        parameter_FIN_OUT_RETCODE = (JRFillParameter)pm.get("FIN_OUT_RETCODE");
        parameter_P_SCHM_CODE = (JRFillParameter)pm.get("P_SCHM_CODE");
        parameter_P_START_DATE = (JRFillParameter)pm.get("P_START_DATE");
        parameter_P_SOL_ID = (JRFillParameter)pm.get("P_SOL_ID");
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_FIN_REPORT_TO = (JRFillParameter)pm.get("FIN_REPORT_TO");
        parameter_P_Currency = (JRFillParameter)pm.get("P_Currency");
        parameter_FIN_BANKREPOS_PARAM = (JRFillParameter)pm.get("FIN_BANKREPOS_PARAM");
        parameter_FIN_IMG_PATH = (JRFillParameter)pm.get("FIN_IMG_PATH");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_FIN_REPOS_LIST = (JRFillParameter)pm.get("FIN_REPOS_LIST");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_FIN_SESSION_ID = (JRFillParameter)pm.get("FIN_SESSION_ID");
        parameter_FIN_TEMPLATE_PATH = (JRFillParameter)pm.get("FIN_TEMPLATE_PATH");
        parameter_FIN_APP_UTIL = (JRFillParameter)pm.get("FIN_APP_UTIL");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_P_ENTRY_USER_ID = (JRFillParameter)pm.get("P_ENTRY_USER_ID");
        parameter_FIN_JASPER_PATH = (JRFillParameter)pm.get("FIN_JASPER_PATH");
        parameter_FIN_INP_STR = (JRFillParameter)pm.get("FIN_INP_STR");
        parameter_P_SCHM_TYPE = (JRFillParameter)pm.get("P_SCHM_TYPE");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    void initFields(Map fm)
    {
        field_v_BankFax = (JRFillField)fm.get("v_BankFax");
        field_v_accountNumber = (JRFillField)fm.get("v_accountNumber");
        field_v_enteredBy = (JRFillField)fm.get("v_enteredBy");
        field_Project_Bank_Name = (JRFillField)fm.get("Project_Bank_Name");
        field_v_entryDate = (JRFillField)fm.get("v_entryDate");
        field_v_BankPhone = (JRFillField)fm.get("v_BankPhone");
        field_v_entryNumber = (JRFillField)fm.get("v_entryNumber");
        field_Project_Image_Name = (JRFillField)fm.get("Project_Image_Name");
        field_v_accountName = (JRFillField)fm.get("v_accountName");
        field_v_amount = (JRFillField)fm.get("v_amount");
        field_v_BankAddress = (JRFillField)fm.get("v_BankAddress");
        field_v_BranchName = (JRFillField)fm.get("v_BranchName");
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
        variable_Grand_amount = (JRFillVariable)vm.get("Grand_amount");
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
            value = (java.lang.String)(((net.sf.jasperreports.engine.JRDataSource)parameter_REPORT_DATA_SOURCE.getValue()).doSort(""));
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
            value = (java.lang.String)("");
        }
        else if (id == 11)
        {
            value = (java.lang.String)("");
        }
        else if (id == 12)
        {
            value = (java.lang.String)("CUSTOM|FIN_DEPOSIT_LISTING.FIN_DEPOSIT_LISTING%3%CUSTOM::|where%START_DATE%=%((java.lang.String)parameter_P_START_DATE.getValue())%Parameter%Date::and%END_DATE%=%((java.lang.String)parameter_P_END_DATE.getValue())%Parameter%Date::and%SCHM_TYPE%=%((java.lang.String)parameter_P_SCHM_TYPE.getValue())%Parameter%String::and%SCHM_CODE%=%((java.lang.String)parameter_P_SCHM_CODE.getValue())%Parameter%String::and%Currency%=%((java.lang.String)parameter_P_Currency.getValue())%Parameter%String::and%ENTRY_USER_ID%=%((java.lang.String)parameter_P_ENTRY_USER_ID.getValue())%Parameter%String::and%SOL_ID%=%((java.lang.String)parameter_P_SOL_ID.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_START_DATE%java.sql.Timestamp%10%!NULL!%Start Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_END_DATE%java.sql.Timestamp%10%!NULL!%End Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_SCHM_TYPE%java.lang.String%100%!NULL!%Scheme Type@DBQUERY%PRODUCT!@!Schm_Type_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_SCHM_CODE%java.lang.String%100%!NULL!%Scheme Code@DBQUERY%PRODUCT!@!SchemeCodes_List1#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_Currency%java.lang.String%100%!NULL!%Currency@DBQUERY%PRODUCT!@!Cntry_Crncy_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_ENTRY_USER_ID%java.lang.String%100%!NULL!%User Id@DBQUERY%PRODUCT!@!UserId_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_SOL_ID%java.lang.String%100%!NULL!%Branch Code@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_DEPOSIT_LISTING.FIN_DEPOSIT_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_DEPOSIT_LISTING.FIN_DEPOSIT_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 13)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_START_DATE.getValue()) + "!" +((java.lang.String)parameter_P_END_DATE.getValue()) + "!" +((java.lang.String)parameter_P_SCHM_TYPE.getValue()) + "!" +((java.lang.String)parameter_P_SCHM_CODE.getValue()) + "!" +((java.lang.String)parameter_P_Currency.getValue()) + "!" +((java.lang.String)parameter_P_ENTRY_USER_ID.getValue()) + "!" +((java.lang.String)parameter_P_SOL_ID.getValue()));
        }
        else if (id == 14)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 15)
        {
            value = (java.lang.Integer)(new Integer(1));
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
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 21)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 22)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 23)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 24)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_amount.getValue())==0 || ((java.math.BigDecimal)field_v_amount.getValue())== null ? 0.00 :((java.math.BigDecimal)field_v_amount.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 27)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankPhone.getValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankFax.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankAddress.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 31)
        {
            value = (java.lang.String)("Deposit Listing (By ALL) From "+((java.lang.String)parameter_P_START_DATE.getValue())+" To "+((java.lang.String)parameter_P_END_DATE.getValue()));
        }
        else if (id == 32)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(" Currency : "+((java.lang.String)parameter_P_Currency.getValue()).toUpperCase());
        }
        else if (id == 34)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_v_entryNumber.getValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.String)field_v_accountNumber.getValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(((java.lang.String)field_v_accountName.getValue()));
        }
        else if (id == 38)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_amount.getValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.String)field_v_enteredBy.getValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)(((java.lang.String)field_v_entryDate.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)("Page No. :"  +((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.String)("Total (" +((java.lang.Integer)variable_REPORT_COUNT.getValue())+ ") Record Listed.");
        }
        else if (id == 43)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Grand_amount.getValue()));
        }
        else if (id == 44)
        {
            value = (java.lang.String)(null);
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
            value = (java.lang.String)(((net.sf.jasperreports.engine.JRDataSource)parameter_REPORT_DATA_SOURCE.getValue()).doSort(""));
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
            value = (java.lang.String)("");
        }
        else if (id == 11)
        {
            value = (java.lang.String)("");
        }
        else if (id == 12)
        {
            value = (java.lang.String)("CUSTOM|FIN_DEPOSIT_LISTING.FIN_DEPOSIT_LISTING%3%CUSTOM::|where%START_DATE%=%((java.lang.String)parameter_P_START_DATE.getValue())%Parameter%Date::and%END_DATE%=%((java.lang.String)parameter_P_END_DATE.getValue())%Parameter%Date::and%SCHM_TYPE%=%((java.lang.String)parameter_P_SCHM_TYPE.getValue())%Parameter%String::and%SCHM_CODE%=%((java.lang.String)parameter_P_SCHM_CODE.getValue())%Parameter%String::and%Currency%=%((java.lang.String)parameter_P_Currency.getValue())%Parameter%String::and%ENTRY_USER_ID%=%((java.lang.String)parameter_P_ENTRY_USER_ID.getValue())%Parameter%String::and%SOL_ID%=%((java.lang.String)parameter_P_SOL_ID.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_START_DATE%java.sql.Timestamp%10%!NULL!%Start Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_END_DATE%java.sql.Timestamp%10%!NULL!%End Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_SCHM_TYPE%java.lang.String%100%!NULL!%Scheme Type@DBQUERY%PRODUCT!@!Schm_Type_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_SCHM_CODE%java.lang.String%100%!NULL!%Scheme Code@DBQUERY%PRODUCT!@!SchemeCodes_List1#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_Currency%java.lang.String%100%!NULL!%Currency@DBQUERY%PRODUCT!@!Cntry_Crncy_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_ENTRY_USER_ID%java.lang.String%100%!NULL!%User Id@DBQUERY%PRODUCT!@!UserId_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_SOL_ID%java.lang.String%100%!NULL!%Branch Code@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_DEPOSIT_LISTING.FIN_DEPOSIT_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_DEPOSIT_LISTING.FIN_DEPOSIT_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 13)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_START_DATE.getValue()) + "!" +((java.lang.String)parameter_P_END_DATE.getValue()) + "!" +((java.lang.String)parameter_P_SCHM_TYPE.getValue()) + "!" +((java.lang.String)parameter_P_SCHM_CODE.getValue()) + "!" +((java.lang.String)parameter_P_Currency.getValue()) + "!" +((java.lang.String)parameter_P_ENTRY_USER_ID.getValue()) + "!" +((java.lang.String)parameter_P_SOL_ID.getValue()));
        }
        else if (id == 14)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 15)
        {
            value = (java.lang.Integer)(new Integer(1));
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
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 21)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 22)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 23)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 24)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_amount.getOldValue())==0 || ((java.math.BigDecimal)field_v_amount.getOldValue())== null ? 0.00 :((java.math.BigDecimal)field_v_amount.getOldValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getOldValue()));
        }
        else if (id == 27)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankPhone.getOldValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankFax.getOldValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankAddress.getOldValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getOldValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 31)
        {
            value = (java.lang.String)("Deposit Listing (By ALL) From "+((java.lang.String)parameter_P_START_DATE.getValue())+" To "+((java.lang.String)parameter_P_END_DATE.getValue()));
        }
        else if (id == 32)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getOldValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(" Currency : "+((java.lang.String)parameter_P_Currency.getValue()).toUpperCase());
        }
        else if (id == 34)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_v_entryNumber.getOldValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.String)field_v_accountNumber.getOldValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(((java.lang.String)field_v_accountName.getOldValue()));
        }
        else if (id == 38)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_amount.getOldValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.String)field_v_enteredBy.getOldValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)(((java.lang.String)field_v_entryDate.getOldValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)("Page No. :"  +((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.String)("Total (" +((java.lang.Integer)variable_REPORT_COUNT.getOldValue())+ ") Record Listed.");
        }
        else if (id == 43)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Grand_amount.getOldValue()));
        }
        else if (id == 44)
        {
            value = (java.lang.String)(null);
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
            value = (java.lang.String)(((net.sf.jasperreports.engine.JRDataSource)parameter_REPORT_DATA_SOURCE.getValue()).doSort(""));
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
            value = (java.lang.String)("");
        }
        else if (id == 11)
        {
            value = (java.lang.String)("");
        }
        else if (id == 12)
        {
            value = (java.lang.String)("CUSTOM|FIN_DEPOSIT_LISTING.FIN_DEPOSIT_LISTING%3%CUSTOM::|where%START_DATE%=%((java.lang.String)parameter_P_START_DATE.getValue())%Parameter%Date::and%END_DATE%=%((java.lang.String)parameter_P_END_DATE.getValue())%Parameter%Date::and%SCHM_TYPE%=%((java.lang.String)parameter_P_SCHM_TYPE.getValue())%Parameter%String::and%SCHM_CODE%=%((java.lang.String)parameter_P_SCHM_CODE.getValue())%Parameter%String::and%Currency%=%((java.lang.String)parameter_P_Currency.getValue())%Parameter%String::and%ENTRY_USER_ID%=%((java.lang.String)parameter_P_ENTRY_USER_ID.getValue())%Parameter%String::and%SOL_ID%=%((java.lang.String)parameter_P_SOL_ID.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_START_DATE%java.sql.Timestamp%10%!NULL!%Start Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_END_DATE%java.sql.Timestamp%10%!NULL!%End Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_SCHM_TYPE%java.lang.String%100%!NULL!%Scheme Type@DBQUERY%PRODUCT!@!Schm_Type_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_SCHM_CODE%java.lang.String%100%!NULL!%Scheme Code@DBQUERY%PRODUCT!@!SchemeCodes_List1#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_Currency%java.lang.String%100%!NULL!%Currency@DBQUERY%PRODUCT!@!Cntry_Crncy_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_ENTRY_USER_ID%java.lang.String%100%!NULL!%User Id@DBQUERY%PRODUCT!@!UserId_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_SOL_ID%java.lang.String%100%!NULL!%Branch Code@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_DEPOSIT_LISTING.FIN_DEPOSIT_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_DEPOSIT_LISTING.FIN_DEPOSIT_LISTING( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 13)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_START_DATE.getValue()) + "!" +((java.lang.String)parameter_P_END_DATE.getValue()) + "!" +((java.lang.String)parameter_P_SCHM_TYPE.getValue()) + "!" +((java.lang.String)parameter_P_SCHM_CODE.getValue()) + "!" +((java.lang.String)parameter_P_Currency.getValue()) + "!" +((java.lang.String)parameter_P_ENTRY_USER_ID.getValue()) + "!" +((java.lang.String)parameter_P_SOL_ID.getValue()));
        }
        else if (id == 14)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 15)
        {
            value = (java.lang.Integer)(new Integer(1));
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
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 21)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 22)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 23)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 24)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_amount.getValue())==0 || ((java.math.BigDecimal)field_v_amount.getValue())== null ? 0.00 :((java.math.BigDecimal)field_v_amount.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 27)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankPhone.getValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankFax.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankAddress.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 31)
        {
            value = (java.lang.String)("Deposit Listing (By ALL) From "+((java.lang.String)parameter_P_START_DATE.getValue())+" To "+((java.lang.String)parameter_P_END_DATE.getValue()));
        }
        else if (id == 32)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getEstimatedValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(" Currency : "+((java.lang.String)parameter_P_Currency.getValue()).toUpperCase());
        }
        else if (id == 34)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_v_entryNumber.getValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.String)field_v_accountNumber.getValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(((java.lang.String)field_v_accountName.getValue()));
        }
        else if (id == 38)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_amount.getValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.String)field_v_enteredBy.getValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)(((java.lang.String)field_v_entryDate.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)("Page No. :"  +((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.String)("Total (" +((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue())+ ") Record Listed.");
        }
        else if (id == 43)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Grand_amount.getEstimatedValue()));
        }
        else if (id == 44)
        {
            value = (java.lang.String)(null);
        }

        return value;
    }


}
