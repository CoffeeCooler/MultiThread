package com.sunft.base.sync007;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ����AtomicIntegerԭ����
 * @author sunft
 *
 */
public class AtomicUse {

	private static AtomicInteger 
		count = new AtomicInteger(0);
	
	/**
	 * ���addAndGet��һ���������Ƿ�ԭ���Ե�,
	 * ��Ҫ��synchronized�������ε�,
	 * ��֤4��addAndGet����ԭ����
	 * @return
	 */
	public synchronized int multiAdd() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//ֻ��֤���д����ԭ����,������֤�������е�ԭ����
		count.addAndGet(1);
		count.addAndGet(2);
		count.addAndGet(3);
		count.addAndGet(4);//+10
		
		return count.get();
	}
	
	public static void main(String[] args) {
		final AtomicUse au = new AtomicUse();
		
		List<Thread> ts = new ArrayList<Thread>();
		for(int i = 0; i < 100; i ++) {
			ts.add(new Thread(new Runnable(){

				@Override
				public void run() {
					System.out.println(au.multiAdd());
				}
				
			}));
		}
		
		for(Thread t : ts) {
			t.start();
		}
	}

}



