package com.zhc.core.util;

import java.util.Date;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;

/*
 * 加密工具类
 */
public class EncryptUtil {

	// 加密方式
	private static String ALGORITHMNAME = "MD5";
	// 加密次数
	private static int HASHITERATIONS = 5;

	/**
	 * md5加密
	 * 
	 * @param source
	 *            加密数据源
	 * @param salt
	 *            盐值
	 * @return 加密后的字符串
	 */
	public static String encMD5(Object source, Object salt) {
		String encMD5Str = new SimpleHash(ALGORITHMNAME, source, salt,
				HASHITERATIONS).toHex();
		return encMD5Str;
	}

	/**
	 * Base64加密
	 * 
	 * @param str
	 *            要加密的字符串
	 * @return 加密后的字符串
	 */
	public static String encBase64(String str, String password) {
		String tmp = str + Base64.encodeToString(password.getBytes());
		tmp = Base64.encodeToString(tmp.getBytes());
		return tmp;
	}

	/**
	 * 
	 * @param str
	 *            要解密的字符串
	 * @return 解密后的字符串
	 */
	public static String decBase64(String str, String password) {
		String tmp = str;
		if (null != tmp && !tmp.isEmpty()) {
			tmp = Base64.decodeToString(tmp.getBytes());
		}
		int index = tmp.lastIndexOf(Base64.encodeToString(password.getBytes()));
		if (-1 != index) {
			tmp = tmp.substring(0, index);
		}
		return tmp;
	}

	public static void main(String[] args) {
		String encStr = encBase64(new Date().getTime()+"", "");
		System.out.println(encStr);
		System.out.println(decBase64(encStr, ""));
	}
}
