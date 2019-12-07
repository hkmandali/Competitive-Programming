package src.Collections;

import java.util.Vector;
// almost same as arraylist but the diff is that
/*
1. the rate at which they grow 50% for arraylist , 100% for vector
2. traversal , arraylist has only iterator , vector has iterator and enumeration
2. vector is thread safe where arraylist is not , source gfg
 */
public class VectorEx {
    public static void main(String[] args)
    {
        Vector obj = new Vector();
        System.out.println("size of vector is "+obj.size());
        for(int i=0;i<20;++i)
        {
            obj.add(i);
        }
        System.out.println(obj);
        System.out.println("new size of vector is "+obj.size());
        obj.remove(4);
        obj.add(4,"tetsgsdg");
        System.out.println(obj);
        System.out.println("new size of vector is "+obj.size());
        int v = (int) obj.get(5);
    }
}
