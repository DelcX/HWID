package me.lightcolour.main.Util;

import javax.swing.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

    public class HWIDUtil {

        private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String oo() {
        // TODO Auto-generated method stub
        long start = System.currentTimeMillis();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(
                    new String[] { "wmic", "cpu", "get", "ProcessorId" }
            );
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,	e,"ERROR",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        try {
            process.getOutputStream().close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,	e,"ERROR",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next() + eee();

        return serial;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }


    public static String eee() {
        StringBuilder s = new StringBuilder();
        StringBuilder aaa = new StringBuilder(s.toString());
        s.append(generateHWID().toString().replaceAll("\\@",""));
        aaa.append(aaa.toString().getBytes());
        return bytesToHex(aaa.toString().getBytes());
    }

    public static byte[] generateHWID() {
        try {
            MessageDigest hash = MessageDigest.getInstance("MD5");
            StringBuilder s = new StringBuilder();
            s.append(System.getProperty("os.name"));
            s.append(System.getProperty("os.arch"));
            s.append(System.getProperty("os.version"));
            s.append(Runtime.getRuntime().availableProcessors());
            s.append(System.getenv("PROCESSOR_IDENTIFIER"));
            s.append(System.getenv("PROCESSOR_ARCHITECTURE"));
            s.append(System.getenv("PROCESSOR_ARCHITEW6432"));
            s.append(System.getenv("NUMBER_OF_PROCESSORS"));
            return hash.digest(s.toString().getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new Error("Algorithm wasn't found.", e);
        }
    }
}
