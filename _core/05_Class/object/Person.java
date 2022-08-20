package object;

class Pet {
	String nick; // class의 정적인 정보 (상태값 : 변수에 저장)
	int age;
	
	// 상태값을 변경시킬 수 있는 동적 존재 : 메서드를 활용
	void sound(String nick) {
		System.out.println(nick + "은(는) 소리를 낸다");
	}
	void initialize(String nickName, int petAge) {
		nick = nickName;
		age = petAge;
	}
	void getInfo() {
		System.out.println(nick);
		System.out.println(age);
	}
	int getOld() {
		age++;
		return age;
		
	}
	boolean die() {
		nick = "";
		age = 0;
		return false;
	}
}

public class Person { // Person 이라는 개념을 만들기 위한 분류
	String name;
	int age;
	
	void speak() {
		System.out.println("사람은 말을 한다");
	}
	
	public static void main(String[] args) {
		// 인스턴스 만들기
		Pet myPet = new Pet(); // 메모리의 heap영역에 주소값을 생성하여 접근(이용) 가능하게 함
		myPet.sound("냐옹이"); // Pet이라는 객체에 냐용이를 설정하여 동작하게 함
		myPet.nick = "댕댕이"; // Pet이라는 객체에 댕댕이를 초기화
		myPet.age = 3;
		
		Pet yourPet = new Pet();
//		yourPet.nick = "냥";
//		yourPet.age = 1;
		yourPet.initialize("냥", 1);
//		System.out.println(yourPet.nick);
//		System.out.println(yourPet.age);
		yourPet.getInfo(); // 냥이는 한 살임
		int age = yourPet.getOld(); // 냥이 한 살 늙음
		System.out.println("현재 냥이는" + age + "짤");
		yourPet.die();
		yourPet.getInfo();
		
	}
}
