package algorithm.tonghuashun;

import java.util.Arrays;

/**
 * 快速排序算法 双指针
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {2, 5, 3, 11, 1, 8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * top-k 算法
     * 快排变形
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) return arr;
        int[] dest = new int[k];
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int pos = quickSort1(arr, low, high);
            if (pos == k - 1) break;
            else if (pos < k - 1) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        System.arraycopy(arr, 0, dest, 0, k);
        return dest;
    }

    private static void sort(int[] array) {
        int low = 0, high = array.length - 1;
        quickSort(array, low, high);
    }

    /**
     * 快速排序主方法 二叉搜索树的中序遍历
     *
     * @param array
     * @param leftBound
     * @param rightBound
     */
    private static void quickSort(int[] array, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int i = leftBound;
        int j = rightBound;
        int pivot = array[leftBound];
        while (i < j) {
            while (i < j && array[j] >= pivot) {
                j--;
            }
            while (i < j && array[i] <= pivot) {
                i++;
            }
            swap(array, i, j);
        }
        swap(array, leftBound, i);
        quickSort(array, leftBound, i - 1);
        quickSort(array, i + 1, rightBound);
    }

    private static int quickSort1(int[] array, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return leftBound;
        }
        int i = leftBound;
        int j = rightBound;
        int pivot = array[leftBound];
        while (i < j) {
            while (i < j && array[j] >= pivot) {
                j--;
            }
            while (i < j && array[i] <= pivot) {
                i++;
            }
            swap(array, i, j);
        }
        swap(array, leftBound, i);
        return i;
    }


    /**
     * 交换位置
     *
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
