package ws.com.chinaedu.hel.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.alibaba.fastjson.JSON;

public class StrUtils {
	
	public static String isNullToStr(Object inStr){
		String retStr = inStr+"";
		if(inStr == null|| "".equals(inStr) || "undefined".equals(inStr) || "null".equals(inStr)){
			return "";
		}else{
			return retStr;
		}
	}
	
	public static String isNullToZero(Object inStr){
		String retStr = inStr+"";
		if(inStr == null|| "".equals(inStr) || "undefined".equals(inStr) || "null".equals(inStr)){
			return "0";
		}else{
			return retStr;
		}
	}
	
	public static boolean isEmpty(String str) {
		if ( str == null || "".equals(str) || "null".equals(str) || "undefined".equals(str)) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(String str) {
		if ( str != null && !"".equals(str) && !"null".equals(str) && !"undefined".equals(str) ) {
			return true;
		}
		return false;
	}
	
	public static String makeBeanToStringByGetMethod(Object innerObj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		StringBuffer sBuffer = new StringBuffer();
        Class<? extends Object> thisClass = innerObj.getClass();
		Method[] thisMethods = thisClass.getMethods();
		for(Method thisMethod :thisMethods){
			String methodName = thisMethod.getName();
			if(methodName.contains("get")&&!"getClass".equals(methodName)){
				Object obj = thisMethod.invoke(innerObj);
				sBuffer.append(methodName.substring(3,methodName.length())+"="+obj);
			}
		}
		return sBuffer.toString();
	}
	
	public static String makeGetMethodNameToSetMethodName(String getterName){
		getterName = "s"+getterName.substring(1, getterName.length());
		return getterName;
	}
	
	public static String toJson(Object obj){
		return JSON.toJSONString(obj);
	}
	
	public static String[] makeStrToArr(String oneStr){
		return new String[]{oneStr};
	}
	
	public static String subMessStr(String message){
    	if(message != null){
    		message = message.replaceAll("(?<=>)\\s+(?=<)", "");
    	}
    	return message;
	}
	
	
	public static String dealNo(String DocNo,String certifyCode){
		String DocNoStr = DocNo.substring(certifyCode.length(), DocNo.length());
		return DocNoStr;
	}
	
	
	/**
	 * 根据状态转码，参见v_doc_track_history
	 * @param status
	 * @return
	 */
	public static String decodeChangeStatus(String status){
//		单证申请类型	DOC_APPLY_TYPE	01	单证发放
//		单证申请类型	DOC_APPLY_TYPE	02	单证缺号申请
//		单证申请类型	DOC_APPLY_TYPE	03	单证领用
//		单证申请类型	DOC_APPLY_TYPE	04	中介经理发放
//		单证申请类型	DOC_APPLY_TYPE	05	单证调拨
//		单证申请类型	DOC_APPLY_TYPE	06	单证人工回销
//		单证申请类型	DOC_APPLY_TYPE	07	单证回销回退
//		单证申请类型	DOC_APPLY_TYPE	08	单证冻结
//		单证申请类型	DOC_APPLY_TYPE	09	单证解冻
//		单证申请类型	DOC_APPLY_TYPE	10	单证销毁
//		单证申请类型	DOC_APPLY_TYPE	11	单证发放回退
//		单证申请类型	DOC_APPLY_TYPE	12	单证入库
//
//
//		单证变更状态	DOC_CHANGE_STATUS	01	未生效 
//		单证变更状态	DOC_CHANGE_STATUS	02	已生效 
//		单证变更状态	DOC_CHANGE_STATUS	04	已退回（未入库）
//
//		单证回销类型	DOC_BACK_WRTOFF_TYPE	01	正常回销 
//		单证回销类型	DOC_BACK_WRTOFF_TYPE	02	作废回销 
//		单证回销类型	DOC_BACK_WRTOFF_TYPE	03	遗失回销 
//		单证回销类型	DOC_BACK_WRTOFF_TYPE	04	空白回销
		
		if("01-01-".equals(status)){
			status = "未确认库存";
		} else if("01-02-".equals(status)){
			status = "库存";
		} else if("01-04-".equals(status)){
			status = "退回";
		} else if("02-02-".equals(status)){
			status = "印刷缺号";
		} else if("03-02-".equals(status)){
			status = "未用";
		} else if("05-01-".equals(status)){
			status = "库存";
		} else if("05-02-".equals(status)){
			status = "库存";
		} else if("06-02-01".equals(status)){
			status = "正常回销";
		} else if("06-02-02".equals(status)){
			status = "作废回销";
		} else if("06-02-03".equals(status)){
			status = "遗失回销";
		} else if("06-02-04".equals(status)){
			status = "空白回销";
		} else if("07-01-01".equals(status)){
			status = "回销回退申请";
		} else if("07-01-02".equals(status)){
			status = "回销回退申请";
		} else if("07-01-03".equals(status)){
			status = "回销回退申请";
		} else if("07-02-01".equals(status)){
			status = "未用";
		} else if("07-02-02".equals(status)){
			status = "未用";
		} else if("07-02-03".equals(status)){
			status = "未用";
		} else if("08-02-".equals(status)){
			status = "冻结";
		} else if("09-02-".equals(status)){
			status = "解冻";
		} else if("10-02-".equals(status)){
			status = "销毁";
		} else if("11-02-".equals(status)){
			status = "库存";
		} else if("12-02-".equals(status)){
			status = "库存";
		} else if("13-02-01".equals(status)){
			status = "系统正常回销";
		} else if("13-02-02".equals(status)){
			status = "系统作废回销";
		} else if("13-02-03".equals(status)){
			status = "系统遗失回销";
		}
		return status;
	}
	
}
