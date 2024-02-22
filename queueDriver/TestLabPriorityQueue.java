package queueDriver;

import queue.*;

public class TestLabPriorityQueue {

	public static void main(String[] args) {
		//lab13no1();
		lab13no2();
	}

	private static void lab13no1() {
		// Lab 13 #1
		QueueADT<Integer> queue = new PriorityQueue<Integer>();
		queue.add(2);
		queue.add(5);
		queue.add(7);
		queue.add(3);
		queue.add(5);

		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
	}
	
	private static void lab13no2() {
		QueueADT<Airplane> arrivals = new PriorityQueue<Airplane>();
		Airplane a1 = new Airplane(0, 9, 500);	// should land last
		Airplane a2 = new Airplane(0, 3, 501);	// should land first
		Airplane a3 = new Airplane(0, 5, 502);
		
		arrivals.add(a1);
		arrivals.add(a2);
		arrivals.add(a3);
		
		for(int i = 0; i < arrivals.size(); i++) {
			System.out.println(arrivals.remove() + " has landed");
		}
	}
}
