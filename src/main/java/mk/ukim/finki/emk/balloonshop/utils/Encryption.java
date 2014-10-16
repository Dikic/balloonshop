package mk.ukim.finki.emk.balloonshop.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encryption {

	public static String encrypt(String source){
		String md5 = null;
		try {
			MessageDigest mdEnc = MessageDigest.getInstance("MD5");
			mdEnc.update(source.getBytes(),0,source.length());
			md5=new BigInteger(1, mdEnc.digest()).toString();
		} catch(Exception ex){
			return null;
		}
		return md5;
	}
}
