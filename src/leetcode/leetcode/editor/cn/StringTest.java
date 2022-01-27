package leetcode.leetcode.editor.cn;

/**
 * @ClassName StringTest
 * @Description TODO
 * @Author lizq9
 * @Date 2022/1/21 14:41
 */
public class StringTest {

    public static void a() {
        String a = "1";
        b(a);
        // a = "3";
        System.out.println(a);
    }

    public static void b(String a) {
        a = "2";
    }

    public static void c() {
        StringBuilder a = new StringBuilder("1");
        StringBuilder b = new StringBuilder("2");
        d(a, b);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }

    public static void d(StringBuilder a, StringBuilder b) {
        a.append("2");
        b = a;
    }

    public static void main(String[] args) {
        // a();
        c();
    }
}
