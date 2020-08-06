package solution.my;

import java.io.PrintStream;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        /**
         * 需要在method方法执行后，仅打印a=100,b=200 请写出method方法的代码
         */
//        method(a, b);
        method1(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    private static void method1(int a, int b) {
        PrintStream printStream = new PrintStream(System.out) {
            @Override
            public void print(String s) {
                super.print(s.replace("10", "100"));
            }
        };
        System.setOut(printStream);
    }

    private static void method(int a, int b) {
        System.out.println("a=" + a * 10 + "," + "b=" + b * 20);
        System.exit(0);
    }


}
