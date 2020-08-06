package oldAlgorithm.Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 贪心算法举例
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，
 * 当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，
 * 使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //巧克力的数量
        System.out.print("请输入巧克力的数量:");
        int n = sc.nextInt();
        System.out.println();
        int[] w = new int[n];
        for (int i = 0; i < w.length; i++) {
            w[i] = sc.nextInt();//给每块巧克力的重量赋值
        }
        //孩子的数量
        System.out.print("请输入孩子的数量:");
        int m = sc.nextInt();
        System.out.println();
        int[] h = new int[m];
        for (int i = 0; i < h.length; i++) {
            h[i] = sc.nextInt(); //每个孩子想要的巧克力的重量
        }
        //对w,h进行排序
        Arrays.sort(w);
        Arrays.sort(h);
        System.out.println("巧克力重量排序后：" + Arrays.toString(w));
        System.out.println("孩子想要的巧克力重量排序后：" + Arrays.toString(h));
        int count = 0; //记录发的巧克力数量
        int student = 0; //记录做比较的是第几个学生
        for (int i = 0; i < w.length; i++) {
            if (w[i] < h[student]){
                continue;
            }
            count++;
            student++;
            if (student == m){
                break;
            }
        }
        System.out.println("获得巧克力的孩子数量：" + count);
    }
}
