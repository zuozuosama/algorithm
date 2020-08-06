package solution.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanString {
    public int romanToInt(String s) {
        int ret = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int cur = map.get(chars[i]);
            if (i - 1 >= 0){
                int pre = map.get(chars[i - 1]);
                if (cur > pre){
                    ret += cur - pre * 2;
                }else {
                    ret += cur;
                }
            }else {
                ret += cur;
            }
        }
        return ret;
    }

    @Test
    public void test1(){
        String s = "MCMXCIV";
        int res = romanToInt(s);
        System.out.println(res);
    }

    @Test
    public void test2(){
        String s = "LVIII";
        int res = romanToInt(s);
        System.out.println(res);
    }
}
