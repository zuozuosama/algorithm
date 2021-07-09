package epmTest;

import org.junit.Test;

public class A {
    @Test
    public void d(){
        String s ="epm.Check61*()_+pol;@#$%&*(;\",\"审核说明\",\"warning\")";
        String a = String.format("%8s", "dd");
        String dd = String.format("%8s"+s, "");
        System.out.println(dd);
        System.out.println(a);
    }


}
