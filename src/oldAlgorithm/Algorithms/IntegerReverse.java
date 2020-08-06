package oldAlgorithm.Algorithms;

/*
    int ：4个字节 32位
    long：8个字节 64位
 */
public class IntegerReverse {
    public int reverse(int x) {
        long rs = 0;
        while (x != 0) {
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        // 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
        // 请根据这个假设，如果反转后整数溢出那么就返回 0。
        return (rs < Integer.MIN_VALUE || rs > Integer.MAX_VALUE) ? 0 : (int) rs;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MIN_VALUE); // -2^31
//        System.out.println(Integer.MAX_VALUE); // 2^31-1
        int reverse = new IntegerReverse().reverse(12378);
        System.out.println(reverse);
    }
}
