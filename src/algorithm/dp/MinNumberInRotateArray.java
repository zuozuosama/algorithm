package algorithm.dp;

public class MinNumberInRotateArray {
    public int solution(int[] array) {
        if (array.length == 1) return array[0];
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (array[mid] > array[high]) low = mid + 1;
            else if (array[mid] < array[high]) high = mid;
            else high--;
        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] seq = {8,9,19,3,7};
        MinNumberInRotateArray mn = new MinNumberInRotateArray();
        System.out.println(mn.solution(seq));


    }


}
