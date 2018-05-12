package com.sunft.base.design.future;

/**
 * �൱�ڴ�����
 * @author sunft
 *
 */
public class FutureData implements Data {
	
	//��ʵ���ݶ���
	private RealData realData;
	
	private boolean isReady = false;
	
	public synchronized void setRealData(RealData realData) {
		//����Ѿ�װ�������,��ֱ�ӷ���
		if(isReady) {
			return;
		}
		
		//���ûװ��,����ת����ʵ����
		this.realData = realData;
		isReady = true;
		//֪ͨ����һ������������
		notify();
	}
	
	@Override
	public synchronized String getRequest() {
		//���û��װ�غ�,�����һֱ��������״̬
		while(!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//װ�غ�ֱ�ӻ�ȡ���ݼ���
		return this.realData.getRequest();
	}

}


