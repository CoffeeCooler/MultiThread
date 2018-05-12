package com.sunft.base.design.master;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		//����20���߳�
		Master master = new Master(new Worker(), 20);
		
		Random r = new Random();
		
		//�ύ100�������Master
		for(int i = 1; i <= 100; i ++) {
			Task t = new Task();
			t.setId(i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);
		}
		//��������
		master.execute();
		long start = System.currentTimeMillis();
		
		while(true) {
			if(master.isComplete()) {
				long end = System.currentTimeMillis() - start;
				int priceResult = master.getResult();
				System.out.println("���ս��:" 
						+ priceResult + ",ִ��ʱ��:" + end);
				break;
			}
		}
	}

}


