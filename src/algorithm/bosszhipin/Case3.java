package algorithm.bosszhipin;

import java.util.Arrays;

public class Case3 {
    public int[] calculateStatistics (int[] dataArr) {
        // write code here
        int length = dataArr.length;
        Arrays.sort(dataArr);
        int[] res = new int[4];
        res[0]=dataArr[(length-1)/2];
        res[1]=dataArr[0];
        res[2]=dataArr[length-1];
        res[3]=dataArr[(int) (length*0.9)-1];
        return res;
    }
}
