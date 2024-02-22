package queueDriver;

import queue.*;

public class Quiz7PQ {

	public static void main(String[] args) {
		QueueADT<Integer> queue = new PriorityQueue<Integer>();
		queue.add(8);
		queue.add(6);
		queue.add(10);
		queue.add(4);
		queue.add(12);
		System.out.println(queue);
	}
	
}
