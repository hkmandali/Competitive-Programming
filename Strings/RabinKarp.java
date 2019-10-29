package Strings;

public class RabinKarp {
    static final int max_char = 256;
    static void stringmatch(String s1,String s2,int prime)
    {
        int l1 = s1.length();
        int l2 = s2.length();
        int hash =1;
        int hash_s1= 0;
        int hash_s2= 0;

        // The value of hash would be "pow(max_char, l2-1)%prime"
        // this would be used in doing the minus while appending
        for (int i = 0; i < l2 -1; ++i)
            hash = (hash*max_char)%prime;
        //calculate the has values of s1 and s2
        for(int i=0;i<l2;++i)
        {
            hash_s1 = (max_char*hash_s1 + s1.charAt(i))%prime; // we are performing a mod with prime to
            // ensure that hash doesnt mix up with another
            hash_s2 = (max_char*hash_s2 + s2.charAt(i))%prime;
        }
        for(int i=0;i<l1-l2+1;++i)
        {
            if(hash_s1 == hash_s2) // if equal , compare the elements for that range
            {
                int j;
                for(j=0;j<l2;++j)
                {
                    if(s1.charAt(i+j) != s2.charAt(j))
                        break;
                }
                if(j == l2)
                {
                    System.out.println("pattern found at index "+i);
                }
            }
            // if not equal , modify the elements hash by deleting the first element and appending the last
            if(i<l1-l2) // just to append one more character at the corner case
            {
                hash_s1 = (max_char*(hash_s1 - s1.charAt(i)*hash) + s1.charAt(i+l2))%prime; // we are performing a mod with prime to
                if(hash_s1 < 0)
                    hash_s1 = hash_s1 + prime; // if -ve value , append the prime to it , corner case checked through gfg
            }
        }
        return ; // we can also return the index integers instead of printing them here
    }
}
