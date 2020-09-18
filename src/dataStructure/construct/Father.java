package dataStructure.construct;

public class Father {

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
        Son son = new Son(2);
        Son son1 = new Son(3);
    }
}