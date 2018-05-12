package com.sunft.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


/**
 * ���߳�ʹ��Vector����HashTable��ʾ��(���߳�ͬ������)
 * ʵ���߳�ͬ����ʹ��Vector���ArrayList, HashTable���HashMap
 * @author sunft
 *
 */
public class Tickets {

	public static void main(String[] args) {
		
		final Vector<String> tickets = new Vector<String>();
		//��װ���̰߳�ȫ����
		Map<String, String> map 
			= Collections.synchronizedMap(
					new HashMap<String, String>());
		
		for(int i = 1; i <= 1000; i ++) {
			tickets.add("��Ʊ" + i);
		}
		
		//�ڵ�����ʱ�������remove���±���,ע�͵�����
		//�̲߳��ֿ�������ִ��
		for(Iterator iterator = tickets.iterator(); 
				iterator.hasNext();) {
			String string = (String) iterator.next();
			tickets.remove(20);
		}
		
		//ʹ��10���߳��Ƴ�Ʊ
		for(int i = 0; i <= 10; i ++) {
			new Thread("�߳�" + i){

				@Override
				public void run() {
					while(true) {
						if(tickets.isEmpty()) break;
						System.out.println(
								Thread.currentThread().getName() 
								+ "---" + tickets.remove(0));
					}
				}
				
			}.start();
		}
	}

}
