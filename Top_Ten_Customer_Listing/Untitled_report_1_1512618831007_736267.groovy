/*
 * Generated by JasperReports - 12/7/17 10:23 AM
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
class Untitled_report_1_1512618831007_736267 extends JREvaluator
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
    private JRFillParameter parameter_P_vi_Due_Date = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_P_vi_loanType = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_FIN_DB_CONN = null;
    private JRFillParameter parameter_FIN_OUT_RETCODE = null;
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_FIN_REPORT_TO = null;
    private JRFillParameter parameter_FIN_IMG_PATH = null;
    private JRFillParameter parameter_FIN_BANKREPOS_PARAM = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_FIN_SESSION_ID = null;
    private JRFillParameter parameter_FIN_TEMPLATE_PATH = null;
    private JRFillParameter parameter_FIN_APP_UTIL = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_FIN_JASPER_PATH = null;
    private JRFillParameter parameter_FIN_INP_STR = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_v_NRC_No32 = null;
    private JRFillField field_BranchName = null;
    private JRFillField field_Branch = null;
    private JRFillField field_BankAddress = null;
    private JRFillField field_v_Due_Date32 = null;
    private JRFillField field_BankFax = null;
    private JRFillField field_v_Sanction_Date = null;
    private JRFillField field_v_Bussiness32 = null;
    private JRFillField field_v_Sanction_Amount = null;
    private JRFillField field_v_Customer_acc_Name = null;
    private JRFillField field_Bank_Name = null;
    private JRFillField field_Image_Name = null;
    private JRFillField field_v_Collectral_type32 = null;
    private JRFillField field_BankPhone = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_TODAY = null;
    private JRFillVariable variable_FIN_DB_CONN = null;
    private JRFillVariable variable_Sanction32Amount = null;


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
        parameter_P_vi_Due_Date = (JRFillParameter)pm.get("P_vi_Due_Date");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_P_vi_loanType = (JRFillParameter)pm.get("P_vi_loanType");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_FIN_DB_CONN = (JRFillParameter)pm.get("FIN_DB_CONN");
        parameter_FIN_OUT_RETCODE = (JRFillParameter)pm.get("FIN_OUT_RETCODE");
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_FIN_REPORT_TO = (JRFillParameter)pm.get("FIN_REPORT_TO");
        parameter_FIN_IMG_PATH = (JRFillParameter)pm.get("FIN_IMG_PATH");
        parameter_FIN_BANKREPOS_PARAM = (JRFillParameter)pm.get("FIN_BANKREPOS_PARAM");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_FIN_SESSION_ID = (JRFillParameter)pm.get("FIN_SESSION_ID");
        parameter_FIN_TEMPLATE_PATH = (JRFillParameter)pm.get("FIN_TEMPLATE_PATH");
        parameter_FIN_APP_UTIL = (JRFillParameter)pm.get("FIN_APP_UTIL");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_FIN_JASPER_PATH = (JRFillParameter)pm.get("FIN_JASPER_PATH");
        parameter_FIN_INP_STR = (JRFillParameter)pm.get("FIN_INP_STR");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    void initFields(Map fm)
    {
        field_v_NRC_No32 = (JRFillField)fm.get("v_NRC_No ");
        field_BranchName = (JRFillField)fm.get("BranchName");
        field_Branch = (JRFillField)fm.get("Branch");
        field_BankAddress = (JRFillField)fm.get("BankAddress");
        field_v_Due_Date32 = (JRFillField)fm.get("v_Due_Date ");
        field_BankFax = (JRFillField)fm.get("BankFax");
        field_v_Sanction_Date = (JRFillField)fm.get("v_Sanction_Date");
        field_v_Bussiness32 = (JRFillField)fm.get("v_Bussiness ");
        field_v_Sanction_Amount = (JRFillField)fm.get("v_Sanction_Amount");
        field_v_Customer_acc_Name = (JRFillField)fm.get("v_Customer_acc_Name");
        field_Bank_Name = (JRFillField)fm.get("Bank_Name");
        field_Image_Name = (JRFillField)fm.get("Image_Name");
        field_v_Collectral_type32 = (JRFillField)fm.get("v_Collectral_type ");
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
        variable_TODAY = (JRFillVariable)vm.get("TODAY");
        variable_FIN_DB_CONN = (JRFillVariable)vm.get("FIN_DB_CONN");
        variable_Sanction32Amount = (JRFillVariable)vm.get("Sanction Amount");
    }


    /**
     *
     */
    Object evaluate(int id)
    {
        Object value = null;

        if (id == 0)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 1)
        {
            value = (java.lang.String)("../images");
        }
        else if (id == 2)
        {
            value = (java.lang.String)("../jrxml");
        }
        else if (id == 3)
        {
            value = (java.lang.String)("");
        }
        else if (id == 4)
        {
            value = (java.lang.String)("");
        }
        else if (id == 5)
        {
            value = (java.lang.String)("CUSTOM|FIN_TOP_TEN_CUSTOMER_LIST.FIN_TOP_TEN_CUSTOMER_LIST%3%CUSTOM::|where%vi_Due_Date%=%((java.lang.String)parameter_P_vi_Due_Date.getValue())%Parameter%Date::and%vi_loanType%=%((java.lang.String)parameter_P_vi_loanType.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_Due_Date%java.sql.Timestamp%10%!NULL!%Due_date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_loanType%java.lang.String%100%!NULL!%Loan_type@DBQUERY%NONE%java.lang.String!@!SET!@!0!@!100&!&Demand Loan#@#OverDraft#@#Hire Purchase%CONSTANT%N%N::|{call CUSTOM.FIN_TOP_TEN_CUSTOMER_LIST.FIN_TOP_TEN_CUSTOMER_LIST( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_TOP_TEN_CUSTOMER_LIST.FIN_TOP_TEN_CUSTOMER_LIST( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 6)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_Due_Date.getValue()) + "!" +((java.lang.String)parameter_P_vi_loanType.getValue()));
        }
        else if (id == 7)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 8)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 9)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 10)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 11)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 12)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 13)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 14)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 15)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 16)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 17)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 18)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Sanction_Amount.getValue()));
        }
        else if (id == 19)
        {
            value = (java.lang.String)(((java.lang.String)field_Bank_Name.getValue()));
        }
        else if (id == 20)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Image_Name.getValue()),((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 21)
        {
            value = (java.lang.String)("Loan & Advances List of Ten largest Customer as at " +((java.lang.String)parameter_P_vi_Due_Date.getValue()));
        }
        else if (id == 22)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getValue()));
        }
        else if (id == 23)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Customer_acc_Name.getValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.String)field_v_NRC_No32.getValue()));
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Bussiness32.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Collectral_type32.getValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Sanction_Amount.getValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Sanction_Date.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_Branch.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_REPORT_COUNT.getValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Sanction_Date.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)("Page No.  " + ((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
        }
        else if (id == 33)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Sanction32Amount.getValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)("");
        }
        else if (id == 35)
        {
            value = (java.lang.String)("");
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
            value = (java.sql.Connection)(null);
        }
        else if (id == 1)
        {
            value = (java.lang.String)("../images");
        }
        else if (id == 2)
        {
            value = (java.lang.String)("../jrxml");
        }
        else if (id == 3)
        {
            value = (java.lang.String)("");
        }
        else if (id == 4)
        {
            value = (java.lang.String)("");
        }
        else if (id == 5)
        {
            value = (java.lang.String)("CUSTOM|FIN_TOP_TEN_CUSTOMER_LIST.FIN_TOP_TEN_CUSTOMER_LIST%3%CUSTOM::|where%vi_Due_Date%=%((java.lang.String)parameter_P_vi_Due_Date.getValue())%Parameter%Date::and%vi_loanType%=%((java.lang.String)parameter_P_vi_loanType.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_Due_Date%java.sql.Timestamp%10%!NULL!%Due_date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_loanType%java.lang.String%100%!NULL!%Loan_type@DBQUERY%NONE%java.lang.String!@!SET!@!0!@!100&!&Demand Loan#@#OverDraft#@#Hire Purchase%CONSTANT%N%N::|{call CUSTOM.FIN_TOP_TEN_CUSTOMER_LIST.FIN_TOP_TEN_CUSTOMER_LIST( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_TOP_TEN_CUSTOMER_LIST.FIN_TOP_TEN_CUSTOMER_LIST( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 6)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_Due_Date.getValue()) + "!" +((java.lang.String)parameter_P_vi_loanType.getValue()));
        }
        else if (id == 7)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 8)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 9)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 10)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 11)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 12)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 13)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 14)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 15)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 16)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 17)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 18)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Sanction_Amount.getOldValue()));
        }
        else if (id == 19)
        {
            value = (java.lang.String)(((java.lang.String)field_Bank_Name.getOldValue()));
        }
        else if (id == 20)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Image_Name.getOldValue()),((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 21)
        {
            value = (java.lang.String)("Loan & Advances List of Ten largest Customer as at " +((java.lang.String)parameter_P_vi_Due_Date.getValue()));
        }
        else if (id == 22)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getOldValue()));
        }
        else if (id == 23)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Customer_acc_Name.getOldValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.String)field_v_NRC_No32.getOldValue()));
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Bussiness32.getOldValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Collectral_type32.getOldValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Sanction_Amount.getOldValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Sanction_Date.getOldValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_Branch.getOldValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Sanction_Date.getOldValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)("Page No.  " + ((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
        }
        else if (id == 33)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Sanction32Amount.getOldValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)("");
        }
        else if (id == 35)
        {
            value = (java.lang.String)("");
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
            value = (java.sql.Connection)(null);
        }
        else if (id == 1)
        {
            value = (java.lang.String)("../images");
        }
        else if (id == 2)
        {
            value = (java.lang.String)("../jrxml");
        }
        else if (id == 3)
        {
            value = (java.lang.String)("");
        }
        else if (id == 4)
        {
            value = (java.lang.String)("");
        }
        else if (id == 5)
        {
            value = (java.lang.String)("CUSTOM|FIN_TOP_TEN_CUSTOMER_LIST.FIN_TOP_TEN_CUSTOMER_LIST%3%CUSTOM::|where%vi_Due_Date%=%((java.lang.String)parameter_P_vi_Due_Date.getValue())%Parameter%Date::and%vi_loanType%=%((java.lang.String)parameter_P_vi_loanType.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_Due_Date%java.sql.Timestamp%10%!NULL!%Due_date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_loanType%java.lang.String%100%!NULL!%Loan_type@DBQUERY%NONE%java.lang.String!@!SET!@!0!@!100&!&Demand Loan#@#OverDraft#@#Hire Purchase%CONSTANT%N%N::|{call CUSTOM.FIN_TOP_TEN_CUSTOMER_LIST.FIN_TOP_TEN_CUSTOMER_LIST( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_TOP_TEN_CUSTOMER_LIST.FIN_TOP_TEN_CUSTOMER_LIST( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 6)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_Due_Date.getValue()) + "!" +((java.lang.String)parameter_P_vi_loanType.getValue()));
        }
        else if (id == 7)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 8)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 9)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 10)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 11)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 12)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 13)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 14)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 15)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 16)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 17)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 18)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Sanction_Amount.getValue()));
        }
        else if (id == 19)
        {
            value = (java.lang.String)(((java.lang.String)field_Bank_Name.getValue()));
        }
        else if (id == 20)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Image_Name.getValue()),((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 21)
        {
            value = (java.lang.String)("Loan & Advances List of Ten largest Customer as at " +((java.lang.String)parameter_P_vi_Due_Date.getValue()));
        }
        else if (id == 22)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getEstimatedValue()));
        }
        else if (id == 23)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Customer_acc_Name.getValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.String)field_v_NRC_No32.getValue()));
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Bussiness32.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Collectral_type32.getValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Sanction_Amount.getValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Sanction_Date.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_Branch.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.String)(((java.lang.String)field_v_Sanction_Date.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)("Page No.  " + ((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
        }
        else if (id == 33)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Sanction32Amount.getEstimatedValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)("");
        }
        else if (id == 35)
        {
            value = (java.lang.String)("");
        }

        return value;
    }


}
