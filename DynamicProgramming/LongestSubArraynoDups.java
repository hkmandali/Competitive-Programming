package DynamicProgramming;

import java.util.HashMap;

public class LongestSubArraynoDups {
    static int longest(int[] a) // returns the length of longest subarray ( contiguous) without duplicate elements
    {
        int result =1;// min sub array length i.e if all the values are equal
        int start_index =0,end_index=0;// this will store the starting and ending indices of that subarray
        int global_start=0 ,global_end=0; // these are used for the final sub array
        HashMap<Integer,Integer> countmap = new HashMap<>(); // this will store if an element is already visited similar to visited array
        for(int i=0;i<a.length;++i)
        {
            int curr = a[i];
            System.out.println("the current element is "+curr);
            if(countmap.containsKey(curr)) // if that element is already visited
            {
                if(start_index <= countmap.get(curr) ) // if the occurrence of the element is less than the start index , then there is no point in checking(no harm)
                {
                    start_index = countmap.get(curr) +1; // updating the start to next element
                    System.out.println(" the start index is "+start_index + " end index is "+end_index +" hashmap is "+curr+"  ->  "+countmap.get(curr));
                }
                countmap.replace(curr,i); // updating it to the index of the curr element in the hashmap + 1
            }
            else
            {
                countmap.put(curr,i);
                System.out.println("didnt find this element , pushed into hashmap "+curr +" -> "+countmap.get(curr) + " endindex is "+end_index);
            }
            end_index++; // end index is incremented irrespective of start index
            if(end_index - start_index > result)
            {

                result = end_index - start_index; // similar to below statement
                // result = Math.max(result,end_index-start_index);
                global_start = start_index;
                global_end = end_index-1;
            }
        }
        System.out.println("the start is "+global_start +"  end index is "+global_end);
        return result;
    }
    public static void main(String[] args)
    {
        int[] a = {2,3,1,1,4,3,2};
        //int[] a = {1,2,3,4,2,1};
        //int[] a = {2,3,3,1,4,3,2,3,2};
        //int[] a = {1,2,2,3,4,5,1,1};
        System.out.println(" the longest sub array is "+longest(a));
    }
}
