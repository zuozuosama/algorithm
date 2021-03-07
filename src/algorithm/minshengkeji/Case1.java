package algorithm.minshengkeji;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 5
 * 30 20 40 50 91 物品价格
 * 1  2  1  2  3 物品第一种属性
 * 2  1  3  2  1 物品第二种属性
 * 6 六个人来选商品希望每个人都选到某种属性下最低价格的商品，如果商品选完则输出-1
 * 2  3  1  2  1  1
 *
 * 每种物品的属性都有三种 1 2 3
 *
 * 输出：
 * 20 40 30 50 91 -1
 *
 */
public class Case1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        int[] fp = new int[n];
        int[] sp = new int[n];

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            p[i] = a;
        }
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            fp[i] = a;
        }
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            sp[i] = a;
        }
        int m = in.nextInt();
        int[] e = new int[m];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            e[i] = a;
        }
        LinkedList[] lists = new LinkedList[3];
        for (int i = 0; i < n; i++) {
            int v = fp[i];
            int c = sp[i];
            if (lists[v - 1] == null || lists[c - 1] == null) {
                lists[v - 1] = new LinkedList<Integer>();
                lists[c - 1] = new LinkedList<Integer>();
            }
            lists[v - 1].add(p[i]);
            lists[c - 1].add(p[i]);
        }

        for (int i = 0; i < 3; i++) {
            Collections.sort(lists[i]);
        }
        for (int i = 0; i < m; i++) {
            if (lists[e[i] - 1].isEmpty()){
                System.out.println(-1);
                break;
            }
            System.out.print(lists[e[i] - 1].getFirst() + " ");
            lists[e[i] - 1].removeFirst();
        }
    }
}
