package algorithm.kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 9
 * 25 84 21 47 15 27 68 35 20
 *
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 35 27 47 68 84
 * 15 20 21 25 27 35 47 68 84
 * 15 20 21 25 27 35 47 68 84
 */
public class Case2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String blank = sc.nextLine();
        String input = sc.nextLine();
        int[] array = new int[n];
        String[] s = input.split(" ");
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        quickSort(array, 0, array.length - 1);
    }

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
        printarr(array);
        quickSort(array, leftBound, i - 1);
        quickSort(array, i + 1, rightBound);

        return;
    }

    private static void printarr(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (i==array.length-1){
                System.out.println(array[i]);
            }else {
                System.out.print(array[i]+" ");
            }

        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
