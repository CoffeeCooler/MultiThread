package com.sunft.base.sync007;

/**
 * ����volatile�ؼ��ֵ��÷�
 * @author sunft
 *
 */
public class RunThread extends Thread {
	
	//��volatile�ؼ���
	private volatile boolean isRunning = true;
	
	private void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("����run����...");
		//��volatile,ÿ�γ���ʹ��isRunning��ֵ
		//��ǿ���̵߳������ڴ������Ҹ�ֵ
		while(isRunning == true) {
			boolean a = isRunning;
		}
		
		System.out.println("�߳�ֹͣ");
	}

	public static void main(String[] args) 
			throws InterruptedException {
		RunThread rt = new RunThread();
		rt.start();
		Thread.sleep(3000);
		rt.setRunning(false);
		System.out.println("isRunning��ֵ�Ѿ���������false");
		Thread.sleep(1000);
		System.out.println(rt.isRunning);
	}
	
}

