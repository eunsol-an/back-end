package generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Product {
	private String pno;
	private int price;
	
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

class User {
	private String name;
	private List<Product> pList; // 구매상품목록

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getpList() {
		return pList;
	}
	public void setpList(List<Product> pList) {
		this.pList = pList;
	}
}

public class MultiGeneric {

	public static void main(String[] args) {
		// 쇼핑몰의 유저리스트
		List<User> userList = new ArrayList<>();
		// 0번 유저의 상품 구매 목록은?
		List<Product> prodListOfZero = userList.get(0).getpList();
		// 오늘 상품 구매한 유저들의 구매상품 리스트
		List<List<Product>> todayList = new ArrayList<List<Product>>();
		// 권장하지는 않지만 임의로 만들어보는 3중 제네릭
		List<Map<String, List<Product>>> whatList = new ArrayList<>();
	}

}
