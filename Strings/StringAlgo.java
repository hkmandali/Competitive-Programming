package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringAlgo {
    // brute force comparison
    static int stringmatch(String s1,String s2) // s1 is the string on which we are comparing
            // s2 is the string which is being compared , s1 > s2 length
    {
        int l1 = s1.length();
        int l2 = s2.length(); // we need to compare only from 0 to l1 - l2 + 1 positions in s1 because ( l1 -(l2 -1)) is the max
        for(int i=0;i<l1-l2+1;++i)
        {
            int j =0;
            for(;j<l2 && s2.charAt(j) == s1.charAt(i+j);++j)
            {
                // we just check if the chars are equal
            }
            if(j == l2)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the first string");
        String s1 = br.readLine();
        System.out.println("enter the second string");
        String s2 = br.readLine();
        int result = stringmatch(s1,s2);
        if(result == -1)
        {
            System.out.println("string didnt match");
        }
        else
        {
            String s3 = s1.substring(result,result+ s2.length() );
            // the above is not required , we can just print s2
            System.out.println("result is "+ result +"matched string is " + s3);
        }
        System.out.println("Through Rabin Karp string matching");
        RabinKarp.stringmatch(s1,s2,101); // third argument is a prime number for modulo hashing

        System.out.println("Through KMP string matching");
        KMPString.stringmatch(s1,s2); // third argument is a prime number for modulo hashing
        return;
    }
}
