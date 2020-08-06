package oldAlgorithm.zhixingshunxun;

public class HelloB extends HelloA{
    public HelloB(){
        System.out.println("I am B class");
    }
    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}
