package built_in.time;

import java.time.LocalTime;

public class LocalTimeEx {

	public static void main(String[] args) {
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		System.out.println(now.toNanoOfDay());
		System.out.println(now.toSecondOfDay()); // 오늘의 시작부터 지금까지의 초
		System.out.println(now.toString());
		System.out.println(now.MAX);
		System.out.println(now.MIN);
		System.out.println(now.MIDNIGHT);
		System.out.println(now.NOON);
		System.out.println(now.plusHours(1L)); // 현재 시간에서 1시간 더하기
		System.out.println(now.plusMinutes(10L));
		System.out.println(now.plusSeconds(100L));
		System.out.println(now.plusNanos(100000L));
		System.out.println(now.minusHours(2L));
		System.out.println(now.minusMinutes(12L));
		System.out.println(now.minusSeconds(200L));
		System.out.println(now.minusNanos(300000L));

	}

}
