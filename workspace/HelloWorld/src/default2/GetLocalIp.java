package default2;

import java.net.InetAddress;


public class GetLocalIp {

	public static void main(String[] args) throws Exception{
//	获取本机IP地址及主机名		
		InetAddress address = InetAddress.getLocalHost();
			
		    System.out.println("Local HostAdress:"
			+address.getHostAddress());
		    
            String hostname=address.getHostName();
            System.out.println("hostname:"+hostname);
         
	}
	}


