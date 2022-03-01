package sort;

import java.util.Arrays;

/**
 * @author: xyx
 * @date 2021/10/26 14:16
 * @description: 插入排序
 */
public class Insert {
    public static void main(String[] args) {
        Insert insert = new Insert();
        int[] a = {7, 13, 4, 5, 8, 1, 11, 9};
        int[] a2 = {7, 13, 4, 5};
        System.out.println("原始排序序列是:" + Arrays.toString(a));
        insert.insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void insertSort(int[] a) {
        //n-1趟
        for (int i = 1; i < a.length; i++) {
            //使用while循环
            while (a[i - 1] > a[i]) {
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
                i--;//--这个逻辑蛮重要的
                if (i == 0) {
                    break;
                }
            }
        }
    }

}
