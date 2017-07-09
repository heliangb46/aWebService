package ws.com.chinaedu.hel.utils;




import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 主要用为javaBean与xml互转的两个方法。
 *
 */
public class JaxbUtils {
	public static boolean isFormat = false;
	/**
	 * JavaBean转换成xml
	 * 重载实现，默认编码UTF-8
	 * @param obj
	 * @return 
	 */
	public static String convertToXml(Object obj) throws JAXBException {
		return convertToXml(obj, "UTF-8", false);
	}
	
	/**
	 * JavaBean转换成xml
	 * 重载实现，是否格式化
	 * @param obj
	 * @return 
	 */
	public static String convertToXml(Object obj,boolean isFormat) throws JAXBException {
		return convertToXml(obj, "UTF-8", isFormat);
	}
	

	/**
	 * JavaBean转换成xml
	 * @param obj
	 * @param encoding 
	 * @param isFormat 
	 * @return 
	 * @throws JAXBException 
	 */
	public static String convertToXml(Object obj, String encoding, boolean isFormat) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		if(isFormat){
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, isFormat);
		}else{
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, JaxbUtils.isFormat);
		}
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);

		return writer.toString();
	}

    /**
     * xml转换成JavaBean
     * 
     * @param xml
     * @param beanClass
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <R> R converyToJavaBean(String xml, Class<?> beanClass) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(beanClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (R) unmarshaller.unmarshal(new StringReader(xml));
    }
}
