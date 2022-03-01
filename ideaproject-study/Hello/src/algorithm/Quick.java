package algorithm;

import java.util.Arrays;

/**
 * @author :xyx
 * @date :2021/1/22 8:33
 * @description:快速排序,关键在于划分,会影响效率
 * @代码结构，代码是一行一行执行的
 */
public class Quick {
    public static int Partition(int[] a, int low, int high) {
        int pivot = a[low];//基准元素选第一个
        while (low < high) {
            while (low < high && a[high] >= pivot) {
                --high;
            }
            a[low] = a[high];

            while (low < high && a[low] <= pivot) {
                ++low;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }

    public static void QuickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotpos = Partition(a, low, high);
            QuickSort(a, low, pivotpos - 1);
            QuickSort(a, pivotpos + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 9, 11, 8, 12, 7, 13, 6};
        System.out.println("原序列为:" + Arrays.toString(a));
        QuickSort(a, 0, a.length - 1);
        System.out.println(Partition(a, 0, a.length - 1));
        System.out.println("排序后为:" + Arrays.toString(a));
    }
}
