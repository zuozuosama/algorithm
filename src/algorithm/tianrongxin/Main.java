package algorithm.tianrongxin;

import java.util.Scanner;

/**
 * 输入：
 * 34567yuw
 * <p>
 * 输出：
 * 英文字母: 3
 * 空格: 0
 * 数字: 5
 * 其它字符: 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int qita = 0;
        int eng = 0;
        int blank = 0;
        int num = 0;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') num++;
            else if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z') eng++;
            else if (c == ' ') blank++;
            else qita++;
        }
        System.out.println("英文字母: " + eng);
        System.out.println("空格: " + blank);
        System.out.println("数字: " + num);
        System.out.println("其它字符: " + qita);
    }
}
