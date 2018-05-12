package com.sunft.base.sync007;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ��֤Volatile�ķ�ԭ����
 * @author sunft
 *
 */
public class VolatileNoAtomic extends Thread {
	
//	private static volatile int count = 0;
	//����JVM�Ļ�����,����ʹ��ԭ���ౣ֤ͬ��
	private static AtomicInteger count = new AtomicInteger(0);
	
	private static void addCount() {
		for(int i = 0; i < 1000; i ++) {
//			count ++;
			count.incrementAndGet(); //++
		}
		//System.out���˷�����,��������ʹ��
		System.out.println(count);
	}

	@Override
	public void run() {
		addCount();
	}

	public static void main(String[] args) {
		
		VolatileNoAtomic[] arr = new VolatileNoAtomic[10];
		for(int i = 0; i < 10; i ++) {
			arr[i] = new VolatileNoAtomic();
		}
		
		for(int i = 0; i < 10; i ++) {
			arr[i].start();
		}
	}

}


