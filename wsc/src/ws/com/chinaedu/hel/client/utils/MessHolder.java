package ws.com.chinaedu.hel.client.utils;

public class MessHolder<REQ, RES> {
    public REQ reqMes;
    public RES resMes;

    public MessHolder(REQ reqMes, RES resMes) {
        super();
        this.reqMes = reqMes;
        this.resMes = resMes;
    }
}
