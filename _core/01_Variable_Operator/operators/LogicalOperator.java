package operators;

public class LogicalOperator {

	public static void main(String[] args) {
		System.out.println("논리연산자 => 리턴타입? boolean");
		System.out.println("&&, ||, !");
		
		// &&, || 연산의 방식을 고려하기
		System.out.println(false && true); // false
		System.out.println(true || false); // true
		System.out.println(!false); // true
	}

}
