package algorithm;

import java.util.Arrays;

/**
 * @author :xyx
 * @date :2021/1/19 20:54
 * @description:冒泡排序示例 9 8 7 5 1
 * 从后往前交换，这冒泡排序应该是最简单能写出的排序算法了
 */

public class Bubble {
    public static void BubbleSort(int[] a) {
        boolean flag = false;
        for (int i = 0; i < a.length - 1; i++) {
            flag = false;
            for (int j = a.length - 1; j >= i + 1; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
                if (flag == true) {
                    break;
                }
            }
            System.out.println("冒泡排序第" + (i + 1) + "遍的结果是:");
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[] a = {21, 22, 1, 2, 67, 9, 98};
        System.out.println("原数据为:" + Arrays.toString(a));
        BubbleSort(a);


    }
}
