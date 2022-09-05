package generic;

public class FruitBox {

	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<>();
		Box<Apple> appleBox = new Box<>();
		Box<Orange> orangeBox = new Box<>();
//		Box<Toy> toy = new Box<>(); 타입제한
		
		Apple apple = new Apple();
		appleBox.add(apple);
		System.out.println(appleBox.get(0));
	}

}
