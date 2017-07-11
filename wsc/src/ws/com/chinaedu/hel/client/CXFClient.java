package ws.com.chinaedu.hel.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.alibaba.fastjson.JSON;

import ws.com.chinaedu.hel.client.sei.CheckCardPw;
import ws.com.chinaedu.hel.client.utils.JaxbUtils;
import ws.com.chinaedu.hel.client.utils.MessHolder;
import ws.com.chinaedu.hel.client.utils.WebsUtils;

public class CXFClient {

	public static void main(String[] args) throws Exception {
		System.out.println("Starting Client");

		// 定义JaxWs的代理工厂
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		// 设置JaxWs代理工厂的属性，包括服务类和地址
		factory.setServiceClass(CheckCardPw.class);
		factory.setAddress("http://localhost:9000/CheckCardPw");

		// 获取服务类的对象并处理
		CheckCardPw checkCardPw = (CheckCardPw) factory.create();
		MessHolder<ws.com.chinaedu.hel.client.pojo.req.Message, ws.com.chinaedu.hel.client.pojo.res.Message> messHolder = new MessHolder<ws.com.chinaedu.hel.client.pojo.req.Message, ws.com.chinaedu.hel.client.pojo.res.Message>(
				new ws.com.chinaedu.hel.client.pojo.req.Message(), new ws.com.chinaedu.hel.client.pojo.res.Message());

		messHolder.reqMes = WebsUtils.initReqMByClass(messHolder.reqMes.getClass());
		messHolder.reqMes.getBody().setCardNo("010110");
		messHolder.reqMes.getBody().setPassword("101011");
		String reqMesStr = JaxbUtils.convertToXml(messHolder.reqMes);
		System.out.println("reqMesStr：" + reqMesStr);
		String resMesStr = checkCardPw.checkCardPw(reqMesStr);
		System.out.println("resMesStr：" + resMesStr);
		messHolder.resMes = JaxbUtils.converyToJavaBean(resMesStr, messHolder.resMes.getClass());
		System.out.println(JSON.toJSONString(messHolder));
		System.exit(0);
	}
}
