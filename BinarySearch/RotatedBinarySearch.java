package BinarySearch;

public class RotatedBinarySearch {
    static int BinarySearch(int[] a,int start_index,int last_index,int search)
    {
        int mid = (start_index + last_index)/2;
        if(start_index > last_index)
            return -1;
        if(a[mid] == search)
        {
            return mid;
        }
        else if((start_index + last_index)/2 == start_index)// only two elements case
        {
            if(a[start_index] == search)
                return start_index;
            else if(a[last_index] == search)
                return last_index;
            else
                return -1;
        }
        else
        {
            if(a[start_index] < a[mid]) // first half is sorted
            {
                // element lies in between start and mid
                if(search >= a[start_index] && search < a[mid]) // we dont consider = mid becuase it is already considered above
                    return BinarySearch(a, start_index, mid-1, search);
                // element doesnt lie in between
                else
                    return BinarySearch(a,mid+1,last_index,search);
            }
            else // second half is sorted
            {
                // element lies in between mid and last
                if(search > a[mid] && search <= a[last_index])
                    return BinarySearch(a,mid+1,last_index,search);
                // element doesnt lies in between
                else
                    return BinarySearch(a,start_index,mid-1,search);
            }
        }
    }
    public static void main(String[] args)
    {
        int[] a={3,4,5,6,7,0,1,2};
        for(int i=0;i<a.length;++i)
        {
            int res = BinarySearch(a,0,a.length-1,a[i]);
            System.out.println("the element "+a[i]+" is found at index "+res);
        }
    }
}
