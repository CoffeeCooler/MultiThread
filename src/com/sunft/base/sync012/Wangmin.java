package com.sunft.base.sync012;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * ������
 * @author sunft
 *
 */
public class Wangmin implements Delayed {

	private String name;
	// ���֤
	private String id;
	// ��ֹʱ��
	private long endTime;
	// ����ʱ�乤����
	private TimeUnit timeUnit = TimeUnit.SECONDS;

	public Wangmin(String name, String id, long endTime) {
		this.name = name;
		this.id = id;
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Delayed o) {
		Wangmin w = (Wangmin) o;
		return this.getDelay(this.timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1 : 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return endTime - System.currentTimeMillis();
	}

}


