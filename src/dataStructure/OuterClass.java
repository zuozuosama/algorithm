package dataStructure;

public class OuterClass {

    private float f=1.0f;

    //静态内部类才可以有静态方法
    public class InnerClass{
        /*static*/ float func(){
            return f;
        }
    }

    class InnerClass2{
        public float func(){
            return f;
        }
    }


    //静态方法不能用非静态变量
    static class InnerClass3{
        protected static float func(){
            return 1.0f;
//            return f;
        }
    }

    abstract class InnerClass4{
        public abstract float func();
    }
}
