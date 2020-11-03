package com.xing.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NvPiao {
    public static void main(String[] arges) {

        Scanner sc1 = new Scanner (System.in); //输入月份和日期
        Scanner sc2 = new Scanner (System.in); //输入 大写字母字符串
        //接受输入参数
        String m = sc1.nextLine ();
        String n = sc2.nextLine ();

        List<Integer> prices = new ArrayList<> ();

        String temp[] = n.split ("\\s+");
        for (String s : temp) {
            Integer price = Integer.parseInt (s);
            if (price != null && price <= 10000 && price > -1) {//判断输入的是否为数字
                prices.add (price);
            }
        }
        Collections.sort (prices); //将输入的价格进行排序

        Integer total = Integer.parseInt (m); //获取输入的预算上限
        Integer sum = 0;
        /**
         * 遍历价格集合，prices是有序的集合，从小到大排列
         *      total 为当前拥有的钱，如果total >= price ，说明可以买此商品，
         *      则total = total - price;
         *      此时，计算总价 sum += price
         *      直到total < price 说明当前拥有的钱不够支付下一个商品，则跳出循环 打印sum总价;
         */
        for (Integer price : prices) {
            if (total >= price) {
                total = total - price;
                sum += price;
            } else {
                break;
            }
        }
        System.out.println (sum);
    }

}