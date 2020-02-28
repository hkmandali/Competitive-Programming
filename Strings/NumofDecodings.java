package src.Strings;
// given a number find the number of ways it can be decoded , i.e 1 corresponds to 'A' , 2 corresponds to 'B' 26 corresponds to 'Z'
// if 1234 is given it can thought as abcd ,  lcd , and so on
// so the approach is like find the character whose previous character is <= 2 and current is <= 6 then this can be another formation
public class NumofDecodings {
    static int numdecode(int[] input,int len)
    {
        int[] out = new int[len];
        if(input[0] == 0)
            return 0;
        out[0] =1;
        if(input[0] <=2 && input[1] <= 6)
            out[1] =2;
        else
            out[1] =1;
        for(int i=2;i<len;++i)
        {

            if(input[i-1] ==1 || input[i-1] == 2 && input[i] <=6 )
            {
                out[i] = out[i-2]; // last to second combinations
            }
            if(input[i] >0)
                out[i] += out[i-1]; // counting num of possible for previous combinations
        }

        return out[len-1]; // this gives us num of decodings
    }
    public static void main(String[] args) {
        int[] input ={1,3,0};
        System.out.println("num of decodings is "+numdecode(input,input.length));
    }
}
