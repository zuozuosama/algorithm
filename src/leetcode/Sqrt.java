package leetcode;

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        int l = 0, r = x;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (x / m < m) { //防止溢出
                r = m;
            } else {
                l = m;
            }
        }
        return l;
    }
}
