package algorithm.qianxin;

import java.util.*;


public class Case1 {
    /**
     * @param num_money int整型 奖金的总数,单位为元
     * @return int整型
     */
    public static int CalulateMethodCount(int num_money) {
//        // write code here
//        if (num_money < 3) return num_money;
//        int p = 1, q = 2;
//        for (int i = 3; i <= num_money; i++) {
//            int temp = p + q;
//            p = q;
//            q = temp;
//        }
//        return q+1;

        if (num_money < 1) return 0;
        if (num_money == 1) {
            return 1;
        }
        return CalulateMethodCount(num_money - 1) * 2;

//        return (int)Math.pow(2,num_money-1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(CalulateMethodCount(n));
    }
}
