/*
 * Generated by JasperReports - 12/6/17 5:25 PM
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
class Untitled_report_1_1512557724606_153654 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_P_vi_TranDate = null;
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
    private JRFillParameter parameter_P_vi_acct_id = null;
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
    private JRFillParameter parameter_P_vi_BranchCode = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_v_BankFax = null;
    private JRFillField field_v_MMKBalance = null;
    private JRFillField field_v_balance = null;
    private JRFillField field_v_sol_desc = null;
    private JRFillField field_v_acct_name = null;
    private JRFillField field_v_rate = null;
    private JRFillField field_Project_Bank_Name = null;
    private JRFillField field_v_BankPhone = null;
    private JRFillField field_v_foracid = null;
    private JRFillField field_Project_Image_Name = null;
    private JRFillField field_v_gl_sub_head_code = null;
    private JRFillField field_v_BankAddress = null;
    private JRFillField field_v_BranchName = null;
    private JRFillField field_v_cur = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_sub_gp_code_COUNT = null;
    private JRFillVariable variable_Sub_gl_code_COUNT = null;
    private JRFillVariable variable_TODAY = null;
    private JRFillVariable variable_FIN_DB_CONN = null;
    private JRFillVariable variable_FCY = null;
    private JRFillVariable variable_FCYVariable = null;
    private JRFillVariable variable_MMK = null;
    private JRFillVariable variable_32GrandTotal_MMK_Balance = null;
    private JRFillVariable variable_Sub_fcy = null;
    private JRFillVariable variable_sub_mmk = null;
    private JRFillVariable variable_G_total_fcy = null;


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
        parameter_P_vi_acct_id = (JRFillParameter)pm.get("P_vi_acct_id");
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
        parameter_P_vi_BranchCode = (JRFillParameter)pm.get("P_vi_BranchCode");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    void initFields(Map fm)
    {
        field_v_BankFax = (JRFillField)fm.get("v_BankFax");
        field_v_MMKBalance = (JRFillField)fm.get("v_MMKBalance");
        field_v_balance = (JRFillField)fm.get("v_balance");
        field_v_sol_desc = (JRFillField)fm.get("v_sol_desc");
        field_v_acct_name = (JRFillField)fm.get("v_acct_name");
        field_v_rate = (JRFillField)fm.get("v_rate");
        field_Project_Bank_Name = (JRFillField)fm.get("Project_Bank_Name");
        field_v_BankPhone = (JRFillField)fm.get("v_BankPhone");
        field_v_foracid = (JRFillField)fm.get("v_foracid");
        field_Project_Image_Name = (JRFillField)fm.get("Project_Image_Name");
        field_v_gl_sub_head_code = (JRFillField)fm.get("v_gl_sub_head_code");
        field_v_BankAddress = (JRFillField)fm.get("v_BankAddress");
        field_v_BranchName = (JRFillField)fm.get("v_BranchName");
        field_v_cur = (JRFillField)fm.get("v_cur");
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
        variable_sub_gp_code_COUNT = (JRFillVariable)vm.get("sub_gp_code_COUNT");
        variable_Sub_gl_code_COUNT = (JRFillVariable)vm.get("Sub_gl_code_COUNT");
        variable_TODAY = (JRFillVariable)vm.get("TODAY");
        variable_FIN_DB_CONN = (JRFillVariable)vm.get("FIN_DB_CONN");
        variable_FCY = (JRFillVariable)vm.get("FCY");
        variable_FCYVariable = (JRFillVariable)vm.get("FCYVariable");
        variable_MMK = (JRFillVariable)vm.get("MMK");
        variable_32GrandTotal_MMK_Balance = (JRFillVariable)vm.get(" GrandTotal_MMK_Balance");
        variable_Sub_fcy = (JRFillVariable)vm.get("Sub_fcy");
        variable_sub_mmk = (JRFillVariable)vm.get("sub_mmk");
        variable_G_total_fcy = (JRFillVariable)vm.get("G_total_fcy");
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
            value = (java.lang.String)("CUSTOM|FIN_GL_CODE_BALANCE.FIN_GL_CODE_BALANCE%3%CUSTOM::|where%vi_TranDate%=%((java.lang.String)parameter_P_vi_TranDate.getValue())%Parameter%Date::and%vi_acct_id%=%((java.lang.String)parameter_P_vi_acct_id.getValue())%Parameter%String::and%vi_BranchCode%=%((java.lang.String)parameter_P_vi_BranchCode.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_TranDate%java.sql.Timestamp%10%!NULL!%Tran_Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_acct_id%java.lang.String%100%!NULL!%Account_id@DBQUERY%NONE%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_vi_BranchCode%java.lang.String%100%!NULL!%Branch Code@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_GL_CODE_BALANCE.FIN_GL_CODE_BALANCE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_GL_CODE_BALANCE.FIN_GL_CODE_BALANCE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 7)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_TranDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_acct_id.getValue()) + "!" +((java.lang.String)parameter_P_vi_BranchCode.getValue()));
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
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_balance.getValue())== 0 || ((java.math.BigDecimal)field_v_balance.getValue())== null ? 0.00 : ((java.math.BigDecimal)field_v_balance.getValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)((((java.lang.String)field_v_cur.getValue()).toUpperCase()).equals("MMK") ?
 "-" :(((java.math.BigDecimal)variable_FCY.getValue())>0 && ((java.math.BigDecimal)variable_FCY.getValue())<1 ?
"0"+new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_FCY.getValue())):
new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_FCY.getValue()))));
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_MMKBalance.getValue())== 0 || ((java.math.BigDecimal)field_v_MMKBalance.getValue())== null ? 0.00 :((java.math.BigDecimal)field_v_MMKBalance.getValue()));
        }
        else if (id == 26)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_MMK.getValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)((((java.lang.String)field_v_cur.getValue()).toUpperCase()).equals("MMK")? 0.00: ((java.math.BigDecimal)variable_FCY.getValue()));
        }
        else if (id == 28)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_MMK.getValue()));
        }
        else if (id == 29)
        {
            value = (java.math.BigDecimal)((((java.lang.String)field_v_cur.getValue()).toUpperCase()).equals("MMK")?0.00 :((java.math.BigDecimal)variable_FCY.getValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.Object)(((java.lang.String)parameter_P_vi_acct_id.getValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.Object)(((java.lang.String)field_v_gl_sub_head_code.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)((((java.math.BigDecimal)variable_Sub_fcy.getValue())== 0 || ((java.math.BigDecimal)variable_Sub_fcy.getValue())== null? "0.00":
new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_Sub_fcy.getValue()))));
        }
        else if (id == 33)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_sub_mmk.getValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 36)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)("GL Code Balance Listing AS " +((java.lang.String)parameter_P_vi_TranDate.getValue()));
        }
        else if (id == 38)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_acct_id.getValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.String)field_v_foracid.getValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)(((java.lang.String)field_v_sol_desc.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.String)field_v_cur.getValue()));
        }
        else if (id == 42)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_MMK.getValue()));
        }
        else if (id == 43)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getValue()));
        }
        else if (id == 44)
        {
            value = (java.lang.String)(((java.lang.String)variable_FCYVariable.getValue()));
        }
        else if (id == 45)
        {
            value = (java.lang.String)(((java.lang.String)field_v_acct_name.getValue()));
        }
        else if (id == 46)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
        }
        else if (id == 47)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_32GrandTotal_MMK_Balance.getValue()));
        }
        else if (id == 48)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getValue())+ " ) Records Listed.");
        }
        else if (id == 49)
        {
            value = (java.lang.String)(((java.math.BigDecimal)variable_G_total_fcy.getValue())== 0 || ((java.math.BigDecimal)variable_G_total_fcy.getValue())== null? "0.00":
new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_G_total_fcy.getValue())));
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
            value = (java.lang.String)("CUSTOM|FIN_GL_CODE_BALANCE.FIN_GL_CODE_BALANCE%3%CUSTOM::|where%vi_TranDate%=%((java.lang.String)parameter_P_vi_TranDate.getValue())%Parameter%Date::and%vi_acct_id%=%((java.lang.String)parameter_P_vi_acct_id.getValue())%Parameter%String::and%vi_BranchCode%=%((java.lang.String)parameter_P_vi_BranchCode.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_TranDate%java.sql.Timestamp%10%!NULL!%Tran_Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_acct_id%java.lang.String%100%!NULL!%Account_id@DBQUERY%NONE%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_vi_BranchCode%java.lang.String%100%!NULL!%Branch Code@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_GL_CODE_BALANCE.FIN_GL_CODE_BALANCE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_GL_CODE_BALANCE.FIN_GL_CODE_BALANCE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 7)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_TranDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_acct_id.getValue()) + "!" +((java.lang.String)parameter_P_vi_BranchCode.getValue()));
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
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_balance.getOldValue())== 0 || ((java.math.BigDecimal)field_v_balance.getOldValue())== null ? 0.00 : ((java.math.BigDecimal)field_v_balance.getOldValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)((((java.lang.String)field_v_cur.getOldValue()).toUpperCase()).equals("MMK") ?
 "-" :(((java.math.BigDecimal)variable_FCY.getOldValue())>0 && ((java.math.BigDecimal)variable_FCY.getOldValue())<1 ?
"0"+new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_FCY.getOldValue())):
new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_FCY.getOldValue()))));
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_MMKBalance.getOldValue())== 0 || ((java.math.BigDecimal)field_v_MMKBalance.getOldValue())== null ? 0.00 :((java.math.BigDecimal)field_v_MMKBalance.getOldValue()));
        }
        else if (id == 26)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_MMK.getOldValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)((((java.lang.String)field_v_cur.getOldValue()).toUpperCase()).equals("MMK")? 0.00: ((java.math.BigDecimal)variable_FCY.getOldValue()));
        }
        else if (id == 28)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_MMK.getOldValue()));
        }
        else if (id == 29)
        {
            value = (java.math.BigDecimal)((((java.lang.String)field_v_cur.getOldValue()).toUpperCase()).equals("MMK")?0.00 :((java.math.BigDecimal)variable_FCY.getOldValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.Object)(((java.lang.String)parameter_P_vi_acct_id.getValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.Object)(((java.lang.String)field_v_gl_sub_head_code.getOldValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)((((java.math.BigDecimal)variable_Sub_fcy.getOldValue())== 0 || ((java.math.BigDecimal)variable_Sub_fcy.getOldValue())== null? "0.00":
new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_Sub_fcy.getOldValue()))));
        }
        else if (id == 33)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_sub_mmk.getOldValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getOldValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getOldValue()));
        }
        else if (id == 36)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getOldValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)("GL Code Balance Listing AS " +((java.lang.String)parameter_P_vi_TranDate.getValue()));
        }
        else if (id == 38)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_acct_id.getValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.String)field_v_foracid.getOldValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)(((java.lang.String)field_v_sol_desc.getOldValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.String)field_v_cur.getOldValue()));
        }
        else if (id == 42)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_MMK.getOldValue()));
        }
        else if (id == 43)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getOldValue()));
        }
        else if (id == 44)
        {
            value = (java.lang.String)(((java.lang.String)variable_FCYVariable.getOldValue()));
        }
        else if (id == 45)
        {
            value = (java.lang.String)(((java.lang.String)field_v_acct_name.getOldValue()));
        }
        else if (id == 46)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
        }
        else if (id == 47)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_32GrandTotal_MMK_Balance.getOldValue()));
        }
        else if (id == 48)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getOldValue())+ " ) Records Listed.");
        }
        else if (id == 49)
        {
            value = (java.lang.String)(((java.math.BigDecimal)variable_G_total_fcy.getOldValue())== 0 || ((java.math.BigDecimal)variable_G_total_fcy.getOldValue())== null? "0.00":
new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_G_total_fcy.getOldValue())));
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
            value = (java.lang.String)("CUSTOM|FIN_GL_CODE_BALANCE.FIN_GL_CODE_BALANCE%3%CUSTOM::|where%vi_TranDate%=%((java.lang.String)parameter_P_vi_TranDate.getValue())%Parameter%Date::and%vi_acct_id%=%((java.lang.String)parameter_P_vi_acct_id.getValue())%Parameter%String::and%vi_BranchCode%=%((java.lang.String)parameter_P_vi_BranchCode.getValue())%Parameter%String::|INP_STR%1%java.lang.String%VARCHAR2::OUT_RETCODE%4%java.math.BigDecimal%NUMBER::OUT_REC%4%java.lang.String%VARCHAR2::|P_vi_TranDate%java.sql.Timestamp%10%!NULL!%Tran_Date@DBQUERY%NONE%java.sql.Timestamp!@!DEFAULT!@!8!@!10%CONSTANT%N%N::P_vi_acct_id%java.lang.String%100%!NULL!%Account_id@DBQUERY%NONE%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::P_vi_BranchCode%java.lang.String%100%!NULL!%Branch Code@DBQUERY%PRODUCT!@!SolID_List#@#N%java.lang.String!@!DEFAULT!@!0!@!100%CONSTANT%N%N::|{call CUSTOM.FIN_GL_CODE_BALANCE.FIN_GL_CODE_BALANCE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |{call CUSTOM.FIN_GL_CODE_BALANCE.FIN_GL_CODE_BALANCE( ((java.lang.String)parameter_FIN_INP_STR.getValue())  , ((java.math.BigDecimal)parameter_FIN_OUT_RETCODE.getValue()) , ((java.lang.String)parameter_FIN_OUT_REC.getValue()) ) } |false");
        }
        else if (id == 7)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_TranDate.getValue()) + "!" +((java.lang.String)parameter_P_vi_acct_id.getValue()) + "!" +((java.lang.String)parameter_P_vi_BranchCode.getValue()));
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
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_balance.getValue())== 0 || ((java.math.BigDecimal)field_v_balance.getValue())== null ? 0.00 : ((java.math.BigDecimal)field_v_balance.getValue()));
        }
        else if (id == 24)
        {
            value = (java.lang.String)((((java.lang.String)field_v_cur.getValue()).toUpperCase()).equals("MMK") ?
 "-" :(((java.math.BigDecimal)variable_FCY.getEstimatedValue())>0 && ((java.math.BigDecimal)variable_FCY.getEstimatedValue())<1 ?
"0"+new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_FCY.getEstimatedValue())):
new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_FCY.getEstimatedValue()))));
        }
        else if (id == 25)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)field_v_MMKBalance.getValue())== 0 || ((java.math.BigDecimal)field_v_MMKBalance.getValue())== null ? 0.00 :((java.math.BigDecimal)field_v_MMKBalance.getValue()));
        }
        else if (id == 26)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_MMK.getEstimatedValue()));
        }
        else if (id == 27)
        {
            value = (java.math.BigDecimal)((((java.lang.String)field_v_cur.getValue()).toUpperCase()).equals("MMK")? 0.00: ((java.math.BigDecimal)variable_FCY.getEstimatedValue()));
        }
        else if (id == 28)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_MMK.getEstimatedValue()));
        }
        else if (id == 29)
        {
            value = (java.math.BigDecimal)((((java.lang.String)field_v_cur.getValue()).toUpperCase()).equals("MMK")?0.00 :((java.math.BigDecimal)variable_FCY.getEstimatedValue()));
        }
        else if (id == 30)
        {
            value = (java.lang.Object)(((java.lang.String)parameter_P_vi_acct_id.getValue()));
        }
        else if (id == 31)
        {
            value = (java.lang.Object)(((java.lang.String)field_v_gl_sub_head_code.getValue()));
        }
        else if (id == 32)
        {
            value = (java.lang.String)((((java.math.BigDecimal)variable_Sub_fcy.getEstimatedValue())== 0 || ((java.math.BigDecimal)variable_Sub_fcy.getEstimatedValue())== null? "0.00":
new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_Sub_fcy.getEstimatedValue()))));
        }
        else if (id == 33)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_sub_mmk.getEstimatedValue()));
        }
        else if (id == 34)
        {
            value = (java.lang.String)(FinUtil.getImage(((java.lang.String)field_Project_Image_Name.getValue()), ((java.lang.String)parameter_FIN_IMG_PATH.getValue())));
        }
        else if (id == 35)
        {
            value = (java.lang.String)(((java.lang.String)field_Project_Bank_Name.getValue()));
        }
        else if (id == 36)
        {
            value = (java.util.Date)(((java.util.Date)variable_TODAY.getEstimatedValue()));
        }
        else if (id == 37)
        {
            value = (java.lang.String)("GL Code Balance Listing AS " +((java.lang.String)parameter_P_vi_TranDate.getValue()));
        }
        else if (id == 38)
        {
            value = (java.lang.String)(((java.lang.String)parameter_P_vi_acct_id.getValue()));
        }
        else if (id == 39)
        {
            value = (java.lang.String)(((java.lang.String)field_v_foracid.getValue()));
        }
        else if (id == 40)
        {
            value = (java.lang.String)(((java.lang.String)field_v_sol_desc.getValue()));
        }
        else if (id == 41)
        {
            value = (java.lang.String)(((java.lang.String)field_v_cur.getValue()));
        }
        else if (id == 42)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_MMK.getEstimatedValue()));
        }
        else if (id == 43)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()));
        }
        else if (id == 44)
        {
            value = (java.lang.String)(((java.lang.String)variable_FCYVariable.getEstimatedValue()));
        }
        else if (id == 45)
        {
            value = (java.lang.String)(((java.lang.String)field_v_acct_name.getValue()));
        }
        else if (id == 46)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
        }
        else if (id == 47)
        {
            value = (java.math.BigDecimal)(((java.math.BigDecimal)variable_32GrandTotal_MMK_Balance.getEstimatedValue()));
        }
        else if (id == 48)
        {
            value = (java.lang.String)("Total ( " + ((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue())+ " ) Records Listed.");
        }
        else if (id == 49)
        {
            value = (java.lang.String)(((java.math.BigDecimal)variable_G_total_fcy.getEstimatedValue())== 0 || ((java.math.BigDecimal)variable_G_total_fcy.getEstimatedValue())== null? "0.00":
new java.text.DecimalFormat("#,###.00").format(((java.math.BigDecimal)variable_G_total_fcy.getEstimatedValue())));
        }

        return value;
    }


}
