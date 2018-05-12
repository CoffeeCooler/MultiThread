package com.sunft.base.sync006;

/**
 * ʹ��synchronized������С��������,�������
 * @author sunft
 *
 */
public class Optimize {
	
	public void doLongTimeTask() {
		try {
			
			//��鲻��Ҫͬ��,��synchronized���г�����ﵽ�Ż���Ŀ��
			System.out.println("��ǰ�߳̿�ʼ:" 
					+ Thread.currentThread().getName()
					+ ",����ִ��һ���ϳ�ʱ���ҵ�����,�����ݲ���Ҫͬ��");
			Thread.sleep(2000);
			//########################################
			
			synchronized(this) {
				System.out.println("��ǰ�߳�:" 
						+ Thread.currentThread().getName() +
						",ִ��ͬ�������,����ͬ���������в���");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final Optimize otz = new Optimize();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				otz.doLongTimeTask();
			}
			
		}, "t1");
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				otz.doLongTimeTask();
			}
			
		}, "t2");
		
		t1.start();
		t2.start();
	}

}
