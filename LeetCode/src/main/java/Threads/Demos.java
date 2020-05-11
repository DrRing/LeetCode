package Threads;

public class Demos {
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			Thread thread = new MyThread1();
			thread.start();
		}
	}
}
