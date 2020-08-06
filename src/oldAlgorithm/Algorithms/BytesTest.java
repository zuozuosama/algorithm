package oldAlgorithm.Algorithms;

import java.io.UnsupportedEncodingException;

public class BytesTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("中".getBytes("UTF-8").length);
        System.out.println("中".getBytes("GBK").length);
        System.out.println("中".getBytes("unicode").length);
        System.out.println("中".getBytes().length);
    }
}
