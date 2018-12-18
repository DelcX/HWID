package me.lightcolour.main;

import me.lightcolour.main.obfuscator.obfuscator;

import javax.swing.*;

import static me.lightcolour.main.HWID.HWIDVerify;

public class Main {
    public static boolean hahaha = HWIDVerify();
    public static obfuscator obf;
    public static void main(String[] args){
        if (hahaha) {
            //succeed
            obf  = new obfuscator();
            JOptionPane.showMessageDialog(null,"驗證成功但未破解!");
        }else {
            JOptionPane.showMessageDialog(null,"ERROR \n 验证错误!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
