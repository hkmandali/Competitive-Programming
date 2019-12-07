package src.Collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
class Greater implements Comparator<Integer>
{

    @Override
    public int compare(Integer a, Integer b) {
        if(a<b)
            return 1;
        else if(a>b)
            return -1;
        else
            return 0;
    }
}
public class PriorityQueueEx {
    public static void main(String[] args)
    {
        PriorityQueue<Integer> obj = new PriorityQueue<>(10,new Greater());
        PriorityQueue<Integer> obj1 = new PriorityQueue<>(10);
        System.out.println(" size of obj1 is "+obj1.size());
        for(int i=0;i<20;++i)
        {
            obj.add(i);
            obj1.add(i);
        }
        System.out.println(" new size of obj1 is "+obj1.size());
        Iterator itr = obj.iterator();
        while(!obj.isEmpty())
        {
            System.out.println(obj.poll() +"   "+obj1.poll());

        }
        Comparator comp = obj.comparator();
        System.out.println("comp is "+comp);
    }
}
