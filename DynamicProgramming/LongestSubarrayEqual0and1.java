package DynamicProgramming;
// this program prints the longest subarray with equal number of 0's and 1's

import java.util.HashMap;

public class LongestSubarrayEqual0and1 {
    public static void main(String[] args)
    {
       int[] arr = {0,0,0,1,1,1,1,0,0,0,0};
        //int[] arr = {0, 1,0,1};
        int sum =0;
        HashMap<Integer,Integer> obj = new HashMap<>(); // this hashmap contains sum of sub array vs index mapping
        int start_index =0;
        int end_index =0;
        int len = arr.length;
        int max_length =0; // max length of subarray
        for(int i=0;i<len;++i)
        {
            sum = sum + (arr[i] == 0 ? -1 : 1);
            if(obj.containsKey(sum))
            {
                if(i - obj.get(sum) > max_length)
                {

                    max_length = i- obj.get(sum);
                    start_index = obj.get(sum) + 1;
                    end_index = i;
                }
            }
            else
            {
                obj.put(sum,i);
            }

        }
        System.out.println("start index is  "+start_index+"  end index is "+end_index);
        System.out.println("the array is ");
        for(int i = start_index;i<=end_index;++i)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
