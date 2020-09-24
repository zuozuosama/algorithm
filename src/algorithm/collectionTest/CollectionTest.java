package algorithm.collectionTest;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();  // extends AbstractList implements List extends Collection
        Set<Integer> integers1 = new HashSet<>();  //extends AbstractSet implements Set extends Collection
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();  //extends AbstractMap implements Map
        integerIntegerHashMap.put(2,2);
    }
}
