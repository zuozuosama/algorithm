package algorithm.hose;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        //foreach不能使用break和continue，只能使用return等价于continue跳出当前循环
        //forEach()本身无法跳出循环，必须遍历所有的数据才能结束。
        integers.forEach(it -> {
            System.out.println(it);
            if (it > 1) return;
            System.out.println(it + "break");
        });
    }
}
