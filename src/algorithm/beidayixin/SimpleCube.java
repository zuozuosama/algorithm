package algorithm.beidayixin;

public class SimpleCube {
    private double length;
    private double width;
    private double height;

    int w,x,y,z;

    public SimpleCube(int a,int b){
        x=a;y=b;
    }

    public SimpleCube(int a,int b,int c,int d){

        this(a,b);
        w=d;z=c;
    }

    public SimpleCube(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public static void revertWord(String word){
        String[] split = word.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (i==0){
                sb.append(split[i]);
            }else {
                sb.append(split[i]).append(" ");
            }

        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
//        Integer integer = new Integer(0);
//        addThree(integer);
//        System.out.println(integer);

        int a=0,c=0;
        do{
            --c;
            a=a-1;
        }while (a>0);
        System.out.println(c);
    }

    public static void addThree(Integer i){
        int a = i.intValue();
        a+=3;
        i=new Integer(a);
    }


    /**
     * 求体积
     * @return
     */
    public double calcVolume() {
        return length * width * height;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
