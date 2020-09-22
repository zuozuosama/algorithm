package algorithm.singleTon;

/**
 * 懒汉式
 */
public class SingleTonDemo2 {
    private static SingleTonDemo2 instance;

    public static synchronized SingleTonDemo2 getInstance() {
        if (instance == null) instance = new SingleTonDemo2();
        return instance;
    }
}
