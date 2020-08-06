package oldAlgorithm.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。例如，在字符串中”arabcacfr”，最长非重复子字符串为”acfr”，长度为4。
 */
public class LongestSingleSubstring {
    public static void main(String[] args) {
        int num = lengthOfLongestSubstring("arabcacfr");
        System.out.println("最长的子字符串长度为：" + num);
    }

    private static int findLongestSubstringLength(String string) {
        if (string == null || string.equals("")) return 0;
        int maxLength = 0;
        int curLength = 0;
        int[] positions = new int[26];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = -1; //初始化为-1，负数表示没出现过
        }
        for (int i = 0; i < string.length(); i++) {
            int curChar = string.charAt(i) - 'a';
            int prePosition = positions[curChar];
            //当前字符与它上次出现位置之间的距离
            int distance = i - prePosition;
            //当前字符第一次出现，或者前一个非重复子字符串中没有包含当前字符
            if (prePosition < 0 || distance > curLength) {
                curLength++;
            } else {
                //更新最长非重复子字符串的长度
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = distance;
            }
            positions[curChar] = i; //更新字符出现的位置
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // 记录字符上次出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        // 记录每次不含重复字符的子字符串
        List<String> list = new ArrayList<>();
        int max = 0;
        // 最近出现重复字符的位置
        int pre = -1;

        for (int i = 0, strLen = str.length(); i < strLen; i++) {
            Character ch = str.charAt(i);
            Integer index = map.get(ch);
            if (index != null)
                pre = Math.max(pre, index);
            max = Math.max(max, i - pre);
            map.put(ch, i);
            list.add(str.substring(pre+1,i+1));
        }

        for (String sub:list){
            if (sub.length() == max){
                System.out.println("最长的子字符串为：" + sub);
            }
        }
        return max;
    }
}
