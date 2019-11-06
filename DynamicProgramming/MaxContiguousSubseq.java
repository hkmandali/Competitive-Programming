package DynamicProgramming;

public class MaxContiguousSubseq {
    private int maxsumbrute(int[] arr) // over here we check the values for all the indices
    {
        int arrlen = arr.length;
        int max_sum =0;
        int start_index =0,end_index=0;
        for(int i=0;i<arrlen;++i)
        {
            int current_sum =0; // for that index
            for(int j=i;j<arrlen;++j)
            {
                current_sum = current_sum +arr[j];
                if(current_sum > max_sum)
                {
                    max_sum = current_sum;
                    start_index = i;
                    end_index = j;
                }

            }
        }
        System.out.println("the start and end index are "+ start_index +"  "+end_index);
        return max_sum;
    } // this is O(n2) approach , we can have O(n) approach as discussed below but the indices cannot be found

    private int maxsum(int[] arr) // over here we store the values till an index
    {
        int arrlen = arr.length;
        int max_sum =0;
        int sumtillcurrent = 0;
        for(int i=0;i<arrlen;++i) {
            sumtillcurrent = sumtillcurrent + arr[i]; // in this we are storing the sum till
            // the current index and if it is < 0 , we de initialize it to 0 to start from next index
            if(sumtillcurrent < 0)
            {
                sumtillcurrent = 0;
            }
            if(sumtillcurrent > max_sum)
            {
                max_sum = sumtillcurrent;
            }
        }
        return max_sum;
    }
    // the above method can also be implemented using d.p by the below procedure
    // in this method we store the max sum till a particular index in a separate array and check the max element in that array
    private int maxsumdp(int[] arr)
    {
        int arrlen = arr.length;
        int max_sum =0;
        int[] maxsummarr = new int[arrlen]; // this stores the max sum till that index
        if(arr[0] > 0)
            maxsummarr[0]= arr[0];
        else
            maxsummarr[0]= 0;
        int sumtillcurrent = 0;
        for(int i=1;i<arrlen;++i) {
            //if(maxsummarr[i-1] > 0)
            //{
            if(maxsummarr[i-1] + arr[i] > 0)
            {
                maxsummarr[i] = maxsummarr[i-1] + arr[i];
            }
            else
                maxsummarr[i] = 0;
            //}
            /*
            else // the else case will never come because maxsumarr is never -ve , it is either 0 or +ve
            {
                if(arr[i] > 0)
                {
                    maxsummarr[i] = arr[i];
                }
                else
                    maxsummarr[i] = 0;

            }
             */
        }
        for(int i=0;i<arrlen;++i)
        {
            if(maxsummarr[i] > max_sum)
                max_sum = maxsummarr[i];
        }
        return max_sum;
    }

    public static void main(String[] args)
    {
        MaxContiguousSubseq obj = new MaxContiguousSubseq();
        int[] arr = {4,-11,13,-4,-5,2};
        int[] arr2 = {1,-3,4,-2,-1,6};
        int[] arr3 ={-2,11,-4,13,-5,2};
        int max_sum = obj.maxsumbrute(arr);
        int max_sum2 = obj.maxsumbrute(arr2);
        int max_sum3 = obj.maxsum(arr);
        int max_sum4 = obj.maxsum(arr2);
        int max_sum5 = obj.maxsumbrute(arr3);
        int max_sum6 = obj.maxsum(arr3);
        int max_sum7 = obj.maxsumdp(arr);
        int max_sum8 = obj.maxsumdp(arr2);
        int max_sum9 = obj.maxsumdp(arr3);
        System.out.println("the max sum using brute is "+max_sum +"   "+max_sum2+"   "+max_sum5 );
        System.out.println("the max sum  is "+max_sum3 +"   "+max_sum4+"   "+max_sum6);
        System.out.println("the max sum using dp  is "+max_sum7 +"   "+max_sum8+"   "+max_sum9);
    }
}
