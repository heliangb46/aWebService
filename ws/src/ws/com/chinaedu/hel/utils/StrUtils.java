package ws.com.chinaedu.hel.utils;

public class StrUtils {
	public static String isNullToStr(Object inStr) {
		String retStr = inStr + "";
		if (inStr == null || "".equals(inStr) || "undefined".equals(inStr) || "null".equals(inStr)) {
			return "";
		} else {
			return retStr;
		}
	}

	public static String isNullToZero(Object inStr) {
		String retStr = inStr + "";
		if (inStr == null || "".equals(inStr) || "undefined".equals(inStr) || "null".equals(inStr)) {
			return "0";
		} else {
			return retStr;
		}
	}
}
