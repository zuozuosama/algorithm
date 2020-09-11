package algorithm.tonghuashun;

public class Case1 {
    public static void printNotContainFive(){
        for (int i = 1; i <= 90; i++) {
            String s = String.valueOf(i);
            if (!s.contains("5")){
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        printNotContainFive();
    }
}
