package Threads;

public class MyThread1 extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
