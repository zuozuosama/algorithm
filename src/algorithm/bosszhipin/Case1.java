package algorithm.bosszhipin;

import java.util.Arrays;

/**
 * ipArr去blackIpArr查看每个ip是否是黑名单ip
 */
public class Case1 {
    public boolean[] isBlackIp (String[] ipArr, String[] blackIpArr) {
        boolean[] res = new boolean[ipArr.length];
        Arrays.fill(res,false);
        // write code here
        for (int i = 0; i < ipArr.length; i++) {
            String cur = ipArr[i];
            for (int j = 0; j < blackIpArr.length; j++) {
                if (cur.equals(blackIpArr[j])){
                    res[i]=true;
                    break;
                }
            }
        }
        return res;
    }
}
