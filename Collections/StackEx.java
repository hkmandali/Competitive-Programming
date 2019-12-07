package src.Collections;

import java.util.Stack;
public class StackEx {
    public static void main(String[] args)
    {
        Stack obj = new Stack();
        System.out.println("size of stack is "+obj.size());
        for(int i=0;i<20;++i)
        {
            obj.push(i);
        }
        System.out.println(obj);
        System.out.println("new size of stack is "+obj.size());
        System.out.println("top element of stack is "+obj.peek());
        obj.pop();
        obj.push("tetsgsdg");
        System.out.println("top element of stack is "+obj.peek());
        System.out.println(obj);
        System.out.println("empty of stack is "+obj.empty());
        int v = (int) obj.get(5);
    }
}
