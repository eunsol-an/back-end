package built_in.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		String[] strArr = {"bat", "baby", "bounus", "cA", "ca", "co", "c", "c0", "car", "combat", "count", "date", "disc"};
		
		// 소문자c로 시작하고 모두 소문자인 패턴
		Pattern pattern = Pattern.compile("c[a-z]*");
		for (String str : strArr) {
			Matcher matcher = pattern.matcher(str);
			if (matcher.matches()) {
				System.out.print(str + ", "); // ca, co, c, car, combat, count, 
			}
		}
	}

}
