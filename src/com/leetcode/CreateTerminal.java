package com.leetcode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author 姚晶辉
 * @Description TODO
 * @date 2020/12/20 15:59
 * @Version 1.0
 */
public class CreateTerminal {
    private static String path ="d:/";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String comd=sc.nextLine();
            String[] s = comd.split(" ");
            if(s.length==1){
                exels();
                continue;
            }else if (s.length==2){
                if (s[0].equals("rm")){
                    exerm(s[1]);
                    continue;
                }
                exetouch(s[1]);
                continue;
            }else {
                rename(s[1],s[2]);
            }
        }
        }

    private static void rename(String oldName, String newName) {
        new File(path+"/"+oldName).renameTo( new File(path+"/"+newName));
    }

    private static void exetouch(String name) {
        try {
            new File(path+"/"+name).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建文件失败");
        }
    }

    private static void exerm(String name) {
        new File(path+"/"+name).delete();
    }

    private static void exels() {
        String[] list = new File(path).list();
        for (String s : list) {
            System.out.println(s);
        }
    }

}
