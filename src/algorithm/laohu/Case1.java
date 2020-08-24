package algorithm.laohu;

import java.util.*;


/**
 *
 */
public class Case1 {
//    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//    /**
//     * 合适的股票每手价格组合
//     * @param prices int整型一维数组 股票数量
//     * @param m int整型 资产值
//     * @return int整型ArrayList<ArrayList<>>
//     */
//    public ArrayList<ArrayList<Integer>> combinationSum (int[] prices, int m) {
//        // write code here
//        ArrayList<Integer> track = new ArrayList<>();
//        backtrace(prices, track, m);
//        return res;
//    }
//
//    private void backtrace(int[] nums, ArrayList<Integer> track, int target) {
//        if (target < 0)
//            return;
//        if (target == 0) {
//            res.add(track);
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (track.contains(nums[i])) continue;
//            track.add(nums[i]);
//            backtrace(nums, track, target - nums[i]);
//            track.remove(track.size()-1);
//        }
//    }
//
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] prices = new int[3];
        String blank = sc.nextLine();
        for (int i = 0; i < 3; i++) {
            int x = sc.nextInt();
            prices[i]=x;
        }
        Case1 case1 = new Case1();
        System.out.println(case1.combinationSum(prices,m));
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum(int[] prices, int target) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (prices == null || prices.length == 0)
            return res;
        Arrays.sort(prices);
        backtrace(prices, 0, target, ls);
        return res;
    }

    private void backtrace(int[] arr, int index, int sum, ArrayList<Integer> ls) {
        if (sum < 0)
            return;
        if (sum == 0) {
            if (!res.contains(ls))
                res.add(new ArrayList<>(ls));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (ls.contains(arr[i])) continue;
            ls.add(arr[i]);
            backtrace(arr, i, sum - arr[i], ls);
            ls.remove(ls.size() - 1);
        }

    }

}
