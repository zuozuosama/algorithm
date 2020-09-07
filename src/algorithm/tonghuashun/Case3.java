package algorithm.tonghuashun;

import java.util.Scanner;

public class Case3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        int length = t.length();
        for (char c : t.toCharArray()) {
            String cstr = String.valueOf(c);
            if (s.contains(cstr)){
                length--;
            }
        }
        if (length==0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
