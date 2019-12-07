package src.Arrays;

import java.util.Arrays;

// this program finds out the least number not present in the array
public class LeastNotPresentinArray {
    public static void main(String[] args)
    {
        int[] arr = {-1,-100,1,2,3,4};
        //int[] arr = {4,5,1,2,6,0};
        int min = Integer.MAX_VALUE;
        int i=0;
        int len = arr.length;
        for(i=0;i<len;++i)
        {
            if(arr[i] < min)
                min = arr[i];
        }
        if(min < 0) {
            for (i = 0; i < len; ++i) {
                arr[i] = arr[i] - (min - 1);
            }
        }
        System.out.println("array now is"+ Arrays.toString(arr));
        for(i=0;i<len;++i)
        {
            if(min < 0) {
                if (Math.abs(arr[i]) + min >= 0 && Math.abs(arr[i]) + min < len) {
                    if (arr[Math.abs(arr[i]) + min] > 0)
                        arr[Math.abs(arr[i]) + min] = -arr[Math.abs(arr[i]) + min];
                }
            }
            // only for +ve
            else {
                if (Math.abs(arr[i]) < len) {
                    if (arr[Math.abs(arr[i])] > 0)
                        arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
                }
            }

        }

        for(i=0;i<len;++i)
        {
            int j =i-1;
            if(arr[i] > 0)
            {
                if(min < 0)
                    System.out.println("the least number not present in array is "+j);
                else
                    System.out.println("the least number not present in array is "+i);
                i = len +1;
            }
        }
        if(min >= 0) {
            if (i == len) {
                System.out.println("the least number not present in array is " + i);
            }
        }

    }
}
