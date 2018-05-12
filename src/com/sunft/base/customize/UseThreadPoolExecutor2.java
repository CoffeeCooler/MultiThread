package com.sunft.base.customize;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * �Զ����̳߳�
 * @author sunft
 *
 */
public class UseThreadPoolExecutor2 implements Runnable {
	
	private static AtomicInteger count 
		= new AtomicInteger();
	
	@Override
	public void run() {
		try {
			int temp = count.incrementAndGet();
			System.out.println("����" + temp);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		/**
		 * ���н������ȣ�����ϵͳ��Դ�ľ��������޽��������в��������ʧ�ܵ������
		 * ��������������ϵͳ���߳���С��corePoolSizeʱ�����½��߳�ִ������
		 * ���ﵽcorePoolSize�󣬾Ͳ���������ӡ�
		 * �����������µ�������룬����û�п��е��߳���Դ��������ֱ�ӽ�����еȴ���
		 * �����񴴽��ʹ�����ٶȲ���ܴ��޽���лᱣ�ֿ���������ֱ���ľ�ϵͳ�ڴ档
		 */
		BlockingQueue<Runnable> queue = 
				new LinkedBlockingQueue<Runnable>();
		
		ExecutorService executor = new ThreadPoolExecutor(
				5,              //core
				10,             //max,�����10û������
				120L,           //2����
				TimeUnit.SECONDS,
				queue);
		
		for(int i = 0; i < 20; i ++) {
			executor.execute(new UseThreadPoolExecutor2());
		}
		
		Thread.sleep(1000);
		System.out.println("queue size:" + queue.size());   //10
		Thread.sleep(2000);
		
	}

}






