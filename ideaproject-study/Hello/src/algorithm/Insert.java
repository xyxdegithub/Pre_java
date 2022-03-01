package algorithm;

import java.util.Arrays;

/**
 * @author :xyx
 * @date :2021/1/19 20:06
 * @description:直接插入排序示例 把第一个元素视为有序序列，依次的与有序序列比较和交换
 */
public class Insert {
    //传入一个数组，n为数组长度

    public static void InsertPart(int[] a, int n) {
        int key = a[n];
        int j = n;
        while (a[j - 1] > a[j]) {
            a[j] = a[j - 1];
            j--;
            if (j == 0) {
                break;
            }
        }
        a[j] = key;
    }

    public static void InsertSort(int[] a, int n) {
        //认为第一个元素（下标为0）已排好序,i从1开始,外层循环总是控制循环次数的
        for (int i = 1; i < n; i++) {
            InsertPart(a, i);
        }
    }

    //整合一下写成一个函数
    public static void InsertSort2(int[] a, int n) {
        for (int i = 1; i < n; i++) {//n-1趟
            int key = a[i];
            int j = i;
            while (a[j - 1] > a[j]) {
                a[j] = a[j - 1];
                j--;
                if (j == 0) {
                    break;
                }
            }
            a[j] = key;

            System.out.println("第" + (i) + "次直接插入排序结果为:" + Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 1, 4, 5, 6, 7};
        System.out.println("原先序列为:" + Arrays.toString(a));
        InsertSort2(a, 6);
//        for (int i = 0; i < 6; i++) {
//            System.out.println(a[i]);
//        }
//
//        int[] a2 = {1, 4, 2, 3, 6};
//        InsertSort2(a2, 5);
//        System.out.println(Arrays.toString(a2));

    }

}
