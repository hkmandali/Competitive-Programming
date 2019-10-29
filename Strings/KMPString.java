package Strings;

public class KMPString {
    static int[] prefix; // this holds how many characters are matching till point , i.e prefix and suffix
    static void constructPrefix(String s1) {
        int len = s1.length();
        prefix = new int[len];
        int i = 1, j = 0;
        prefix[0] = 0;
        while (i < len) {
            if (s1.charAt(i) == s1.charAt(j)) {
                prefix[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = prefix[j - 1];
            } else {
                prefix[i] = 0;
                i++;
            }
        }

    }
    static void stringmatch(String s1,String s2)
    {
        constructPrefix(s2);
        System.out.println("the prefix array is");
        for(int i=0;i<s2.length();++i)
        {
            System.out.print(prefix[i] +" ");
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int i=0,j=0;
        while(i<len1)
        {
            if(s1.charAt(i) == s2.charAt(j))
            {
                if(j == len2 -1)
                {
                    System.out.println("the two stroings matched at "+ (i-j));
                    return;
                }
                else
                {
                    i++;
                    j++;
                }
            }
            else if(j> 0)
            {
                j = prefix[j-1];
            }
            else i++;
        }
        return;
    }

}
