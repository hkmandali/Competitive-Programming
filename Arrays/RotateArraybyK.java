// given an array and a number k , print the resulting array obtained by shifting the array by k positions ,
// for simplicity we have considered k < n , if k > n just add mod
package src.Arrays;

import java.util.Arrays;

public class RotateArraybyK {
    static void rotatewithoutmem(int[] arr,int k)
    {
        int changes =0;
        int len =arr.length;
        int current = arr[0];
        int i=0;
        while(changes < len)
        {
            int temp = arr[(i+k )%len];
            arr[(i+k )%len] = current;
            current = temp;
            i = (i +k )% len;
            changes++;
        }
    }
    public static void main(String[] args)
    {
        int[] arr ={1,2,3,4,5,6};
        int k =3;
        int len = arr.length;
        int[] newarr = new int[len];
        for(int i=0;i<len;++i)
        {
            newarr[(i+k) % len] = arr[i]; //in this case we are taking an extra memory of newarr i.e n
        }
        System.out.println(Arrays.toString(newarr));

        // without extra memory approach , not wokring for corner cases , need to update
        if(arr.length % k == 0)
        {
            rotatewithoutmem(arr,k-1);
            rotatewithoutmem(arr,1);
        }
        else
            rotatewithoutmem(arr,k);
        System.out.println(Arrays.toString(arr));

    }
}
