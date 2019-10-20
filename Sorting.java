package src;

import src.QuickSort;
import java.util.Arrays;

public class Sorting {
    public static class Merge{
        void Merge(int[] a,int left,int middle,int right) // this function will merge the two arrays ,
        // left to middle and middle + 1 to right
        {
            System.out.println(" Merge left is " + left +" middle is "+ middle +" right is "+right);
            int i,j;
            int num1 = middle - left + 1; // num of elements in first
            int num2 = right - middle; // num of elements in second
            int[] first = new int[num1];
            int[] second = new int[num2];
            for(i=0;i<num1;++i)
                first[i] = a[left +i];
            for(j=0;j<num2;++j)
                second[j] = a[middle + 1 +j];
            if(right - left == 1)
            {
                if(a[left] > a[right])
                {
                    System.out.println("one to one " + a[left] + "  and "+ a[right]);
                    int temp = a[left];
                    a[left] = a[right];
                    a[right] = temp;
                }
            }
            else
            {
                System.out.println(" in else i is " + i +" middle is "+middle  +" j is "+j +" right is "+ right);
                i=0;j=0;
                int k = left;
                while(i < num1 && j< num2)
                {
                    System.out.println(" in if a[i] is " + a[i] + "  a[j] is "+ a[j]);
                    if(first[i] < second[j])
                    {
                        a[k] = first[i];
                        i++;
                    }
                    else
                    {
                        a[k] = second[j];
                        j++;
                    }
                    k++;
                    /*
                    if(a[i] > a[j] ) // swap them
                    {

                        System.out.println("in merge swappning " + a[i] + "  and "+ a[j]);
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        i++;
                    }
                    else
                    {
                        j++;
                    }
                    */ // the issue with tthis approach has been that after swapping re ordering is not happening i.e
                    // it ends as -7 1 2 10 8 9 --> second half is not sorting , so we need to store in temp  arrays .

                }
                // hint taken through gfg
                while(i < num1)
                {
                    a[k] = first[i];
                    i++;
                    k++;
                }
                while(j < num2)
                {
                    a[k] = second[j];
                    j++;
                    k++;
                }
                System.out.println("value after llop i is " + i +" middle is "+middle +" right is " + right +"  j is "+ j);

            }
        }
        void Divide(int[] a,int lef,int righ) // this function will
        // divide the array into halves and calls recursively
        {
            //System.out.println(" Divide left is " + left  +" right is "+right);
            int left = lef;
            int right = righ;
            int[] b =a; // here modifying b or a will be the same as it is passed as reference
            if(left < right) {
                Divide(b, left, left + (right - left) / 2);
                Divide(b, 1 + left + (right - left) / 2, right);
                int middle = left + (right - left )/2;
                System.out.println("calling merge on left is " + left +" middle is" +middle+ "  right is "+ right);
                Merge(b, left,middle, right);
            }
            //System.out.println(" left is " + left + "  right is "+ right);
        }
        int[] Mergesort(int[] a)
        {
            int[] b = a;
            int len = b.length;
            Divide(b,0,len-1);
            return b;
        }
    }

    static int[] bubblesort(int[] a) // highest to the last approach
    {
        int[] b =a;
        int size = b.length;
        System.out.println("the elements passed are ");
        System.out.print(Arrays.toString(b));
        int swap=1; // used as an extra flag
        for(int i=0;i<size && swap ==1;++i)
        {
            swap =0;
            for(int j=0;j<size-i-1;++j) // last i elements are already sorted
            {

                if(b[j] > b[j+1])
                {               // comparing every j with j +1 i.e pushing the highest element to last
                    int temp = b[j+1];
                    b[j+1] = b[j];
                    b[j] = temp;// swapping the adjacent elements and pushing the highest elemnt to last
                    swap =1;
                }
            }
        }
        return b;
    }
    static int[] bubblesort3(int[] a) // lowest to the first approach
    {
        int[] b =a;
        int size = b.length;
        //System.out.println("the elements passed are ");
        //System.out.print(Arrays.toString(b));
        for(int i=size-1;i>=0;--i)
        {
            for(int j=size-1;j>= size-i;--j) // last i elements are already sorted
            {
                if(b[j] < b[j-1])
                {               // comparing every j with j-1 i.e pushing the lowest element to first
                    int temp = b[j-1];
                    b[j-1] = b[j];
                    b[j] = temp;// swapping the adjacent elements and pushing the lowest elemnt to first
                }
            }
        }
        return b;
    }
    static int[] bubblesort2(int[] a) // number of swaps less , comp same (hybrid between selection and bubble)
    {
        int[] b =a;
        int size = b.length;
        //System.out.println("the elements passed are ");
        //System.out.print(Arrays.toString(b));
        for(int i=0;i<size;++i)
        {
            for(int j=i+1;j<size;++j)
            {
                int temp = b[i];
                if(b[i] > b[j])
                {               // comparing only the ith element with all other elements and not j with j +1, this reduces the number of comparisons for a particular element position
                    b[i] = b[j];
                    b[j] = temp;
                    // swapping the least element to the front
                }
            }
        }
        return b;
    }
    static int[] selection(int[] a) // sim to bub2 but swap is only made at the last
    {
        int size = a.length;
        int[] b =Arrays.copyOf(a,size); // this doesnt modify the original array and allocates a new memory in the heap

        //System.out.println("the elements passed are ");
        //System.out.print(Arrays.toString(b));
        for(int i=0;i<size;++i)
        {
            int min = i; //  index of min
            for(int j=i+1;j<size;++j)
            {
                if(b[i] > b[j])
                {
                    min = j;
                    // finding the min element and then swapping with i
                }
            }
            int temp = b[min];
            b[min] = b[i];
            b[i] = temp;
        }
        return b;
    }
    static int[] insertion(int[] a) // inserting the element at the correct position
    {
        int[] b =a;
        int size = b.length;
        //System.out.println("the elements passed are ");
        //System.out.print(Arrays.toString(b));
        for(int i=1;i<size;++i)
        {
            int min = b[i]; //  index of min
            int j =i;
            for(;j>0 && min < b[j-1];--j)
            {
          //      System.out.println("current value of j is "+j+"  b[j] " +b[j] +" b[j-1] is" +b[j-1]);
                b[j] = b[j-1];

            }
            //System.out.println("current value of j " +j + " b[j] is "+b[j] + " min is "+ min+" min is "+ min);
            b[j] = min;
            //System.out.println("value of i is "+i+" after of j " +j + " b[j] is "+b[j] + " min is "+ min);
        }
        return b;
    }
    static int[] shellsort(int[] a) // this is an advanced version of shell sort which reduces the
    // number of comparisons by dividing the list into sublists and then sorting accordingly
    {
        int[] b =a;
        int size =a.length;
        int gap_size = size/2;
        for(;gap_size>0;gap_size= gap_size/2)
        {
            // now it is as normal insertion sort but the number of swaps are reduced
            for(int i=gap_size;i<size;++i)
            {
                int temp = b[i]; // current index
                int j =i;
                for(;j>=gap_size && temp < b[j-gap_size];j-=gap_size)// bawically we are taking the elements of gap distance and comparing them
                {
                    b[j] = b[j-gap_size]; // similar to insertion sort
                }
                b[j] = temp;
            }
        }
        return b;
    }
    public static void main(String[] args){
        int[] arr = {10,1,2,9,8,-7};
        int n = arr.length;// size of array
        int[] bub2 = bubblesort2(arr);
        System.out.println("the sorted elements through bubble sort 2 are ");
        for(int i=0;i<n;++i)
        {
            System.out.print(bub2[i] +" ");
        }
        int[] bubarr = {10,1,2,9,8,-7};
        int[] bub = bubblesort(bubarr);
        System.out.println("the sorted elements through bubble sort are ");
        for(int i=0;i<n;++i)
        {
            System.out.print(bub[i] +" ");
        }

        int[] bub3arr = {10,1,2,9,8,-7};
        int[] bub3 = bubblesort3(bub3arr);
        System.out.println("the sorted elements through bubble sort3 are ");
        for(int i=0;i<n;++i)
        {
            System.out.print(bub3[i] +" ");
        }

        int[] selarr = {10,1,2,9,8,-7};
        int[] sel = selection(selarr);
        System.out.println("the sorted elements through selection sort are ");
        for(int i=0;i<n;++i)
        {
            System.out.print(sel[i] +" ");
        }
        System.out.println("the sinpout array is are ");
        for(int i=0;i<n;++i)
        {
            System.out.print(selarr[i] +" ");
        }

        int[] insarr = {10,1,2,9,8,-7};
        int[] ins = insertion(insarr);
        System.out.println("the sorted elements through insertipon sort are ");
        for(int i=0;i<n;++i)
        {
            System.out.print(ins[i] +" ");
        }

        int[] shellarr = {10,1,2,9,8,-7};
        int[] shell = shellsort(shellarr);
        System.out.println("the sorted elements through shell sort are ");
        for(int i=0;i<n;++i)
        {
            System.out.print(shell[i] +" ");
        }
        Sorting.Merge innerclass = new Sorting.Merge();
        int[] mergearr = {10,1,2,9,-7,8};
        int len = mergearr.length;
        int[] mergeaftarr = innerclass.Mergesort(mergearr);
        System.out.println("the sorted elements through merge sort are ");
        for(int i=0;i<len;++i)
        {
            System.out.print(mergeaftarr[i] +" ");
        }

        int[] quickarr = {10,1,2,9,-7,8};
        int quicklen = quickarr.length;
        QuickSort obj = new QuickSort();
        int[] quickaftarr = obj.QuickSort(quickarr);
        System.out.println("the sorted elements through quick sort are ");
        for(int i=0;i<quicklen;++i)
        {
            System.out.print(quickaftarr[i] +" ");
        }

        int[] heaparr = {4,10,3,1,5};
        int heaplen = heaparr.length;
        HeapSort heapobj = new HeapSort();
        int[] heapaftarr = heapobj.Heapsort(heaparr);
        System.out.println("the sorted elements through heap sort are ");
        for(int i=0;i<heaplen;++i)
        {
            System.out.print(heaparr[i] +" ");
        }

        return;
    }
}
