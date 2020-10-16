package algorithm.bosszhipin;

import java.util.ArrayList;

/**
 * "While there is life,there is hope."
 * ["hope","here"]
 * <p>
 * 输出：
 * ["here","here","hope]
 */
public class Case2 {
    public ArrayList<String> filterSensitiveWords(String content, String[] sensitiveWords) {
        int[] index = new int[sensitiveWords.length];
        ArrayList<String> res = new ArrayList<>();
        while (true) {
            for (int i = 0; i < sensitiveWords.length; i++) {
                String cur = sensitiveWords[i];
                index[i] = content.indexOf(cur);
            }
            int minIndex = findMinIndex(index);
            if (minIndex == -1) {
                break;
            }
            int minLength = sensitiveWords[minIndex].length();
            content = content.substring(index[minIndex] + minLength);
            res.add(sensitiveWords[minIndex]);
        }
        return res;

    }

    private int findMinIndex(int[] index) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < index.length; i++) {
            if (index[i] < minValue && index[i] >= 0) {
                minValue = index[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Case2 case2 = new Case2();
        String[] sensitiveWords = {"hope", "here", "is"};
        ArrayList<String> strings = case2.filterSensitiveWords("While there is life,there is hope.", sensitiveWords);
        System.out.println(strings);
    }

}
