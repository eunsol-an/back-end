package etc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {

	public static void main(String[] args) {
		// stack 구조 : 책을 바닥부터 쌓는 모양으로 데이터가 만들어지는 형태
		// 후입선출 - Last Input First Out : 마지막에 쌓인 데이터를 가장 먼저 꺼낼 수 있다
		// queue 구조 : 양쪽이 열려있는 파이프에 한 쪽에서 데이터를 밀어 넣는 형태
		// 선입선출 - First In First Out : 처음 쌓은 데이터부터 꺼낼 수 있다
		
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		
		stack.push(123);
		stack.push(3456);
		stack.push(2456);
		stack.push(5768);
		
		System.out.println("Stack 구조");
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
		
		queue.offer(23234);
		queue.offer(21341);
		queue.offer(8823);
		
		System.out.println("Queue 구조");
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}

}
