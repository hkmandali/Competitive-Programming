package src.Exception;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModification {
    public static void main(String[] args) {
        ArrayList<Integer> obj = new ArrayList<>();
        for(int i=0;i<6;++i)
        {
            obj.add(i);
        }
        Iterator<Integer> itr = obj.iterator();
        for(int i:obj)
        {
            if(i == 3)
                obj.remove(i);
        }
        while(itr.hasNext())
        {
            if(itr.next() == 3)
                itr.remove();
            //System.out.println();
        }
        itr = obj.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

    }
}
