package algorithm.tonghuashun;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Case2 {

    public static void main(String[] args) throws Exception {
        //声明Integer的泛型ArrayList对象，并放入Integer实例
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(new Integer(5));
        intList.add(7);
        //定义需要被加入list对象的字符串
        String str = "abc";
        //通过反射获取list对象运行时的add方法，此时该方法已经被擦除泛型
        Method m = intList.getClass().getMethod("add", java.lang.Object.class);
        //调用泛型方法加入String对象
        m.invoke(intList, str);
        //打印结果：[5, 7, abc]
        System.out.println(intList);
        for (Object obj : intList)
            System.out.println(obj.getClass());
		/*打印结果：
		class java.lang.Integer
		class java.lang.Integer
		class java.lang.String*/
    }

}
