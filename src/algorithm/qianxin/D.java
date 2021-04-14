package algorithm.qianxin;

/**
 * 与运算的妙用  每执行一次x = x&(x-1)，会将x用二进制表示时最右边的一个1变为0，
 * 因为x-1将会将x的低位变为0。
 *
 *
 * 1、 判断一个数是否是2的方幂
 * n > 0 && ((n & (n - 1)) == 0 )
 *
 * 解释((n & (n-1)) == 0)：
 *
 * 如果A&B==0，表示A与B的二进制形式没有在同一个位置都为1的时候。
 *
 * 那么本题到底啥意思？？
 *
 * 不妨先看下n-1是什么意思。
 *
 *    令:n=110101 1000(二进制,十进制也一样)，则
 *
 *     n-1=110101 0111。
 *
 * n&(n-1)=1101010000
 *
 * 由此可以得出，n和n-1的低位不一样，直到有个转折点，就是借位的那个点，从这个点开始的高位，
 * n和n-1都一样，如果高位一样这就造成一个问题，
 * 就是n和n-1在相同的位上可能会有同一个1，从而使((n & (n-1)) != 0),如果想要
 *
 * ((n & (n-1)) == 0)，则高位必须全为0，这样就没有相同的1。
 *
 * 所以n是2的幂或0
 *
 * 比较排序算法，至少需要比较多少次？：
 * 已知下列各种初始状态(长度为n)元素，试问当利用直接插入法进行排序时，
 * 至少需要进行多少次比较(要求排序后的文件按关键字从大到小顺序排列)。
 * 在这种情况下，插入第i个(2≤i≤n)元素的比较次数为1，因此，总的比较次数为1+1+1+……+1=n-1。
 *
 *
 * static方法不会被重写
 *
 */
public class D {
    /**
     * 999使用除2取余法转为二进制数 数1的个数
     * @param args
     */
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
