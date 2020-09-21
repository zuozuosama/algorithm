package algorithm.dahua;

/**
 * 五猴子粉桃问题 java经典四十题
 */
public class Case1 {

    //非递归方式
    public static int part() {
        int lastPart = 1; //最后那只猴子拿到的那份桃子数，
        int onePart = 0; //通过最后那份桃子推理出第一份的桃子数，
        int count = 1; //循环的次数，设置为条件。一共要循环4次
        while (count < 5) {
            onePart = lastPart;
            for (int i = 0; i < 4; i++) {
                int allPeach = onePart * 5 + 1; //假设第i次桃子的总数 ,从第五次开始
                if (allPeach % 4 != 0) //如果不能整除4就不能推理出上次桃子的分数，叠加桃子数重新开始循环
                {
                    lastPart++;
                    count = 1; //循环计数器次数重置为1
                    break;
                }
                onePart = allPeach / 4; //可以求出上次桃子的个数
                count++; //叠加计数器

            }
        }

        return onePart * 5 + 1;
    }

    public static void main(String[] args) {
        System.out.println(part());
    }

}

