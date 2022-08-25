package built_in.time;

import java.time.LocalDate;

public class LocalDateEx {

	public static void main(String[] args) {
		// 1.8 이전에서는 new Date()를 통해 구현했던 것을
		// 1.8 이후에서는 calendar 혹은 LocalDate, LocalDateTime을 사용을 권장한다

		LocalDate today = LocalDate.now();
		System.out.println(today); // 2022-05-19
		
		System.out.println(today.getDayOfMonth()); // 19
		System.out.println(today.getDayOfWeek()); // THURSDAY
		System.out.println(today.getDayOfYear()); // 139
		System.out.println(today.getMonthValue()); // 5
		System.out.println(today.getYear()); // 2022
		System.out.println(today.getMonth()); // MAY
		System.out.println(today.plusYears(1L)); // 2023-05-19
		LocalDate ago100 = today.minusYears(100L);
		System.out.println(ago100); // 1922-05-19
		// months, days, weeks 도 있으니 추가로 확인해 볼 것
	}

}
