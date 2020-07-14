package com.example.dailytest.testmain.testSendSoapRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Constant {
    public static final String DATABASE_NAME = "iotinfomgr";
    public static int SUCCESS_CODE = 0;
    public static int FAILED_CODE = 1;
    /**
     * 0 成功
     * 1001 正则表达式，应用名，分组名，标签名不合法
     * 1100 批量操作，添加重复的名字
     * 1111 名字已经存在
     * 1200 请求参数错误
     * 1600 规格限制，例如：分组名不能超过100个，标签不能超过20个
     * 2100 标签，分组，应用下面有绑定用户，不允许删除，更新
     * 3200 权限校验不通过
     * 1104 网络异常/中断
     */
    public static final String ID = "_id";
    public static final String TIME = "modTime";
    public static final int SUCCESS = 0;
    public static final int INVALID_NAME = 1001;
    public static final int DUPLICATE_NAME = 1100;
    public static final int NON_EXISTED_ENTITY = 1101;
    public static final int EXISTED_NAME = 1111;
    public static final int ERROR_PARAMETER = 1200;
    public static final int LIMITED_SPECIFICATION = 1600;
    public static final int EXISTED_USER = 2100;
    public static final int DATA_ISEMPTY = 2200;
    public static final int PERMISSION_DENIED = 3200;
    public static final int DATABASE_OPER_ERROR = 3300;
    public static final int MARIADB_ERROR = 3400;
    public static final int HTTP_REQUEST_ERROR = 3502;
    public static final int ERROR_OPERATION = 2400;
    public static final int MOD_NAME_MAX_LEN = 30;
    public static final int MOD_NAME_MIN_LEN = 4;
    public static final int MOD_DESC_MAX_LEN = 200;
    public static final int MOD_MAX_NUM = 500;
    public static final int MOD_INDEX_INT_MAX_LEN = 10;
    public static final int MOD_INDEX_STR_MAX_LEN = 2048;
    public static final int MOD_INDEX_INT_MIN_LEN = 1;
    public static final int ATTR_MAX_NUM = 100;
    public static final int ATTR_NAME_MAX_LEN = 30;
    public static final int ATTR_INT_MIN_VALUE = -2147483648;
    public static final int ATTR_INT_MAX_VALUE = 2147483647;
    public static final int ATTR_BOOLSTATUS_MAX_LEN = 20;
    public static final int ATTR_ENUM_MAX_NUM = 25;
    public static final int ATTR_ENUMREF_MAX_NUM = 99;
    public static final int SVC_MAX_NUM = 100;
    public static final int SVC_NAME_MAX_LEN = 40;
    public static final int SVC_HTTP_SUB_LEN = 7;
    public static final int SVC_HTTPS_SUB_LEN = 8;
    public static final int STRUCT_MAX_DEP = 4;
    public static final int ONENEG = -1;
    public static final int TWONEG = -2;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int THREENEG = -3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SERVEN = 7;
    public static final int EIGHT = 7;
    public static final int FUTURETASK_TIME = 720000;
    public static final String TYPEONE = "1";
    public static final String TYPEZERO = "0";
    public static final String MYSQL = "mysql";
    public static final String MONGODB = "mongodb";
    public static final String GET = "get";
    public static final String POST = "post";
    public static final String PUT = "put";
    public static final String API = "API";
    public static final String SUBCREATE = "subCreate";
    public static final String SUBDELETE = "subDelete";
    public static final String STRPULL = "pull";
    public static final String MAX_SIZE_COUNT = "maxSizeCount";
    public static final int MAX_SIZE = 50;
    public static final String COL_ENTITY = "entityCollection";
    public static final String TERMINAL = "terminal";
    public static final String TRUE = "true";
    public static final String EXCEPSTR = "exception";
    public static final String SVCURLNOTAVA = "服务地址不可用";
    public static final String UPDATESVCNOTBIND = "未绑定更新服务";
    public static final String SVC_NOTEXIST = "服务不存在";
    public static final String SVC_TYPEERROR = "服务类型有误";




    public static volatile Map map = new HashMap();
    /**
    可批量操作，1不可批量操作
     */
    public static ConcurrentHashMap<String,Integer> batchImStatusMap = new ConcurrentHashMap();
    static {
        map.put("maxSizeCount", 0);
    }

    public static String getMessage(int code) {
        switch (code) {
            case SUCCESS:
                return "SUCCESS";
            case INVALID_NAME:
                return "参数不合法";
            case DUPLICATE_NAME:
                return "参数重复";
            case EXISTED_NAME:
                return "参数已经存在";
            case ERROR_PARAMETER:
                return "请求参数错误";
            case LIMITED_SPECIFICATION:
                return "超出规格限制";
            case EXISTED_USER:
                return "有绑定用户";
            case DATA_ISEMPTY:
                return "传入的数据集合为空";
            case PERMISSION_DENIED:
                return "权限校验不通过";
            case MARIADB_ERROR:
                return "数据库异常";
            case HTTP_REQUEST_ERROR:
                return "请求无响应";
            case ERROR_OPERATION:
                return "操作异常";
            case NON_EXISTED_ENTITY:
                return "实体Id不存在";
            default:
                return "UNKNOW";
        }
    }
}
