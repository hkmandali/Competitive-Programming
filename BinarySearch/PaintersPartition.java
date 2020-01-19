package src.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
/*
 2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.


Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.
 */
// https://www.interviewbit.com/problems/painters-partition-problem/

// this can be solved using binary search by finding out the min number of hrs and max number of hrs required to paint all the boards and then minimizing it
public class PaintersPartition {
    /*
    static long minTime(ArrayList<Integer> C,long timeforeachblock) // this is achieved when there are enough number of painters as the number of blocks , so each painter paints only one block and the time will be max among the collection
    {
        int size = C.size();
        long mintime =0;
        for(int i=0;i<size;++i)
        {
            if(C.get(i) > mintime)
                mintime = (long)(C.get(i));
        }
        return mintime*timeforeachblock; // this is for 1 unit of board , and needs to be multiplied by B to get final time
    }

    static long maxTime(ArrayList<Integer> C,long timeforeachblock) // this is achieved when there is only one painter and he paints all of them so the time will be sum of length of all boards
    {
        long maxtime =0;
        int size = C.size();
        for(int i=0;i<size;++i)
        {
            maxtime += (long)C.get(i);
        }
        return maxtime*timeforeachblock; // this is for 1 unit of board , and needs to be multiplied by B to get final time
    }

    static int numPainters(ArrayList<Integer> C,long time,long timeforeachblock) //this gives us the minimum number of painters required to finish the painting in the given time , this can be possible because the painter can only paint adjacent boards
    {
        int numpainter =1;
        int size = C.size();
        long current_time=0; // current elapsed time
        for(int i=0;i<size;++i)
        {
            current_time += (C.get(i)* timeforeachblock);
            if(current_time > time)
            {
                numpainter++;
                current_time = C.get(i)* timeforeachblock;
            }
        }
        return numpainter;
    }
    // this function returns the min time required to paint all boards
    public static int paint(int A, int B, ArrayList<Integer> C) { // A is num of painters, B is time taken by each painter to paint 1 unit of baord and C is the length of board
        long mintime = minTime(C,B);
        long maxtime = maxTime(C,B);
        System.out.println("min time is "+mintime);
        System.out.println("max time is "+maxtime);
        long numhrs = 0;
        while(mintime <= maxtime)
        {
            long midtime = (mintime + maxtime )/2;
            System.out.println("num of painters requrired for "+midtime+"  is "+numPainters(C,midtime,B));
            if(numPainters(C,midtime,(long)B) > A) // num of painters required to finish painting in midtime greater than the number of painters we have , so increment the time
            {
                mintime = midtime +B;
                System.out.println("min is "+mintime+"  max is "+maxtime+"   mid is "+midtime);
            }
            else // num of painters required is less than the num of painters we have , so we decrement the time
            {
                numhrs = midtime;
                System.out.println("min is "+mintime+"  reducing max is "+maxtime+"   mid is "+midtime);
                maxtime = midtime -B; // as we have single unit of time for each unit of board , this is multiplied before returning
            }

        }
        return (int)((numhrs/B) *B )%10000003 ;
    }

     */
    // the above approach is done by considering multiplying the time , now we'll implement for unit time as the multiplication factor is going wrong in corner cases
    // this is for unit time , we'll multiuply the final answer by B
    static long minTime(ArrayList<Integer> C) // this is achieved when there are enough number of painters as the number of blocks , so each painter paints only one block and the time will be max among the collection
    {
        int size = C.size();
        long mintime =0;
        for(int i=0;i<size;++i)
        {
            if(C.get(i) > mintime)
                mintime = (long)(C.get(i));
        }
        return mintime; // this is for 1 unit of board , and needs to be multiplied by B to get final time
    }

    static long maxTime(ArrayList<Integer> C) // this is achieved when there is only one painter and he paints all of them so the time will be sum of length of all boards
    {
        long maxtime =0;
        int size = C.size();
        for(int i=0;i<size;++i)
        {
            maxtime += (long)C.get(i);
        }
        return maxtime; // this is for 1 unit of board , and needs to be multiplied by B to get final time
    }

    static int numPainters(ArrayList<Integer> C,long time) //this gives us the minimum number of painters required to finish the painting in the given time , this can be possible because the painter can only paint adjacent boards
    {
        int numpainter =1;
        int size = C.size();
        long current_time=0; // current elapsed time
        for(int i=0;i<size;++i)
        {
            current_time += C.get(i);
            if(current_time > time)
            {
                numpainter++;
                current_time = C.get(i);
            }
        }
        return numpainter;
    }
    // this function returns the min time required to paint all boards
    public static int paint(int A, int B, ArrayList<Integer> C) { // A is num of painters, B is time taken by each painter to paint 1 unit of baord and C is the length of board
        long mintime = minTime(C); // for unit time
        long maxtime = maxTime(C);
       // System.out.println("min time is "+mintime);
        //System.out.println("max time is "+maxtime);
        long numhrs = 0;
        while(mintime <= maxtime)
        {
            long midtime = mintime + (maxtime - mintime)/2;
            //System.out.println("num of painters requrired for "+midtime+"  is "+numPainters(C,midtime));
            if(numPainters(C,midtime) > A) // num of painters required to finish painting in midtime greater than the number of painters we have , so increment the time
            {
                mintime = midtime +1;
               // System.out.println("min is "+mintime+"  max is "+maxtime+"   mid is "+midtime);
            }
            else // num of painters required is less than the num of painters we have , so we decrement the time
            {
                numhrs = midtime;
               // System.out.println("min is "+mintime+"  reducing max is "+maxtime+"   mid is "+midtime);
                maxtime = midtime -1; // as we have single unit of time for each unit of board , this is multiplied before returning
            }

        }
        return (int)(((numhrs % 10000003) * (B % 10000003) ) % 10000003);
    }

    public static void main(String[] args)
    {
        System.out.println(paint(3,10,new ArrayList<Integer>(Arrays.asList(185, 186, 938, 558, 655, 461, 441, 234, 902, 681)))); // A is the num of painters we have , B is time taken for each unit of board , C are the boards
    }
}
