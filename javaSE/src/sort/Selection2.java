package sort;

import java.util.Arrays;

/**
 * @author: xyx
 * @date 2021/10/21 12:29
 * @description: 参数：一个传入数组，一个传入数组长度
 * 这是简单选择排序第二种
 */
public class Selection2 {
    public static void main(String[] args) {
        int[] a = {7, 13, 4, 5, 8, 1, 11, 9};
        System.out.println(Arrays.toString(a));
        selectionSort(a, 8);
        System.out.println(Arrays.toString(a));
    }

    public static void selectionSort(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            int max = 0;
            int maxIndex = 0;
            for (int j = 0; j < n; j++) {
                if (a[maxIndex] < a[j]) {
                    max = a[j];
                    maxIndex = j;
                }
            }
            int temp = a[maxIndex];
            a[maxIndex] = a[n - 1];
            a[n - 1] = temp;
            n--;
        }
    }
}
