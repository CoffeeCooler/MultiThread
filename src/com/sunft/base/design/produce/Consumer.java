package com.sunft.base.design.produce;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * ������
 * @author sunft
 *
 */
public class Consumer implements Runnable {
	
	private BlockingQueue<Data> queue;

	public Consumer(BlockingQueue<Data> queue) {
		this.queue = queue;
	}
	
	//�������
	private static Random r = new Random();

	@Override
	public void run() {
		while(true) {
			try {
				//��ȡ����,�ô�������
				Data data = this.queue.take();
				//�������ݴ���
				Thread.sleep(r.nextInt(1000));
				System.out.println("��ǰ�����߳�:" 
						+ Thread.currentThread().getName() 
						+ ",���ѳɹ�,��������id:" + data.getId());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
