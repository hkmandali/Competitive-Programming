package src.Collections;

import java.util.LinkedList;
// implemented by checking through gfg
public class LinkedListEx {
    public static void main(String[] args)
    {
        LinkedList obj = new LinkedList();
        System.out.println("size of linkedlist is "+obj.size());
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
        System.out.println("new size of linkedlist is "+obj.size());
        obj.remove(4);
        obj.add(4,"tetsgsdg");
        System.out.println(obj);
        obj.remove((int)5);
        System.out.println(obj);
        obj.removeLast(); // removes the last element
        obj.removeFirst();
        System.out.println("new size of linkedlist is "+obj.size());
        String v = (String)obj.get(5);
    }
}
