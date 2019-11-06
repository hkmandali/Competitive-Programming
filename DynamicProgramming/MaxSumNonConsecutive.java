package DynamicProgramming;

public class MaxSumNonConsecutive {
    private int maxsumdp(int[] arr) {
        int arrlen = arr.length;
        int max_sum = 0;
        int[] maxsummarr = new int[arrlen]; // this stores the max sum till that index
        if(arr[0] > 0)
            maxsummarr[0]= arr[0];
        else
            maxsummarr[0]= 0;
        if(arr[1] > arr[0])
            maxsummarr[1] =arr[1];
        else
            maxsummarr[0]= maxsummarr[0]; // this is zero or the sum of first index
        for(int i=2;i<arrlen;++i)
        {
            if(maxsummarr[i-2] + arr[i] > 0)
            {
                if(maxsummarr[i-2] + arr[i] > maxsummarr[i-1])
                    maxsummarr[i] = maxsummarr[i-2] + arr[i];
                else
                    maxsummarr[i] = maxsummarr[i-1]; // either zero or the previous value
            }
            else
                maxsummarr[i] = maxsummarr[i-1];
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
        MaxSumNonConsecutive obj = new MaxSumNonConsecutive();
        int[] arr = {4,-11,13,-4,-5,2};
        int[] arr2 = {1,-3,4,-2,-1,6};
        int[] arr3 ={-2,11,-4,13,-5,2};
        int max_sum = obj.maxsumdp(arr);
        int max_sum2 = obj.maxsumdp(arr2);
        int max_sum3 = obj.maxsumdp(arr3);
        System.out.println("the max sum for non consecutive using dp is "+max_sum +"   "+max_sum2+"   "+max_sum3 );
    }
}
