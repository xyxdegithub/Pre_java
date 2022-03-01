package default2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIp {
//获取指定地址ip
	public static void main(String[] args) {
		InetAddress address=null;
		try {
			address=InetAddress.getByName("www.baidu.com");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(address.getHostName()+"="
		+address.getHostAddress());
        
	}

}
