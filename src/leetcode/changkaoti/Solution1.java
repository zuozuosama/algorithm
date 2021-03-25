package leetcode.changkaoti;

import java.util.Scanner;

/**
 * 字符串转数字
 */
class Solution1 {
    public int strToInt(String str) {
        str = str.trim();
        char[] ch = str.toCharArray();
        boolean minus = false;
        int index = 0;
        long res = 0;
        if (ch[0] == '-' || ch[0] == '+' || Character.isDigit(ch[0])) {
            if (ch[0] == '-' || ch[0] == '+') {
                if (ch[0] == '-') minus = true;
                index++;
            }
            while (index < ch.length && Character.isDigit(ch[index])) {
                res *= 10;
                res += ch[index] - '0';
                if (res > Integer.MAX_VALUE) { //因为"-2147483647"，所以不能大于等于"-2147483647"
                    return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                index++;
            }
        }
        return minus ? -(int) res : (int) res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.strToInt(line));
    }
}
