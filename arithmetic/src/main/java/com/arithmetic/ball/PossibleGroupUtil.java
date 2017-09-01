/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.arithmetic.ball;

/**
 * TODO desc
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/9/1 13:38 $$
 */
// 组合算法
// 本程序的思路是开一个数组，其下标表示1到n个数，数组元素的值为1表示其下标
// 代表的数被选中，为0则没选中。
// 首先初始化，将数组前m个元素置1，表示第一个组合为前n个数。
// 然后从左到右扫描数组元素值的“10”组合，找到第一个“10”组合后将其变为
// “01”组合，同时将其左边的所有“1”全部移动到数组的最左端。
// 当第一个“1”移动到数组的n-m的位置，即m个“1”全部移动到最右端时，就得
// 到了最后一个组合。
// 例如求5中选3的组合：
// 1 1 1 0 0 //1,2,3
// 1 1 0 1 0 //1,2,4
// 1 0 1 1 0 //1,3,4
// 0 1 1 1 0 //2,3,4
// 1 1 0 0 1 //1,2,5
// 1 0 1 0 1 //1,3,5
// 0 1 1 0 1 //2,3,5
// 1 0 0 1 1 //1,4,5
// 0 1 0 1 1 //2,4,5
// 0 0 1 1 1 //3,4,5

import java.util.ArrayList;
import java.util.List;

/**
 * 面试中遇到的问题，在网上查找资料，加上自己的总结， java 代码实现组合的算法
 * 从n个数里取出m个数的组合是n*(n-1)*...*(n-m+1)/m*(m-1)*...2*1 该方法比较好理解，但具体算法的分析却有难度。
 *二进制转移
 * @author
 * @date
 */
class PossibleGroupUtil {

    /**
     * @param a:组合数组
     * @return :所有可能的组合数组列表
     */
    private List group(int[] a, int m) {
        PossibleGroupUtil zuhe = new PossibleGroupUtil();
        List list = new ArrayList();
        int n = a.length;
        boolean flag = false; // 是否是最后一种组合的标记
        // 生成辅助数组。首先初始化，将数组前m个元素置1，表示第一个组合为前m个数。
        int[] tempNum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < m) {
                tempNum[i] = 1;

            } else {
                tempNum[i] = 0;
            }
        }
        list.add(zuhe.createResult(a, tempNum, m));// 打印第一中默认组合
        do {
            int pose = 0; // 记录改变的位置
            int sum = 0; // 记录改变位置 左侧 1 的个数
            // 然后从左到右扫描数组元素值的“10”组合，找到第一个“10”组合后将其变为“01”
            for (int i = 0; i < (n - 1); i++) {
                if (tempNum[i] == 1 && tempNum[i + 1] == 0) {
                    tempNum[i] = 0;
                    tempNum[i + 1] = 1;
                    pose = i;
                    break;
                }
            }
            list.add(zuhe.createResult(a, tempNum, m));// 打印第一中默认组合

            // 同时将其左边的所有“1”全部移动到数组的最左端。

            for (int i = 0; i < pose; i++) {
                if (tempNum[i] == 1)
                    sum++;
            }

            for (int i = 0; i < pose; i++) {
                if (i < sum)
                    tempNum[i] = 1;
                else
                    tempNum[i] = 0;
            }

            // 判断是否为最后一个组合：当第一个“1”移动到数组的n-m的位置，即m个“1”全部移动到最右端时，就得到了最后一个组合。
            flag = false;
            for (int i = n - m; i < n; i++) {

                if (tempNum[i] == 0)
                    flag = true;

            }
        } while (flag);
        return list;
    }

    // 根据辅助数组和原始数组生成 结果数组
    public int[] createResult(int[] a, int[] temp, int m) {
        int[] result = new int[m];

        int j = 0;
        for (int i = 0; i < a.length; i++) {

            if (temp[i] == 1) {
                result[j] = a[i];
                j++;
            }
        }

        return result;
    }

    // 打印
    public void print1(List list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println();
            int[] temp = (int[]) list.get(i);
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Long startTime= System.currentTimeMillis();
        int[] a = {0, 1, 2, 3, 4,5,6,7}; // 整数数组
        int m = 3; // 待取出组合的个数
        PossibleGroupUtil possibleGroupUtil = new PossibleGroupUtil();
        List list = possibleGroupUtil.group(a, m);
        possibleGroupUtil.print1(list);
        Long endTime=System.currentTimeMillis();
        System.out.println("-----------------------------------");
        System.out.println(endTime-startTime);

    }
}
