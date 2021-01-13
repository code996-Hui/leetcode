package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 姚晶辉
 * @Description TODO
 * @date 2020/12/20 15:39
 * @Version 1.0
 */
public class zhiyuanzhepaixu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        person [] pers = new person[num];
        for (int i = 0; i < num; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            pers[i]=new person(i+1,a*b);
        }
        Arrays.sort(pers);
        for (int i = 0; i < pers.length; i++) {
            System.out.print(pers[i].getId()+" ");
        }
    }

}
class person implements Comparable<person>{
    private int id;
    private int dongxiandu;

    public person(int id, int dongxiandu) {
        this.id = id;
        this.dongxiandu = dongxiandu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDongxiandu() {
        return dongxiandu;
    }

    public void setDongxiandu(int dongxiandu) {
        this.dongxiandu = dongxiandu;
    }

    @Override
    public int compareTo(person o) {
      return (o.dongxiandu-  dongxiandu)==0?id-o.id:(o.dongxiandu-  dongxiandu) ;
    }
}