package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubSeq {
    int commonseqLengthrecur(String a,int len1,String b,int len2)
    {
        if(len1 > 0 && len2 > 0) { // if both of the string have some valid length--> process, else 0
            if (a.charAt(len1 - 1) == b.charAt(len2 - 1)) {
                return 1 + commonseqLengthrecur(a, len1 - 1, b, len2 - 1);
            } else {
                return Math.max(commonseqLengthrecur(a, len1 - 1, b, len2), commonseqLengthrecur(a, len1, b, len2 - 1));
            }
        }
        else
            return 0;
    }
    int commonseqLengthdp(String a,int len1,String b,int len2)// in this approach we
    // store the values for the previous calculation in an array and use it in the next step
            //it is nothing but the same approach as in recursion but we store the values
    {
        int[][] common = new int[len1+1][len2+1];
        for(int i=0;i<len1+1;++i)
            for(int j=0;j<len2+1;++j)
            {
                if(i == 0 || j == 0)
                {
                    common[i][j] = 0;
                }
                else
                {
                    if(a.charAt(i-1) == b.charAt(j-1))
                        common[i][j] = 1 + common[i-1][j-1]; // i.e if the chars are equal
                    // , increment 1 are find the same for length -1
                    else
                    {
                        common[i][j] = Math.max(common[i-1][j],common[i][j-1]);
                    }
                }
            }

        int length = common[len1][len2];
        int stringlen = length;
        char[] sequence = new char[length+1]; // stores the final sequence to be printed
        int id1=len1,id2=len2; // current index for string 1 and 2
        sequence[length] = '\0';
        while(id1>0 && id2>0)
        {
            if(a.charAt(id1-1) == b.charAt(id2-1)) // the characters at the current
                // end are equal, so add these to the string
            {
                sequence[length-1]= a.charAt(id1-1);
                id1--;id2--;length--;
            }
            else if(common[id1-1][id2]> common[id1][id2-1])
            {
                id1--; // here we are checking which neighbor is the largest , and moving to that point
            }
            else
            {
                id2--;
            }
        }
        //System.out.println("the sequence is "+sequence[0] +sequence[1] +sequence[2] +sequence[3] +"length si "+stringlen);
        for(int i=0;i<=stringlen;++i)
        {
            System.out.print(sequence[i]);
        }


        return common[len1][len2];
    }
    public static void main(String[] args) throws IOException {
        String s1,s2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the two strings to be verified");
        s1= br.readLine();
        s2=br.readLine();
        int len1= s1.length();
        int len2=s2.length();
        LongestCommonSubSeq obj = new LongestCommonSubSeq();
        int commonlength = obj.commonseqLengthrecur(s1,len1,s2,len2);
        System.out.println("the length of longest common subsequence is "+commonlength);
        int commonlengthdp = obj.commonseqLengthdp(s1,len1,s2,len2);
        System.out.println("the length of longest common subsequence using dp is "+commonlengthdp);
    }
}
