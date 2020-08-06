package algorithm.double_pointer;

import java.util.Arrays;

/**
 * 快速排序算法 双指针
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = getArray();
        System.out.println("快速排序前:" + Arrays.toString(array));
        quickSort(array,0,array.length-1);
        System.out.println("快速排序后:" + Arrays.toString(array));
    }

    /**
     * 快速排序主方法
     * @param array
     * @param leftBound
     * @param rightBound
     */
    private static void quickSort(int[] array, int leftBound, int rightBound) {
        if (leftBound >= rightBound){
            return;
        }
        int i = leftBound;
        int j = rightBound;
        int pivot = array[leftBound];
        while (i < j){
            while (i < j && array[j] >= pivot){
                j--;
            }
            while (i < j && array[i] <= pivot){
                i++;
            }
            swap(array,i,j);
        }
        swap(array,leftBound,i);
        quickSort(array,leftBound,i-1);
        quickSort(array,i+1,rightBound);
        return;
    }

    /**
     * 交换位置
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 获取1-100区间内的整数随机数组
     * @return
     */
    private static int[] getArray() {
        int[] arr = new int[10];
        for (int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random()*100+1);
        }
        return arr;
    }
}
