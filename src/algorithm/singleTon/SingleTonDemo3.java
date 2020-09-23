package algorithm.singleTon;

/**
 * 懒汉式
 * Double CheckLock实现单例：DCL也就是双重锁判断机制（由于JVM底层模型原因，偶尔会出问题，不建议使用）：
 */
public class SingleTonDemo3 {
    private static volatile SingleTonDemo3 instance;

    public static SingleTonDemo3 getInstance() {
        if (instance == null) {
            synchronized (SingleTonDemo3.class) {
                if (instance == null) {
                    instance = new SingleTonDemo3();
                }
            }
        }
        return instance;
    }
}
