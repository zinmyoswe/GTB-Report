/*
 * Generated by JasperReports - 12/7/17 5:24 PM
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
class Drawing_Encash_Summary_OtherBank_1512644059672_423302 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_P_vi_TranDate = null;
    private JRFillParameter parameter_P_vi_other_bank = null;
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
    private JRFillField field_v_Encash_amt = null;
    private JRFillField field_v_Commission = null;
    private JRFillField field_v_sol_id = null;
    private JRFillField field_Project_Bank_Name = null;
    private JRFillField field_v_drawing_amt = null;
    private JRFillField field_v_AGD_BR_name = null;
    private JRFillField field_Project_Image_Name = null;
    private JRFillField field_v_Encash_Count = null;
    private JRFillField field_v_drawing_Count = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_FIN_REPOSITORY = null;
    private JRFillVariable variable_TODAY = null;
    private JRFillVariable variable_FIN_DB_CONN = null;
    private JRFillVariable variable_DrawingAmount = null;
    private JRFillVariable variable_DrawingIncome = null;
    private JRFillVariable variable_DrawingTotal = null;
    private JRFillVariable variable_GrandTotal_DrawingCount = null;
    private JRFillVariable variable_GrandTotal_DrawingAmount = null;
    private JRFillVariable variable_GrandTotal_DrawingIncome = null;
    private JRFillVariable variable_GrandTotal_DrawingTotal = null;
    private JRFillVariable variable_GrandTotal_EncashCount = null;
    private JRFillVariable variable_EncashAmount = null;
    private JRFillVariable variable_GrandTotal_EncashAmount = null;


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
        parameter_P_vi_TranDate = (JRFillParameter)pm.get("P_vi_TranDate");
        parameter_P_vi_other_bank = (JRFillParameter)pm.get("P_vi_other_bank");
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
        field_v_Encash_amt = (JRFillField)fm.get("v_Encash_amt");
        field_v_Commission = (JRFillField)fm.get("v_Commission");
        field_v_sol_id = (JRFillField)fm.get("v_sol_id");
        field_Project_Bank_Name = (JRFillField)fm.get("Project_Bank_Name");
        field_v_drawing_amt = (JRFillField)fm.get("v_drawing_amt");
        field_v_AGD_BR_name = (JRFillField)fm.get("v_AGD_BR_name");
        field_Project_Image_Name = (JRFillField)fm.get("Project_Image_Name");
        field_v_Encash_Count = (JRFillField)fm.get("v_Encash_Count");
        field_v_drawing_Count = (JRFillField)fm.get("v_drawing_Count");
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
        variable_DrawingAmount = (JRFillVariable)vm.get("DrawingAmount");
        variable_DrawingIncome = (JRFillVariable)vm.get("DrawingIncome");
        variable_DrawingTotal = (JRFillVariable)vm.get("DrawingTotal");
        variable_GrandTotal_DrawingCount = (JRFillVariable)vm.get("GrandTotal_DrawingCount");
        variable_GrandTotal_DrawingAmount = (JRFillVariable)vm.get("GrandTotal_DrawingAmount");
        variable_GrandTotal_DrawingIncome = (JRFillVariable)vm.get("GrandTotal_DrawingIncome");
        variable_GrandTotal_DrawingTotal = (JRFillVariable)vm.get("GrandTotal_DrawingTotal");
        variable_GrandTotal_EncashCount = (JRFillVariable)vm.get("GrandTotal_EncashCount");
        variable_EncashAmount = (JRFillVariable)vm.get("EncashAmount");
        variable_GrandTotal_EncashAmount = (JRFillVariable)vm.get("GrandTotal_EncashAmount");
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
            value = (java.lang.String)("CUSTOM|FIN_DRAWING_ENCASH_SUMMARY.FIN_DRAWING_ENCASH_SUMMARY%3%CUSTOM::|where%vi_TranDate%=%((java.lang.String)parameter_P_vi_TranDate.getValue())%Parameter%Date::and%vi_other_bank%=%((java.lang.String)parameter_P_vi_other_bank.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_TranDate%java.sql.Timestamp%10%!NULL!%Transaction Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_other_bank%java.lang.String%100%!NULL!%Other Bank@DBQUERY%NONE%java.lang.String!@!SET!@!0!@!100&!&KBZ#@#AYA#@#MWD#@#CB#@#SMIDB#@#RDB#@#CHDB#@#Innwa#@#Shwe#@#MABL#@#May(MALAYSIA)#@#May(SINGAPORE)#@#UOB#@#DBS#@#BKK#@#OCBC#@#SIAM#@#AGD%CONSTANT%N%N::|{call CUSTOM.FIN_DRAWING_ENCASH_SUMMARY.FIN_DRAWING_ENCASH_SUMMARY( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_DRAWING_ENCASH_SUMMARY.FIN_DRAWING_ENCASH_SUMMARY( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 7)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_TranDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_other_bank.getValue()));
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
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_drawing_amt.getValue())== null ? 0.00 : ((java.math.BigDecimal)field_v_drawing_amt.getValue()));
        }
        else if (id == 20)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Commission.getValue())== null? 0.00 : ((java.math.BigDecimal)field_v_Commission.getValue()));
        }
        else if (id == 21)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingAmount.getValue())+((java.math.BigDecimal)variable_DrawingIncome.getValue()));
        }
        else if (id == 22)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_drawing_Count.getValue()));
        }
        else if (id == 23)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingAmount.getValue()));
        }
        else if (id == 24)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingIncome.getValue()));
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingTotal.getValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_Encash_Count.getValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Encash_amt.getValue())== null ? 0.00 : ((java.math.BigDecimal)field_v_Encash_amt.getValue()));
        }
        else if (id == 28)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_EncashAmount.getValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 31)
        {
            value = (java.lang.String)("Summary of Drawing and Encashment (AGD to "   +((java.lang.String)parameter_P_vi_other_bank.getValue()) + ") as at" +((java.lang.String)parameter_P_vi_TranDate.getValue()));
        }
        else if (id == 32)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_drawing_Count.getValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_Encash_Count.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_v_AGD_BR_name.getValue()));
        }
        else if (id == 36)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingAmount.getValue()));
        }
        else if (id == 37)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_EncashAmount.getValue()));
        }
        else if (id == 38)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_REPORT_COUNT.getValue()));
        }
        else if (id == 39)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingIncome.getValue()));
        }
        else if (id == 40)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingTotal.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_GrandTotal_DrawingCount.getValue()));
        }
        else if (id == 43)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_DrawingAmount.getValue()));
        }
        else if (id == 44)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_DrawingIncome.getValue()));
        }
        else if (id == 45)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_DrawingTotal.getValue()));
        }
        else if (id == 46)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_GrandTotal_EncashCount.getValue()));
        }
        else if (id == 47)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_EncashAmount.getValue()));
        }
        else if (id == 48)
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
            value = (java.lang.String)("CUSTOM|FIN_DRAWING_ENCASH_SUMMARY.FIN_DRAWING_ENCASH_SUMMARY%3%CUSTOM::|where%vi_TranDate%=%((java.lang.String)parameter_P_vi_TranDate.getValue())%Parameter%Date::and%vi_other_bank%=%((java.lang.String)parameter_P_vi_other_bank.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_TranDate%java.sql.Timestamp%10%!NULL!%Transaction Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_other_bank%java.lang.String%100%!NULL!%Other Bank@DBQUERY%NONE%java.lang.String!@!SET!@!0!@!100&!&KBZ#@#AYA#@#MWD#@#CB#@#SMIDB#@#RDB#@#CHDB#@#Innwa#@#Shwe#@#MABL#@#May(MALAYSIA)#@#May(SINGAPORE)#@#UOB#@#DBS#@#BKK#@#OCBC#@#SIAM#@#AGD%CONSTANT%N%N::|{call CUSTOM.FIN_DRAWING_ENCASH_SUMMARY.FIN_DRAWING_ENCASH_SUMMARY( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_DRAWING_ENCASH_SUMMARY.FIN_DRAWING_ENCASH_SUMMARY( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 7)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_TranDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_other_bank.getValue()));
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
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_drawing_amt.getOldValue())== null ? 0.00 : ((java.math.BigDecimal)field_v_drawing_amt.getOldValue()));
        }
        else if (id == 20)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Commission.getOldValue())== null? 0.00 : ((java.math.BigDecimal)field_v_Commission.getOldValue()));
        }
        else if (id == 21)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingAmount.getOldValue())+((java.math.BigDecimal)variable_DrawingIncome.getOldValue()));
        }
        else if (id == 22)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_drawing_Count.getOldValue()));
        }
        else if (id == 23)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingAmount.getOldValue()));
        }
        else if (id == 24)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingIncome.getOldValue()));
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingTotal.getOldValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_Encash_Count.getOldValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Encash_amt.getOldValue())== null ? 0.00 : ((java.math.BigDecimal)field_v_Encash_amt.getOldValue()));
        }
        else if (id == 28)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_EncashAmount.getOldValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getOldValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getOldValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 31)
        {
            value = (java.lang.String)("Summary of Drawing and Encashment (AGD to "   +((java.lang.String)parameter_P_vi_other_bank.getValue()) + ") as at" +((java.lang.String)parameter_P_vi_TranDate.getValue()));
        }
        else if (id == 32)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getOldValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_drawing_Count.getOldValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_Encash_Count.getOldValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_v_AGD_BR_name.getOldValue()));
        }
        else if (id == 36)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingAmount.getOldValue()));
        }
        else if (id == 37)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_EncashAmount.getOldValue()));
        }
        else if (id == 38)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()));
        }
        else if (id == 39)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingIncome.getOldValue()));
        }
        else if (id == 40)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingTotal.getOldValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_GrandTotal_DrawingCount.getOldValue()));
        }
        else if (id == 43)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_DrawingAmount.getOldValue()));
        }
        else if (id == 44)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_DrawingIncome.getOldValue()));
        }
        else if (id == 45)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_DrawingTotal.getOldValue()));
        }
        else if (id == 46)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_GrandTotal_EncashCount.getOldValue()));
        }
        else if (id == 47)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_EncashAmount.getOldValue()));
        }
        else if (id == 48)
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
            value = (java.lang.String)("CUSTOM|FIN_DRAWING_ENCASH_SUMMARY.FIN_DRAWING_ENCASH_SUMMARY%3%CUSTOM::|where%vi_TranDate%=%((java.lang.String)parameter_P_vi_TranDate.getValue())%Parameter%Date::and%vi_other_bank%=%((java.lang.String)parameter_P_vi_other_bank.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_TranDate%java.sql.Timestamp%10%!NULL!%Transaction Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_other_bank%java.lang.String%100%!NULL!%Other Bank@DBQUERY%NONE%java.lang.String!@!SET!@!0!@!100&!&KBZ#@#AYA#@#MWD#@#CB#@#SMIDB#@#RDB#@#CHDB#@#Innwa#@#Shwe#@#MABL#@#May(MALAYSIA)#@#May(SINGAPORE)#@#UOB#@#DBS#@#BKK#@#OCBC#@#SIAM#@#AGD%CONSTANT%N%N::|{call CUSTOM.FIN_DRAWING_ENCASH_SUMMARY.FIN_DRAWING_ENCASH_SUMMARY( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_DRAWING_ENCASH_SUMMARY.FIN_DRAWING_ENCASH_SUMMARY( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 7)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_TranDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_other_bank.getValue()));
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
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_drawing_amt.getValue())== null ? 0.00 : ((java.math.BigDecimal)field_v_drawing_amt.getValue()));
        }
        else if (id == 20)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Commission.getValue())== null? 0.00 : ((java.math.BigDecimal)field_v_Commission.getValue()));
        }
        else if (id == 21)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingAmount.getEstimatedValue())+((java.math.BigDecimal)variable_DrawingIncome.getEstimatedValue()));
        }
        else if (id == 22)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_drawing_Count.getValue()));
        }
        else if (id == 23)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingAmount.getEstimatedValue()));
        }
        else if (id == 24)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingIncome.getEstimatedValue()));
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingTotal.getEstimatedValue()));
        }
        else if (id == 26)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_Encash_Count.getValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_Encash_amt.getValue())== null ? 0.00 : ((java.math.BigDecimal)field_v_Encash_amt.getValue()));
        }
        else if (id == 28)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_EncashAmount.getEstimatedValue()));
        }
        else if (id == 29)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 31)
        {
            value = (java.lang.String)("Summary of Drawing and Encashment (AGD to "   +((java.lang.String)parameter_P_vi_other_bank.getValue()) + ") as at" +((java.lang.String)parameter_P_vi_TranDate.getValue()));
        }
        else if (id == 32)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getEstimatedValue()));
        }
        else if (id == 33)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_drawing_Count.getValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.Integer)(((java.math.BigDecimal)field_v_Encash_Count.getValue()));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_v_AGD_BR_name.getValue()));
        }
        else if (id == 36)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingAmount.getEstimatedValue()));
        }
        else if (id == 37)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_EncashAmount.getEstimatedValue()));
        }
        else if (id == 38)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()));
        }
        else if (id == 39)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingIncome.getEstimatedValue()));
        }
        else if (id == 40)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_DrawingTotal.getEstimatedValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
        }
        else if (id == 42)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_GrandTotal_DrawingCount.getEstimatedValue()));
        }
        else if (id == 43)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_DrawingAmount.getEstimatedValue()));
        }
        else if (id == 44)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_DrawingIncome.getEstimatedValue()));
        }
        else if (id == 45)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_DrawingTotal.getEstimatedValue()));
        }
        else if (id == 46)
        {
            value = (java.lang.Integer)(((java.lang.Integer)variable_GrandTotal_EncashCount.getEstimatedValue()));
        }
        else if (id == 47)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_GrandTotal_EncashAmount.getEstimatedValue()));
        }
        else if (id == 48)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue())+ " ) Records Listed.");
        }

        return value;
    }


}
