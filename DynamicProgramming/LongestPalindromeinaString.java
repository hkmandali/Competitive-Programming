package src.DynamicProgramming;

//import src.Strings.Palindrome;
public class LongestPalindromeinaString{

    static String longestpalsubstringdp(String s, int start, int end)
    {
        int lenofsubseq = end-start+1; // length of given subseq
        int[][] seqarray = new int[lenofsubseq][lenofsubseq]; // seq array contains the length of longest pal subseq starting at
        // index i and ending at index j for subseq[i][j] , so for every subseq with length 1 , it is 1 because only single character and it is alwyas equal
        int strlen; // length os strings we are considering
        int starting =0, ending =0;
        int max =1;
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
                    if (j - i == 1) {
                        starting =i;
                        ending =j;
                        seqarray[i][j] = 1;
                    }else {
                        if(seqarray[i+1][j-1] == 1) {
                            starting = i;
                            ending =j;
                            seqarray[i][j] = 1;
                        }
                    }
                }
            }
        }
        System.out.println("starting is "+starting +"  ending is "+ending);
        String res = new String(s.substring(starting,ending+1));
        return res;
    }

    public static void main(String[] args)
    {
        String input = "forgeeksskeegfor";
        String res = longestpalsubstringdp(input,0,input.length()-1);
        System.out.println("the max length using dp is "+res);
    }
}
