package algorithm.hose;

import org.junit.Test;

import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        //foreach不能使用break和continue，只能使用return等价于continue跳出当前循环
//        //forEach()本身无法跳出循环，必须遍历所有的数据才能结束。
//        integers.forEach(it -> {
//            System.out.println(it);
//            if (it > 1) return;
//            System.out.println(it + "break");
//        });


//        String[] a={"request","signature","rea"};
//        Arrays.sort(a);
//        System.out.println(Arrays.asList(a));

        TreeSet<String> strings = new TreeSet<>();
        strings.add("request");
        strings.add("signature");
        strings.add("rea");
        System.out.println(strings);
    }

    @Test
    public void d() {
        Integer a = 128;
        Integer b = 128;
        Integer c = Integer.valueOf(128);
        Integer d = Integer.valueOf(128);
        System.out.println(c == d);
        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}
