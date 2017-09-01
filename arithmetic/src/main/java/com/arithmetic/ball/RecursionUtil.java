/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.arithmetic.ball;

/**
 * TODO 递归排序
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/9/1 13:51 $$
 */
public class RecursionUtil {

    public static void main(String[] args) {
        select(2);
    }


    private static void select(int k) {
        char[] result = new char[k];
        subselect(0, 1, result, k);

    }

    private static void subselect(int head, int index, char[] r, int k) {
        for (int i = head; i < a.length + index - k; i++) {
            if (index < k) {
                r[index - 1] = a[i];
                System.out.println("i=" + (i) + ";index=" + (index));
                subselect(i + 1, index + 1, r, k);
            } else if (index == k) {
                r[index - 1] = a[i];
                System.out.println(";i=" + (i) + ";index=" + (index) + ";index==k:" + (index == k));
                System.out.print(i + "===");
                System.out.println(r);
                subselect(i + 1, index + 1, r, k);
            } else {
                System.out.println("++");
                return;//返回到何处？奇怪
            }

        }
    }

    private static char[] a = {'a', 'b', 'c'};
}
