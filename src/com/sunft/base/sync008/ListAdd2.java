package com.sunft.base.sync008;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * wait notify����,wait�ͷ���,notify���ͷ���
 * @author sunft
 *
 */
public class ListAdd2 {

	private volatile static List<String> list = new ArrayList<String>();
	
	public void add() {
		list.add("sunft");
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		final ListAdd2 list = new ListAdd2();
		
		//1��ʵ��������һ��lock
		//��ʹ��wait��notify��ʱ��,һ��Ҫ�����synchronized�ؼ���ȥʹ��
//		final Object lock = new Object();
		
		//���ڼ�ʱ����
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					//synchronized(lock) {
						for(int i = 0; i < 10; i ++) {
							list.add();
							System.out.println("��ǰ�߳�:" 
							+ Thread.currentThread().getName() 
							+ "�����һ��Ԫ��...");
							Thread.sleep(500);
							if(list.size() == 5) {
								System.out.println("�Ѿ�����֪ͨ...");
								//����֪ͨ
								countDownLatch.countDown();
								//����֪ͨ,���ǲ�δ�ͷ���,�ȵ���ǰ�߳�ִ�����,
								//t2����ִ��
								//lock.notify();
							}
						}
					//}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}, "t1");
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				//synchronized(lock) {
					if(list.size() != 5) {
						try {
							//�ͷ���
							//lock.wait();
							//����������
							countDownLatch.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("��ǰ�߳�:" 
					+ Thread.currentThread().getName() 
					+ "�յ�֪ͨ�߳�ֹͣ...");
					throw new RuntimeException();
				}
			//}
			
		}, "t2");
		
		t2.start();
		//��֤t2�߳���������
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		
	}

}
