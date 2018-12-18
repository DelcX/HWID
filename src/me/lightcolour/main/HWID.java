package me.lightcolour.main;

import me.lightcolour.main.Util.HWIDUtil;
import me.lightcolour.main.Util.HttpUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class HWID {


	public static void main(String[] args){
		if (HWIDVerify()) {
			//succeed
			JOptionPane.showMessageDialog(null,"233333");
		}else {
			JOptionPane.showMessageDialog(null,"ERROR \n 验证错误!","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	public static boolean HWIDVerify() {
		boolean passesd = false;
		try {
			for (int iop = 0; iop < 7; iop++) {
				String[] essswitch;
				switch (iop) {
					case 0:
						essswitch = HttpUtil.sendGet("https://raw.githubusercontent.com/Lightcolour-666/HWID/master/src/me/lightcolour/main/Util/HWID.txt", null).split("\n");
						break;
					case 1:
						essswitch = HttpUtil.sendGet("https://raw.githubusercontent.com/Lightcolour-666/HWID/master/src/me/lightcolour/main/Util/HWID.txt", null).split("\n");
						break;
					case 2:
						essswitch = HttpUtil.sendGet("https://raw.githubusercontent.com/Lightcolour-666/HWID/master/src/me/lightcolour/main/Util/BlackHWID.txt", null).split("\n");
						break;
					case 3:
						essswitch = HttpUtil.sendGet("https://raw.githubusercontent.com/Lightcolour-666/HWID/master/src/me/lightcolour/main/Util/HWID.txt", null).split("\n");
						break;
					case 4:
						essswitch = HttpUtil.sendGet("https://raw.githubusercontent.com/Lightcolour-666/HWID/master/src/me/lightcolour/main/Util/HWID.txt", null).split("\n");
						break;
					case 5:
						essswitch = HttpUtil.sendGet("https://raw.githubusercontent.com/Lightcolour-666/HWID/master/src/me/lightcolour/main/Util/HWID.txt", null).split("\n");
						break;
					case 6:
						essswitch = HttpUtil.sendGet("https://raw.githubusercontent.com/Lightcolour-666/HWID/master/src/me/lightcolour/main/Util/HWID.txt", null).split("\n");
						break;
					default:
						essswitch = HttpUtil.sendGet("https://raw.githubusercontent.com/Lightcolour-666/HWID/master/src/me/lightcolour/main/Util/HWID.txt", null).split("\n");
						break;
				}
				for (int i = 0; i < essswitch.length; i++) {
					if(essswitch[i] != null && (! essswitch[i].isEmpty()) && essswitch[i].equals(HWIDUtil.oo())) {
						passesd = true;
						break;
					}
				}
			}
			System.out.println(passesd);
			if (!passesd) {
				if (JOptionPane.showInputDialog(null, "Unver ified\nUpdate your HWID/IP on the my account page\n", HWIDUtil.oo()).toString().contains("lightcolour")) {
					Runtime.getRuntime().exit(-1);
				} else {
					Runtime.getRuntime().exit(-1);
				}
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error\n Info:\n ","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}

	
	

}
