package Strings;

class TSTNode{
    char element; // we shouldn't be storing String at each node because if we store string ,
    // it will not augment our purpose in string searching by calculating the prefixes instead we need
    // to loop through all of them to find the corresponding suffixes
    boolean isEndofString = false;
    TSTNode equal,left,right;
    public TSTNode insert(String s,TSTNode t,int index)
    {
        TSTNode curr = t;
        char ch = s.charAt(index);

        if(curr == null)
        {
            System.out.println("curr is null and inserting ch -"+ch +"  at index  "+ index);
            curr = new TSTNode();
        }
        if(curr.element == '\0')
        {
            System.out.println("element is null and inserting ch -"+ch +"  at index  "+ index);
            curr.element = s.charAt(index);
            if(index == s.length() -1 )
            {
                System.out.println("length is equal to index");
                curr.isEndofString = true;
                return curr;
            }
            else
            {
                curr.equal = new TSTNode();
                curr = curr.equal; // used to go to the next level
            }

        }
        else
        {
            if(ch > curr.equal.element)
            {
                System.out.println("ch is > curr element inserting ch -"+ch +"  at index  "+ index);
                if(curr.right == null)
                   curr.right = new TSTNode();
                curr = curr.right;
            }
            else if(ch < curr.equal.element) {
                System.out.println("ch is < curr element inserting ch -" + ch + "  at index  " + index);
                if(curr.left == null)
                    curr.left = new TSTNode();
                curr = curr.left;
            }
            else {
                System.out.println("ch is = curr element inserting ch -" + ch + "  at index  " + index);
                if(curr.equal == null)
                    curr.equal = new TSTNode();
                curr = curr.equal;
            }
        }
        insert(s,curr,index+1);
        return curr;

    }
    public void printall(TSTNode t,String s)
    {

        char ch = t.element;
        String appended,appended_left,appended_right ;
        appended= appended_left = appended_right = s; // this is  useful
        // when the function gets called recursive and the call flow doesnt change line 89-90
        System.out.println("ch is "+ch +"  s is "+s );
        if(t.isEndofString)
        {
            appended = appended + ch;
            System.out.println("found string - "+ appended);
        }
        if(t.left != null)
        {
            appended = appended ;
            System.out.println("left is not null - "+t.left.element+" append is "+appended);
            printall(t.left,appended);
        }
        if(t.equal != null)
        {
            appended = appended +ch;
            System.out.println("equal is not null - "+t.equal.element+" append is "+appended);
            System.out.println("calling print on t.element  "+t.element+" append is "+appended);
            printall(t.equal,appended);
        }
        if(t.right != null)
        {
            System.out.println("in right  append is "+appended);
            appended = appended ;
            System.out.println("right is not null - "+t.right.element+" append is "+appended);
            printall(t.right,appended);
        }
        return;
    }

}

public class TernarySearchTree {
/*
    // this function lets us compare if a string needs to be inserted to the right or the left
    private static int compareTrie(TSTNode a,String b,int index)
    {
        if(a.element > b.charAt(index))
            return 1; // a is > b
        else if(a.element < b.charAt(index))
            return -1; // a is < b
        else
            return compareTrie()

    }
  */


    public static void main(String[] args)
    {
        String[] keys = {"hello","hey"};
        TSTNode t = new TSTNode();

        for(int i=0;i<keys.length;++i)
        {
            t.insert(keys[i],t,0);
        }
        String s= new String();
        t.printall(t,s);
        return;
    }
}
