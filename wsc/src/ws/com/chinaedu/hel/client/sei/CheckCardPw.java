package ws.com.chinaedu.hel.client.sei;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ws.com.chinaedu.hel.client.constants.IDocWebsConstants;

@WebService(targetNamespace = IDocWebsConstants.tns_CheckCardPw)
public interface CheckCardPw {
    @WebMethod(action = "checkCardPw", operationName = "checkCardPw") // 注册的方法名
    @WebResult(name = IDocWebsConstants.websType_message)
    public String checkCardPw(@WebParam(name = IDocWebsConstants.websType_message) String reqMess) throws Exception;
}