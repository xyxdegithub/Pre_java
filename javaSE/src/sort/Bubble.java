package sort;

import java.util.Arrays;



/**
 * @author: xyx
 * @date 2021/10/24 9:48
 * @description: 冒泡排序核心就是相邻两个数两两交换
 * 一下的代码能如何改进呢
 * 冒泡排序应该是最简单能写出的排序算法了
 */
public class Bubble {
    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        int[] a = {7, 13, 4, 5, 8, 1, 11, 9};
        int[] a2 = {7, 13, 4, 5};
        System.out.println("原始排序序列是:" + Arrays.toString(a2));
        bubble.Bubble(a2);
        // System.out.println(Arrays.toString(a2));
    }

    public void Bubble(int[] a) {
        //外层循环是控制循环几次
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = false;//设置标志位，进行判断
            //内层循环就是从左到右一遍冒泡排序
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = true;//发生位置交换，标志位变换
                }
            }
            if (flag == false) {
                break;
            }
            System.out.print("第" + (i + 1) + "次的排序结果" + ":");
            System.out.println(Arrays.toString(a));
        }

    }
}
