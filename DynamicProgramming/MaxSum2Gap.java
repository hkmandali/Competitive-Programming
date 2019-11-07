package DynamicProgramming;

public class MaxSum2Gap { // for each element there should be atleast 2 elements in between we select the next element
    private int maxsumdp(int[] arr)
    {
        int arrlen = arr.length;
        int max_sum = 0;
        int[] maxsummarr = new int[arrlen]; // this stores the max sum till that index
        if(arr[0] > 0)
            maxsummarr[0] = arr[0];
        else
            maxsummarr[0] = 0;
        if(arr[1] > arr[0])
        {
            if(arr[1] > 0)
                maxsummarr[1] = arr[1];
            else
                maxsummarr[1] =maxsummarr[0];
        }
        else
            maxsummarr[1] = maxsummarr[0];
        if(arr[2] > arr[1])
        {
            if(arr[2] > 0)
                maxsummarr[2] = arr[2];
            else
                maxsummarr[2] =maxsummarr[1];
        }
        else
            maxsummarr[2] = maxsummarr[1];
        for(int i=3;i<arrlen;++i)
        {
            if(maxsummarr[i-3] + arr[i] > 0)
            {
                if(maxsummarr[i-3] + arr[i] > maxsummarr[i-2])
                    maxsummarr[i] = maxsummarr[i-3] + arr[i];
                else
                    maxsummarr[i] = maxsummarr[i-1];
            }
            else
            {
                maxsummarr[i] = maxsummarr[i-1];
            }
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
        MaxSum2Gap obj = new MaxSum2Gap();
        int[] arr = {4,-11,-13,-4,-5,2};
        int[] arr2 = {1,8,4,-2,3,6};
        int[] arr3 ={-2,10,-4,13,-5,2};
        int max_sum = obj.maxsumdp(arr);
        int max_sum2 = obj.maxsumdp(arr2);
        int max_sum3 = obj.maxsumdp(arr3);
        System.out.println("the max sum 2 gap for non consecutive using dp is "+max_sum +"   "+max_sum2+"   "+max_sum3 );
    }
}
