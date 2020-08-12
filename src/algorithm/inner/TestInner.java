package algorithm.inner;

public class TestInner {
    private int number = 100;

    public class Inner {
        private int number = 200;

        public void paint() {
            int number = 500;
            //局部覆盖
            System.out.println(number);
            System.out.println(this.number);
            System.out.println(TestInner.this.number);
        }
    }

    public static void main(String[] args) {
        TestInner inner = new TestInner();
        TestInner.Inner in = inner.new Inner();
        in.paint();
    }
}
