// given an array , for each element print the value obtained by multiplying all the elements except it without using division
// 1. A simple approach would be multiply all the elements and for every element divide it with current element , but we need to do without division , so maintain two arrays , one for maintaining left product and other for maintaining right product
// left array maintains the product from starting to left of that index , right maintains the product from the right of it to end
package src.Arrays;

import java.util.Arrays;

public class MultiplicatedArray {
    static int[] MulwithoutDiv(int[] a)
    {
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] =1;
        right[len-1] = 1;
        for(int i=1;i<len;++i)
        {
            left[i] = left[i-1] * a[i-1];
            right[len-i-1] = right[len-i] * a[len-i];
        }
        int[] res = new int[len];
        for(int i=0;i<len;++i)
        {
            res[i] = left[i] * right[i];
        }
        return res;
    }
    public static void main(String[] args)
    {
        int[] arr = { 1,2,-3,4,-5,6};
        int[] res = MulwithoutDiv(arr);
        System.out.println(Arrays.toString(res));
    }
}
