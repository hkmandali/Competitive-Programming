package src.Hashing;

import java.util.*;

public class Hash {
    static void insertelements(Map<Integer,Integer> m)
    {
        int[] a = {1,12,32,4,15,6,17,83,99,20};
        int size = a.length;
        for(int i=0;i<size;++i)
        {
            m.put(a[i],2*a[i]);
        }
    }

    static void printmapelements(Map<Integer,Integer> m)
    {
        Iterator<Map.Entry<Integer,Integer>> itr = m.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<Integer,Integer> entry = itr.next();
            System.out.print(entry.getKey() +"  " + entry.getValue() + "\n");
        }
    }
    public static void main(String[] args)
    {
        HashMap<Integer,Integer> m1 = new HashMap<Integer,Integer>();
        LinkedHashMap<Integer,Integer> m2= new LinkedHashMap<Integer,Integer>();
        TreeMap<Integer,Integer> m3= new TreeMap<Integer,Integer>();
        Hashtable<Integer,Integer> m4 = new Hashtable<Integer, Integer>();
        insertelements(m1);
        insertelements(m2);
        insertelements(m3);
        insertelements(m4);
        System.out.println("the elements in hashmap are ");
        printmapelements(m1); // elements are in random order
        System.out.println("the elements in linked hashmap are ");
        printmapelements(m2);// elements are in insertion order
        System.out.println("the elements in tree map are ");
        printmapelements(m3);// elements are in sorted order of keys
        System.out.println("the elements in hash table are ");
        printmapelements(m4);// elements are arbitrary , this is used when thread synchronization is needed and no null keys are allowed , else it is similar to hashmap
    }
}
