package sort;

public class QuickSort {
    public int[] quicksort(int[] nums) {
        return quick(nums, 0, nums.length - 1);
    }

    private int[] quick(int[] nums, int l, int r) {
        if (l > r) return nums;
        int left = l;
        int rigth = r;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            swap(nums, l, r);
        }
        swap(nums, left, l);
        quick(nums, left, l - 1);
        quick(nums, l + 1, rigth);
        return nums;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {1, 5, 3, 7, 2};
        int[] arr = quickSort.quicksort(nums);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
