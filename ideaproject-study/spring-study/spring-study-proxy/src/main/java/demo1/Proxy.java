package demo1;

/**
 * @author :xyx
 * @date :2021/3/29 15:02
 * @description:TODO
 * @
 */
public class Proxy implements Rent {

    private Host host;

    public Proxy() {

    }

    public void setHost(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
    }

    public void test(){

    }
}


