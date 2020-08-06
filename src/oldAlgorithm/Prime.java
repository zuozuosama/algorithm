package oldAlgorithm;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入上限数字： ");
        int n = scanner.nextInt();
        System.out.print("请输入下限数字： ");
        int m = scanner.nextInt();
        System.out.println();
        printPrime(n,m);
    }

    private static void printPrime(int lower,int upper) {
        int count = 0;
        for (int i=lower;i<=upper;i++){
            if (judgePrime(i)){
                System.out.print(i+" ");
                count++;
            }
            if (count==10){
                System.out.println();
                count=0;
            }
        }
    }

    private static boolean judgePrime(int num) {
        if (num==1){
            return false;
        }
        if (num==2){
            return true;
        }else {
            for (int i = 2; i < num; i++) {
                if (num % i==0){
                    return false;
                }
            }
        }
        return true;
    }
}
