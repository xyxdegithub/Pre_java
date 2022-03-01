import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author :xyx
 * @date :2021/5/31 19:30
 * @description:TODO
 * @
 */
public class NetAPI {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//LAPTOP-RHOC8VHG/192.168.1.3

        InetAddress name = InetAddress.getByName("www.baidu.com");
        System.out.println(name);//www.baidu.com/14.215.177.39

    }
}
