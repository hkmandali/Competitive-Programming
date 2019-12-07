// given an array and an input parameter(max_step)[ we can jump upto max step i.e at a given index we can take from 1 to max step steps ] , we need to find out what is the maximum value that can be achieved when we reach the last index
package src.Arrays;
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

import java.util.Comparator;
public class SubArrayMaxStep {
    public static void main(String[] args) throws IOException {
        //int[] arr = {10,2,-10,5,20};
        int[] arr = {2,-4,6,10,-12};
        int len = arr.length;
        int[] finarr = new int[len]; // array which has the final values finarr[len-1] will be our result ,O(nk)
        int[] finarr2 = new int[len]; // array which has the final values finarr2[len-1] will be our result , O(nlogk)
        System.out.println("enter the max steps");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max_step = Integer.parseInt(br.readLine());
        // creating a max heap with capacity of max-step ,
        PriorityQueue obj = new PriorityQueue<Integer>(new Comparator<Integer>(){

            public int compare(Integer a, Integer b)
            {
                if(a<b)
                    return 1;
                else if(a>b)
                    return -1;
                else
                    return 0;
            }
        });
        finarr[0] =arr[0];
        finarr2[0] =arr[0];
        obj.add(arr[0]); // adding the first element to priority queue
        //O(n*k) solution
        for(int i=1;i<len;++i)
        {
            int max = Integer.MIN_VALUE;
            int j=i-1;
            while(j>=(i-max_step) && j >=0)
            {
                if(finarr[j] > max)
                    max = finarr[j];
                j--;
            }
            finarr[i] = max + arr[i];
        }
            //O(n*log(k)) solution
        for(int i=1;i<len;++i)
        {
            finarr2[i] = arr[i] + (int)obj.peek();
            if(obj.size() == max_step)
            {
                System.out.println("reached max size and removing te first "+ arr[i-max_step] );
                obj.remove((Integer)arr[i-max_step]); // if the size of priority queue has reached max size , remove the index of first one

            }
            System.out.println("  size and max now is "+ obj.size() +" "+obj.peek());
            obj.add(finarr2[i]);
            System.out.println("  size after adding is "+obj.size());
        }

        System.out.println(" the max array is ");
        System.out.println(Arrays.toString(finarr));
        System.out.println(" the max array 2 is ");
        System.out.println(Arrays.toString(finarr2));

    }
}
