package com.sunft.base.sync008;

import java.util.ArrayList;
import java.util.List;

public class ListAdd1 {
	
	/**
	 * volatileʹlist�ڶ���߳�֮��ɼ�
	 */
	private volatile static List<String> list = new ArrayList<String>();
	
	public void add() {
		list.add("sunft");
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		final ListAdd1 list1 = new ListAdd1();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					for(int i = 0; i < 10; i ++) {
						list1.add();
						System.out.println("��ǰ�߳�:" 
								+ Thread.currentThread().getName() 
								+ "�����һ��Ԫ��...");
						Thread.sleep(500);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}, "t1");
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				while(true) {
					if(list1.size() == 5) {
						System.out.println("��ǰ�߳��յ�֪ͨ:" 
								+ Thread.currentThread() 
								+ " list size = 5 �߳�ֹͣ...");
						throw new RuntimeException();
					}
				}
			}
			
		}, "t2");
		
		t1.start();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}

}



