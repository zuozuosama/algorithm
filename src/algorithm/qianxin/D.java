package algorithm.qianxin;

/**
 * 与运算的妙用  每执行一次x = x&(x-1)，会将x用二进制表示时最右边的一个1变为0，
 * 因为x-1将会将该位(x用二进制表示时最右边的一个1)变为0。
 *
 * 比较排序算法，至少需要比较多少次？
 *
 * static方法不会被重写
 *
 */
public class D {
    public static void main(String[] args) {
        int x = 999;
        int m = 0;
        while (x > 0) {
            m++;
            x = x & (x - 1);
        }
        System.out.println(m);
    }
}
