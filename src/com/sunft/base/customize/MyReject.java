package com.sunft.base.customize;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * �Զ���ܾ�������,��Ҫʵ��RejectedExecutionHandler�ӿ�
 * @author sunft
 *
 */
public class MyReject implements RejectedExecutionHandler {
	
	public MyReject(){}

	/**
	 * ��������
	 * ��toString()����д��,Runnable�ӿ���û��ʲô����,
	 * ����toString()���������Ա�ʾ����
	 */
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("�Զ��崦��...��ǰ���ܾ�����Ϊ��" + r.toString());
	}

}


