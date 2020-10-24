package algorithm.niukewang;

//

/**
 * 重写：两同两小一大原则：
 * 两同：方法名相同，参数类型相同
 * 两小：子类方法抛出异常小于父类方法抛出异常，子类返回值类型小于父类返回值类型（返回值类型必须在有继承关系的前提下比较）
 * 一大：子类方法权限大于父类方法访问权限
 */
class A {
    A foo(){
        return this;
    }
}

class B extends A{
    public A foo(){
        return this;
    }
}

class C extends B{
    //错误
    /*public A foo(){
        return A;
    }*/

    //错误
//    public void foo(){
//
//    }

    //错误
//    public int foo(){
//        return 1;
//    }

    //重载
    public A foo(B b){
        return b;
    }

}

