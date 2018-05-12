package com.sunft.base.sync006;

/**
 * ��������
 * @author sunft
 *
 */
public class DeadLock implements Runnable {
	
	private String tag;
	//ע���Ǿ�̬��
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public void run() {
		if("a".equals(tag)) {
			synchronized(lock1) {
				System.out.println("��ǰ�߳�:" + Thread.currentThread().getName() + "����lock1ִ��");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				synchronized(lock2) {
					System.out.println("��ǰ�߳�:" + Thread.currentThread().getName() + "����lock2ִ��");
				}
			}
		}
		
		if("b".equals(tag)) {
			synchronized(lock2) {
				System.out.println("��ǰ�߳�:" + Thread.currentThread().getName() + "����lock2ִ��");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				synchronized(lock1) {
					System.out.println("��ǰ�߳�:" + Thread.currentThread().getName() + "����lock1ִ��");
				}
			}
		}
	}
	
	/**
	 * ��������
	 * @param args
	 */
	public static void main(String[] args) {
		DeadLock d1 = new DeadLock();
		d1.setTag("a");
		DeadLock d2 = new DeadLock();
		d2.setTag("b");
		
		Thread t1 = new Thread(d1, "t1");
		Thread t2 = new Thread(d2, "t2");
		
		t1.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
	}

}
