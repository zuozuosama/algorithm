package leetcode.changkaoti;

public class Rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    private void rotate1(int nums[], int k) {
        //设置count用于限制交换的次数
        int count = nums.length;
        int cur = 0, pre = nums[cur], next, temp;
        //start用于判断是否循环交换了
        int start = cur;
        while (count-- > 0) {
            //循环交换，一直向右移动，直到交换完count次数，所有数字就已经移动完了
            next = (cur + k) % nums.length;
            temp = nums[next];
            nums[next] = pre;
            pre = temp;
            cur = next;
            if (cur == start) {
                cur = (cur + 1) % nums.length;
                start = cur;
                pre = nums[cur];
            }
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {-1, -100, 3, 99};
        rotate.rotate1(nums, 2);
    }
}
