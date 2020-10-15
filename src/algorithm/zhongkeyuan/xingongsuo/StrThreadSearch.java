package algorithm.zhongkeyuan.xingongsuo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class StrThreadSearch {
    public static ExecutorService pool = Executors.newCachedThreadPool();

    public static AtomicInteger result = new AtomicInteger(-1);//最终返回的结果（数组所在位置）

    private static List<String[]> list; //存放随机字符串的集合

    private static final int length = 100000;

    public static final int thread_num = 32;

    /**
     * 搜索方法，针对一个数组来搜索
     *
     * @param searchValue
     * @param begin
     * @param end
     * @return
     */
    public static int search(String searchValue, int begin, int end) {
        int index = begin % 100;
        String[] strings = list.get(index);
        for (int j = 0; j < strings.length; j++) {
            if (result.get() > 0) {
                return result.get();
            }
            if (strings[j].equals(searchValue) || strings[j].contains(searchValue)) {
                if (result.compareAndSet(-1, index)) {
                    return result.get();
                }
                return index;
            }
        }
        return -1;
    }

    /**
     * 搜索线程
     */
    static class SearchThread implements Callable<Integer> {

        private int begin;
        private int end;
        private String searchValue;

        public SearchThread(int begin, int end, String searchValue) {
            this.begin = begin;
            this.end = end;
            this.searchValue = searchValue;
        }

        @Override
        public Integer call() throws Exception {
            return search(searchValue, begin, end);
        }
    }


    public static int mainSearch(String searchValue) throws ExecutionException, InterruptedException {
        int sub = length / thread_num + 1;
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < length; i += sub) {
            int end = i + sub;
            if (end > length) end = length;

            Future<Integer> future = pool.submit(new SearchThread(i, end, searchValue));
            futures.add(future);
        }

        for (Future<Integer> fu : futures) {
            if (fu.get() >= 0) return fu.get();
        }
        return -1;
    }
}
