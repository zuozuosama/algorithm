package dataStructure.construct;

public class Father {
    public int a;

    public void method(){
        System.out.println("父类方法");
    }

    static {
        System.out.println("父静态代码块");            //1
    }

    {
        System.out.println("父构造代码块");            //3
    }

    Father() {
        System.out.println("父构造方法");              //4

    }

    public static void main(String[] args) {
        //静态只会执行一次，在首次加载进内存时候就执行了
//        Son son = new Son(2);
//        Son son1 = new Son(3);
        Father father=new Son(4);
        System.out.println(father.a);
//        father.method1();
//        son1.method();
//        System.out.println(son1.a);
        father.method();
    }
}