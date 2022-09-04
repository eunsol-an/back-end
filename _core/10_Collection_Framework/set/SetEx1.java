package set;

import java.util.HashSet;
import java.util.Set;

public class SetEx1 {

	public static void main(String[] args) {
		Set set = new HashSet();
		// 1 ~ 10까지의 숫자 10개를 Set에 담는데 몇번이 실행되는지 출력
		int cnt = 0;
		
		for (int i = 0; set.size() < 10; i++) {
			set.add((int)(Math.floor(Math.random()*10))+1);
			cnt++;
		}
		System.out.println(set);
		System.out.println(cnt);
		
		Set set2 = new HashSet();
		set2.add(4);
		set2.add(5);
		set2.add(6);
		set2.add(2);
		set2.add(1);
		set2.add(17);
		System.out.println(set2);

	}

}
