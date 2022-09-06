package etc.enums;

public enum Direction {
	EAST(1, ">"),
	SOUTH(2, "V"),
	WEST(3, "<"),
	NOTHE(4, "^");
	
	private static final Directions[] DR_ARR = Directions.values();
	private final int value;
	private final String sign;

	Direction(int value, String sign) {
		this.value = value;
		this.sign = sign;
	}
	
	public int getValue() {
		return this.value;
	}
	public String getSign() {
		return this.sign;
	}
}
