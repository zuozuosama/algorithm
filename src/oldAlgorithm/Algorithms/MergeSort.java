package oldAlgorithm.Algorithms;

import java.util.Arrays;

/*
    归并排序
 */
public class MergeSort {
    private static int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    private static void merge(int[] a, int low, int mid, int high) {
        //创建一个临时排序数组
        int[] temp = new int[high - low + 1];
        int i = low; //左游标
        int j = mid + 1; //右游标
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖a数组
        /**
         * 因为递归过程中low可能不为0，不为0的原因是可能对low=3,mid=3,high=4即
         * a[3]-a[4]范围的子数组进行排序
         */
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }

    public static void main(String[] args) {

        int[] arr = {21,25,84,47,15,27,68,35,20};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
