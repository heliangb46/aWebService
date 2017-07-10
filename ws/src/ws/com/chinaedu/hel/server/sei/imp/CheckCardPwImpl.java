package ws.com.chinaedu.hel.server.sei.imp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ws.com.chinaedu.hel.business.ICheckCardPwService;
import ws.com.chinaedu.hel.constants.IDocWebsConstants;
import ws.com.chinaedu.hel.server.sei.CheckCardPw;
import ws.com.chinaedu.hel.utils.JaxbUtils;
import ws.com.chinaedu.hel.utils.MessHolder;
import ws.com.chinaedu.hel.utils.WebsUtils;

@WebService(targetNamespace = IDocWebsConstants.tns_CheckCardPw)
public class CheckCardPwImpl implements CheckCardPw {

	private static final Logger logger = LoggerFactory.getLogger(CheckCardPwImpl.class);

	boolean enable = true;

	private ICheckCardPwService checkCardPwServiceImpl;

	@Override
	@WebMethod(action = "checkCardPw", operationName = "checkCardPw") // 注册的方法名
	@WebResult(name = IDocWebsConstants.websType_message)
	public String checkCardPw(@WebParam(name = IDocWebsConstants.websType_message) String message) throws Exception {
		logger.info("checkCardPw .listen start");
		Long startTime = System.currentTimeMillis();
		logger.debug("checkCardPw .message=" + message);

		// 用于持有请求、反馈报文的对象(使用目的：防止频繁声明message pojo 对象的类型)
		MessHolder<ws.com.chinaedu.hel.server.sei.imp.pojo.req.Message, ws.com.chinaedu.hel.server.sei.imp.pojo.res.Message> messHolder = new MessHolder<ws.com.chinaedu.hel.server.sei.imp.pojo.req.Message, ws.com.chinaedu.hel.server.sei.imp.pojo.res.Message>(
				new ws.com.chinaedu.hel.server.sei.imp.pojo.req.Message(),
				new ws.com.chinaedu.hel.server.sei.imp.pojo.res.Message());
		// TDocIntfCallLog websLog = websUtilsDao.getNewLog("checkCardPw");
		String resMStr = "";
		if (enable) {
			// 请求报文的拦截器-----------------begin-----------------
			String[] reqMInfos = WebsUtils.reqMFilter(message);
			message = reqMInfos[0];// 处理后的报文
			String reqMVersion = reqMInfos[1];// 报文版本标识
			// 请求报文的拦截器-----------------end-------------------

			// 将请求报文转化为对应的bean----------------------begin----------------------
			try {
				messHolder.reqMes = JaxbUtils.converyToJavaBean(message, messHolder.reqMes.getClass());
			} catch (Exception e) {
				WebsUtils.dealwithAnsResHeader(messHolder.resMes.getHead().getResponse(),
						IDocWebsConstants.Message_Header_businessRespCode_01, IDocWebsConstants.webs_error_str_001);
				logger.error("ServiceException=异常(cast), ClassName=[" + this.getClass().getName() + "] "
						+ IDocWebsConstants.webs_error_str_001 + e);
				// websLog.setExceptionInf(IDocWebsConstants.webs_error_str_001 +
				// e.getClass().getName());
			}
			// 将请求报文转化为对应的bean----------------------end----------------------

			// 创建反馈报文空白结构
			messHolder.resMes = WebsUtils.initResMByClass(messHolder.resMes.getClass());

			try {
				messHolder.resMes = checkCardPwServiceImpl.doCheckCardPw(messHolder);// 根据条件更新数据库
			} catch (Exception e) {
				WebsUtils.dealwithAnsResHeader(messHolder.resMes.getHead().getResponse(),
						IDocWebsConstants.Message_Header_businessRespCode_01, IDocWebsConstants.webs_error_str_002);
				logger.error("ServiceException=异常, ClassName=[" + this.getClass().getName() + "] " + e);
				// websLog.setExceptionInf("调用dao异常：" + e.getClass().getName());
			}
			//
			// 拼接报文头----------------------begin----------------------
			WebsUtils.dealwithAnsResHeader(messHolder.resMes.getHead().getResponse());
			// 拼接报文头----------------------end----------------------

			resMStr = JaxbUtils.convertToXml(messHolder.resMes);
			logger.debug("rtnMsg=" + resMStr);

			// 反馈报文的拦截器，若中介调用（老版报文）-------------begin----------
			if (reqMVersion.equals(IDocWebsConstants.MESVER_V1)) {
				resMStr = WebsUtils.resMFilter(resMStr, reqMInfos[2])[0];
			}
			// 反馈报文的拦截器，若中介调用（老版报文）---------------end----------
		} else {
			logger.error("ServiceException=开关：关");
		}
		// websLog.setTxResult(IDocWebsConstants.Log_Exec_Status_Success);
		// websLog.setMsgContent(message);
		// websLog.setRetMsgContent(resMStr);

		// 执行结束计时
		long endTime = System.currentTimeMillis();
		// 执行时间
		long exeTime = endTime - startTime;

		// websLog.setTxOrg("" + exeTime);
		// websUtilsDao.saveLog(websLog, logger);

		logger.info("checkCardPw .exeTime=" + exeTime);
		logger.info("checkCardPw .listen end");
		return resMStr;
	}

	public ICheckCardPwService getCheckCardPwServiceImpl() {
		return checkCardPwServiceImpl;
	}

	public void setCheckCardPwServiceImpl(ICheckCardPwService checkCardPwServiceImpl) {
		this.checkCardPwServiceImpl = checkCardPwServiceImpl;
	}
}