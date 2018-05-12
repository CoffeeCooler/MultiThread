package com.sunft.base.sync005;

/**
 * ���������쳣,���ͷŵ�ռ�е���
 * @author sunft
 *
 */
public class SyncException {
	
	private int i = 0;
	
	/**
	 * һ���׳��쳣,�����߳̾Ϳ��Խ���÷���,
	 * �����catch����Ҫ�����쳣�Ĵ���,
	 * ����ҵ���߼�ʱһ��Ҫ�����
	 */
	public synchronized void operation() {
		while(true) {
			try {
				i ++;
				Thread.sleep(200);
				System.out.println(
						Thread.currentThread().getName() 
						+ " , i = " + i);
				if(i == 10) {
					//�����������ʱ�쳣
					Integer.parseInt("a");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(" log info i = " + i);
				continue;
			} 
		}
	}

	public static void main(String[] args) {
		final SyncException se = new SyncException();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				se.operation();
			}
			
		}, "t1");
		
		t1.start();
	}

}


