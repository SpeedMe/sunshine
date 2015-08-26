package com.zhubajie.sunshine.core.util;

/**
 * 字符串工具类
 * @author jianyang
 *
 */
public class StringUtil {
	
	/**
	 * 字符串是否为null或者空（空包括blank和""）
	 * @param str
	 * @return
	 */
	public static boolean isNullOrBlank(String str){
		return str != null && str.trim().length() > 0 ? false : true;
	}
	
	
	
	

	/**
	 * 包装字符串
	 * @param source  要包装的源字符串
	 * @param wraper  包装元素
	 * @param len	     包装后的总长度
	 * @return
	 */
	public static String wraperStrEnd(String source, String wraper, int len){
		
		if(isNullOrBlank(source)){
			return null;
		}
		
		if(isNullOrBlank(wraper)){
			return source;
		}
		
		if(len < wraper.length()){
			return wraper;
		}
		
		String warpper = source;
		
		for(int i = 0; i < (len  - source.length()); i++){
			warpper = warpper + wraper;
		}
		
		return warpper;
		
	}
	
	public static void main(String[] args) {
//		System.out.println(getRamdomNumString());
	}
	

	
	
}
