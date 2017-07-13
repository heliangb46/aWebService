package ws.com.chinaedu.hel.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WebsUtils {

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
		setter.invoke(messObj, (val.getClass()).cast(val));
	}

	/**
	 * 用reqM的class初始化一个请求报文bean
	 * 
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
	public static <R> R initReqMByClass(Class<?> reqMByClass)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException,
			InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
		Object of = getMessFactoryByMessClass(reqMByClass);
		return getReqMByFactory(of);
	}

	/**
	 * 用reqM的创建工厂，创建一个reqM对象
	 * 
	 * @param of
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings("unchecked")
	public static <R> R getReqMByFactory(Object of) throws IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Object reqM = WebsUtils.getOneValueByGetterName(of, "createMessage");

		Object messageHead = WebsUtils.getOneValueByGetterName(of, "createMessageHead");
		WebsUtils.setOneValueBySetterNameAndValue(reqM, "setHead", messageHead);

		Object reqMHead = WebsUtils.getOneValueByGetterName(reqM, "getHead");

		Object messageHeadSysHeader = WebsUtils.getOneValueByGetterName(of, "createMessageHeadSysHeader");
		WebsUtils.setOneValueBySetterNameAndValue(reqMHead, "setSysHeader", messageHeadSysHeader);

		Object messageBody = WebsUtils.getOneValueByGetterName(of, "createMessageBody");
		WebsUtils.setOneValueBySetterNameAndValue(reqM, "setBody", messageBody);
		return (R) reqM;
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

}
