package com.sunft.base.sync009;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ģ����������
 * @author sunft
 *
 */
public class MyQueue {

	//1����Ҫһ������Ԫ�صļ���
	private LinkedList<Object> list = new LinkedList<Object>();
	
	//2����Ҫһ��������
	private AtomicInteger count = new AtomicInteger(0);
	
	//3����Ҫ�ƶ����޺�����
	private final int minSize = 0;
	
	//�ñ����ڹ������г�ʼ��
	private final int maxSize;
	
	//4�����췽��
	public MyQueue(int size) {
		this.maxSize = size;
	}
	
	//5����ʼ��һ���������ڼ���
	private final Object lock = new Object();
	
	//put(anObject):��anObject�ӵ�BlockingQueue����,
	//���BlockingQueueû�пռ�,����ô˷������̱߳����,
	//ֱ��BlockingQueue�����пռ�Ϊֹ
	public void put(Object obj) {
		synchronized(lock){
			while(count.get() == this.maxSize) {
				try {
					//����
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//1������Ԫ��
			list.add(obj);
			//2���������ۼ�
			count.incrementAndGet();
			//3��֪ͨ����һ���߳�(����)
			lock.notify();
			System.out.println("�¼����Ԫ��Ϊ:" + obj);
		}
	}
	
	//take:ȡ��BlockingQueue��������λ�Ķ���,��BlockingQueueΪ��,
	//��Ͻ���ȴ�״ֱ̬��BlockingQueue���µ����ݱ�����
	public Object take() {
		Object ret = null;
		synchronized(lock) {
			while(count.get() == this.minSize) {
				try {
					//����
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//1�����Ƴ�Ԫ�ز���
			ret = list.removeFirst();
			//2���������ݼ�
			count.decrementAndGet();
			//3����������һ���߳�
			lock.notify();
		}
		return ret;
	}
	
	public int getSize() {
		return this.count.get();
	}
	
	public static void main(String[] args) {
		final MyQueue mq = new MyQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");
		
		System.out.println("��ǰ�����ĳ���:" + mq.getSize());
		
		//������д������
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				mq.put("f");
				mq.put("g");
			}
			
		}, "t1");
		
		t1.start();
		
		//�Ӷ������ó�����
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				Object o1 = mq.take();
				System.out.println("�Ƴ���Ԫ��Ϊ:" + o1);
				Object o2 = mq.take();
				System.out.println("�Ƴ���Ԫ��Ϊ:" + o2);
			}
			
		}, "t2");
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
	}
}


