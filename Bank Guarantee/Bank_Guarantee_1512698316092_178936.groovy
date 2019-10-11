/*
 * Generated by JasperReports - 12/7/17 5:58 PM
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
class Bank_Guarantee_1512698316092_178936 extends JREvaluator
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
    private JRFillParameter parameter_P_vi_CurrencyCode = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_FIN_DB_CONN = null;
    private JRFillParameter parameter_P_vi_startDate = null;
    private JRFillParameter parameter_FIN_OUT_RETCODE = null;
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_FIN_REPORT_TO = null;
    private JRFillParameter parameter_FIN_IMG_PATH = null;
    private JRFillParameter parameter_FIN_BANKREPOS_PARAM = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_P_vi_endDate = null;
    private JRFillParameter parameter_FIN_SESSION_ID = null;
    private JRFillParameter parameter_FIN_TEMPLATE_PATH = null;
    private JRFillParameter parameter_P_vi_Branchcode = null;
    private JRFillParameter parameter_FIN_APP_UTIL = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_FIN_JASPER_PATH = null;
    private JRFillParameter parameter_FIN_INP_STR = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_v_BankFax = null;
    private JRFillField field_ExpiredDate = null;
    private JRFillField field_TranDate = null;
    private JRFillField field_BeneName = null;
    private JRFillField field_Project_Bank_Name = null;
    private JRFillField field_v_BankPhone = null;
    private JRFillField field_GteePeriod = null;
    private JRFillField field_GteeNo = null;
    private JRFillField field_Project_Image_Name = null;
    private JRFillField field_GteeAmt = null;
    private JRFillField field_Currency = null;
    private JRFillField field_ApplicantName = null;
    private JRFillField field_v_BankAddress = null;
    private JRFillField field_v_BranchName = null;
    private JRFillField field_CancelDate = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_TODAY = null;
    private JRFillVariable variable_FIN_DB_CONN = null;
    private JRFillVariable variable_GteeAmount_total = null;


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
        parameter_P_vi_CurrencyCode = (JRFillParameter)pm.get("P_vi_CurrencyCode");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_FIN_DB_CONN = (JRFillParameter)pm.get("FIN_DB_CONN");
        parameter_P_vi_startDate = (JRFillParameter)pm.get("P_vi_startDate");
        parameter_FIN_OUT_RETCODE = (JRFillParameter)pm.get("FIN_OUT_RETCODE");
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_FIN_REPORT_TO = (JRFillParameter)pm.get("FIN_REPORT_TO");
        parameter_FIN_IMG_PATH = (JRFillParameter)pm.get("FIN_IMG_PATH");
        parameter_FIN_BANKREPOS_PARAM = (JRFillParameter)pm.get("FIN_BANKREPOS_PARAM");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_P_vi_endDate = (JRFillParameter)pm.get("P_vi_endDate");
        parameter_FIN_SESSION_ID = (JRFillParameter)pm.get("FIN_SESSION_ID");
        parameter_FIN_TEMPLATE_PATH = (JRFillParameter)pm.get("FIN_TEMPLATE_PATH");
        parameter_P_vi_Branchcode = (JRFillParameter)pm.get("P_vi_Branchcode");
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
        field_v_BankFax = (JRFillField)fm.get("v_BankFax");
        field_ExpiredDate = (JRFillField)fm.get("ExpiredDate");
        field_TranDate = (JRFillField)fm.get("TranDate");
        field_BeneName = (JRFillField)fm.get("BeneName");
        field_Project_Bank_Name = (JRFillField)fm.get("Project_Bank_Name");
        field_v_BankPhone = (JRFillField)fm.get("v_BankPhone");
        field_GteePeriod = (JRFillField)fm.get("GteePeriod");
        field_GteeNo = (JRFillField)fm.get("GteeNo");
        field_Project_Image_Name = (JRFillField)fm.get("Project_Image_Name");
        field_GteeAmt = (JRFillField)fm.get("GteeAmt");
        field_Currency = (JRFillField)fm.get("Currency");
        field_ApplicantName = (JRFillField)fm.get("ApplicantName");
        field_v_BankAddress = (JRFillField)fm.get("v_BankAddress");
        field_v_BranchName = (JRFillField)fm.get("v_BranchName");
        field_CancelDate = (JRFillField)fm.get("CancelDate");
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
        variable_GteeAmount_total = (JRFillVariable)vm.get("GteeAmount_total");
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
            value = (java.lang.String)("");
        }
        else if (id == 6)
        {
            value = (java.lang.String)("");
        }
        else if (id == 7)
        {
            value = (java.lang.String)("CUSTOM|FIN_BANK_GUARANTEE.FIN_BANK_GUARANTEE%3%CUSTOM::|where%vi_startDate%=%((java.lang.String)parameter_P_vi_startDate.getValue())%Parameter%Date::and%vi_endDate%=%((java.lang.String)parameter_P_vi_endDate.getValue())%Parameter%Date::and%vi_CurrencyCode%=%((java.lang.String)parameter_P_vi_CurrencyCode.getValue())%Parameter%String::and%vi_Branchcode%=%((java.lang.String)parameter_P_vi_Branchcode.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_startDate%java.sql.Timestamp%10%!NULL!%Start Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_endDate%java.sql.Timestamp%10%!NULL!%End Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_CurrencyCode%java.lang.String%100%!NULL!%Currency Code@DBQUERY%PRODUCT!@!Crncy_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_vi_Branchcode%java.lang.String%100%!NULL!%Branch Code@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_BANK_GUARANTEE.FIN_BANK_GUARANTEE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_BANK_GUARANTEE.FIN_BANK_GUARANTEE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 8)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_startDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_endDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_CurrencyCode.getValue()) + "!" +((java.lang.String)parameter_P_vi_Branchcode.getValue()));
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
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 18)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 19)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 20)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_GteeAmt.getValue()));
        }
        else if (id == 21)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 22)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 23)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankPhone.getValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankFax.getValue()));
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankAddress.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)("Report for Guarantee Issure ("+((java.lang.String)parameter_P_vi_startDate.getValue())+" to "+((java.lang.String)parameter_P_vi_endDate.getValue())+")");
        }
        else if (id == 27)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.String)(((java.lang.String)field_TranDate.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_GteeNo.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.String)field_ApplicantName.getValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.String)(((java.lang.String)field_BeneName.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.String)field_Currency.getValue()));
        }
        else if (id == 33)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_GteeAmt.getValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)(((java.lang.String)field_ExpiredDate.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_CancelDate.getValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.String)field_GteePeriod.getValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(null);
        }
        else if (id == 38)
        {
            value = (java.lang.String)(new SimpleDateFormat("MMM-yyyy").format(new SimpleDateFormat("dd-MM-yyyy").parse(((java.lang.String)parameter_P_vi_endDate.getValue())))+" Total ("+((java.lang.Integer)variable_REPORT_COUNT.getValue())+") Nos");
        }
        else if (id == 39)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GteeAmount_total.getValue()));
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
            value = (java.lang.String)("");
        }
        else if (id == 6)
        {
            value = (java.lang.String)("");
        }
        else if (id == 7)
        {
            value = (java.lang.String)("CUSTOM|FIN_BANK_GUARANTEE.FIN_BANK_GUARANTEE%3%CUSTOM::|where%vi_startDate%=%((java.lang.String)parameter_P_vi_startDate.getValue())%Parameter%Date::and%vi_endDate%=%((java.lang.String)parameter_P_vi_endDate.getValue())%Parameter%Date::and%vi_CurrencyCode%=%((java.lang.String)parameter_P_vi_CurrencyCode.getValue())%Parameter%String::and%vi_Branchcode%=%((java.lang.String)parameter_P_vi_Branchcode.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_startDate%java.sql.Timestamp%10%!NULL!%Start Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_endDate%java.sql.Timestamp%10%!NULL!%End Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_CurrencyCode%java.lang.String%100%!NULL!%Currency Code@DBQUERY%PRODUCT!@!Crncy_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_vi_Branchcode%java.lang.String%100%!NULL!%Branch Code@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_BANK_GUARANTEE.FIN_BANK_GUARANTEE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_BANK_GUARANTEE.FIN_BANK_GUARANTEE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 8)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_startDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_endDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_CurrencyCode.getValue()) + "!" +((java.lang.String)parameter_P_vi_Branchcode.getValue()));
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
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 18)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 19)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 20)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_GteeAmt.getOldValue()));
        }
        else if (id == 21)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getOldValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 22)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getOldValue()));
        }
        else if (id == 23)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankPhone.getOldValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankFax.getOldValue()));
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankAddress.getOldValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)("Report for Guarantee Issure ("+((java.lang.String)parameter_P_vi_startDate.getValue())+" to "+((java.lang.String)parameter_P_vi_endDate.getValue())+")");
        }
        else if (id == 27)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.String)(((java.lang.String)field_TranDate.getOldValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_GteeNo.getOldValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.String)field_ApplicantName.getOldValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.String)(((java.lang.String)field_BeneName.getOldValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.String)field_Currency.getOldValue()));
        }
        else if (id == 33)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_GteeAmt.getOldValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)(((java.lang.String)field_ExpiredDate.getOldValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_CancelDate.getOldValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.String)field_GteePeriod.getOldValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(null);
        }
        else if (id == 38)
        {
            value = (java.lang.String)(new SimpleDateFormat("MMM-yyyy").format(new SimpleDateFormat("dd-MM-yyyy").parse(((java.lang.String)parameter_P_vi_endDate.getValue())))+" Total ("+((java.lang.Integer)variable_REPORT_COUNT.getOldValue())+") Nos");
        }
        else if (id == 39)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GteeAmount_total.getOldValue()));
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
            value = (java.lang.String)("");
        }
        else if (id == 6)
        {
            value = (java.lang.String)("");
        }
        else if (id == 7)
        {
            value = (java.lang.String)("CUSTOM|FIN_BANK_GUARANTEE.FIN_BANK_GUARANTEE%3%CUSTOM::|where%vi_startDate%=%((java.lang.String)parameter_P_vi_startDate.getValue())%Parameter%Date::and%vi_endDate%=%((java.lang.String)parameter_P_vi_endDate.getValue())%Parameter%Date::and%vi_CurrencyCode%=%((java.lang.String)parameter_P_vi_CurrencyCode.getValue())%Parameter%String::and%vi_Branchcode%=%((java.lang.String)parameter_P_vi_Branchcode.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_startDate%java.sql.Timestamp%10%!NULL!%Start Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_endDate%java.sql.Timestamp%10%!NULL!%End Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_CurrencyCode%java.lang.String%100%!NULL!%Currency Code@DBQUERY%PRODUCT!@!Crncy_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_vi_Branchcode%java.lang.String%100%!NULL!%Branch Code@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_BANK_GUARANTEE.FIN_BANK_GUARANTEE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_BANK_GUARANTEE.FIN_BANK_GUARANTEE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 8)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_startDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_endDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_CurrencyCode.getValue()) + "!" +((java.lang.String)parameter_P_vi_Branchcode.getValue()));
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
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 18)
        {
            value = (java.util.Date)(DateUtil.today());
        }
        else if (id == 19)
        {
            value = (java.sql.Connection)(null);
        }
        else if (id == 20)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_GteeAmt.getValue()));
        }
        else if (id == 21)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 22)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 23)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankPhone.getValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankFax.getValue()));
        }
        else if (id == 25)
        {
            value = (java.lang.String)(((java.lang.String)field_v_BankAddress.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.String)("Report for Guarantee Issure ("+((java.lang.String)parameter_P_vi_startDate.getValue())+" to "+((java.lang.String)parameter_P_vi_endDate.getValue())+")");
        }
        else if (id == 27)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()));
        }
        else if (id == 28)
        {
            value = (java.lang.String)(((java.lang.String)field_TranDate.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_GteeNo.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(((java.lang.String)field_ApplicantName.getValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.String)(((java.lang.String)field_BeneName.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)(((java.lang.String)field_Currency.getValue()));
        }
        else if (id == 33)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_GteeAmt.getValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)(((java.lang.String)field_ExpiredDate.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_CancelDate.getValue()));
        }
        else if (id == 36)
        {
            value = (java.lang.String)(((java.lang.String)field_GteePeriod.getValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)(null);
        }
        else if (id == 38)
        {
            value = (java.lang.String)(new SimpleDateFormat("MMM-yyyy").format(new SimpleDateFormat("dd-MM-yyyy").parse(((java.lang.String)parameter_P_vi_endDate.getValue())))+" Total ("+((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue())+") Nos");
        }
        else if (id == 39)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GteeAmount_total.getEstimatedValue()));
        }

        return value;
    }


}
