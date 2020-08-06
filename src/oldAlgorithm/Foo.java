package oldAlgorithm;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Foo {
    public static void main(String[] args) {
        //System.out相当于输出的路径 PrintWriter像BufferedWriter包装类,PrintWriter独特的地方只是带有自己特有的
        //println和print方法
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out),true);
        out.println("李宗奇");

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("李宗奇");
        printWriter.close();
    }
}
