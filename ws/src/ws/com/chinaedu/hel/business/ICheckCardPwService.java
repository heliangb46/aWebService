package ws.com.chinaedu.hel.business;

import ws.com.chinaedu.hel.utils.MessHolder;

public interface ICheckCardPwService {
    ws.com.chinaedu.hel.server.sei.imp.pojo.res.Message doCheckCardPw(MessHolder<ws.com.chinaedu.hel.server.sei.imp.pojo.req.Message, ws.com.chinaedu.hel.server.sei.imp.pojo.res.Message> messHolder);
}
