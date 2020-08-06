package oldAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串查询工具类
 */
public class StringUtilsExt {
    /**
     *
     * @param source 源字符串
     * @param prefix 开头字符串
     * @param postfix 结尾字符串
     * @return 在source中所有以prefix开头并且以postfix结尾的字符串
     */
    public static List<String> findSubString(String source,String prefix,String postfix){
        List<String> list = new ArrayList<>();
        while (!"".equals(source)){
            System.out.println("substring:  "+ source);
            int start = source.indexOf(prefix);
            int end = source.indexOf(postfix);
            System.out.println("start: " + start + "end: " + end);
            if (start==-1||end==-1){
                break;
            }
            if (end<start){
                source = source.substring(end+postfix.length());
            }else {
                String substring1 = source.substring(start, end + postfix.length());
                list.add(substring1);
                System.out.println("查找的字符串：" + substring1);
                source = source.substring(end+postfix.length());
            }
        }
        return list;
    }

    /**
     * 两种构造字符串的方式
     */
    public static void construct(){
        byte[] bytes = "abcde".getBytes();//[97, 98, 99, 100, 101
        String s = new String(bytes, 2, 3);
        System.out.println("bytes构造：" + s);
        char[] chars = "abcde".toCharArray();
        String s1 = new String(chars, 0, chars.length);
        System.out.println("char数组构造：" + s1);
    }

    public static void main(String[] args) {
//        String str = "\"{\"TaxCode\":\"91321000071018179B\",\"RetMsg\":\"1011-XXX开启成功[0000,]\"," +
//                "\"MachineNo\":\"0\",\"TaxClock\":\"2016-11-02 11:21:30\",\"RetCode\":\"1011\"," +
//                "\"IsInvEmpty\":\"0\",\"CorpName\":\"XXXX分公司\",\"CheckCode\":\"661XXX4681\"," +
//                "\"IsLockReached\":\"0\",\"InvLimit\":\"0.0\",\"IsRepReached\":\"0\"}ax\"";
//        List<String> list = findSubString(str, "ax", "de");
//        System.out.println(list);
        construct();
    }
}
