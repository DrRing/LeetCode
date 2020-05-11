package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class MyThreadone implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());

	}
}

class MyThreadtwo implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return 0;
	}

}

public class Demo4 {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 2; i++) {
			executorService.execute(new MyThreadone());
			FutureTask<Integer> ft = new FutureTask<Integer>(new MyThreadtwo());
			// 输出
//			pool-1-thread-1
//			pool-1-thread-2
//			pool-1-thread-3
//			pool-1-thread-4
			executorService.submit(ft);
		}
		executorService.shutdown();
	}
}