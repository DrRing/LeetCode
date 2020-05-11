package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo3 {
	public static void main(String[] args) {

		for (int i = 0; i < 2; i++) {
			// 创建MyThread实例
			Callable<Integer> c = new MyThread3();
			// 获取FutureTask
			FutureTask<Integer> ft = new FutureTask<Integer>(c);
			// 使用FutureTask初始化Thread
			Thread t = new Thread(ft);
			// 输出：
			// Thread-0 Thread-1
			t.start();
		}
	}
}
