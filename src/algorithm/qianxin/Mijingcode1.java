package algorithm.qianxin;

import java.util.Scanner;

/**
 * 不使用中间变量交换值
 * 首先：^ 是 位运算 的一种： 异或 运算
 *
 * 1^1=0;
 *
 * 0^0=0;
 *
 * 1^0=1;
 *
 * 0^1=1;
 *
 * 将a、b用二进制表示为：
 *
 * a=An-1 An-2……A1 A0
 *
 * b=Bn-1 Bn-2……B1 B0
 *
 * 由于a与b进行位运算，是各个bit位分别进行运算，互不影响，下面对某一个位值i上的运算进行分析；
 *
 * 设Ai和Bi是a、b二进制位上的数值，0或1。
 *
 * 四种情况：
 *
 * 当Ai=1;Bi=1;时：
 *
 * Ai^=Bi;后：Ai=0；
 *
 * Bi^=Ai;后：Bi=1；
 *
 * Ai^=Bi;后：Ai=1；
 *
 * 当Ai=1;Bi=0;时：
 *
 * Ai^=Bi;后：Ai=1；
 *
 * Bi^=Ai;后：Bi=1；
 *
 * Ai^=Bi;后：Ai=0；
 *
 * 当Ai=0;Bi=1;时：
 *
 * Ai^=Bi;后：Ai=1；
 *
 * Bi^=Ai;后：Bi=0；
 *
 * Ai^=Bi;后：Ai=1；
 *
 * 当Ai=0;Bi=0;时：
 *
 * Ai^=Bi;后：Ai=0；
 *
 * Bi^=Ai;后：Bi=0；
 *
 * Ai^=Bi;后：Ai=0；
 *
 * 也就是说，对于a、b的每个bit位上的值，进行三次异或赋值运算之后，都会被交换，那么a、b值也就交换了。
 */
public class Mijingcode1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("a = " + a + " " + "b = " + b);
    }
}
