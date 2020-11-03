package com.xing.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LoveSpend {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner (System.in);
        Scanner scanner2 = new Scanner (System.in);

        String s1 = scanner1.nextLine ();
        String s2 = scanner2.nextLine ();
        //使用ArrayList集合进行存放数据价格
        List<Integer> prices = new ArrayList<> ();
        //第二行输入商品价格的值中间有空格隔开且为数组
        //java.lang.string.split，即split 方法,它实现的功能是将一个字符串分割为子字符串，然后将结果作为字符串数组返回
        String temp[] = s2.split("\\s+");
        //foreach循环，遍历所有输入的值
        //parseInt() 函数可解析一个字符串,并返回一个整数,语法 parseInt(string, radix) 参数描述 string 必需要被解析的字符串
        for (String s : temp) {

            Integer price = Integer.parseInt (s);
            if(price !=null&&price<=10000&&price>-1){
                prices.add(price);
            }
        }
        Collections.sort (prices); //将输入的价格进行排序
        //parseInt() 函数可解析一个字符串,并返回一个整数,语法 parseInt(string, radix) 参数描述 string 必需要被解析的字符串
        Integer total = Integer.parseInt (s1); //获取第一行输入的自己预算的值
        Integer sum=0;
        for (Integer price : prices) {
            if(total>=price){
                total=total-price;
                sum=sum+price;
            }else {
                break;
            }
            
        }
        System.out.println (sum);


    }
}
