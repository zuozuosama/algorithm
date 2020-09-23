package algorithm.singleTon;

/**
 * 枚举实现单例模式，懒汉式
 */
public class SingleTonDemo5 {

    private SingleTonDemo5(){};

    enum singleTonEnum {
        INSTANCE;

        singleTonEnum() {
            singleTonDemo5 = new SingleTonDemo5();
        }

        private SingleTonDemo5 singleTonDemo5;

        public SingleTonDemo5 getInstance() {
            return singleTonDemo5;
        }
    }

    public static SingleTonDemo5 getInstance() {
        return singleTonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        System.out.println(SingleTonDemo5.getInstance());
    }
}
