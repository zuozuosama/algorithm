package algorithm.wenjingkeji;

//给定一个数据库表，abc, 字段定义为：学生id（int），学生姓名（String），考试科目（String），考试成绩（int），所属学期（String）
//其中，科目的取值范围为：数学，英语，语文
//写一个sql，找到所有一年级的小朋友当中，过去两个学期（一年级上学期、一年级下学期）当中，
// 所有单科成绩都大于90分，且每学期总成绩大于280分的学生
//
//
//
//SELECT  name,sum(kemu) scoreSum FROM abc WHERE xueqi = '一年级上学期' or xueqi = '一年级下学期'
// and name in (select name from (SELECT name,count(1) count  FROM abc WHERE xueqi = '一年级上学期'
// or xueqi = '一年级下学期' and subject > 90 group by id having count =6) a )  group by xueqi having scoreSum > 280

//// 给定一个数组，类似【8，13，-50，1，16，0，-33，180，-380，11】
//// 写一个函数，以给定数组作为输入，返回 Max（Sum（sub1）+ Sum（sub2））
//// [-20,-12,-2,-8,-200]
public class ThreeMeet {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(nums[i], res);
        }
        return res;
    }
// 100, -5, 20

    public int maxSub(int[] arr){
        int left = 0;
        int right = arr.length-1;
        int max=0;
        while (left<=right){
            int[] l=new int[left+1];
            int[] r = new int[right-left];

            //复制arr的数到l和r中
            int lsum = maxSubArray(l);
            int rsum = maxSubArray(r);
            max = Math.max(max,lsum+rsum);
            left++;
        }
        return max;
    }
}
