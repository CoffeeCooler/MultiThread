package com.sunft.base.sync006;

/**
 * ������ĸı�����
 * @author sunft
 *
 */
public class ChangeLock2 {
	
	//���������ַ�ʽ�Ƿ���ʵ��ͬ��δ�����
	//private String lock = new String("lock");
	private String lock = "lock";
	
	/**
	 * ���Ըı�������
	 */
	private void method() {
		synchronized(lock) {
			try {
				System.out.println("��ǰ�߳�:" 
						+ Thread.currentThread().getName() 
						+ "��ʼ...");
				lock.replace('c', 'o');
				Thread.sleep(2000);
				System.out.println("��ǰ�߳�:" 
						+ Thread.currentThread().getName() 
						+ "����...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �����󱻸ı�,�Ӳ�����ûɶ����
	 * @param args
	 */
	public static void main(String[] args) {
		final ChangeLock2 changeLock = new ChangeLock2();
		
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


