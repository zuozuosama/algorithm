package algorithm.jinghangtianli;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {

    /**
     * 直接在代码中抛出
     *
     * @throws FileNotFoundException
     */
    public void test() throws FileNotFoundException {
        FileReader fr = new FileReader(new File("test.csv"));
    }

    /**
     * catch抓取异常，finally写一定要执行的代码（如流的关闭）
     */
    public void test1() {
        FileReader fr = null;
        try {
            fr = new FileReader(new File("test.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * throw 用来抛出运行期异常
     */
    public void test2() {
        int a = 3;
        int b = 0;
        try {
            int i = a / b;
        } catch (Exception e) {
            throw new RuntimeException("有异常");
        }
    }
}
