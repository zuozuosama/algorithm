package oldAlgorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTravel {
    public static void main(String[] args) {
        Map<String,Object> modelmap = new HashMap<>();
        modelmap.put("name","lisi");
        modelmap.put("password","123456");
        keySet(modelmap);
        entrySet(modelmap);
        iterator(modelmap);
    }

    private static void iterator(Map<String, Object> modelmap) {
        System.out.println("-----------------------------------迭代器遍历-------------------------------------");
        Iterator<Map.Entry<String, Object>> it = modelmap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Object> next = it.next();
            System.out.println("key:" +next.getKey() + "  value:" + next.getValue());
        }
    }

    private static void entrySet(Map<String, Object> modelmap) {
        System.out.println("-----------------------------------entryset遍历-------------------------------------");
        for (Map.Entry<String,Object> entry:modelmap.entrySet()){
            System.out.println("key:" + entry.getKey() + "  value:" + entry.getValue());
        }
    }

    private static void keySet(Map<String,Object> map) {
        System.out.println("-----------------------------------keyset遍历-------------------------------------");
        for (String key:map.keySet()){
            System.out.println("key:" + key + "  value:" + map.get(key));
        }
    }
    
    
}
