package com.sunft.base.design.future;

/**
 * ��ʵ������
 * @author sunft
 *
 */
public class RealData implements Data {
	
	private String result;

	public RealData(String queryStr) {
		System.out.println("����" + queryStr 
				+ "���в�ѯ,����һ���ܺ�ʱ�Ĳ���...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�������,��ȡ���");
		result = "��ѯ���";
	}

	@Override
	public String getRequest() {
		return result;
	}

}
