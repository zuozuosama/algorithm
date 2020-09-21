package algorithm;

public class StringTest {
    public static void main(String[] args) {
        String a = "test";
        String b = "test";
        System.out.println(a==b);

        // 两个。第一个对象是字符串常量"xyz" 第二个对象是new String("xyz")的时候产生的，
        // 在堆中分配内存给这个对象，只不过这个对象的内容是指向字符串常量"xyz"
        // 另外还有一个引用s，指向第二个对象。这是一个变量，在栈中分配内存。。
        String c = new String("test"); //这句创建了几个String Object

        String d = new String("test");
        System.out.println(a==c);
        System.out.println(c==d);
    }
}
