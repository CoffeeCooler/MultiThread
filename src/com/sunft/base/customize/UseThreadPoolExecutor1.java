package com.sunft.base.customize;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �Զ����̳߳�
 * @author sunft
 *
 */
public class UseThreadPoolExecutor1 {
	
	public static void main(String[] args) {
		
		/**
		 * ��ʹ���н����ʱ,�����µ�������Ҫִ��,����̳߳�ʵ���߳���С��corePoolSize,�����ȴ����߳�
		 * ������corePoolSize,��Ὣ����������,
		 * ����������,�������߳���������maximumPoolSize��ǰ����,�����µ��߳�,
		 * ���߳�������maximumPoolSize,��ִ�оܾ�����,�������Զ��巽ʽ��
		 * Ĭ��ʹ��AbortPolicy
		 */
		ThreadPoolExecutor pool = new ThreadPoolExecutor(
				1,       //coreSize
				2,       //MaxSize
				60,      //60
				TimeUnit.SECONDS,   
				new ArrayBlockingQueue<Runnable>(3),  //ָ��һ�ֶ���
				new MyReject()		
		);
		
		//�첽ִ��
		MyTask mt1 = new MyTask(1, "����1");//ֱ�ӱ�ִ��
		MyTask mt2 = new MyTask(2, "����2");//�������
		MyTask mt3 = new MyTask(3, "����3");//�������
		MyTask mt4 = new MyTask(4, "����4");//�������
		MyTask mt5 = new MyTask(5, "����5");//�����߳�
		MyTask mt6 = new MyTask(6, "����6");
		
		pool.execute(mt1);
		pool.execute(mt2);
		pool.execute(mt3);
		pool.execute(mt4);
		pool.execute(mt5);
		pool.execute(mt6);
		
		//�����ر�
		pool.shutdown();
		//ǿ�ƹر�
		//pool.shutdownNow();
	}
	
}






