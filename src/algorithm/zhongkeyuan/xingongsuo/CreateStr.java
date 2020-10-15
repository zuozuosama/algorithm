package algorithm.zhongkeyuan.xingongsuo;

import java.util.ArrayList;
import java.util.Random;

public class CreateStr {
    /**
     * 每100个随机字符分为一组，每组加入到List中
     */
    public void createStrArr() {
        ArrayList<String[]> list = new ArrayList<>(1000);
        String[] strings;
        for (int i = 0; i < 1000; i++) {
            strings = new String[100];
            for (int j = 0; j < 100; j++) {
                strings[j] = createRandomNumber(10);
            }
            list.add(strings);
        }
    }

    /**
     * 生成指定位数的随机数字
     *
     * @param length
     * @return
     */
    public static String createRandomNumber(int length) {
        StringBuffer number = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int randomNumber = new Random().nextInt(10);
            number.append(randomNumber);
        }
        return number.toString();
    }

}
