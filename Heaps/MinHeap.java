package src.Heaps;

import src.Trees.Tree;

import java.util.ArrayList;

public class MinHeap extends Tree {
    int capacity;
    int curr_no_of_elements;
    int[] arr;
    ArrayList<Integer> arr1;
    MinHeap(int capacity)
    {
        arr = new int[capacity];
        this.capacity = capacity;
        curr_no_of_elements= 0;
    }
    int getCapactity()
    {
        return capacity;
    }
    int parent(int i) // here i is the index
    {
        return (i-1)/2;
    }
    int leftchild(int i)
    {
        return 2*i +1;
    }
    int rightchild(int i)
    {
        return 2*i +2;
    }
    void insertKey(int key) // this method inserts a key into the tree
    {
        if(capacity == curr_no_of_elements)
            System.out.println("cannot insert anymore as it is full");
        curr_no_of_elements++;
        int curr_index = curr_no_of_elements-1;
        arr[curr_index] = key;
        while(curr_index != 0 && arr[parent(curr_index)] > arr[curr_index])
        {
            // swapping both the elements
            arr[parent(curr_index)] = arr[parent(curr_index)] + arr[curr_index];
            arr[curr_index] = arr[parent(curr_index)] - arr[curr_index];
            arr[parent(curr_index)] = arr[parent(curr_index)] - arr[curr_index];
            curr_index = parent(curr_index);
        }
        return;
    }
    // this method extracts the min among the heap and returns to us
    int extractMin()
    {
        int min = arr[0];
        arr[0] = arr[curr_no_of_elements -1];
        curr_no_of_elements--;
        heapify(0); // this propagates the heap property to bottom sub trees
        return min;
    }
    void heapify(int index) // for min heap
    {
        int left = 2*index +1;
        int right = 2*index +2;
        int smallest_index = right; // this stores the index of the smallest element among left and right
        // we have both the children , now we need to propagate it upwards
        if(arr[left] < arr[right])
        {
            smallest_index = left;
        }
        if(arr[smallest_index] < arr[index])
        {
            // if the child is less than parent , then swap both of them and heapify the below sub trees as it needs to be propagated
            arr[smallest_index] = arr[smallest_index] + arr[index];
            arr[index] = arr[smallest_index] - arr[index];
            arr[smallest_index] = arr[smallest_index] - arr[index]; // swapped both of them , now call heapify on the below sub trees
            heapify(smallest_index);
        }
    }
    boolean delete(int key)
    {

        return false;
    }
    public static void main(String[] args)
    {
        MinHeap obj = new MinHeap(8);
        obj.insertKey(10);
        obj.insertKey(87);
        obj.insertKey(817);
        obj.insertKey(7);
        obj.insertKey(9);
        System.out.println("the value at root is "+obj.extractMin());
    }
}
