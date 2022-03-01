/**
 * 
 */
package proxy;

/**
 * @author xyx 2021年1月16日 上午11:06:19
 * 
 */
public class NetWorkTest {
	public static void main(String[] args) {
		Server server = new Server();
		ProxyServer proxyserver = new ProxyServer(server);
		proxyserver.browse();
	}
}

interface NetWork {
	public abstract void browse();
}

//被代理类
class Server implements NetWork {

	@Override
	public void browse() {
		System.out.println("真实的服务器!");

	}

}

//代理类
class ProxyServer implements NetWork {
	private NetWork network;

	public ProxyServer(NetWork network) {
		super();
		this.network = network;
	}

	public void check() {
		System.out.println("联网前检查核对!");
	}

	@Override
	public void browse() {
		check();
		network.browse();
	}

}