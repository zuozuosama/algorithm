package oldAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String str = "abcd13faeb";
        findFirst(str);
    }

    private static void findFirst(String str) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {
            map.put(split[i],map.getOrDefault(split[i],0)+1);
        }

        for (String key:map.keySet()){
            if(map.get(key)==1){
                System.out.println(key);
                break;
            }
        }
    }
}
