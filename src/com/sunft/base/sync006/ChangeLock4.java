package com.sunft.base.sync006;

/**
 * 锁对象的改变问题
 * @author sunft
 *
 */
public class ChangeLock4 {
	
	private String lock = "lock";
	
	/**
	 * 测试改变锁对象
	 */
	private void method() {
		synchronized(lock) {
			try {
				System.out.println("当前线程:" 
						+ Thread.currentThread().getName() 
						+ "开始...");
				lock = new String("lock");
				Thread.sleep(2000);
				System.out.println("当前线程:" 
						+ Thread.currentThread().getName() 
						+ "结束...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 锁对象被改变,加不加锁没啥区别
	 * @param args
	 */
	public static void main(String[] args) {
		final ChangeLock4 changeLock = new ChangeLock4();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				changeLock.method();
			}
			
		}, "t1");
		
		t1.start();
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				changeLock.method();
			}
			
		}, "t2");
		
		t2.start();
	}

}
