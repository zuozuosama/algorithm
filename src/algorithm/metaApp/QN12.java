package algorithm.metaApp;

import java.io.IOException;

public class QN12 {
    public static void main(String[] args) {
        System.out.print(method(0));
    }
    private static Integer method(Integer i){
        try{
            if(i++ > 0)
                throw new IOException();
            return i++;
        }catch (IOException e){
            i++;
            return i++;
        }catch (Exception e){
            i++;
            return i++;
        }finally {
            return i++;
        }
    }
}
