package algorithm.dahua;

/**
 * 一堆香蕉，分成五份剩一个，第一个人吃掉剩下那个，拿走一份。。。5个人最少需要多少个香蕉
 */
public class Case2 {

    private static int m = 0;//总香蕉数

    public static void main(String[] args) {
        int m = part(1, 1);
        System.out.println(m);
    }

    public static int part(int n, int k) {
        if ((n % 5 == 1) && k <= 5) {
            if (k == 5) {
                return m;
            }
            k++;
            //下一个人吃掉一个拿走一份
            return part((n - 1) / 5 * 4, k);
        } else {
            //不满足一直递增
            m++;
            return part(m, 1);
        }
    }




}
