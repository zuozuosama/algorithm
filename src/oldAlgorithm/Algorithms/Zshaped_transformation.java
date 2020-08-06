package oldAlgorithm.Algorithms;

import java.util.ArrayList;
import java.util.List;

/*
    L   C   I   R
    E T O E S I I G
    E   D   H   N
 */
public class Zshaped_transformation {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        String convert = convert(str, 3);
        System.out.println(convert);

    }
}
