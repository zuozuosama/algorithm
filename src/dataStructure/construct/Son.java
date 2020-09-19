package dataStructure.construct;

public class Son extends Father{
    public int a = 1;

    public void method(){
        System.out.println("子类方法");
    }

    public void method1(){
        System.out.println("子类方法");
    }

    static {
        System.out.println("子静态代码块");            //2
    }
    {
        System.out.println("子构造代码块");            //5
    }
    Son(){
        System.out.println("子构造方法");              //6
    }

    public Son(int a){
        this.a=a;
        System.out.println("a=" + a);
    }
}
