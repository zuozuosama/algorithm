package algorithm.kedaxunfei;

import java.util.Scanner;

public class Case4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int first = 0;
        for (int i = 0; i < input.toCharArray().length; i++) {
            char cur = input.charAt(i);
            if (cur >= '0' && cur <= '9') {
                if (first == 0 && cur > '0') {
                    sb.append(cur);
                    first++;
                }else if (first > 0){
                    sb.append(cur);
                }

            }
        }
        System.out.println(sb.toString());
    }
}
