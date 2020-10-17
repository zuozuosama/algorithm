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

//    父静态代码块
//    子静态代码块
//    父构造代码块
//    父构造方法
//    子构造代码块
//    子构造方法
//    父构造代码块
//    父构造方法
//    子构造代码块
//    子构造方法
//    父构造代码块
//    父构造方法
//    子构造代码块
//    子构造方法
    public static void main(String[] args) {
        //静态只会执行一次，在首次加载进内存时候就执行了
        Son son = new Son();
        Son son1 = new Son();
        Father father=new Son();
//        System.out.println(father.a);
//        father.method1();
//        son1.method();
//        System.out.println(son1.a);
//        father.method();
    }
}