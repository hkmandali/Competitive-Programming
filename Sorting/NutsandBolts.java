package src.Sorting;

import java.util.Arrays;

// given a sequence of nuts and bolts , we need to find out the matching
// the brute force approach would be to match each nut with each bolt , so that we get the matching one's , it would take n2 complexity
// we can reduce this by sorting the nuts similar to bolts by using quick sort
// we choose a pivot element and then sort smaller elements to left and larger to right
public class NutsandBolts {
    static int partition(char[] input,int low , int high , char pivot)
    {
        int i = low;
        char temp1;
        for(int j=low;j<high;++j)
        {
            if(input[j] < pivot)
            {
                temp1 = input[i];
                input[i] = input[j];
                input[j] = temp1;
                i++;
            }
            else if(input[j] == pivot){
                temp1 = input[j];
                input[j] = input[high];
                input[high] = temp1;
                j--;
            }
        }
        temp1 = input[i];
        input[i] = input[high];
        input[high] = temp1;
        return i;
    }
/*
    static int partitionquick(int[] arr, int low , int high)
    {
        int pivot = arr[high];
        int i = low;
        for(int j=low;j<high;++j)
        {
            if(arr[j] < pivot)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    static void quicksort(int[] arr , int low , int high)
    {
        if(low < high)
        {
            int part = partitionquick(arr,low,high);
            System.out.println("part is "+part);
            quicksort(arr,low,part-1);;
            quicksort(arr,part+1,high);
        }
    }
    */
    static void matchPairs(char[] nuts,char[] bolts,int low , int high)
    {
        // we need to apply quicksort for nuts based on the last element of bolts
        if(low < high)
        {
            //char ch =bolts[high];
            int pivot = partition(nuts,low,high,bolts[high]); // based on the last element of bolt we partition the nuts
            // next we partition bolts based on the pivot element
            System.out.println("nuts now is "+Arrays.toString(nuts));
            partition(bolts,low,high,bolts[high]);
            System.out.println("bolts now is "+Arrays.toString(bolts));
            matchPairs(nuts, bolts, low, pivot-1);
            matchPairs(nuts, bolts, pivot+1, high);

        }
    }
    static void printArray(char[] input)
    {
        for(char ch:input) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char[] nuts = {'a','e','d','b','c'};
        char[] bolts = {'e','a','c','b','d'};
        //char nuts[] = {'@', '#', '$', '%', '^', '&'};
        //char bolts[] = {'$', '%', '&', '^', '@', '#'};

        // Method based on quick sort which matches nuts and bolts
        matchPairs(nuts, bolts, 0, 4);

        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        printArray(bolts);

//        int[] arr = {80,70,30,40,60,55,60};
//        quicksort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
    }
}
