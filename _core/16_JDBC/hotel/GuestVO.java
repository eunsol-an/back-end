package hotel;

public class GuestVO {
	private String name;
	private String tel;
	private int age;
	private int gen;
	
	public GuestVO() {}
	
	public GuestVO(String name, String tel, int age, int gen) {
		super();
		this.name = name;
		this.tel = tel;
		this.age = age;
		this.gen = gen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGen() {
		return gen;
	}

	public void setGen(int gen) {
		this.gen = gen;
	}

	@Override
	public String toString() {
		return "GuestVO [name=" + name + ", tel=" + tel + ", age=" + age + ", gen=" + (gen == 1 ? "여" : gen == 2 ? "남" : "") + "]";
	}
	
}
