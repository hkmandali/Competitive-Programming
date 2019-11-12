package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestIncrSubseq {
    private int maxseq(int[] arr) // this is almost similar to maxcontiguoussubseq where we find the max sum of adjacent
    {
        int arr_length = arr.length;
        int[] temparr = new int[arr_length];//this stores the max length of sequence till that item
        temparr[0] =1;
        int max_length=0;
        // here we have two arrays curr array and temp ( longest increasing subsequence) array
        // j is iterated from 0 to i and the highest value is stored in the temp array
        for(int i=1;i<arr_length;++i)
        {
            temparr[i] =1;
            for(int j =0;j<i;++j)
            {
                if(arr[i] > arr[j] && temparr[i] < temparr[j] +1)
                    temparr[i] = temparr[j] +1;
            }
        }
        // now the temp array stores the maximum increasing sequence till that point
        for(int i=0;i<arr_length;++i)
            if(temparr[i] > max_length)
                max_length = temparr[i];
        return max_length;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {5,6,2,3,4,1,9,9,8,9,5};
        LongestIncrSubseq obj = new LongestIncrSubseq();
        int res = obj.maxseq(arr);
        System.out.println("the max increasing sequcne is "+res);
    }
}
