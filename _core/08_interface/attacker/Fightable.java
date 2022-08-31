package attacker;

interface Attackable {
	void attack(Unit unit); // public abstract 가 생략되어 있음
}

interface Movable {
	public abstract void move(int x, int y);
}

// interface들 간의 상속 extends
public interface Fightable extends Movable, Attackable{
	
}
