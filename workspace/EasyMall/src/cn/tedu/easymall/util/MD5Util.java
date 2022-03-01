package cn.tedu.easymall.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	/**
	 * 使用md5的算法进行加密
	 */
	public static String md5(String plainText) {
		// 用来保存加密后的密文的数组
		byte[] secretBytes = null;
		try {
			//将明文转成byte数组并进行加密，获得密文数组
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		//将2进制数组转成16进制表示的字符串
		String md5code = new BigInteger(1, secretBytes).toString(16);
		//128位2进制数组转成16进制时，可能不足32位
		//在字符串前面补0，使所有的字符串长度一定是32位
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		//返回32位定长的密文
		return md5code;
	}

}
