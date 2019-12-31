package Trie;

public class Trie {

    static int num_children =26; // this can be changed based on the characters or we can use a hashmap

    public Trie[] children;
    public boolean end_of_word;

    public Trie()
    {
        System.out.println("creating a new trie");
        children = new Trie[num_children];
        end_of_word = false;
    }
    public static Trie Head; // this is the first node i.e the head
    public static void insertNode(String input) // this adds a new node into the trie
    {
        System.out.println("the string passed is "+input);
        int len = input.length();
        Trie itr = Head;
        for(int i=0;i<len;++i)
        {
            char current = input.charAt(i);
            int curr_index = current -'a'; // this gives us the current index of the character

            if (itr.children[curr_index] == null) {
                itr.children[curr_index] = new Trie();
            }

            itr = itr.children[curr_index];
        }
        itr.end_of_word = true;
    }

    public static boolean search(String word) // this searches for a word in the trie
    {
        boolean ret = false;
        int len = word.length();
        Trie itr = Head;
        for(int i=0;i<len;++i)
        {
            char current = word.charAt(i);
            int curr_index = current -'a';
            if(itr.children[curr_index] ==  null) // there is no such word in the trie
                return false;
            else
            {
                itr = itr.children[curr_index];
            }
        }
        if(itr != null && itr.end_of_word)
            return true;
        return false;
    }

    public static void main(String[] args)
    {
        String[] input = {"hemu","hem","hemanth","heman","thala"};
        Head = new Trie();
        for(int i=0;i<input.length;++i)
        {
           insertNode(input[i]);
        }

        System.out.println("the values found for hema is "+search("hema"));
        System.out.println("the values found for hemu is "+search("hemu"));
        System.out.println("the values found for thal is "+search("thal"));
        System.out.println("the values found for thala is "+search("thala"));
    }

}
