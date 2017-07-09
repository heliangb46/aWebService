package ws.com.chinaedu.hel.utils;

public class MessHolder<REQ, RES> {
    public REQ reqMes;
    public RES resMes;

    public MessHolder(REQ reqMes, RES resMes) {
        super();
        this.reqMes = reqMes;
        this.resMes = resMes;
    }
}
