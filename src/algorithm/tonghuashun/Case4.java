package algorithm.tonghuashun;

//给定一年中经过的秒数，计算年月日时分秒，并转为Date类型
public class Case4 {
    public void pr(long second){
        long days=second/60/60/24;
        int month=(int)days/30;
        int daynum=(int)days%30;

    }
}
