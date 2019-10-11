/*
 * Generated by JasperReports - 12/6/17 4:01 PM
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
class MoneyChangerIBD_1512552667875_403556 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_TransactionDate = null;
    private JRFillParameter parameter_FIN_REPORT_TYPE = null;
    private JRFillParameter parameter_REPORT_FILE_RESOLVER = null;
    private JRFillParameter parameter_FIN_OUT_REC = null;
    private JRFillParameter parameter_UserID = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_FIN_REPORT_DESC = null;
    private JRFillParameter parameter_FIN_SER_FINQUERY = null;
    private JRFillParameter parameter_FINRPT_DEFAULT_FORMAT = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_BuyingSelling = null;
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
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_FIN_JASPER_PATH = null;
    private JRFillParameter parameter_FIN_INP_STR = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_BranchName = null;
    private JRFillField field_Branch = null;
    private JRFillField field_BankAddress = null;
    private JRFillField field_Project_Bank_Name = null;
    private JRFillField field_BankFax = null;
    private JRFillField field_BuyingSelling = null;
    private JRFillField field_TellerID = null;
    private JRFillField field_TotalAmount = null;
    private JRFillField field_Note = null;
    private JRFillField field_TotalNote = null;
    private JRFillField field_Image_Name = null;
    private JRFillField field_Rate = null;
    private JRFillField field_CurrencyType = null;
    private JRFillField field_BankPhone = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_Counter_COUNT = null;
    private JRFillVariable variable_Currency_COUNT = null;
    private JRFillVariable variable_FIN_REPOSITORY = null;
    private JRFillVariable variable_TODAY = null;
    private JRFillVariable variable_FIN_DB_CONN = null;
    private JRFillVariable variable_Unit = null;
    private JRFillVariable variable_Amount = null;
    private JRFillVariable variable_UnitTotal = null;
    private JRFillVariable variable_AmountTotal = null;


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
        parameter_TransactionDate = (JRFillParameter)pm.get("TransactionDate");
        parameter_FIN_REPORT_TYPE = (JRFillParameter)pm.get("FIN_REPORT_TYPE");
        parameter_REPORT_FILE_RESOLVER = (JRFillParameter)pm.get("REPORT_FILE_RESOLVER");
        parameter_FIN_OUT_REC = (JRFillParameter)pm.get("FIN_OUT_REC");
        parameter_UserID = (JRFillParameter)pm.get("UserID");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_FIN_REPORT_DESC = (JRFillParameter)pm.get("FIN_REPORT_DESC");
        parameter_FIN_SER_FINQUERY = (JRFillParameter)pm.get("FIN_SER_FINQUERY");
        parameter_FINRPT_DEFAULT_FORMAT = (JRFillParameter)pm.get("FINRPT_DEFAULT_FORMAT");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_BuyingSelling = (JRFillParameter)pm.get("BuyingSelling");
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
        field_BranchName = (JRFillField)fm.get("BranchName");
        field_Branch = (JRFillField)fm.get("Branch");
        field_BankAddress = (JRFillField)fm.get("BankAddress");
        field_Project_Bank_Name = (JRFillField)fm.get("Project_Bank_Name");
        field_BankFax = (JRFillField)fm.get("BankFax");
        field_BuyingSelling = (JRFillField)fm.get("BuyingSelling");
        field_TellerID = (JRFillField)fm.get("TellerID");
        field_TotalAmount = (JRFillField)fm.get("TotalAmount");
        field_Note = (JRFillField)fm.get("Note");
        field_TotalNote = (JRFillField)fm.get("TotalNote");
        field_Image_Name = (JRFillField)fm.get("Image_Name");
        field_Rate = (JRFillField)fm.get("Rate");
        field_CurrencyType = (JRFillField)fm.get("CurrencyType");
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
        variable_Counter_COUNT = (JRFillVariable)vm.get("Counter_COUNT");
        variable_Currency_COUNT = (JRFillVariable)vm.get("Currency_COUNT");
        variable_FIN_REPOSITORY = (JRFillVariable)vm.get("FIN_REPOSITORY");
        variable_TODAY = (JRFillVariable)vm.get("TODAY");
        variable_FIN_DB_CONN = (JRFillVariable)vm.get("FIN_DB_CONN");
        variable_Unit = (JRFillVariable)vm.get("Unit");
        variable_Amount = (JRFillVariable)vm.get("Amount");
        variable_UnitTotal = (JRFillVariable)vm.get("UnitTotal");
        variable_AmountTotal = (JRFillVariable)vm.get("AmountTotal");
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
            value = (java.lang.String)("CUSTOM|FIN_MONEY_CHANGER_IBD.FIN_MONEY_CHANGER_IBD%3%CUSTOM::|where%TransactionDate%=%((java.lang.String)parameter_TransactionDate.getValue())%Parameter%Date::and%UserID%=%((java.lang.String)parameter_UserID.getValue())%Parameter%String::and%BuyingSelling%=%((java.lang.String)parameter_BuyingSelling.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|TransactionDate%java.sql.Timestamp%10%!NULL!%Transaction Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::UserID%java.lang.String%100%!NULL!%UserID@DBQUERY%CUSTOM!@!MoneyChangerIBD_CustSearch.scr#@#UserID#@#UserID,SOL_ID#@#UserID,SOL_ID#@#1%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::BuyingSelling%java.lang.String%100%!NULL!%Option@DBQUERY%NONE%java.lang.String!@!SET!@!0!@!100&!&Buying#@#Selling%CONSTANT%N%N::|{call CUSTOM.FIN_MONEY_CHANGER_IBD.FIN_MONEY_CHANGER_IBD( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_MONEY_CHANGER_IBD.FIN_MONEY_CHANGER_IBD( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 8)
        {
            value = (java.lang.String)(((java.lang.String)parameter_TransactionDate.getValue()) + "!" +((java.lang.String)parameter_UserID.getValue()) + "!" +((java.lang.String)parameter_BuyingSelling.getValue()));
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
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 16)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 17)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 18)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 19)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 20)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 21)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 22)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 23)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 24)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_Note.getValue())*((java.math.BigDecimal)field_TotalNote.getValue()));
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Unit.getValue())*((java.math.BigDecimal)field_Rate.getValue()));
        }
        else if (id == 26)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Unit.getValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_TotalAmount.getValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.Object)(((java.lang.String)field_TellerID.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_TellerID.getValue())+ "         Branch Code : "  + ((java.lang.String)field_Branch.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.String)field_BuyingSelling.getValue()).equals("B") ? "Buying" :(((java.lang.String)field_BuyingSelling.getValue()).equals("S")?"Selling":"Wrong Transaction"));
        }
        else if (id == 31)
        {
            value = (java.lang.Object)(((java.lang.String)field_CurrencyType.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.String)field_CurrencyType.getValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(((java.lang.String)field_TellerID.getValue())+" Total");
        }
        else if (id == 34)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_UnitTotal.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(" ");
        }
        else if (id == 36)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_AmountTotal.getValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(" ");
        }
        else if (id == 38)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Image_Name.getValue()),((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)(((java.lang.String)field_BankPhone.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.String)field_BankFax.getValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.String)(((java.lang.String)field_BankAddress.getValue()));
        }
        else if (id == 43)
        {
            value = (java.lang.String)("Money Changer At " +((java.lang.String)parameter_TransactionDate.getValue()));
        }
        else if (id == 44)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getValue()));
        }
        else if (id == 45)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_Note.getValue()));
        }
        else if (id == 46)
        {
            value = (java.lang.String)(((java.math.BigDecimal)field_TotalNote.getValue()));
        }
        else if (id == 47)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Unit.getValue()));
        }
        else if (id == 48)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_Rate.getValue()));
        }
        else if (id == 49)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_TotalAmount.getValue()));
        }
        else if (id == 50)
        {
            value = (java.lang.String)(" ");
        }
        else if (id == 51)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
        }
        else if (id == 52)
        {
            value = (java.lang.String)(null);
        }
        else if (id == 53)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getValue()) + " ) Records Listed.");
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
            value = (java.lang.String)("CUSTOM|FIN_MONEY_CHANGER_IBD.FIN_MONEY_CHANGER_IBD%3%CUSTOM::|where%TransactionDate%=%((java.lang.String)parameter_TransactionDate.getValue())%Parameter%Date::and%UserID%=%((java.lang.String)parameter_UserID.getValue())%Parameter%String::and%BuyingSelling%=%((java.lang.String)parameter_BuyingSelling.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|TransactionDate%java.sql.Timestamp%10%!NULL!%Transaction Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::UserID%java.lang.String%100%!NULL!%UserID@DBQUERY%CUSTOM!@!MoneyChangerIBD_CustSearch.scr#@#UserID#@#UserID,SOL_ID#@#UserID,SOL_ID#@#1%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::BuyingSelling%java.lang.String%100%!NULL!%Option@DBQUERY%NONE%java.lang.String!@!SET!@!0!@!100&!&Buying#@#Selling%CONSTANT%N%N::|{call CUSTOM.FIN_MONEY_CHANGER_IBD.FIN_MONEY_CHANGER_IBD( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_MONEY_CHANGER_IBD.FIN_MONEY_CHANGER_IBD( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 8)
        {
            value = (java.lang.String)(((java.lang.String)parameter_TransactionDate.getValue()) + "!" +((java.lang.String)parameter_UserID.getValue()) + "!" +((java.lang.String)parameter_BuyingSelling.getValue()));
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
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 16)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 17)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 18)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 19)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 20)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 21)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 22)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 23)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 24)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_Note.getOldValue())*((java.math.BigDecimal)field_TotalNote.getOldValue()));
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Unit.getOldValue())*((java.math.BigDecimal)field_Rate.getOldValue()));
        }
        else if (id == 26)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Unit.getOldValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_TotalAmount.getOldValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.Object)(((java.lang.String)field_TellerID.getOldValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_TellerID.getOldValue())+ "         Branch Code : "  + ((java.lang.String)field_Branch.getOldValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.String)field_BuyingSelling.getOldValue()).equals("B") ? "Buying" :(((java.lang.String)field_BuyingSelling.getOldValue()).equals("S")?"Selling":"Wrong Transaction"));
        }
        else if (id == 31)
        {
            value = (java.lang.Object)(((java.lang.String)field_CurrencyType.getOldValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.String)field_CurrencyType.getOldValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(((java.lang.String)field_TellerID.getOldValue())+" Total");
        }
        else if (id == 34)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_UnitTotal.getOldValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(" ");
        }
        else if (id == 36)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_AmountTotal.getOldValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(" ");
        }
        else if (id == 38)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Image_Name.getOldValue()),((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getOldValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)(((java.lang.String)field_BankPhone.getOldValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.String)field_BankFax.getOldValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.String)(((java.lang.String)field_BankAddress.getOldValue()));
        }
        else if (id == 43)
        {
            value = (java.lang.String)("Money Changer At " +((java.lang.String)parameter_TransactionDate.getValue()));
        }
        else if (id == 44)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getOldValue()));
        }
        else if (id == 45)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_Note.getOldValue()));
        }
        else if (id == 46)
        {
            value = (java.lang.String)(((java.math.BigDecimal)field_TotalNote.getOldValue()));
        }
        else if (id == 47)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Unit.getOldValue()));
        }
        else if (id == 48)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_Rate.getOldValue()));
        }
        else if (id == 49)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_TotalAmount.getOldValue()));
        }
        else if (id == 50)
        {
            value = (java.lang.String)(" ");
        }
        else if (id == 51)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
        }
        else if (id == 52)
        {
            value = (java.lang.String)(null);
        }
        else if (id == 53)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getOldValue()) + " ) Records Listed.");
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
            value = (java.lang.String)("CUSTOM|FIN_MONEY_CHANGER_IBD.FIN_MONEY_CHANGER_IBD%3%CUSTOM::|where%TransactionDate%=%((java.lang.String)parameter_TransactionDate.getValue())%Parameter%Date::and%UserID%=%((java.lang.String)parameter_UserID.getValue())%Parameter%String::and%BuyingSelling%=%((java.lang.String)parameter_BuyingSelling.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|TransactionDate%java.sql.Timestamp%10%!NULL!%Transaction Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::UserID%java.lang.String%100%!NULL!%UserID@DBQUERY%CUSTOM!@!MoneyChangerIBD_CustSearch.scr#@#UserID#@#UserID,SOL_ID#@#UserID,SOL_ID#@#1%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::BuyingSelling%java.lang.String%100%!NULL!%Option@DBQUERY%NONE%java.lang.String!@!SET!@!0!@!100&!&Buying#@#Selling%CONSTANT%N%N::|{call CUSTOM.FIN_MONEY_CHANGER_IBD.FIN_MONEY_CHANGER_IBD( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_MONEY_CHANGER_IBD.FIN_MONEY_CHANGER_IBD( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 8)
        {
            value = (java.lang.String)(((java.lang.String)parameter_TransactionDate.getValue()) + "!" +((java.lang.String)parameter_UserID.getValue()) + "!" +((java.lang.String)parameter_BuyingSelling.getValue()));
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
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 16)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 17)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 18)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 19)
        {
            value = (java.lang.Integer)(new Integer(1));
        }
        else if (id == 20)
        {
            value = (java.lang.Integer)(new Integer(0));
        }
        else if (id == 21)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 22)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 23)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 24)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_Note.getValue())*((java.math.BigDecimal)field_TotalNote.getValue()));
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Unit.getEstimatedValue())*((java.math.BigDecimal)field_Rate.getValue()));
        }
        else if (id == 26)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Unit.getEstimatedValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_TotalAmount.getValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.Object)(((java.lang.String)field_TellerID.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_TellerID.getValue())+ "         Branch Code : "  + ((java.lang.String)field_Branch.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.String)field_BuyingSelling.getValue()).equals("B") ? "Buying" :(((java.lang.String)field_BuyingSelling.getValue()).equals("S")?"Selling":"Wrong Transaction"));
        }
        else if (id == 31)
        {
            value = (java.lang.Object)(((java.lang.String)field_CurrencyType.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.String)field_CurrencyType.getValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.String)(((java.lang.String)field_TellerID.getValue())+" Total");
        }
        else if (id == 34)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_UnitTotal.getEstimatedValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(" ");
        }
        else if (id == 36)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_AmountTotal.getEstimatedValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(" ");
        }
        else if (id == 38)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Image_Name.getValue()),((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)(((java.lang.String)field_BankPhone.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.String)field_BankFax.getValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.String)(((java.lang.String)field_BankAddress.getValue()));
        }
        else if (id == 43)
        {
            value = (java.lang.String)("Money Changer At " +((java.lang.String)parameter_TransactionDate.getValue()));
        }
        else if (id == 44)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getEstimatedValue()));
        }
        else if (id == 45)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_Note.getValue()));
        }
        else if (id == 46)
        {
            value = (java.lang.String)(((java.math.BigDecimal)field_TotalNote.getValue()));
        }
        else if (id == 47)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_Unit.getEstimatedValue()));
        }
        else if (id == 48)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_Rate.getValue()));
        }
        else if (id == 49)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_TotalAmount.getValue()));
        }
        else if (id == 50)
        {
            value = (java.lang.String)(" ");
        }
        else if (id == 51)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
        }
        else if (id == 52)
        {
            value = (java.lang.String)(null);
        }
        else if (id == 53)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()) + " ) Records Listed.");
        }

        return value;
    }


}