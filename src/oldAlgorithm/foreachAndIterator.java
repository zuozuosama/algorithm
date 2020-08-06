package oldAlgorithm;

import java.util.*;

public class foreachAndIterator {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("arraylist1");
        arrayList.add("arraylist2");
        arrayList.add("arraylist3");
        //运用Collections工具类一次性添加
        Collections.addAll(arrayList,"arraylist4","arraylist5","arraylist6");
        System.out.println("arraylist:"+arrayList);
        System.out.println("==============================迭代器遍历===============================");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("==============================foreach遍历===============================");
        //会发生异常，因为集合类型遍历是用迭代器实现的，
//        for (String s : arrayList) {
//            if ("arraylist1".equals(s)){
//                arrayList.remove(s);
//            }
//        }

        //删除元素的正确做法
        for (int i = 0;i < arrayList.size();i++){
            String s = arrayList.get(i);
            if ("arraylist1".equals(s)){
                arrayList.remove(s);
                i--;
            }
        }

        System.out.println(arrayList);
//
//        List<String> linkedList = new LinkedList<String>();
//        linkedList.add("linkedlist1");
//        linkedList.add("linkedlist2");
//        linkedList.add("linkedlist3");
//
//        System.out.println("==============================迭代器遍历===============================");
//        Iterator<String> iterator1 = linkedList.iterator();
//        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
//
//        System.out.println("==============================foreach遍历===============================");
//        for (String str:linkedList){
//            System.out.println(str);
//        }
    }
}
