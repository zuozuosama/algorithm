package algorithm.jvm;

public class StaticTest1 {
    private static String msg = null;

    // static 能保证可见性？ 因为String在方法区每次会写进线程共享区，所以可以线程共享
    static void enable() {
        new Thread(() -> {
            while (true) {
                msg = "T1";
                if (!"T1".equals(msg)) {
                    System.out.println("T1 break");
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                msg = "T2";
                if (!"T2".equals(msg)) {
                    System.out.println("T2 break");
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        enable();
    }
}
