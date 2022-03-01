package algorithm;

import java.util.Arrays;

/**
 * @author :xyx
 * @date :2021/1/20 8:51
 * @description:简单选择排序示例
 * @序列中找最大值与最后一个数做交换或找最小与第一个数交换 0 1 2 3 4 5 6
 */
public class Selection {
    public static int SelectionSortPart1(int[] a, int n) {
        int max = a[0];
        int maxindex = 0;
        for (int i = 0; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
                maxindex = i;
            }
        }
        return maxindex;
    }

    public static void SelectionSortPart2(int[] a, int n) {
        //while (n > 1) {
        for (int i = 0; i < a.length - 1; i++) {
            int maxindex = SelectionSortPart1(a, n);
            //换到最后面
            int temp = a[maxindex];
            a[maxindex] = a[n - 1];
            a[n - 1] = temp;

            n--;//n--的思考
            System.out.println("第" + (i + 1) + "次选择排序结果为:" + Arrays.toString(a));
        }

    }

    public static void SelectionSort(int[] a, int n) {
        for (int i = 0; i < a.length - 1; i++) {
            // int maxindex = SelectionSortPart1(a, n);
            int max = a[0];
            int maxindex = 0;
            for (int j = 0; j < n; j++) {
                if (max < a[j]) {
                    max = a[j];
                    maxindex = j;
                }
            }
            int temp = a[maxindex];
            a[maxindex] = a[n - 1];
            a[n - 1] = temp;
            n--;
            System.out.println("第" + (i + 1) + "次选择排序结果为:" + Arrays.toString(a));
        }
    }

    public static void SelectionSort2(int[] a) {
//总共要循环a.length-1趟
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;//最小值下标
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
            System.out.println("第" + (i + 1) + "次选择排序结果为:" + Arrays.toString(a));
        }
    }

    public static void SelectionSort3(int[] a) {

        //System.out.println("第" + (i + 1) + "次选择排序结果为:" + Arrays.toString(a));
    }


    public static void main(String[] args) {
        int[] a = {10, 9, 11, 8, 12, 7, 13};
        System.out.println("原序列为:" + Arrays.toString(a));
        SelectionSortPart2(a, 7);
        //System.out.println("排序好后的数据为:" + Arrays.toString(a));

        System.out.println("***********************************");
        int[] a1 = {5, 6, 4, 7, 3, 8, 2};
        System.out.println("原序列为:" + Arrays.toString(a1));
        SelectionSort(a1, 7);

        System.out.println("***********************************");
        int[] a2 = {8, 9, 7, 10, 6, 11, 5};
        System.out.println("原序列为:" + Arrays.toString(a2));
        SelectionSort2(a2);

        System.out.println("***********************************");
//        int[] a3 = {100,99,101,98,102,97,103};
//        System.out.println("原序列为:" + Arrays.toString(a3));
//        SelectionSort3(a3);
    }

}
