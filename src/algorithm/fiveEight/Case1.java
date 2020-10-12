package algorithm.fiveEight;

import java.util.ArrayList;

/**
 * 数组删除重复项，保留最近出现的数字
 * <p>
 * ex:
 * <p>
 * 输入：
 * 5,2,3,5,1
 * 输出：
 * 2,3,5,1
 */
public class Case1 {
    public int[] removeDuplicate(int[] array) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (integers.indexOf(array[i]) == -1) {
                integers.add(0, array[i]);
            }
        }
        int[] ints = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }
}
