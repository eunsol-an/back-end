package baseball;

public class User {
	private String nickname = "";
	private int tryCnt = 0;
	private int time = 0;
	
	public User() {}
	
	public User(String nickname, int tryCnt) {
		this.nickname = nickname;
		this.tryCnt = tryCnt;
	}
	
	public User(String nickname, int tryCnt, int time) {
		this.nickname = nickname;
		this.tryCnt = tryCnt;
		this.time = time;
	}
	
	public void printUser() {
		System.out.print("닉네임:" + nickname);
		System.out.println("\t시도횟수:" + tryCnt);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getTryCnt() {
		return tryCnt;
	}

	public void setTryCnt(int tryCnt) {
		this.tryCnt = tryCnt;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
