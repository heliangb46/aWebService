package ws.com.chinaedu.hel.business.imp;

import org.springframework.stereotype.Service;

import ws.com.chinaedu.hel.business.ICheckCardPwService;
import ws.com.chinaedu.hel.constants.IDocWebsConstants;
import ws.com.chinaedu.hel.utils.MessHolder;
import ws.com.chinaedu.hel.utils.StrUtils;

@Service
public class CheckCardPwServiceImpl implements ICheckCardPwService {
    /**
     * 校验激活卡密码
     * 
     * @param messHolder
     * @return
     */
    @Override
    public ws.com.chinaedu.hel.server.sei.imp.pojo.res.Message doCheckCardPw(MessHolder<ws.com.chinaedu.hel.server.sei.imp.pojo.req.Message, ws.com.chinaedu.hel.server.sei.imp.pojo.res.Message> messHolder) {
        String cardNo = StrUtils.isNullToStr(messHolder.reqMes.getBody().getCardNo());
        String passWd = StrUtils.isNullToStr(messHolder.reqMes.getBody().getPassword());
		
		if(cardNo.equals("")||passWd.equals("")){
            messHolder.resMes.getHead().getResponse().setBusinessRespText("缺少必输条件。");
            messHolder.resMes.getHead().getResponse().setBusinessRespCode("02");
            return messHolder.resMes;// 如果缺少条件，则不走更新
		}
        // String activateCode = checkCardPwDao.querCard(cardNo);
        String activateCode = "0001";// 因为没有dao层，这里用假数据代表
		if(activateCode==null || ("").equals(activateCode)){
            messHolder.resMes.getHead().getResponse().setBusinessRespText(IDocWebsConstants.webs_error_str_012);
            messHolder.resMes.getHead().getResponse().setBusinessRespCode(IDocWebsConstants.Message_Header_businessRespCode_01);
            return messHolder.resMes;
		}
		if(!activateCode.equals(passWd)){
            messHolder.resMes.getHead().getResponse().setBusinessRespText(IDocWebsConstants.webs_error_str_013);
            messHolder.resMes.getHead().getResponse().setBusinessRespCode(IDocWebsConstants.Message_Header_businessRespCode_01);
            return messHolder.resMes;
		}
		//如果单证存在，同时密码校验成功，返回函数默认为1；
        messHolder.resMes.getHead().getResponse().setRelateRows("" + 1);
        return messHolder.resMes;
	}

}
