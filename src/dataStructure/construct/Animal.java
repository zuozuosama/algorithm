package dataStructure.construct;

class Animal
{
    public int age=40;

    public void eat()
    {
        System.out.println("吃东西");
    }
    public void sleep()
    {
        System.out.println("睡觉");
    }
}

class Cat extends Animal
{
    public int age=5;
    //重写了父类的方法
    public void eat()
    {
        System.out.println("猫吃老鼠");
    }
    public void playGame()
    {
        System.out.println("玩毛线球");
    }
}
class Dog extends Animal
{
    public int age=3;
    //重写了父类的方法
    public void eat()
    {
        System.out.println("狗啃骨头");
    }
}
class AnimalTest
{
    public static void main(String[] args)
    {

        //向上转型:不需要强制类型转换
        Animal a=new Cat();
        System.out.println(a.age);	//调用的是父类的成员变量
        a.eat();					//调用的是子类Cat的方法
        //a.playGame();				//多态的弊端：无法访问子类特有的方法		error:类型为Animal的变量a找不到方法playGame()
        a.sleep();					//调用的是子类Cat的方法

		/*
			结论：当超类类变量引用子类对象
				访问成员变量时：访问的是父类的成员变量
				访问成员方法时：先访问的是超类的此方法，如果此方法被子类覆盖，则调用子类的方法。并且不能访问子类特有的方法
		*/
        System.out.println("------------");
        //向下转型：需要强制类型转换
        Cat cat=(Cat)a;
        System.out.println(cat.age);	//访问的是子类Cat的成员变量
        cat.eat();					//访问的是子类Cat的方法
        cat.playGame();				//可以访问子类Cat特有的方法
        //Cat cat2=a;				//error:Animal无法转换为Cat

        System.out.println("------------");
        //Dog dog=(Dog)a;
		/*上条语句在编译时并不会出现错误，这是因为编译器认为超类变量a可能是Dog类,但是在运行时会抛出一个ClassCastException（类型转换异常）
		如果没有捕获这个异常，那么程序就会异常终止，如何解决这个问题呢？
			在进行类型转换之前，先查看是否能够成功的转换，通过使用instanceof操作符来实现。如下
		*/
        if(a instanceof Dog)
        {
            Dog dog=(Dog)a;
            System.out.println("可以进行转换");
        }
        else
        {
            System.out.println("不可以进行转换");
        }

        System.out.println("-----------instanceof 操作符-----------------");
        System.out.println(a instanceof Dog);
        System.out.println(a instanceof Cat);
        System.out.println(null instanceof Cat);
        System.out.println(a instanceof Animal);
    }
}