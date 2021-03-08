package oldAlgorithm.Algorithms;

import java.util.Arrays;
import java.util.Random;


/**
 * 直接插入排序
 */
public class InsertAlgorithms {
    public static void main(String[] args) {
        int[] arr = getArr();
//        List<Integer> list = Arrays.asList(1,2,3);
//        System.out.println("asList:"+list);
        System.out.println("排序前: " + Arrays.toString(arr));
        insertAlgorithms(arr);
    }

    private static void insertAlgorithms(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
        System.out.println("排序后: " + Arrays.toString(arr));
    }

    private static int[] getArr() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            arr[i] = (int) (random.nextInt(10) + 1);
        }
        return arr;
    }

}
