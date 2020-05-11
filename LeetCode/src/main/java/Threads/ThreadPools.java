package Threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class ThreadPools {
	public static void main(String[] args) {

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);
//表示延迟3秒执行:, 3, TimeUnit.SECONDS
//延迟1秒后每3秒执行一次, 1, 3, TimeUnit.SECONDS
	}
}