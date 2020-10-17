package algorithm.ziguang;

public class Case1 {
//    public static void main(String[] args) {
//        StringBuilder a = new StringBuilder("A");
//        StringBuilder b = new StringBuilder("B");
//        operator(a,b);
//        System.out.println(a+","+b);
//    }

    private static void operator(StringBuilder x, StringBuilder y) {
        x.append(y);
        y=x;
    }

    public int add(int a,int b){
        try {
            return a+b;
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }
        return 0;
    }

    public static void main(String[] args) {
        Case1 case1 = new Case1();
        System.out.println("和是"+case1.add(9,34));
    }
}
