package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName GenericWildcard
 * @Description TODO
 * @Author lizq9
 * @Date 2022/1/18 13:25
 */
public class GenericWildcard {

    // public static <T> void test(T... arg) {
    //     List<T> list = Stream.of(arg[0]).flatMap(x->Arrays.stream(x)).collect(Collectors.toList());
    //     System.out.println(list.get(0));
    //     System.out.println(list.get(1));
    // }

    public static void main(String[] args) {
        // int[] a = new int[]{1, 3};
        // test(a);

        List<List<Integer>> b = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        b.add(integers);
        //扁平化流
        List<Integer> collect = b.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect); //[1,2]
    }
}
