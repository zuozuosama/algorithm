package algorithm.wenjingkeji;



/**
 *  给定一个数组,类似【8,13,-50,1,16,0,-33,180,-380,11】
 * 写一个函数,以给定数组作为输入,返回 Max（Sum（sub1）+ Sum（sub2））
 */
public class ThreeMeet {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(nums[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeMeet threeMeet = new ThreeMeet();
        int[] a = {8, 13, -50, 1, 16, 0, -33, 180, -380, 11};
        System.out.println(threeMeet.maxSub(a));
    }


    public int maxSub(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int max = Integer.MIN_VALUE;
        int[] l;
        int[] r;
        while (left <= right - 1) {
            l = new int[left + 1];
            r = new int[right - left];
            System.arraycopy(arr, 0, l, 0, left + 1);
            System.arraycopy(arr, left + 1, r, 0, right - left);
            //复制arr的数到l和r中
            int lsum = maxSubArray(l);
            int rsum = maxSubArray(r);
            max = Math.max(max, lsum + rsum);
            left++;
        }
        return max;
    }
}
