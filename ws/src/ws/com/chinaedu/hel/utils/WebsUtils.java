package ws.com.chinaedu.hel.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import ws.com.chinaedu.hel.constants.IDocWebsConstants;

public class WebsUtils {
	/**
	 * 处理应答报文反馈报文头中的部分信息
	 * 
	 * @param response
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static void dealwithAnsResHeader(Object response) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		dealwithAnsResHeader(response,
				StrUtils.isNullToStr(WebsUtils.getOneValueByGetterName(response, "getBusinessRespCode")));
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
	public static void dealwithAnsResHeader(Object response, String businessRespCode) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		dealwithAnsResHeader(response, businessRespCode,
				StrUtils.isNullToStr(WebsUtils.getOneValueByGetterName(response, "getBusinessRespText")));
	}

	/**
	 * 处理应答报文反馈报文头中的部分信息
	 * 
	 * @param response
	 * @param businessRespCode
	 * @param businessRespText
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static void dealwithAnsResHeader(Object response, String businessRespCode, String businessRespText)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException,
			NoSuchMethodException {
		businessRespCode = StrUtils.isNullToStr(businessRespCode);
		businessRespText = StrUtils.isNullToStr(businessRespText);

		Object relateRowsObj = WebsUtils.getOneValueByGetterName(response, "getRelateRows");
		if (relateRowsObj == null) {// 如果响应纪录数没有赋值，则默认成0
			WebsUtils.setOneValueBySetterNameAndValue(response, "setRelateRows", "0");
		}

		String relateRows = StrUtils.isNullToZero(WebsUtils.getOneValueByGetterName(response, "getRelateRows"));

		if ("0".equals(relateRows)) {
			// 如果relateRows=0
			if ("".equals(businessRespCode)) {
				// 如果businessRespCode没值，默认为02
				businessRespCode = IDocWebsConstants.Message_Header_businessRespCode_02;
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespCode", businessRespCode);
			} else {
				// 如果有值，则赋值给response.businessRespCode
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespCode", businessRespCode);

			}
		} else {
			// 如果relateRows!=0
			if ("".equals(businessRespCode)) {
				// 如果businessRespCode没值，则默认00
				businessRespCode = IDocWebsConstants.Message_Header_businessRespCode_00;
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespCode", businessRespCode);
			} else {
				// 如果有值，则赋值给response.businessRespCode
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespCode", businessRespCode);
			}
		}

		// 根据businessRespCode的值，写入businessRespText；
		if (IDocWebsConstants.Message_Header_businessRespCode_00.equals(businessRespCode)) {
			// 若businessRespCode为00
			if ("".equals(businessRespText)) {
				// 如果businessRespText为空，则默认“成功”。
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText", "成功");
			} else {
				// 如果有值，则赋值给response.businessRespText
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText", businessRespText);
			}
		} else if (IDocWebsConstants.Message_Header_businessRespCode_01.equals(businessRespCode)) {
			if ("".equals(businessRespText)) {
				// 若businessRespText为空，则默认成“没有查到相应数据”；
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText", "服务端错误");
			} else {
				// 如果有值，则赋值给response.businessRespText
				WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText", businessRespText);
			}
		} else if (IDocWebsConstants.Message_Header_businessRespCode_02.equals(businessRespCode)) {
			if ("0".equals(relateRows)) {
				// 若businessRespCode不为00，relateRows为0，
				if ("".equals(businessRespText)) {
					// 若businessRespText为空，则默认成“没有查到相应数据”；
					WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText", "没有查到相应数据");
				} else {
					// 如果有值，则赋值给response.businessRespText，但前缀加上“无对应数据”
					WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText",
							"无对应数据" + businessRespText);
				}
			} else {
				// 若businessRespCode为02，relateRows b为0，
				if ("".equals(businessRespText)) {
					// 若businessRespText为空，则默认成“没有查到相应数据”；
					WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText", "没有查到相应数据");
				} else {
					// 如果有值，则赋值给response.businessRespText，但前缀加上“无对应数据”
					WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText", businessRespText);
				}
			}
		} else {
			// 若还有其他情况，只能默认成businessRespText现有值。未完待续。。。
			WebsUtils.setOneValueBySetterNameAndValue(response, "setBusinessRespText", businessRespText);
		}

	}

	/**
	 * 按get方法名，取得当前对象的getter方法返回值
	 * 
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
	public static Object getOneValueByGetterName(Object thisObj, String getMethodName) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		Class<?> thisObjClass = thisObj.getClass();
		Method getter = thisObjClass.getMethod(getMethodName);
		Object val = getter.invoke(thisObj);
		return val;
	}

	public static void setOneValueBySetterNameAndValue(Object messObj, String setMethodName, Object val)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException,
			NoSuchMethodException {
		Class<?> messObjClass = messObj.getClass();
		Method setter = messObjClass.getMethod(setMethodName, val.getClass());
		setter.invoke(messObj, val);
	}

	/**
	 * 将第一个字母改为大写
	 * 
	 * @param str
	 * @return
	 */
	protected String getFirstUpString(String str) {
		String firstStr = str.substring(0, 1);
		firstStr = firstStr.toUpperCase();
		String otherStr = str.substring(1, str.length());
		String returnStr = "" + firstStr + otherStr;
		return returnStr;
	}

	/**
	 * 用resM的class初始化一个应答报文bean
	 * 
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
	public static <R> R initResMByClass(Class<?> resMessClass)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException,
			InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
		Object messFactory = getMessFactoryByMessClass(resMessClass);
		return createResMessByFactory(messFactory);
	}

	/**
	 * 用resM的创建工厂，创建一个resM对象
	 * 
	 * @param messFactory
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings("unchecked")
	public static <R> R createResMessByFactory(Object messFactory) throws IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Object resM = WebsUtils.getOneValueByGetterName(messFactory, "createMessage");

		Object messageHead = WebsUtils.getOneValueByGetterName(messFactory, "createMessageHead");
		WebsUtils.setOneValueBySetterNameAndValue(resM, "setHead", messageHead);

		Object reqMHead = WebsUtils.getOneValueByGetterName(resM, "getHead");

		Object messageHeadSysHeader = WebsUtils.getOneValueByGetterName(messFactory, "createMessageHeadResponse");
		WebsUtils.setOneValueBySetterNameAndValue(reqMHead, "setResponse", messageHeadSysHeader);

		Object messageBody = WebsUtils.getOneValueByGetterName(messFactory, "createMessageBody");
		WebsUtils.setOneValueBySetterNameAndValue(resM, "setBody", messageBody);
		return (R) resM;
	}

	/**
	 * 根据mess的class得到mess的创建工厂
	 * 
	 * @param reqMessClass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	private static Object getMessFactoryByMessClass(Class<?> reqMessClass)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return Class.forName(reqMessClass.getPackage().getName() + ".ObjectFactory").newInstance();
	}

	/**
	 * 判断请求报文：若老版报文，则去掉报文头内信息内容，若新版则不去掉,或其他请求报文内容
	 * 
	 * @param reqM
	 * @return 返回值为字符串类型数组，0：报文，1：代表报文版本（v1，v2），2：transactionCode，3：系统标识
	 * @throws DocumentException
	 */
	public static String[] reqMFilter(String reqM) throws DocumentException {

		if (reqM != null && !JaxbUtils.isFormat) {// 若配置不是格式化的报文信息，则处理掉所有的制表符、换行符
			reqM = reqM.replaceAll("(?<=>)\\s+(?=<)", "");
		}

		String[] retStrArr = new String[4];
		String reqMVersion = "";
		if (reqM.contains("standardVersionCode")) {
			reqMVersion = IDocWebsConstants.MESVER_V1;
		} else {
			reqMVersion = IDocWebsConstants.MESVER_V2;
		}

		if (reqMVersion.equals(IDocWebsConstants.MESVER_V1)) {
			// 处理老版本报文的字段不一样兼容问题
			Document document = DocumentHelper.parseText(reqM);// 将报文转换为dom4j对象
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
		} else {
			retStrArr[0] = reqM;
		}

		retStrArr[1] = reqMVersion;
		return retStrArr;
	}

	/**
	 * 判断应答报文：反馈时候需要做处理
	 * 
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
	public static String[] resMFilter(String resM, String transactionCode)
			throws DocumentException, IllegalArgumentException, SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		String[] retStrArr = new String[2];
		if (resM != null && !JaxbUtils.isFormat) {// 若配置不是格式化的报文信息，则处理掉所有的制表符、换行符、空格
			resM = resM.replaceAll("(?<=>)\\s+(?=<)", "");
		}

		Timestamp logTime = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = dateFormat.format(logTime);

		Document document = DocumentHelper.parseText(resM);// 将报文转换为dom4j对象
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
		tempElmt.setText(dateStr.substring(0, 10));
		response.add(tempElmt);

		tempElmt = DocumentHelper.createElement("responseTime");
		tempElmt.setText(dateStr.substring(11, 19));
		response.add(tempElmt);

		tempElmt = DocumentHelper.createElement("businessRespDate");
		tempElmt.setText(dateStr.substring(0, 10));
		response.add(tempElmt);

		Object tmpObj = response.element("businessRespTime");
		if (tmpObj == null) {
			tempElmt = DocumentHelper.createElement("businessRespTime");
			tempElmt.setText(dateStr.substring(11, 19));
			response.add(tempElmt);
		} else {
			response.element("businessRespTime").setText(dateStr.substring(11, 19));
		}

		retStrArr[0] = root.asXML();
		return retStrArr;
		// 以下注释片段较为重要
		// <?xml version="1.0" encoding="UTF-8"?> 新版应答报文
		// <message >
		// <head>
		// <response>
		// <esbRespType>String</esbRespType>
		// <esbRespCode>String</esbRespCode>
		// <esbRespDesc>String</esbRespDesc>
		// <transRefGUID>String</transRefGUID>--==
		// <transNo>String</transNo>--==
		// <relateRows>String</relateRows>--==
		// <businessRespCode>String</businessRespCode>--==
		// <businessRespText>String</businessRespText>--==
		// <businessRespTime>String</businessRespTime>--==
		// </response>
		// </head>
		// <body />
		// </message>
		//
		//
		// <?xml version="1.0" encoding="UTF-8"?> 老版应答报文
		// <message>
		// <head>
		// <response>
		// <standardVersionCode>String</standardVersionCode>
		// <transRefGUID>String</transRefGUID>
		// <esbRefGUID>String</esbRefGUID>
		// <transNo>String</transNo>--请求报文的复制
		// <transactionCode>String</transactionCode>
		// <responseCode>String</responseCode>
		// <responseText>String</responseText>
		// <responseDate>String</responseDate>---当前
		// <responseTime>String</responseTime>--当前时间
		// <businessRespCode>String</businessRespCode>--00成功 01失败 02其他
		// <businessRespText>String</businessRespText>--文本
		// <businessRespDate>String</businessRespDate>--当前
		// <businessRespTime>String</businessRespTime>--当前
		// <relateRows>String</relateRows>
		// </response>
		// </head>
		// <body/>
	}

}
