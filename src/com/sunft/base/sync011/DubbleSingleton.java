package com.sunft.base.sync011;

/**
 * ˫�ؼ��������,���������,
 * ������������ܱ�֤�̰߳�ȫ,���Բ�����ʹ��
 * @author sunft
 *
 */
public class DubbleSingleton {
	
	private static DubbleSingleton ds;
	
	/**
	 * ˽�еĹ������Ǳ����,����ֱ�ӿ������ⲿnew,
	 * �׺�����ʦ�����ʱ�����˼�˽�й�����
	 */
	private DubbleSingleton() {
		
	}
	
	public static DubbleSingleton getDs() {
		if(ds == null) {
			try {
				//ģ���ʼ�������׼��ʱ��...
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(DubbleSingleton.class) {
				if(ds == null) {
					ds = new DubbleSingleton();
				}
			}
		}
		
		return ds;
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
			
		}, "t1");
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
			
		}, "t2");
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
			
		}, "t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}