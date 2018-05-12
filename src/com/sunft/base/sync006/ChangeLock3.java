package com.sunft.base.sync006;

/**
 * ʹ�ö�����Ϊ��,���Ҹı���������
 * @author sunft
 *
 */
public class ChangeLock3 {
	
	//ʹ�ö�����Ϊ��
	private Student lock = new Student("sunft", 18);
	
	/**
	 * ���Ըı�������
	 */
	private void method() {
		synchronized(lock) {
			try {
				System.out.println("��ǰ�߳�:" 
						+ Thread.currentThread().getName() 
						+ "��ʼ...");
				//�ı��������,����ʵ��ͬ��
				lock.setName("Bruce Lee");
				lock.setAge(20);
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
		final ChangeLock3 changeLock = new ChangeLock3();
		
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


