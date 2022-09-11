import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkEx1 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		ip = InetAddress.getByName("www.naver.com");
		
		System.out.println("getHostAddress : " + ip.getHostAddress());
		System.out.println("getHostName : " + ip.getHostName());
		System.out.println("toString : " + ip.toString());
		
		byte[] ipAddr = ip.getAddress();
		System.out.println("getAddress : " + Arrays.toString(ipAddr));

		System.out.println("------------------------------------");
		String result = "";
		for (int i = 0; i < ipAddr.length; i++) {
			result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
			result += ".";
			
		}
		System.out.println("getAddress + 256 = " + result);
		System.out.println("------------------------------------");
		
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("localHost Address : " + localIp.getHostAddress());
		System.out.println("localHost Name : " + localIp.getHostName());
		System.out.println("localHost toString : " + localIp.toString());
	}

}
