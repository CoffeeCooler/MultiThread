package com.sunft.base.sync011;

import java.util.concurrent.ConcurrentHashMap;

/**
 * �ֶη�װConcurrentHashMap
 * @author sunft
 *
 */
public class MyConcurrentHashMap {

	/**
	 * ���ø������ٴν��з�װ
	 */
	private ConcurrentHashMap<String, ConcurrentHashMap<Integer, String>>
	 map = new ConcurrentHashMap<>();
	
}
