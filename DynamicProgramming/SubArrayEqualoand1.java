package DynamicProgramming;

import java.util.HashMap;

// this program counts the number of subarrays with equal number of 0's and 1's
// let us convert 0's to -1 , so the problem reduces to number of subarrays with sum = 0, let us iterate over the count

// lets take an array and keep accumulating the sum at each index , if the sum is zero , that means that sub array has equal 0 and 1, in case
// the sum is already seen , that means the sub array from that previous index where the sum is seen to the current index has equal 0 and 1
// so we can maintain a hashmap to tell us the corresponding num of subarray with given sum

public class SubArrayEqualoand1 {
    public static void main(String[] args)
    {
        int[] arr = {0, 0, 1, 0, 0, 0, 1, 1};
        //int[] arr = {0, 1,0,1};
        int len = arr.length;
        int sum =0;
        int res =0; // number of subarrays with equal number of 0's and 1's
        HashMap<Integer,Integer> count = new HashMap<>();// this hashmap has sum vs number of subarrays with equal 0's and 1's
        for(int i=0;i<len;++i)
        {
            if(arr[i] == 0)
                arr[i] =-1; // converting to -1 so that sum will be 0 if equal no.of 0's and 1's
            sum = sum +arr[i];
            if(sum ==0) // this means equal 0's and 1's
                res++;
            if(count.containsKey(sum)) {// this means there are equal number of 0's and 1's from that index+1 to current index
                res = res + count.get(sum); // this is because all the subarrays with previous sum should be included
                count.put(sum, count.get(sum) + 1);
            }
            else
                count.put(sum,1);

        }
        System.out.println("the number os subarrays with equal number of 0's and 1's are "+res);


    }

}
