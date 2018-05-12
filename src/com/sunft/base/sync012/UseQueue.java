package com.sunft.base.sync012;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * ����ʹ�ö���
 * @author sunft
 *
 */
public class UseQueue {

	public static void main(String[] args) throws Exception {
		ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<>();
		q.offer("a");
		q.offer("b");
		q.offer("c");
		q.offer("d");
		q.add("e");
		
		System.out.println(q.poll()); //a�Ӷ�����ȡ��Ԫ��,���Ӷ�����ɾ��
		System.out.println(q.size()); //4
		System.out.println(q.peek()); //b
		System.out.println(q.size()); //4
		
		ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);
		array.put("a");
		array.put("b");
		array.add("c");
		array.add("d");
		array.add("e");
		array.add("f");
		//3���ӷŲ���ȥ�ͷ���false
		System.out.println(array.offer("a", 3, TimeUnit.SECONDS));
		
		//��������
		LinkedBlockingQueue<String> linkedQueue = new LinkedBlockingQueue<>();
		linkedQueue.offer("a");
		linkedQueue.offer("b");
		linkedQueue.offer("c");
		linkedQueue.offer("d");
		linkedQueue.offer("e");
		System.out.println(linkedQueue.size());
		
		for(Iterator<String> iterator = linkedQueue.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}
		
		List<String> list = new ArrayList<String>();
		System.out.println(linkedQueue.drainTo(list, 3));
		System.out.println(list.size());
		for(String string : list) {
			System.out.println(string);
		}
		
		final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println(synchronousQueue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		t1.start();
		
		TimeUnit.SECONDS.sleep(2);
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				synchronousQueue.add("asdasd");
			}
			
		});
		
		t2.start();
	}

}
