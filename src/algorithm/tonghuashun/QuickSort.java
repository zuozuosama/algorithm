package algorithm.tonghuashun;

import java.util.Arrays;

/**
 * 快速排序算法 双指针
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {2,5,3};
        quickSort(array,0,array.length-1);
        int[] ints = Arrays.copyOf(array, 2);
        System.out.println(Arrays.toString(ints));
    }

    public void findMinK(){

    }

    /**
     * 快速排序主方法
     * @param array
     * @param leftBound
     * @param rightBound
     */
    private static int[] quickSort(int[] array, int leftBound, int rightBound) {
        if (leftBound >= rightBound){
            return array;
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
        return array;
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


}
