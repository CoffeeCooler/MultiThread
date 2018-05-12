package com.sunft.base.sync012;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * ʹ�����ȶ���
 * @author sunft
 *
 */
public class UsePriorityBlockingQueue {

	public static void main(String[] args) throws Exception {
		PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<Task>();
		Task t1 = new Task();
		t1.setId(3);
		t1.setName("idΪ3");
		Task t2 = new Task();
		t2.setId(4);
		t2.setName("idΪ4");
		Task t3 = new Task();
		t3.setId(1);
		t3.setName("idΪ1");
		
		q.add(t1); //3
		q.add(t2); //4
		q.add(t3); //1
		
		//1 3 4
		System.out.println("����:" + q);
		//�������Ϊ����ÿ��ִ��take������ʱ��ִ�е�
		System.out.println(q.take().getId());
		System.out.println("������" + q);
		System.out.println(q.take().getId());
		System.out.println(q.take().getId());
	}

}


