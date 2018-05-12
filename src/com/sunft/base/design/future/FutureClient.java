package com.sunft.base.design.future;

public class FutureClient {

	/**
	 * ����
	 * @param queryStr
	 * @return
	 */
	public Data request(final String queryStr) {
		//1������Ҫһ���������(Data�ӿڵ�ʵ����)�ȷ��ظ���������Ŀͻ���,�����������Ѿ��յ�
		//����������������
		final FutureData futureData = new FutureData();
		//2������һ���µ��߳�,ȥ������ʵ������,���ݸ�����������
		new Thread(new Runnable(){

			@Override
			public void run() {
				//3������µ��߳̿���ȥ�����ļ�����ʵ����,Ȼ�󴫵ݸ��������
				RealData realData = new RealData(queryStr);
				futureData.setRealData(realData);
			}
			
		}).start();
		
		//���ش������
		return futureData;
	}

}



