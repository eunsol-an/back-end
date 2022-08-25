package built_in.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeEx {

	public static void main(String[] args) {
		LocalDateTime todayNow = LocalDateTime.now();
		System.out.println(todayNow); // 2022-05-19T14:43:32.750

		System.out.println(todayNow.getHour()); // 14
		System.out.println(todayNow.getMinute()); // 43
		System.out.println(todayNow.getSecond()); // 32
		System.out.println(todayNow.getNano()); // 750000000
		// LocalDateTime은 LocalDate와 LocalTime을 모두 포함하는 구조
		
		String curr = todayNow.toString();
		System.out.println(curr.split("T")[0]);
		System.out.println(curr.split("T")[1].substring(0, 8));
		
		// 다른 방법
		System.out.println(curr.substring(0, curr.indexOf("T")));
		System.out.println(curr.substring(curr.indexOf("T")+1));
		System.out.println(curr.substring(0, curr.lastIndexOf(".")));
		
		// split
		String day = curr.split("T")[0];
		String time = curr.split("T")[1].substring(0, 8);
		System.out.println(day + " " + time); // 2022-05-19 16:21:05
		
		// substring
		String day2 = curr.substring(0, curr.indexOf("T"));
		String time2 = curr.substring(curr.indexOf("T")+1, curr.lastIndexOf("."));
		System.out.println(day2 + " " + time2); // 2022-05-19 16:21:05
		
		// replace
		System.out.println(curr.substring(0, curr.lastIndexOf(".")).replace("T", " ")); // 2022-05-19 16:21:05
		
		// 자주 사용하지는 않지만 원하는 형태로 만들 수 있는 방법
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println(dtf.format(todayNow)); // 2022-05-19 16:21:05
		System.out.println(todayNow.format(dtf)); // 2022-05-19 16:21:05
		
		LocalDateTime calc = LocalDateTime.of(2022, 1, 1, 0, 0);
		System.out.println(calc);
		LocalDateTime today = LocalDateTime.of(2022, 5, 21, 0, 0);
		System.out.println(today);
		System.out.println(ChronoUnit.MONTHS.between(calc, today)); // 월 차이 계산
		System.out.println(ChronoUnit.DAYS.between(calc, today)); // 일 차이 계산
	}

}
