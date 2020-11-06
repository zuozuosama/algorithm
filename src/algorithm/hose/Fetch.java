package algorithm.hose;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class Fetch {

    public static final int MAX_SIZE = 3000;
    public static final int PAGE_SIZE = 10;

    public static Fetch getInstance() {
        return new Fetch();
    }

    public <A> List<A> queryAmountData(Function<LimitEntry, List<A>> function) {
        List<A> result = new ArrayList<>();
        queryDataConsumer(function, result::addAll);
        return result;
    }

    public <A> void queryDataConsumer(Function<LimitEntry, List<A>> function, Consumer<List<A>> consumer) {
        AtomicInteger offset = new AtomicInteger(0);
        while (true) {
            List<A> apply = function.apply(new LimitEntry(offset.get(), MAX_SIZE));
            int count;
            if (apply == null) {
                count = 0;
            } else {
                count = apply.size();
            }
            consumer.accept(apply);
            if (count != MAX_SIZE) {
                return;
            } else {
                offset.addAndGet(MAX_SIZE);
            }
        }
    }

    public <A> A queryRepeatData(Supplier<A> supplier) {
        int i = 0;
        A o = null;

        while (o == null && i < 3) {
            o = supplier.get();

            if (o == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
//                        throw new Ile("出现系统异常：" + ex.getMessage());
                }
            }
            i++;
        }
        return o;
    }

    public class LimitEntry {
        public final int offset;
        public final int size;

        private LimitEntry(int offset, int size) {
            this.offset = offset;
            this.size = size;
        }
    }

    public void separator(int total, Consumer<LimitEntry> consumer) {
        AtomicInteger offset = new AtomicInteger(0);
        AtomicInteger size = new AtomicInteger(MAX_SIZE);
        do {
            if (size.get() <= total) {
                consumer.accept(new LimitEntry(offset.getAndAccumulate(MAX_SIZE, Integer::sum), size.getAndAccumulate(MAX_SIZE, Integer::sum)));
            } else {
                consumer.accept(new LimitEntry(offset.getAndAccumulate(MAX_SIZE, Integer::sum), total));
            }
        } while (offset.get() < total);
    }
}


