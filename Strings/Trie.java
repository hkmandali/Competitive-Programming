// this has been implemented by watching the tutorials of gaurav and tushar

// the advantages of trie's over bst and hashing is that it can compute in lesser with the over head of storage
package Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class TrieNode{
    HashMap<Character,TrieNode> child;
    boolean endofstring;
    TrieNode(){
        child = new HashMap<>();
        endofstring = false;
    }
    boolean search(String s,TrieNode t)
    {
        int len = s.length();
        TrieNode curr = t;
        for(int i=0;i<len;++i)
        {
            char ch = s.charAt(i);
            TrieNode node = curr.child.get(ch);
            System.out.println("the current char is "+ch);
            if(node != null)
            {
                System.out.println("node is not null");
            }
            else
            {
                System.out.println("didnt find the string");
                return false;
            }
            curr = node;
        }
       // return 1; // this can be given in case of partial matches is accepted
       return curr.endofstring;
    }
    void insert(String s,TrieNode t)
    {
        int len = s.length();
        TrieNode curr = t;
        for(int i=0;i<len;++i)
        {
            char ch = s.charAt(i);
            TrieNode node = curr.child.get(ch);
            if(node == null)
            {
                node = new TrieNode();
                curr.child.put(ch,node);
            }
            curr = node;
        }
        curr.endofstring = true;
    }
    boolean delete(String s,TrieNode t,int index)
    {
        int len = s.length();
        TrieNode curr = t;
        if(index == s.length())
        {
            if(!t.endofstring)
                return false;
            t.endofstring = false;
            return t.child.size() == 0; // this is useful in line 76 because if there is a child , we need to keep the parent
            // else we can delete it as there is no more use of it
            // else we can give return true as below
            //return true;
        }
        char ch = s.charAt(index);
        TrieNode node = t.child.get(ch);
        if(node == null) // if there is no child for that character
            return false;
        boolean delCurrNode = delete(s,node,index + 1);
        // if it is true delete the character from the hashmap
        if(delCurrNode)
        {
            t.child.remove(ch);
            return true; // we can return if there are no more mappings
        }
        return false;
    }
    // this function prints all the contents of a trie
    void printall(TrieNode t,String s)
    {
        if(t.child.size() == 0)
        {
            System.out.println(" in print all "+s);
            return;
        }


        Iterator<Map.Entry<Character,TrieNode>> itr = t.child.entrySet().iterator();
        while(itr.hasNext())
        {
            String appended = s;
            Map.Entry<Character,TrieNode> next = itr.next();
            appended = appended+next.getKey();
            printall(next.getValue(),appended);
        }


    }

};
public class Trie {

    public static void main(String[] args)
    {
        TrieNode t = new TrieNode();
        String[] data= {"hola","thats'it","enti","testing","there"};
        for(int i=0;i<data.length;++i)
        {
            t.insert(data[i],t);// insering elements into trie
        }
        boolean find = t.search("hol",t);
        System.out.println("the string found is "+find);
        boolean b_del = t.delete("enti",t,0);
        System.out.println("the string found is "+b_del);
        boolean b_del2 = t.delete("hola",t,0);
        System.out.println("the string found  for hola is "+b_del2);
        /*
        Iterator<Map.Entry<Character,TrieNode>> itr = t.child.entrySet().iterator();
        while(itr.hasNext())        {
            HashMap.Entry<Character,TrieNode> next = itr.next();

            System.out.println("string value of "+next.getKey());
        }
        */
        System.out.println("the final values are");
        String s= new String();
        t.printall(t,s);
        return;
    }
}
