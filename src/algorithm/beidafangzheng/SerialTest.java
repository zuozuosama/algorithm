package algorithm.beidafangzheng;

import java.io.*;


public class SerialTest extends Serial implements Serializable {
    /**
     * 在序列化一个对象到文件时，下面哪个字段会被保存到文件中？
     *
     * static、transient修饰的变量不会被序列化
     */
    private int a; //只有a
    public static int b;
    transient int c;

    public static void main(String[] args) throws IOException {
        //以下哪种创建流方式是错误的
//        BufferedReader br = new BufferedReader(new FileInputStream("d.csv"));
//        ObjectInputStream ou = new ObjectInputStream(new FileInputStream("d.csv")); //序列化方法
    }
}
