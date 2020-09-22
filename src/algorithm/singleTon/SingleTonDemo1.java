package algorithm.singleTon;

/**
 * 饿汉式
 */
public class SingleTonDemo1 {
    private static SingleTonDemo1 instance = new SingleTonDemo1();

    public static SingleTonDemo1 getInstance(){
        return instance;
    }
}
