package src.Collections;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
// this is used to push elements from front as well as back in both diretions
public class ArrayDequeEx {
    public static void main(String[] args)
    {
        ArrayDeque obj = new ArrayDeque() ;
        System.out.println("size of array deque is "+obj.size());
        obj.add("a");
        obj.add("b");
        obj.add(7);
        obj.add(6);
        obj.add(5);
        obj.add("c");
        obj.add("d");
        obj.add("e");
        obj.add("f");
        System.out.println(obj);
        System.out.println("new size of array deque is "+obj.size());
        obj.remove(4);
        System.out.println(obj);
        obj.remove((int)5);
        obj.addFirst("first");
        obj.addLast("last");
        System.out.println(obj);
        obj.removeLast(); // removes the last element
        obj.removeFirst();

        System.out.println("new size of array deque is "+obj.size());
    }
}
