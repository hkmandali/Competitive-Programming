package src;

public class QuickSort {
    void swap(int[] a,int i , int j)
    {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    int[] QuickSort(int[] a)
    {
        int[] b =a;
        int len = b.length;
        Quicksortrecur(b,0,len-1);
        return b;
    }
    int partition(int[] a, int low,int high)
    {
        int pivot =a[low];
        int i=low+1,j;
        for(j = low+1;j <= high;++j)
        {
            if(a[j] < pivot)
            {
                swap(a,i,j);
                i++;
            }

        }
        swap(a,low,i-1);
        return i-1;
    }
    void Quicksortrecur(int[] a,int low,int high)
    {
        if(low < high)
        {
            int par = partition(a,low,high);
            Quicksortrecur(a,low,par-1);
            Quicksortrecur(a,par+1,high);
        }
    }
}
