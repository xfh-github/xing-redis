package com.xing.pojo;

import java.util.Scanner;

public class PasswordTest {
    public static void main(String[] arges) {
        String[] strs = {"ABCDEFGHI", "JKLMNOPQR", "STUVWXYZ*"};
        String str1=strs[0];
        String str2=strs[2];
        String str3=strs[1];

        Scanner s1 = new Scanner (System.in);//第一行，输入月份和日期
        Scanner s2 = new Scanner (System.in);//第二行，大写字符串
        String m = s1.nextLine ();
        String n = s2.nextLine ();

        String tempn = n.replaceAll ("\\s", "*"); //将输入的字符串中的空格转化为*
        String temp[] = m.split("\\s+");
        Integer c = Integer.parseInt (temp[0]);
        Integer d = Integer.parseInt (temp[1]);

        if(c>12||c<0){
            System.out.println ("输入月份不合法");
            return;
        }
        if(d<0||d>31){
            System.out.println ("输入日期不合法");
            return;
        }
        int x=(c-1)%3; //分组左移动位置
        int y=(d-1)%9; //组内左移动的位置

        if(x==0){
            strs[0]=str1;
            strs[1]=str2;
            strs[2]=str3;
        }else if(x==1){
            strs[0]=str2;
            strs[1]=str3;
            strs[2]=str1;
        }else if(x==2){
            strs[0]=str3;
            strs[1]=str1;
            strs[2]=str2;
        }
        System.out.println (strs[0]+" "+strs[1]+" "+strs[2]);
        char[] ch = tempn.toCharArray ();
        for (int i = 0; i < strs.length; i++) {
            strs[i] = leftMoveIndex(strs[i], y); //组内字符左移
        }
        System.out.println(strs[0] + " "+strs[1] + " "+strs[2]);
        for (int j = 0; j < ch.length; j++) { //循环输入的字符数组 ，若出现在分组中，则输出 分组的位置 和 字符出现的位置
            if(!"ABCDEFGHIJKLMNOPQRSTUVWXYZ*".contains(ch[j]+"")){
                System.out.println("输入字符串不合法");
                return;
            }else {
                for (int i = 0; i < strs.length; i++) {
                    if (strs[i].contains(ch[j] + "")) {
                        System.out.print((i + 1) + "" + (strs[i].indexOf(ch[j] + "") + 1) + " ");
                    }
                }
            }
        }
    }
    public static String leftMoveIndex(String from, int index) {
        String first = from.substring(0, index);
        String second = from.substring(index);
        first = reChange(first);
        second = reChange(second);
        from = first + second;
        from = reChange(from);
        return from;
    }
    /**
     * 循环反转字符串
     * @param from
     * @return
     */
    public static String reChange(String from) {
        char[] froms = from.toCharArray();
        int length = froms.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = froms[i];
            froms[i] = froms[length - 1 - i];
            froms[length - 1 - i] = temp;
        }
        return String.valueOf(froms);
    }


}




