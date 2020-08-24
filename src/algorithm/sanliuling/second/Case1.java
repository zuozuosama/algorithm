package algorithm.sanliuling.second;

import java.util.ArrayList;
import java.util.Scanner;

public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<String> strings = new ArrayList<>();

        int a = 0;
        int b = 0;
        String substring = "";

        b = input.indexOf('n', a);
        substring = input.substring(a, b);
        strings.add(substring);
        a = b;

        while (b>0) {
            b = input.indexOf('n', a + 1);
            if (b<0){
                substring = input.substring(a);
                strings.add(substring);
                break;
            }
            substring = input.substring(a, b);
            strings.add(substring);
            a = b;
        }
        for (String out : strings) {
            out=out.substring(0,1).toUpperCase()+out.substring(1);
            System.out.println(out);
        }
    }
}
