package Threads;

import java.util.concurrent.Callable;

/**
 * Java实现多线程的方式3 实现Callable接口
 * 
 * @author hongbo.zhao 2019年4月12日 上午7:12:35
 */
class MyThread3 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return null;
	}
}
