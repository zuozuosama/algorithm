package oldAlgorithm;

import java.util.*;

/**
 * HashSet
 * 底层数据结构是哈希表。(无序,唯一)
 * 如何来保证元素唯一性?
 * 1.依赖两个方法：hashCode()和equals()
 *
 * LinkedHashSet
 * 底层数据结构是链表和哈希表。(FIFO插入有序,唯一)
 * 1.由链表保证元素有序
 * 2.由哈希表保证元素唯一
 *
 * TreeSet
 * 底层数据结构是红黑树。(唯一，有序)
 */
public class SetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        //数组和List之间相互转换
        List<String> list = Arrays.asList("E", "B", "A", "D", "C");
        System.out.println("list: " + list);
        String[] strings = list.toArray(new String[list.size()]);
        System.out.println("数组: " + Arrays.toString(strings));
        List<String> list1 = Arrays.asList(strings);
        System.out.println("数组转为list: " + list1);

        for(String ele: Arrays.asList("E","B","A","D","C")){
            hashSet.add(ele);
            linkedHashSet.add(ele);
            treeSet.add(ele);
        }
        System.out.println("A".hashCode());
        System.out.println(Objects.hashCode("A"));
        System.out.println("order in hashset:" + hashSet);//不保证有序
        System.out.println("order in linkedhashset:"+linkedHashSet);//FIFO保证安装插入顺序排序
        System.out.println("order in treeset:"+treeSet);//内部实现排序

        /*order in hashset:[A, B, C, D, E]
        order in linkedhashset:[E, B, A, D, C]
        order in treeset:[A, B, C, D, E]*/
    }
}
