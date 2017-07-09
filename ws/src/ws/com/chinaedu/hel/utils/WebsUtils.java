package ws.com.chinaedu.hel.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;

import ws.com.chinaedu.hel.constants.IDocWebsConstants;

public class WebsUtils {
	
	/**
	 * 写报文反馈信息
	 * @param obj
	 * @return
	 */
	public static String getInfoStrWithNotEnoughQryConditions(Object obj){
		return "该数据缺少必输条件：" + JSON.toJSONString(obj);
	}
	/**
	 * 处理应答报文反馈报文头中的部分信息
	 * @param response
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static void dealwithAnsResHeader(Object response) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		dealwithAnsResHeader(response,StrUtils.isNullToStr(WebsUtils.getOneValueByGetterName(response, "getBusinessRespCode")));
	}
	
    /**
     * 处理应答报文反馈报文头中的部分信息
     * 
     * @param response
     * @param businessRespCode
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
	public static void dealwithAnsResHeader(Object response,String businessRespCode) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		dealwithAnsResHeader(response,businessRespCode,StrUtils.isNullToStr(WebsUtils.getOneValueByGetterName(response, "getBusinessRespText")));
	}
	
	/**
	 * 处理应答报文反馈报文头中的部分信息
	 * @param response
	 * @param businessRespCode
	 * @param businessRespText
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static void dealwithAnsResHeader(Object response,String businessRespCode,String businessRespText) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		businessRespCode = StrUtils.isNullToStr(businessRespCode);
		businessRespText = StrUtils.isNullToStr(businessRespText);
		
		Object relateRowsObj = WebsUtils.getOneValueByGetterName(response, "getRelateRows");
		if(relateRowsObj==null){//如果响应纪录数没有赋值，则默认成0
			WebsUtils.setOneValueBySetterNameAndValue(response, "setRelateRows", "0");
		}
		
		String relateRows = StrUtils.isNullToZero(WebsUtils.getOneValueByGetterName(response, "getRelateRows"));
		
		if("0".equals(relateRows)){
			//如果relateRows=0
			if("".equals(businessRespCode)){
				//如果businessRespCode没值，默认为02
				businessRespCode = IDocWebsConstants.Message_Header_businessRespCode_02;
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespCode", businessRespCode);
			}else{
				//如果有值，则赋值给response.businessRespCode
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespCode", businessRespCode);

			}
		}else{
			//如果relateRows!=0
			if("".equals(businessRespCode)){
				//如果businessRespCode没值，则默认00
				businessRespCode = IDocWebsConstants.Message_Header_businessRespCode_00;
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespCode", businessRespCode);
			}else{
				//如果有值，则赋值给response.businessRespCode
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespCode",businessRespCode);
			}
		}
		
		//根据businessRespCode的值，写入businessRespText；
		if(IDocWebsConstants.Message_Header_businessRespCode_00.equals(businessRespCode)){
			//若businessRespCode为00
			if("".equals(businessRespText)){
				//如果businessRespText为空，则默认“成功”。
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText","成功");
			}else{
				//如果有值，则赋值给response.businessRespText
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText",businessRespText);
			}
		} else if(IDocWebsConstants.Message_Header_businessRespCode_01.equals(businessRespCode)){
			if("".equals(businessRespText)){
				//若businessRespText为空，则默认成“没有查到相应数据”；
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText","服务端错误");
			}else {
				//如果有值，则赋值给response.businessRespText
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText",businessRespText);
			}
		} else if(IDocWebsConstants.Message_Header_businessRespCode_02.equals(businessRespCode)){
			if("0".equals(relateRows)){
				//若businessRespCode不为00，relateRows为0，
				if("".equals(businessRespText)){
					//若businessRespText为空，则默认成“没有查到相应数据”；
					WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText","没有查到相应数据");
				}else {
					//如果有值，则赋值给response.businessRespText，但前缀加上“无对应数据”
					WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText","无对应数据"+businessRespText);
				}
			}else{
				//若businessRespCode为02，relateRows b为0，
				if("".equals(businessRespText)){
					//若businessRespText为空，则默认成“没有查到相应数据”；
					WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText","没有查到相应数据");
				}else {
					//如果有值，则赋值给response.businessRespText，但前缀加上“无对应数据”
					WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText",businessRespText);
				}
			}
		} else{
			//若还有其他情况，只能默认成businessRespText现有值。未完待续。。。
			WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText",businessRespText);
		}
		
	}
	
	

	/**
	 * 取得请求报文头的某一个节点
	 * @param messObj
	 * @param whichHeaderGetter
	 * @param getMethodName
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static String getReqHeaderOneValByGetMethodName(Object messObj,String whichHeaderGetter,String getMethodName) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
        Class<?> messObjClass = messObj.getClass();
		Method getHead = messObjClass.getMethod("getHead", null);
		Object head = getHead.invoke(messObj, null);
		
        Class<?> headClass = head.getClass();
		Method getOneHeader = headClass.getMethod(whichHeaderGetter, null);
		Object oneHeader = getOneHeader.invoke(head, null);
		
        Class<?> oneHeaderClass = oneHeader.getClass();
		Method getMethod = oneHeaderClass.getMethod(getMethodName, null);
		Object value = getMethod.invoke(oneHeader, null);
		return StrUtils.isNullToStr(value);
	}
	
	public static Object getHeaderOnePartByGetMethodName(Object messObj,String whichHeaderGetter) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
        Class<?> messObjClass = messObj.getClass();
		Method getHead = messObjClass.getMethod("getHead", null);
		Object head = getHead.invoke(messObj, null);
		
        Class<?> headClass = head.getClass();
		Method getOneHeader = headClass.getMethod(whichHeaderGetter, null);
		Object oneHeader = getOneHeader.invoke(head, null);
		
		return oneHeader;
	}
	
	
	/**
	 * 按get方法名，取得当前对象的getter方法返回值
	 * @param thisObj
	 * @param whichHeaderGetter
	 * @param getMethodName
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
    public static Object getOneValueByGetterName(Object thisObj, String getMethodName) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
        Class<?> thisObjClass = thisObj.getClass();
        Method getter = thisObjClass.getMethod(getMethodName, null);
		Object val = getter.invoke(thisObj, null);
        return val;
	}
	
    public static void setOneValueBySetterNameAndValueAndType(Object messObj, String setMethodName, Class<?> type, Object val) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
        Class<?> messObjClass = messObj.getClass();
		Method setter = messObjClass.getMethod(setMethodName, type);
		setter.invoke(messObj, type.cast(val));
	}
	
	public static void setOneValueBySetterNameAndValue(Object messObj,String setMethodName,Object val) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
        Class<?> messObjClass = messObj.getClass();
		Method setter = messObjClass.getMethod(setMethodName, val.getClass());
		setter.invoke(messObj, (val.getClass()).cast(val));
	}
	
	/**
	 * 根据属性名得到set方法名
	 * @param keyName
	 * @return
	 */
	protected String getSetMethodNameByKeyName(String keyName){
		String firstStr = keyName.substring(0, 1);
		firstStr = firstStr.toUpperCase();
		String otherStr = keyName.substring(1, keyName.length());
		String setMethodName = "set" + firstStr + otherStr;
		return setMethodName;
	}
	/**
	 * 根据属性名得到get方法名
	 * @param keyName
	 * @return
	 */
	protected String getGetMethodNameByKeyName(String keyName){
		String firstStr = keyName.substring(0, 1);
		firstStr = firstStr.toUpperCase();
		String otherStr = keyName.substring(1, keyName.length());
		String setMethodName = "get" + firstStr + otherStr;
		return setMethodName;
	}
	
	/**
	 * 将第一个字母改为大写
	 * @param str
	 * @return
	 */
	protected String getFirstUpString(String str){
		String firstStr = str.substring(0, 1);
		firstStr = firstStr.toUpperCase();
		String otherStr = str.substring(1, str.length());
		String returnStr = "" + firstStr + otherStr;
		return returnStr;
	}
	
	protected String getObjectFactoryCreaterName(String name){
		String returnName = "";
		returnName += "createMessageBody" + getFirstUpString(name) + "s" + getFirstUpString(name);
		return returnName;
	}
	
	protected String getObjectFactoryCreaterName(String name,String innerStr){
		String returnName = "";
		returnName += "createMessageBody" + innerStr + getFirstUpString(name) + "s" + getFirstUpString(name);
		return returnName;
	}
	
	/**
	 * 用方法名得到该对象方法的映射，用方法名遍历
	 * @param thisClass
	 * @param name
	 * @return
	 */
    public static Method getMethodByName(Class<?> thisClass, String name) {
		Method[] methods = thisClass.getMethods();
		for(Method method : methods){
			String methodName = method.getName();
			if(methodName.equals(name)){
				return method;
			}
		}
		return null;
	}
	
	/**
	 * 用方法名得到方法的映射，用getMethod实现
	 * @param objClass
	 * @param name
	 * @return
	 * @throws NoSuchMethodException
	 */
    protected Method getMethodByNameWithoutType(Class<?> objClass, String name) throws NoSuchMethodException {
		Method retMethod = null;
		try {
			retMethod = objClass.getMethod(name, Object.class);
		} catch (SecurityException e) {
			throw e;
		} catch (NoSuchMethodException e) {
			try {
				retMethod = objClass.getMethod(name, String.class);
			} catch (SecurityException e1) {
				throw e1;
			} catch (NoSuchMethodException e1) {
				try {
					retMethod = objClass.getMethod(name, Integer.class);
				} catch (SecurityException e2) {
					throw e2;
				} catch (NoSuchMethodException e2) {
					throw e2;
				}
			}
		}
		return retMethod; 
	}
	/**
	 * 用reqM的class初始化一个请求报文bean
	 * @param reqMByClass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
    public static Object initReqMByClass(Class<?> reqMByClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
		Object of = getMessFactoryByMessClass(reqMByClass);
		return getReqMByFactory(of);
	}
	/**
	 * 用reqM的创建工厂，创建一个reqM对象
	 * @param of
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static Object getReqMByFactory(Object of) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Object reqM = WebsUtils.getOneValueByGetterName(of, "createMessage");
		
		Object messageHead = WebsUtils.getOneValueByGetterName(of, "createMessageHead");
		WebsUtils.setOneValueBySetterNameAndValue(reqM, "setHead",messageHead);
		
		Object reqMHead = WebsUtils.getOneValueByGetterName(reqM, "getHead");
		
		Object messageHeadSysHeader = WebsUtils.getOneValueByGetterName(of, "createMessageHeadSysHeader");
		WebsUtils.setOneValueBySetterNameAndValue(reqMHead, "setSysHeader", messageHeadSysHeader);
		
		Object messageBody = WebsUtils.getOneValueByGetterName(of, "createMessageBody");
		WebsUtils.setOneValueBySetterNameAndValue(reqM, "setBody", messageBody);
		return reqM;
	}
	/**
	 * 用resM的class初始化一个应答报文bean
	 * @param resMessClass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
    public static <T extends Class<?>, R> R initResMByClass(T resMessClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
        Object messFactory = getMessFactoryByMessClass(resMessClass);
        return createResMessByFactory(messFactory);
    }
	/**
	 * 用resM的创建工厂，创建一个resM对象
	 * @param messFactory
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
    public static <R> R createResMessByFactory(Object messFactory) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Object resM = WebsUtils.getOneValueByGetterName(messFactory, "createMessage");
		
		Object messageHead = WebsUtils.getOneValueByGetterName(messFactory, "createMessageHead");
		WebsUtils.setOneValueBySetterNameAndValue(resM, "setHead",messageHead);
		
		Object reqMHead = WebsUtils.getOneValueByGetterName(resM, "getHead");
		
		Object messageHeadSysHeader = WebsUtils.getOneValueByGetterName(messFactory, "createMessageHeadResponse");
		WebsUtils.setOneValueBySetterNameAndValue(reqMHead, "setResponse", messageHeadSysHeader);
		
		Object messageBody = WebsUtils.getOneValueByGetterName(messFactory, "createMessageBody");
		WebsUtils.setOneValueBySetterNameAndValue(resM, "setBody", messageBody);
        return (R) resM;
	}
	
	
	/**
	 * 根据mess的class得到mess的创建工厂
	 * @param reqMessClass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
    private static <T extends Class<?>> Object getMessFactoryByMessClass(T reqMessClass) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return Class.forName(reqMessClass.getPackage().getName() + ".ObjectFactory").newInstance();
    }
	
	/**
	 * 利用反射实现对象之间属性复制
	 * @param from
	 * @param to
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void copyProperties(Object from, Object to) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		copyPropertiesExclude(from, to, null);
	}
	
	/**
	 * 复制对象属性
	 * @param from
	 * @param to
	 * @param excludsArray 排除属性列表
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void copyPropertiesExclude(Object from, Object to, String[] excludsArray) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		List<String> excludesList = null;
		if(excludsArray != null && excludsArray.length > 0) {
			excludesList = Arrays.asList(excludsArray);	//构造列表对象
		}
		
		
		Method[] fromMethods = from.getClass().getDeclaredMethods();
		Method[] toMethods = to.getClass().getDeclaredMethods();
		Method fromMethod = null, toMethod = null;
		String fromMethodName = null, toMethodName = null;
		for (int i = 0; i < fromMethods.length; i++) {
			fromMethod = fromMethods[i];
			fromMethodName = fromMethod.getName();
			if (!fromMethodName.contains("get"))
				continue;
			//排除列表检测
			if(excludesList != null && excludesList.contains(fromMethodName.substring(3).toLowerCase())) {
				continue;
			}
			toMethodName = "set" + fromMethodName.substring(3);
			toMethod = findMethodByName(toMethods, toMethodName);
			if (toMethod == null)
				continue;
			Object value = fromMethod.invoke(from, new Object[0]);
			if(value == null)
				continue;
			//集合类判空处理
			if(value instanceof Collection) {
				Collection newValue = (Collection)value;
				if(newValue.size() <= 0)
					continue;
			}
			toMethod.invoke(to, new Object[] {value});
		}
	}
	
	/**
	 * 对象属性值复制，仅复制指定名称的属性值
	 * @param from
	 * @param to
	 * @param includsArray
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void copyPropertiesInclude(Object from, Object to, String[] includsArray) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		List<String> includesList = null;
		if(includsArray != null && includsArray.length > 0) {
			includesList = Arrays.asList(includsArray);	//构造列表对象
		} else {
			return;
		}
		Method[] fromMethods = from.getClass().getDeclaredMethods();
		Method[] toMethods = to.getClass().getDeclaredMethods();
		Method fromMethod = null, toMethod = null;
		String fromMethodName = null, toMethodName = null;
		for (int i = 0; i < fromMethods.length; i++) {
			fromMethod = fromMethods[i];
			fromMethodName = fromMethod.getName();
			if (!fromMethodName.contains("get"))
				continue;
			//排除列表检测
			String str = fromMethodName.substring(3);
			if(!includesList.contains(str.substring(0,1).toLowerCase() + str.substring(1))) {
				continue;
			}
			toMethodName = "set" + fromMethodName.substring(3);
			toMethod = findMethodByName(toMethods, toMethodName);
			if (toMethod == null)
				continue;
			Object value = fromMethod.invoke(from, new Object[0]);
			if(value == null)
				continue;
			//集合类判空处理
			if(value instanceof Collection) {
				Collection newValue = (Collection)value;
				if(newValue.size() <= 0)
					continue;
			}
			toMethod.invoke(to, new Object[] {value});
		}
	}
	
	/**
	 * 从方法数组中获取指定名称的方法
	 * 
	 * @param methods
	 * @param name
	 * @return
	 */
	public static Method findMethodByName(Method[] methods, String name) {
		for (int j = 0; j < methods.length; j++) {
			if (methods[j].getName().equals(name))
				return methods[j];
		}
		return null;
	}
	
	/**
	 * 则处理掉所有的制表符、换行符
	 * @param str
	 * @return
	 */
	public static String delMessOtherChar(String str){
        Pattern p = Pattern.compile("\t|\r|\n");
        Matcher m = p.matcher(str);
        str = m.replaceAll("");
        return str;
	} 
	
	/**
	 * 判断请求报文：若老版报文，则去掉报文头内信息内容，若新版则不去掉,或其他请求报文内容
	 * @param reqM
	 * @return 返回值为字符串类型数组，0：报文，1：代表报文版本（v1，v2），2：transactionCode，3：系统标识
	 * @throws DocumentException 
	 */
	public static String[] reqMFilter(String reqM) throws DocumentException {
		
        if (reqM!=null&&!JaxbUtils.isFormat) {//若配置不是格式化的报文信息，则处理掉所有的制表符、换行符
        	reqM = reqM.replaceAll("(?<=>)\\s+(?=<)", "");
        }
        
		String[] retStrArr = new String[4];
		String reqMVersion = "";
		if(reqM.contains("standardVersionCode")){
			reqMVersion = IDocWebsConstants.MESVER_V1;
		}else{
			reqMVersion = IDocWebsConstants.MESVER_V2;
		}
		
		if(reqMVersion.equals(IDocWebsConstants.MESVER_V1)){
            // 处理老版本报文的字段不一样兼容问题
			Document document = DocumentHelper.parseText(reqM);//将报文转换为dom4j对象  
			Element root = document.getRootElement();
			Element head = root.element("head");
			Element sysHeader = head.element("sysHeader");
			
			Element standardVersionCode = sysHeader.element("standardVersionCode");
			Element msgDate = sysHeader.element("msgDate");
			Element msgTime = sysHeader.element("msgTime");
			Element systemCode = sysHeader.element("systemCode");
			Element transactionCode = sysHeader.element("transactionCode");
			
			retStrArr[2] = transactionCode.getText();
			
			String systemCodeText = systemCode.getText();
			retStrArr[3] = systemCodeText;
			
			sysHeader.remove(standardVersionCode);
			sysHeader.remove(msgDate);
			sysHeader.remove(msgTime);
			sysHeader.remove(systemCode);
			sysHeader.remove(transactionCode);

			retStrArr[0] = root.asXML();
		}else{
			retStrArr[0] = reqM;
		}
		
		retStrArr[1] = reqMVersion;
		return retStrArr;
	}
	
	/**
	 * 判断应答报文：反馈时候需要做处理
	 * @param resM
	 * @param transactionCode 
	 * @return 
	 * @throws DocumentException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws IllegalArgumentException 
	 */
	public static String[] resMFilter(String resM, String transactionCode) throws DocumentException, IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		String[] retStrArr = new String[2];
        if (resM!=null&&!JaxbUtils.isFormat) {//若配置不是格式化的报文信息，则处理掉所有的制表符、换行符、空格
            resM = resM.replaceAll("(?<=>)\\s+(?=<)", "");
        }
        
        Timestamp logTime = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = dateFormat.format(logTime);
        
		Document document = DocumentHelper.parseText(resM);//将报文转换为dom4j对象  
		Element root = document.getRootElement();
		Element head = root.element("head");
		Element response = head.element("response");
		
		Element esbRespType = response.element("esbRespType");
		Element esbRespCode = response.element("esbRespCode");
		Element esbRespDesc = response.element("esbRespDesc");
		response.remove(esbRespType);
		response.remove(esbRespCode);
		response.remove(esbRespDesc);
		
		Element tempElmt = null;
		tempElmt = DocumentHelper.createElement("standardVersionCode");
		tempElmt.setText("");
		response.add(tempElmt);
		
		tempElmt = DocumentHelper.createElement("esbRefGUID");
		tempElmt.setText("");
		response.add(tempElmt);
		
		tempElmt = DocumentHelper.createElement("transactionCode");
		tempElmt.setText(transactionCode);
		response.add(tempElmt);
		
		tempElmt = DocumentHelper.createElement("responseCode");
		tempElmt.setText("");
		response.add(tempElmt);

		tempElmt = DocumentHelper.createElement("responseText");
		tempElmt.setText("");
		response.add(tempElmt);
		
		tempElmt = DocumentHelper.createElement("responseDate");
		tempElmt.setText(dateStr.substring(0,10));
		response.add(tempElmt);
		
		tempElmt = DocumentHelper.createElement("responseTime");
		tempElmt.setText(dateStr.substring(11,19));
		response.add(tempElmt);
		
		tempElmt = DocumentHelper.createElement("businessRespDate");
		tempElmt.setText(dateStr.substring(0,10));
		response.add(tempElmt);
		
		Object tmpObj = response.element("businessRespTime");
		if(tmpObj == null){
			tempElmt = DocumentHelper.createElement("businessRespTime");
			tempElmt.setText(dateStr.substring(11,19));
			response.add(tempElmt);
		}else{
			response.element("businessRespTime").setText(dateStr.substring(11,19));
		}
		
		retStrArr[0] = root.asXML();
		return retStrArr;
//		以下注释片段较为重要
//		<?xml version="1.0" encoding="UTF-8"?> 新版应答报文
//		<message >
//		  <head>
//		    <response>
//		      <esbRespType>String</esbRespType>
//		      <esbRespCode>String</esbRespCode>
//		      <esbRespDesc>String</esbRespDesc>
//		      <transRefGUID>String</transRefGUID>--==
//		      <transNo>String</transNo>--==
//		      <relateRows>String</relateRows>--==
//		      <businessRespCode>String</businessRespCode>--==
//		      <businessRespText>String</businessRespText>--==
//		      <businessRespTime>String</businessRespTime>--==
//		    </response>
//		  </head>
//		  <body />
//		</message>
//
//
//		<?xml version="1.0" encoding="UTF-8"?>  老版应答报文
//		<message>
//			<head>
//				<response>
//					<standardVersionCode>String</standardVersionCode>
//					<transRefGUID>String</transRefGUID>
//					<esbRefGUID>String</esbRefGUID>
//					<transNo>String</transNo>--请求报文的复制
//					<transactionCode>String</transactionCode>
//					<responseCode>String</responseCode>
//					<responseText>String</responseText>
//					<responseDate>String</responseDate>---当前
//					<responseTime>String</responseTime>--当前时间
//					<businessRespCode>String</businessRespCode>--00成功 01失败 02其他 
//					<businessRespText>String</businessRespText>--文本  
//					<businessRespDate>String</businessRespDate>--当前
//					<businessRespTime>String</businessRespTime>--当前
//					<relateRows>String</relateRows>
//				</response>
//			</head>
//			<body/>
	}
	
	
}
