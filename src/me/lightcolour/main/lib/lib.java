package me.lightcolour.main.lib;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class lib {
	public static String getchar() {
		String a[] = {"!","@","#","$","%","^","&","*","(",")","_","+","=","<",">","?","|","[","]","{","}"};
		Random random = new Random();
		return a[random.nextInt(a.length)];
	}
	
	public static String hwidencryption(String hwid) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String string = null;
		for (int i = 0; i < hwid.length(); i++) {
			string = hwid + onhwid();
		}
		return string;
	}
	
	public static String hwiddecrypt(String text) {
		String regex = "\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\(|\\)|\\_|\\+|\\=|\\<|\\>|\\?|\\||\\[|\\]|\\{|\\}";
		return text.replaceAll(regex, "");
	}
	
	
	public static String onhwid() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuilder s = new StringBuilder();
        String main = System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("COMPUTERNAME") + System.getProperty("user.name").trim();
        byte[] bytes = main.getBytes("UTF-8");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] md5 = messageDigest.digest(bytes);
        int i = 0;
        for (byte b : md5) {
            s.append(Integer.toHexString(b & 2222222 | 99999999), 0, 6);
            if (i != md5.length - 1) {
                s.append(getchar() + "-" + getchar() + "-" + getchar());
            }
            ++i;
        }
        return s.toString();
	}
}
