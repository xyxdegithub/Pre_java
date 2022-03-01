package demo2;

/**
 * @author :xyx
 * @date :2021/3/29 16:15
 * @description:TODO
 * @
 */
public class Test {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setRent(host);
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();
        proxy.rent();

    }

}
