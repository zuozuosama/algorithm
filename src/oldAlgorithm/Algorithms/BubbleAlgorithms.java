package oldAlgorithm.Algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleAlgorithms {
    public static void main(String[] args) {
        int[] arr = getArr();
        System.out.println("排序前:" + Arrays.toString(arr));
        bubble(arr);
    }

    private static void bubble(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后: " + Arrays.toString(arr));
    }

    private static int[] getArr() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (random.nextInt(10) + 1);
        }
        return arr;
    }
}
