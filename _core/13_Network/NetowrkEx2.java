import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class NetowrkEx2 {

	public static void main(String[] args) throws IOException, URISyntaxException {
		URL url = new URL("https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=105");
		// URL - Uniformed Resource Location(정형화된 자원 위치)
		System.out.println("1 : " + url.getAuthority()); // 1 : news.naver.com
		System.out.println("2 : " + url.getContent()); // 2 : sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@5aaa6d82
		System.out.println("3 : " + url.getPort()); // 3 : -1
		System.out.println("4 : " + url.getProtocol()); // 4 : https
		System.out.println("===========================================");
		System.out.println("5 : " + url.getHost()); // 5 : news.naver.com
		System.out.println("6 : " + url.getPath()); // 6 : /main/main.naver
		System.out.println("7 : " + url.getQuery()); // 7 : mode=LSD&mid=shm&sid1=105
		System.out.println("===========================================");
		System.out.println("8 : " + url.getRef()); // 8 : null
		System.out.println("9 : " + url.getUserInfo()); // 9 : null
		System.out.println("10 : " + url.toURI()); // 10 : https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=105
	}

}