package oldAlgorithm.Algorithms;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的全排列
 * 题目：{a,b,c}要求输出{abc,acb,bac,bca,cab,cba}。
 * 字符串全排列可以把字符串看成两个部分，第一个部分为它的一个字符，第二部分是后面的字符。
 * 分两步完成：首先求所有可能出现在第一个位置的字符，即把第一个字符与后面的所有字符交换。第二步固定第一个字符，
 * 求后面所有字符的排列。从中可以看出是典型的递归思路。
 */
public class Shuffle {
    public static ArrayList<String> Permutation(String str) {
        if (str == null) return null;
        //把字符串转化为数组
        char[] ins = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        DoPermutation(ins, 0, list);
        //按字典排序
        Collections.sort(list);
        return list;
    }

    private static void DoPermutation(char[] ins, int i, ArrayList<String> list) {
        if (ins == null) return;
        //如果i指向了最后一个字符
        if (i == ins.length - 1) {
            if (list.contains(String.valueOf(ins))) {
                return;
            }
            list.add(String.valueOf(ins));
        }
        //当i不指向最后一个时，i代表我们做排列操作的字符串的第一个字符
        else {
            for(int j=i;j<ins.length;j++) {
                swap(ins, i, j);//将第一个字符与后面的字符交换
                DoPermutation(ins, i + 1, list); //对后面的字符进行全排列
                swap(ins, j, i);//再将之前交换的字符交换回来，以便于第一个字符再与其他字符进行交换
            }
        }
    }

    /*交换*/
    private static void swap(char[] ins, int i, int j) {
        char tmp = ins[i];
        ins[i] = ins[j];
        ins[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "ahh";
        ArrayList<String> permutation = Permutation(str);
        System.out.println(permutation);
    }
}
