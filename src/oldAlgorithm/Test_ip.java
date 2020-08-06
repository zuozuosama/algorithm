package oldAlgorithm;

//java
public class Test_ip {
    public static boolean test_ip(String str){
        // 1 首先检查字符串的长度 最短应该是0.0.0.0 7位 最长 000.000.000.000 15位
        if(str.length()<7 || str.length() >15) return false;    // 如果长度不符合条件 返回false

        // 2 尝试按.符号进行拆分     拆分结果应该是4段
        String[] arr = str.split("\\.");
        if( arr.length != 4 )    return false;    //如果拆分结果不是4个字串 返回false

        // 3 查看拆分到的每一个子字符串，应该都是纯数字
        for(int i = 0 ; i <4 ; i++ ){
            for(int j = 0; j<arr[i].length();j++){
                char temp = arr[i].charAt(j);
                if(!( temp>'0' && temp< '9' ) ) return false;    //如果某个字符不是数字就返回false
            }
        }

        // 4 对拆分结果转成整数 判断 应该是0到255之间的整数
        for(int i = 0 ; i<4;i++){
            int temp = Integer.parseInt( arr[i] );
            if( temp<0 || temp >255)    return false;    //如果某个数字不是0到255之间的数 就返回false
        }

        return true;
    }

    public static void main(String[] args) {
        String test_str = "256.34.56.67";
        boolean res = test_ip(test_str);
        System.out.println(res);
    }
}
