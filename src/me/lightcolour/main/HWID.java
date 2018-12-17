package me.lightcolour.main;

import java.util.ArrayList;
import java.util.Scanner;

import me.lightcolour.main.lib.lib;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class HWID {
	
	public static String hwid = "HWID,HWID1,HWID2";
	
	
	public static ArrayList<String> gethwid () {
		String a[] = hwid.split(",");
		ArrayList<String> string = new ArrayList();
		for (int i = 0; i < a.length; i++) {
			string.add(a[i]);
		}
		return string;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		oo();
	}
	
	public static void oo() {
	    // TODO Auto-generated method stub  
	    try {  
	        long start = System.currentTimeMillis();  
	        Process process = Runtime.getRuntime().exec(  
	        new String[] { "wmic", "cpu", "get", "ProcessorId" });  
	        process.getOutputStream().close();  
	        Scanner sc = new Scanner(process.getInputStream());  
	        String property = sc.next();  
	        String serial = sc.next();  
	        System.out.println(property + ": " + serial);  
	        System.out.println("time:" + (System.currentTimeMillis() - start));  
	    } catch (IOException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }  
	}
	
	

}
