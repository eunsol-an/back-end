package classes;
class Pet {
	String name = "댕댕쓰";
	String breeds = "골든 리트리버";
	int age = 2;
	
	void sound() {
		System.out.println(name + "는 멍멍 짖어요");
	}
	
	int getOlder() {
		age++;
		return age;
	}
}

public class Quiz_01 {

	public static void main(String[] args) {
		Pet myPet = new Pet();
		System.out.println(myPet.name);
		System.out.println(myPet.breeds);
		System.out.println(myPet.age);
		myPet.sound();
		myPet.getOlder();
		System.out.println("현재 " + myPet.name + "의 나이는 " + myPet.age + "살 입니다.");
		
	}

}
