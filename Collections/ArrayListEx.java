package src.Collections;

import java.util.ArrayList;
// Arraylist is used when the no of elements arent fixed and this can re size dynamically
public class ArrayListEx {
    public static void main(String[] args)
    {
        ArrayList obj = new ArrayList(10);
        System.out.println("size of arraylist is "+obj.size());
        for(int i=0;i<20;++i)
        {
            obj.add(i);
        }
        System.out.println(obj);
        System.out.println("new size of arraylist is "+obj.size());
        obj.remove(4);
        obj.add(4,"tetsgsdg");
        System.out.println(obj);
        System.out.println("new size of arraylist is "+obj.size());
        int v = (int) obj.get(5);
    }
}
