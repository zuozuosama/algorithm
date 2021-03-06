package dataStructure.queue;

public class ArrayQueue<T> {
    private int SIZE = 10;

    private Object[] arr = new Object[SIZE];
    private int foot;

    public ArrayQueue() {
    }

    public boolean isEmpty() {
        return foot == 0;
    }

    public void offer(T t) {
        arr[foot] = t;
        if (++foot >= arr.length) {
            Object[] nArr = new Object[arr.length + SIZE];
            for (int i = 0; i < foot; i++) {
                nArr[i] = arr[i];
            }
            arr = nArr;
        }
    }

    public void poll() {
        if (!isEmpty()) {
            foot--;
            for (int i = 0; i <= foot; i++) {
                arr[i] = arr[i + 1];
            }
            arr[foot + 1] = null;
        } else {
            throw new RuntimeException("队列为空");
        }
    }

    public int size() {
        return foot;
    }


    @SuppressWarnings("unchecked")
    public T get(int i) {
        if (i < foot && i >= 0) {
            return (T) arr[i];
        } else {
            throw new RuntimeException("下标为负数或越栈");
        }
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.poll();
        System.out.println(queue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < foot; i++)
            sb.append(arr[i]).append(" ");
        return sb.toString();
    }
}
