package solution.leetcode;

import java.util.Scanner;

//3、盛水最多的容器（leetcode10）
public class MaxArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(",");
        int[] height = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            height[i] = Integer.parseInt(s[i]);
        }
        System.out.println(maxArea(height));
        sc.close();
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;//左指针
        int r = height.length - 1;//右指针
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(area, maxArea);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}

