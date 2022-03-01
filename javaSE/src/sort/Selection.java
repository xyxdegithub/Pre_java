package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: xyx
 * @date 2021/10/21 10:39
 * @description:选择排序基本思想选出最大或最小的数，与最左或最右的交换 一般都是两层的嵌套循环
 * 找更小的数交换怎么感觉更难实现，关键在于要控制找出最小数的循环起点位置
 */
public class Selection {
    public static void main(String[] args) {
        Selection selection = new Selection();
        int[] a = {7, 13, 4, 5, 8, 1, 11, 9};
        System.out.println(Arrays.toString(a));
        selection.selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    //n的作用控制循环起点位置
    public void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            //内层循环目的找出最小值
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            //加一个minIndex != i可以优化代码，减少执行代码
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }

    }


}