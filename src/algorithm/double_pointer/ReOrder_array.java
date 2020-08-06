package algorithm.double_pointer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面 双指针
 */
public class ReOrder_array {
    public int[] reorderArray(int[] array) {
        int low = 0, high = array.length - 1;
        while (low < high) {
            while (low < high && (array[high] % 2 == 0)) {
                high--;
            }
            while (low < high && (array[low] % 2 == 1)) {
                low++;
            }
            int temp = array[high];
            array[high] = array[low];
            array[low] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        ReOrder_array re = new ReOrder_array();
        int[] array = {2, 4, 6, 8, 1, 3, 5, 7};
        System.out.println(Arrays.toString(re.reorderArray(array)));
    }
}
