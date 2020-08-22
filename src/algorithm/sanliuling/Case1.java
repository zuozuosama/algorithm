package algorithm.sanliuling;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String blank = sc.nextLine();
        int sum=0;
        for (int i = 0; i < n; i++) {
            String wjName = sc.nextLine();
            if (isValid(wjName)) sum++;
        }
        System.out.println(sum);
    }

    public static boolean isValid(String wjName){
        Pattern p = Pattern.compile("[0-9]");
        Matcher matcher = p.matcher(wjName);
        return wjName.length()<=10&&!wjName.contains("_")&&!matcher.find();
    }

}
