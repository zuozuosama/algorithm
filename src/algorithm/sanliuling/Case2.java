package algorithm.sanliuling;

import java.util.Arrays;
import java.util.Scanner;

public class Case2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] data = new int[n];
        String blank = sc.nextLine();
        int[] t = new int[m];
        for (int i = 0; i < m; i++) {
            int temp = sc.nextInt();
            t[i]=temp;
        }
        for (int i = 0; i <n; i++) {
            data[i]=i+1;
        }
        for (int i = 0; i < t.length; i++) {
            process(data,t[i]);
        }
        System.out.println(Arrays.toString(data));
    }

    public static void process(int[] data,int a){
        if (a==1){
            for (int i = 0; i < data.length-2; i++) {
                for (int j=i;j<data.length-2;j++){
                    int p=data[j];
                    data[j]=data[j+1];
                    data[j+1]=p;
                }
            }
        }else if (a==2){
            for (int i = 0; i <data.length; i=i+2) {
                int b=data[i];
                data[i]=data[i+1];
                data[i+1]=b;
            }
        }
    }
}
