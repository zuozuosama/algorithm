package oldAlgorithm;

import java.util.Scanner;

public class Squre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数:  ");
        int num = scanner.nextInt();
        System.out.println();
        for (int i = 1; i <= num * num; i++) {
            if (i % num== 0){
                System.out.println(i);
            }
            else{
                System.out.print(i + " ");
            }
        }
    }
}
