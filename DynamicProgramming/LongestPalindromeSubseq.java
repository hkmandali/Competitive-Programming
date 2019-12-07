package src.DynamicProgramming;
// given a string , find the largest palindromic subsequence

import java.util.ArrayList;

/*1. if the first and last characters of a string are equal , then result is 2 +  longestpalsubseq(s, start + 1,end-1)
2.if length is 2 , if the two chars are equal then return 2 , else 0
3. if the chars are not equal, then result is max of longestpalsubseq(s,start,end-1) and longestpalsubseq(s,start+1,end)
*/
public class LongestPalindromeSubseq {
    static int longestpalsubseq(String s, int start, int end)
    {
        if(start == end)
            return 1;
        else {
            if (s.charAt(start) == s.charAt(end)) {
                if (end - start == 1)
                    return 2;
                else
                    return longestpalsubseq(s, start + 1, end - 1) + 2;
            } else
                return Math.max(longestpalsubseq(s, start, end - 1), longestpalsubseq(s, start + 1, end));
        }
    }

    static int longestpalsubseqdp(String s, int start, int end)
    {
        int lenofsubseq = end-start+1; // length of given subseq
        int[][] seqarray = new int[lenofsubseq][lenofsubseq]; // seq array contains the length of longest pal subseq starting at
        // index i and ending at index j for subseq[i][j] , so for every subseq with length 1 , it is 1 because only single character and it is alwyas equal
        int strlen; // length os strings we are considering

        for(int i=0;i<lenofsubseq;++i)
        {
            seqarray[i][i] =1; // this is always 1 as strlen is 1 and that char is always equal
        }
        // now we increment based on the string lengths i.e string length 2 and so on upto s.length
        for(strlen=2;strlen <=lenofsubseq;++strlen)
        {
            for(int i = 0;i<lenofsubseq-strlen+1;++i)
            {
                int j = i +strlen -1;
                if (s.charAt(j) == s.charAt(i)) {
                    if (j - i == 1)
                        seqarray[i][j] =2;
                    else
                        seqarray[i][j] = seqarray[i+1][j-1] + 2;
                } else
                    seqarray[i][j] = Math.max(seqarray[i][j-1], seqarray[i+1][j]);
            }
        }

        return seqarray[start][end];
    }

    public static void main(String[] args)
    {
        String s = "abcajshdkjghacdskjbgha";
        int len = s.length();
        int res = longestpalsubseq(s,0,len-1);
        int res1 = longestpalsubseqdp(s,0,len-1);
        System.out.println(" the length of longest is "+ res);
        System.out.println(" the length of longest using dp is "+ res1);
    }
}
