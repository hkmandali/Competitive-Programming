package src.Arrays;
// we need to find out if there exists 3 elements in the array such that they form an increasing subsequence

// one of the approaches can be longest increasing subsequence which is done in O(n2)
public class increasing3tuple {

    // returns true if there are 3 increasing element
    boolean longestincreasingsubseq(int[] arr)
    {
        int len = arr.length;
        int[] lis = new int[len]; // has length of  longest increasing subseq till that index
        lis[1] =1; // as 1 element is always increasing
        for(int i=1;i<len;++i)
        {
            lis[i] =1;
            for(int j=0;j<i;++j)
            {
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    if(lis[i] == 3)
                    {

                        System.out.println(" 3 elements exist with increasing subseq at index"+i);
                    }
                }
            }
        }
        System.out.println("not found in n2");
        return false;
    }

    // it can be solved using O(n) by using below method
    // we need to find out the index at which there are two numbers less than the current one

    boolean longeston(int[] arr)
    {
        int len = arr.length;
        int first = Integer.MAX_VALUE , second = Integer.MAX_VALUE;
        for(int i=0;i<len;++i)
        {
            if(arr[i] > first && arr[i] > second) // if the current element is greater than both of them , we return true
            {
                System.out.println(" the three elements are "+ first+ "  "+second+"  "+arr[i]);
                return true;
            }
            if(first > arr[i])
            {
                first = arr[i];
            }
            else if(second > arr[i])
                second = arr[i];
        }
        System.out.println("elements not found");
        return false;

    }
    public static void main(String[] args) {
        int[] arr ={1,3,2,4,5};
        new increasing3tuple().longestincreasingsubseq(arr);

        new increasing3tuple().longeston(arr);
    }
}
