package oldAlgorithm.Algorithms;

/* 贪心算法 + 插入排序
 *
 * 题目：有一个饭店,有n张桌子,每张桌子可以招待不同数量的客人,且不能拼桌,现在来了m批客人,每批客人有两个属性,
 *
 * 一个是客人的总数,一个是他们消费(预计)的总额请设计一个算法,计算出,店家能够获得的最大利润。
 *
 * 我的思路很简单：将每批客人的消费金额，每批客人人数，桌子容量分别建立数组。按照金额从大到小将金额和人数同时排序，
 *
 * 桌子数组从小到大排序。对金额数组和人数数组同时遍历，对每一个金额再根据对应的客人数遍历桌子数组，
 *
 * 是否有满足的桌子，如果有满足的将该金额存入新建的收入数组，同时将该桌子容量设为0。最后输出收入数组，求出总金额。代码如下：
 *
 */

/*
    桌子数 = 3
    客人批次 = 5
    第1张桌子容纳量 = 2
    第2张桌子容纳量 = 4
    第3张桌子容纳量 = 2
    第1批客人数 = 1
    第1批客人消费金额 = 3
    第2批客人数 = 3
    第2批客人消费金额 = 5
    第3批客人数 = 3
    第3批客人消费金额 = 7
    第4批客人数 = 5
    第4批客人消费金额 = 9
    第5批客人数 = 1
    第5批客人消费金额 = 10
    客人的收入分别为：10
    客人的收入分别为：7
    客人的收入分别为：3
    总收入为：20

    3 5
    2 4 2
    1 3
    3 5
    3 7
    5 9
    1 10
    客人的收入分别为: 10
    客人的收入分别为: 7
    客人的收入分别为: 3
    总收入为：20
 */
import java.util.Scanner;

public class ExmDesk {

    /**
     * @param d 桌子容纳量
     * @param p 客人数量
     * @param c 客人消费金额
     * 1.忘了“桌子数组从小到大排序”的代码实现； 2.int sum=0; 改成long sum=0;
     */
    private void calculat(int[] d, int[] p, int[] c) {

        int[] in = new int[d.length]; //收入数组
        for (int i = 1, j; i < c.length; i++) {
            int temc = c[i];
            int temp = p[i];
            for (j = i; j > 0 && temc > c[j - 1]; j--)

            //采用插入排序
            //以金额数组递减顺序同时排序金额数组和人数数组
            {
                c[j] = c[j - 1];
                p[j] = p[j - 1];
            }
            c[j] = temc;
            p[j] = temp;
        }

        //对金额数组和人数数组同时遍历，对每一个金额再根据对应的客人数遍历桌子数组
        int k = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (p[i] <= d[j]) {
                    in[k] = c[i];
                    k++;
                    d[j] = 0;
                    break;
                }
            }
        }
        int sum = 0;
        for (int i : in) {
            sum += i;
            System.out.println("客人的收入分别为: " + i);
        }
        System.out.println("总收入为：" + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[n]; //桌子
        int[] p = new int[m]; //客人数
        int[] c = new int[m]; //客人消费金额

        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        ExmDesk ek = new ExmDesk();
        ek.calculat(d, p, c);

    }
}
