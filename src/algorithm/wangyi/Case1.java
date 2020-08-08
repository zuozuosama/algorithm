package algorithm.wangyi;

import java.util.Scanner;

public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            int m = a[i];
            res += (m / 2);
//            if (m>>1==0){
//                res+=(m/2);
//            }else {
//
//            }
//            while (m >= 2) {
//                m -= 2;
//                res++;
//            }
        }
        System.out.println(res);
    }
}
