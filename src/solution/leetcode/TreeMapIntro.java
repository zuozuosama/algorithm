package solution.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
public class TreeMapIntro {
    /**
     *
     */
    @Test
    public void test_hashmap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("d", "ddd");
        map.put("b", "bbb");
        map.put("a", "aaa");
        map.put("c", "ccc");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println("map.get(key) is :" + map.get(key));
        }
    }

    @Test
    public void test_hashtable(){
        // 定义HashTable,用来测试
        Hashtable<String, String> tab = new Hashtable<String, String>();
        tab.put("d", "ddd");
        tab.put("b", "bbb");
        tab.put("a", "aaa");
        tab.put("c", "ccc");
        Iterator<String> iterator_1 = tab.keySet().iterator();
        while (iterator_1.hasNext()) {
            Object key = iterator_1.next();
            System.out.println("tab.get(key) is :" + tab.get(key));
        }
    }

    /**
     * 基于红黑二叉树的NavigableMap的实现
     * 继承AbstractMap类，内部有比较器comparator，底层是红黑树实现，适用于排序
     */
    @Test
    public void test_treemap(){
        TreeMap<String, String> tmp = new TreeMap<String, String>();
        tmp.put("d", "ddd");
        tmp.put("b", "bbb");
        tmp.put("a", "aaa");
        tmp.put("c", "ccc");
        Iterator<String> iterator_2 = tmp.keySet().iterator();
        while (iterator_2.hasNext()) {
            Object key = iterator_2.next();
            System.out.println("tmp.get(key) is :" + tmp.get(key));
        }
    }
}
