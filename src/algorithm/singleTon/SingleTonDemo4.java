package algorithm.singleTon;

/**
 * 懒汉式
 * 静态内部类实现模式（线程安全，调用效率高，可以延时加载）
 */
public class SingleTonDemo4 {
    private static class SingleTonDemo4Ins {
        private static final SingleTonDemo4 instance = new SingleTonDemo4();
    }

    public static SingleTonDemo4 getInstance() {
        return SingleTonDemo4Ins.instance;
    }
}
