package solution.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 首先分别设置两个数组start和end，用来存放开始时间和结束时间；
 * 然后再对start数组和end数组进行排序。由于我们这里都是从小到大排即可，所以不需要重写compare方法，直接用sort()即可；
 * 设置一个优先队列（最小堆），用来存放结束时间；
 * 如果后一个的开始时间比结束时间要晚，就说明可以放在同一个会议室开会，我们就把堆顶的元素给poll出来，再将现在这个结束时间放进去，
 * 否则说明需要开辟新的会议室，不用poll当前堆顶的元素，直接把现在这个结束时间放进去；
 * 遍历结束之后，堆的大小就是所需会议室的数目。
 */
class MinMeetingRooms {
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        int[] start = new int[intervals.length];
        int[] end = new int [intervals.length];
        for(int i = 0; i < intervals.length; i ++) {
            start[i] = intervals[i][0];
            System.out.println(start[i]);
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        PriorityQueue<Integer> pq = new PriorityQueue<>(end.length);
        pq.add(end[0]);
        for(int i = 1; i < end.length; i ++) {
            if(start[i] >= pq.peek())
                pq.poll();
            pq.add(end[i]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }
}
