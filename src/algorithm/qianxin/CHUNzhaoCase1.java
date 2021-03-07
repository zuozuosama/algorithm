package algorithm.qianxin;

import java.util.LinkedList;

public class CHUNzhaoCase1 {

    private LinkedList<LinkedList<Integer>> res = new LinkedList<>();

    public int MaxMilk(int[] grass, int[] milk) {
        LinkedList<Integer> a = new LinkedList<>();
        travel(grass, milk, a, 0);
        int max = res.get(0).stream().mapToInt(x -> milk[x]).sum();
        for (int i = 1; i < res.size(); i++) {
            int sum = res.get(i).stream().mapToInt(x -> milk[x]).sum();
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }


    private void travel(int[] grass, int[] milk, LinkedList<Integer> list, int index) {
        if (index == grass.length) {
            res.add(list);
            return;
        }
        boolean deflict = false;

        for (int i = 0; i < grass.length; i++) {
            if (list.contains(i)) continue;
            for (Integer a : list) {
                if (grass[i] < grass[a] && milk[i] > milk[a]) {
                    deflict = true;
                    break;
                }
            }
            if (deflict) continue;
            list.add(i);
            travel(grass, milk, list, ++index);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] grass = {3, 5, 8, 2};
        int[] milk = {2, 3, 5, 7};
        CHUNzhaoCase1 s = new CHUNzhaoCase1();
        System.out.println(s.MaxMilk(grass, milk));

    }

}
