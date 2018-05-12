package com.sunft.base.sync006;

/**
 * Java�д����������ķ�ʽ
 * @author sunft
 *
 */
public class ObjectLock {
	
	/**
	 * ������,��ͬһ����������
	 */
	public void method1() {
		synchronized(this) {
			try {
				System.out.println("do method1..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ����,�Ը�������ж��󶼻�������
	 */
	public void method2() {
		synchronized(ObjectLock.class) {
			try {
				System.out.println("do method2..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//���������,�Գ��и�������������
	private Object lock = new Object();
	public void method3() {
		synchronized(lock) {
			try {
				System.out.println("do method3..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final ObjectLock objLock = new ObjectLock();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				objLock.method1();
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				objLock.method2();
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				objLock.method3();
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
