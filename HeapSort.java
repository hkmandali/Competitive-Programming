package src;

class HeapSort {
    void swap(int[] a,int i , int j)
    {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    int[] Heapsort(int[] a)
    {
        int[] b =a;
        int len =b.length;
        Heapsortrecur(b,len);
        return b;
    }
    private void Heapsortrecur(int[] a,int n) // array , size of array
    {
        for(int i=n/2 -1;i>=0;--i)
        {
            heapify(a,n,i);
        }
        for(int i=n-1;i>0;--i)
        {
            swap(a,0,i);
            heapify(a,i,0);
        }
    }
    private void heapify(int[] a,int n,int curr)// array , size of array , current node to be heapified
    {
        int curr_largest = curr;
        int left = 2*curr_largest +1;
        int right = 2*curr_largest +2;
        if(left < n && a[left] > a[curr_largest])
            curr_largest = left;
        if(right < n && a[right] > a[curr_largest])
            curr_largest = right;
        if(curr_largest != curr)
        {
            swap(a,curr,curr_largest);
            heapify(a,n,curr_largest);
        }

    }
}
