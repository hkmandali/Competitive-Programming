package Searching;

import java.util.HashMap;

public class SearchDupinArray {
    public static void main(String[] args)
    {
        int[] a= {1,-2,3,4,2,1,-2};
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<a.length;++i)
        {
            if(count.containsKey(a[i]))
            {
                System.out.println("element found "+a[i]);
            }
            else
                count.put(a[i],a[i]);
        }
    }
}
