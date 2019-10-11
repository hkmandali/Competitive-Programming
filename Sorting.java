package src;


import java.util.Arrays;

public class Sorting {
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
        System.out.println("the elements passed are ");
        System.out.print(Arrays.toString(b));
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
        System.out.println("the elements passed are ");
        System.out.print(Arrays.toString(b));
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
        int[] b =a;
        int size = b.length;
        System.out.println("the elements passed are ");
        System.out.print(Arrays.toString(b));
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
        System.out.println("the elements passed are ");
        System.out.print(Arrays.toString(b));
        for(int i=1;i<size;++i)
        {
            int min = b[i]; //  index of min
            int j =i;
            for(;j>0 && min < b[j-1];--j)
            {
                System.out.println("current value of j is "+j+"  b[j] " +b[j] +" b[j-1] is" +b[j-1]);
                b[j] = b[j-1];

            }
            System.out.println("current value of j " +j + " b[j] is "+b[j] + " min is "+ min+" min is "+ min);
            b[j] = min;
            System.out.println("value of i is "+i+" after of j " +j + " b[j] is "+b[j] + " min is "+ min);
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

        int[] insarr = {10,1,2,9,8,-7};
        int[] ins = insertion(insarr);
        System.out.println("the sorted elements through insertipon sort are ");
        for(int i=0;i<n;++i)
        {
            System.out.print(ins[i] +" ");
        }

        return;
    }
}
