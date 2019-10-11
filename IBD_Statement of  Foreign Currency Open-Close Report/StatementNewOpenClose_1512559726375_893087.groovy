/*
 * Generated by JasperReports - 12/6/17 5:58 PM
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
class StatementNewOpenClose_1512559726375_893087 extends JREvaluator
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
    private JRFillParameter parameter_StartDate = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_FIN_DB_CONN = null;
    private JRFillParameter parameter_FIN_REPOS_FILE = null;
    private JRFillParameter parameter_FIN_OUT_RETCODE = null;
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_FIN_REPORT_TO = null;
    private JRFillParameter parameter_FIN_BANKREPOS_PARAM = null;
    private JRFillParameter parameter_FIN_IMG_PATH = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_FIN_REPOS_LIST = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_FIN_SESSION_ID = null;
    private JRFillParameter parameter_FIN_TEMPLATE_PATH = null;
    private JRFillParameter parameter_FIN_APP_UTIL = null;
    private JRFillParameter parameter_EndDate = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_FIN_JASPER_PATH = null;
    private JRFillParameter parameter_FIN_INP_STR = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_JPY = null;
    private JRFillField field_OpenCloseDate = null;
    private JRFillField field_OpenUSD = null;
    private JRFillField field_OpenMYR = null;
    private JRFillField field_Image_Name = null;
    private JRFillField field_CloseMYR = null;
    private JRFillField field_CloseSGD = null;
    private JRFillField field_BranchName = null;
    private JRFillField field_OpenSGD = null;
    private JRFillField field_CloseEUR = null;
    private JRFillField field_CloseINR = null;
    private JRFillField field_INR = null;
    private JRFillField field_THB = null;
    private JRFillField field_BankPhone = null;
    private JRFillField field_SGD = null;
    private JRFillField field_CloseJPY = null;
    private JRFillField field_BankAddress = null;
    private JRFillField field_BankFax = null;
    private JRFillField field_CloseUSD = null;
    private JRFillField field_Bank_Name = null;
    private JRFillField field_OpenTHB = null;
    private JRFillField field_MYR = null;
    private JRFillField field_EUR = null;
    private JRFillField field_USD = null;
    private JRFillField field_CloseTHB = null;
    private JRFillField field_OpenJPY = null;
    private JRFillField field_OpenEUR = null;
    private JRFillField field_OpenINR = null;
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
        parameter_StartDate = (JRFillParameter)pm.get("StartDate");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_FIN_DB_CONN = (JRFillParameter)pm.get("FIN_DB_CONN");
        parameter_FIN_REPOS_FILE = (JRFillParameter)pm.get("FIN_REPOS_FILE");
        parameter_FIN_OUT_RETCODE = (JRFillParameter)pm.get("FIN_OUT_RETCODE");
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_FIN_REPORT_TO = (JRFillParameter)pm.get("FIN_REPORT_TO");
        parameter_FIN_BANKREPOS_PARAM = (JRFillParameter)pm.get("FIN_BANKREPOS_PARAM");
        parameter_FIN_IMG_PATH = (JRFillParameter)pm.get("FIN_IMG_PATH");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_FIN_REPOS_LIST = (JRFillParameter)pm.get("FIN_REPOS_LIST");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_FIN_SESSION_ID = (JRFillParameter)pm.get("FIN_SESSION_ID");
        parameter_FIN_TEMPLATE_PATH = (JRFillParameter)pm.get("FIN_TEMPLATE_PATH");
        parameter_FIN_APP_UTIL = (JRFillParameter)pm.get("FIN_APP_UTIL");
        parameter_EndDate = (JRFillParameter)pm.get("EndDate");
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
        field_JPY = (JRFillField)fm.get("JPY");
        field_OpenCloseDate = (JRFillField)fm.get("OpenCloseDate");
        field_OpenUSD = (JRFillField)fm.get("OpenUSD");
        field_OpenMYR = (JRFillField)fm.get("OpenMYR");
        field_Image_Name = (JRFillField)fm.get("Image_Name");
        field_CloseMYR = (JRFillField)fm.get("CloseMYR");
        field_CloseSGD = (JRFillField)fm.get("CloseSGD");
        field_BranchName = (JRFillField)fm.get("BranchName");
        field_OpenSGD = (JRFillField)fm.get("OpenSGD");
        field_CloseEUR = (JRFillField)fm.get("CloseEUR");
        field_CloseINR = (JRFillField)fm.get("CloseINR");
        field_INR = (JRFillField)fm.get("INR");
        field_THB = (JRFillField)fm.get("THB");
        field_BankPhone = (JRFillField)fm.get("BankPhone");
        field_SGD = (JRFillField)fm.get("SGD");
        field_CloseJPY = (JRFillField)fm.get("CloseJPY");
        field_BankAddress = (JRFillField)fm.get("BankAddress");
        field_BankFax = (JRFillField)fm.get("BankFax");
        field_CloseUSD = (JRFillField)fm.get("CloseUSD");
        field_Bank_Name = (JRFillField)fm.get("Bank_Name");
        field_OpenTHB = (JRFillField)fm.get("OpenTHB");
        field_MYR = (JRFillField)fm.get("MYR");
        field_EUR = (JRFillField)fm.get("EUR");
        field_USD = (JRFillField)fm.get("USD");
        field_CloseTHB = (JRFillField)fm.get("CloseTHB");
        field_OpenJPY = (JRFillField)fm.get("OpenJPY");
        field_OpenEUR = (JRFillField)fm.get("OpenEUR");
        field_OpenINR = (JRFillField)fm.get("OpenINR");
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
            value = (java.lang.String)("CUSTOM|FIN_STAT_NEW_OPCL_CURRENT_ACC.FIN_STAT_NEW_OPCL_CURRENT_ACC%3%CUSTOM::|where%StartDate%=%((java.lang.String)parameter_StartDate.getValue())%Parameter%Date::and%EndDate%=%((java.lang.String)parameter_EndDate.getValue())%Parameter%Date::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|StartDate%java.sql.Timestamp%10%!NULL!%Start Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::EndDate%java.sql.Timestamp%10%!NULL!%End Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::|{call CUSTOM.FIN_STAT_NEW_OPCL_CURRENT_ACC.FIN_STAT_NEW_OPCL_CURRENT_ACC( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_STAT_NEW_OPCL_CURRENT_ACC.FIN_STAT_NEW_OPCL_CURRENT_ACC( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 7)
        {
            value = (java.lang.String)(((java.lang.String)parameter_StartDate.getValue()) + "!" +((java.lang.String)parameter_EndDate.getValue()));
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
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 11)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 12)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 13)
        {
            value = (java.lang.Integer)(new Integer(0));
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
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 17)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 18)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 19)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Image_Name.getValue()),((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 20)
        {
            value = (java.lang.String)(((java.lang.String)field_Bank_Name.getValue()));
        }
        else if (id == 21)
        {
            value = (java.lang.String)(((java.lang.String)field_BranchName.getValue()));
        }
        else if (id == 22)
        {
            value = (java.lang.String)("Statement of New A/C Opened & A/C Closed of Currenct Account From " + ((java.lang.String)parameter_StartDate.getValue()) + " To " + ((java.lang.String)parameter_EndDate.getValue()));
        }
        else if (id == 23)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? " " :((java.lang.Integer)variable_REPORT_COUNT.getValue())-1);
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_OpenCloseDate.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenUSD.getValue()));
        }
        else if (id == 27)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseUSD.getValue()));
        }
        else if (id == 28)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_USD.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenEUR.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseEUR.getValue()));
        }
        else if (id == 31)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_EUR.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? "B/F" :((java.math.BigDecimal)field_OpenTHB.getValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseTHB.getValue()));
        }
        else if (id == 34)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_THB.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenJPY.getValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseJPY.getValue()));
        }
        else if (id == 37)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_JPY.getValue()));
        }
        else if (id == 38)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenINR.getValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? " " :((java.math.BigDecimal)field_CloseINR.getValue()));
        }
        else if (id == 40)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_JPY.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenMYR.getValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseMYR.getValue()));
        }
        else if (id == 43)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_MYR.getValue()));
        }
        else if (id == 44)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? "B/F " : ((java.math.BigDecimal)field_OpenSGD.getValue()));
        }
        else if (id == 45)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseSGD.getValue()));
        }
        else if (id == 46)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_SGD.getValue()));
        }
        else if (id == 47)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
        }
        else if (id == 48)
        {
            value = (java.lang.String)(null);
        }
        else if (id == 49)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getValue())+ " ) Records Listed.");
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
            value = (java.lang.String)("CUSTOM|FIN_STAT_NEW_OPCL_CURRENT_ACC.FIN_STAT_NEW_OPCL_CURRENT_ACC%3%CUSTOM::|where%StartDate%=%((java.lang.String)parameter_StartDate.getValue())%Parameter%Date::and%EndDate%=%((java.lang.String)parameter_EndDate.getValue())%Parameter%Date::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|StartDate%java.sql.Timestamp%10%!NULL!%Start Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::EndDate%java.sql.Timestamp%10%!NULL!%End Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::|{call CUSTOM.FIN_STAT_NEW_OPCL_CURRENT_ACC.FIN_STAT_NEW_OPCL_CURRENT_ACC( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_STAT_NEW_OPCL_CURRENT_ACC.FIN_STAT_NEW_OPCL_CURRENT_ACC( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 7)
        {
            value = (java.lang.String)(((java.lang.String)parameter_StartDate.getValue()) + "!" +((java.lang.String)parameter_EndDate.getValue()));
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
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 11)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 12)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 13)
        {
            value = (java.lang.Integer)(new Integer(0));
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
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 17)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 18)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 19)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Image_Name.getOldValue()),((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 20)
        {
            value = (java.lang.String)(((java.lang.String)field_Bank_Name.getOldValue()));
        }
        else if (id == 21)
        {
            value = (java.lang.String)(((java.lang.String)field_BranchName.getOldValue()));
        }
        else if (id == 22)
        {
            value = (java.lang.String)("Statement of New A/C Opened & A/C Closed of Currenct Account From " + ((java.lang.String)parameter_StartDate.getValue()) + " To " + ((java.lang.String)parameter_EndDate.getValue()));
        }
        else if (id == 23)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getOldValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? " " :((java.lang.Integer)variable_REPORT_COUNT.getOldValue())-1);
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_OpenCloseDate.getOldValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenUSD.getOldValue()));
        }
        else if (id == 27)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseUSD.getOldValue()));
        }
        else if (id == 28)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_USD.getOldValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenEUR.getOldValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseEUR.getOldValue()));
        }
        else if (id == 31)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_EUR.getOldValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? "B/F" :((java.math.BigDecimal)field_OpenTHB.getOldValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseTHB.getOldValue()));
        }
        else if (id == 34)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_THB.getOldValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenJPY.getOldValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseJPY.getOldValue()));
        }
        else if (id == 37)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_JPY.getOldValue()));
        }
        else if (id == 38)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenINR.getOldValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? " " :((java.math.BigDecimal)field_CloseINR.getOldValue()));
        }
        else if (id == 40)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_JPY.getOldValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenMYR.getOldValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseMYR.getOldValue()));
        }
        else if (id == 43)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_MYR.getOldValue()));
        }
        else if (id == 44)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? "B/F " : ((java.math.BigDecimal)field_OpenSGD.getOldValue()));
        }
        else if (id == 45)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseSGD.getOldValue()));
        }
        else if (id == 46)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_SGD.getOldValue()));
        }
        else if (id == 47)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
        }
        else if (id == 48)
        {
            value = (java.lang.String)(null);
        }
        else if (id == 49)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getOldValue())+ " ) Records Listed.");
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
            value = (java.lang.String)("CUSTOM|FIN_STAT_NEW_OPCL_CURRENT_ACC.FIN_STAT_NEW_OPCL_CURRENT_ACC%3%CUSTOM::|where%StartDate%=%((java.lang.String)parameter_StartDate.getValue())%Parameter%Date::and%EndDate%=%((java.lang.String)parameter_EndDate.getValue())%Parameter%Date::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|StartDate%java.sql.Timestamp%10%!NULL!%Start Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::EndDate%java.sql.Timestamp%10%!NULL!%End Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::|{call CUSTOM.FIN_STAT_NEW_OPCL_CURRENT_ACC.FIN_STAT_NEW_OPCL_CURRENT_ACC( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_STAT_NEW_OPCL_CURRENT_ACC.FIN_STAT_NEW_OPCL_CURRENT_ACC( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 7)
        {
            value = (java.lang.String)(((java.lang.String)parameter_StartDate.getValue()) + "!" +((java.lang.String)parameter_EndDate.getValue()));
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
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 11)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 12)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 13)
        {
            value = (java.lang.Integer)(new Integer(0));
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
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 17)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 18)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 19)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Image_Name.getValue()),((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 20)
        {
            value = (java.lang.String)(((java.lang.String)field_Bank_Name.getValue()));
        }
        else if (id == 21)
        {
            value = (java.lang.String)(((java.lang.String)field_BranchName.getValue()));
        }
        else if (id == 22)
        {
            value = (java.lang.String)("Statement of New A/C Opened & A/C Closed of Currenct Account From " + ((java.lang.String)parameter_StartDate.getValue()) + " To " + ((java.lang.String)parameter_EndDate.getValue()));
        }
        else if (id == 23)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getEstimatedValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? " " :((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue())-1);
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_OpenCloseDate.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenUSD.getValue()));
        }
        else if (id == 27)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseUSD.getValue()));
        }
        else if (id == 28)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_USD.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenEUR.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseEUR.getValue()));
        }
        else if (id == 31)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_EUR.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? "B/F" :((java.math.BigDecimal)field_OpenTHB.getValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseTHB.getValue()));
        }
        else if (id == 34)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_THB.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenJPY.getValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseJPY.getValue()));
        }
        else if (id == 37)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_JPY.getValue()));
        }
        else if (id == 38)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenINR.getValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? " " :((java.math.BigDecimal)field_CloseINR.getValue()));
        }
        else if (id == 40)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_JPY.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? "B/F" : ((java.math.BigDecimal)field_OpenMYR.getValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseMYR.getValue()));
        }
        else if (id == 43)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_MYR.getValue()));
        }
        else if (id == 44)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? "B/F " : ((java.math.BigDecimal)field_OpenSGD.getValue()));
        }
        else if (id == 45)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()).equals(1) ? " " : ((java.math.BigDecimal)field_CloseSGD.getValue()));
        }
        else if (id == 46)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_SGD.getValue()));
        }
        else if (id == 47)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
        }
        else if (id == 48)
        {
            value = (java.lang.String)(null);
        }
        else if (id == 49)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue())+ " ) Records Listed.");
        }

        return value;
    }


}