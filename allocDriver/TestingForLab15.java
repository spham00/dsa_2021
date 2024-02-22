package allocDriver;

import alloc.*;

public class TestingForLab15 {
	
	public static void main(String[] args) {
		Memory mem = new Memory();
		int v1 = mem.allocate(200);
		int v2 = mem.allocate(250);
		int v3 = mem.allocate(50);
	}

}
