package algorithm.dunhuangwang;

public class Y {

    Y() {
        System.out.println("Y构造方法");
    }

    void print() {
        System.out.println("我是Y");
    }

    public static void main(String[] args) {
        Y y = new Y();
        y.print();
        y = new X();
        y.print();
        X x = new X();
        x.print();

        Integer a = new Integer(1000);
        Integer c = 1000;
        int b = 1000;
        System.out.println(a == c);
        System.out.println(c == b);
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
