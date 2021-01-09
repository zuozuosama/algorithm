package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public int[] MergeList(int a[],int b[]){
        int[] newArr = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            newArr[i]=a[i];
        }
        for (int i = a.length; i < newArr.length; i++) {
            newArr[i]=b[i-a.length];
        }
        Arrays.sort(newArr);
        return newArr;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("a",1);
        stringIntegerHashMap.put("a",2);
        System.out.println(stringIntegerHashMap);
    }

}
