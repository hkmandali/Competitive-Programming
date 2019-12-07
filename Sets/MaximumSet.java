package src.Sets;
// given a set of numbers(min and max) , find the maximum range which is present in all the sets
// suppose (1,4) , (2,5) ,(3,7) then (3,4) is the range which is present in all the sets

import java.util.ArrayList;

public class MaximumSet {
    static class Point
    {
        int low;
        int high;
        ArrayList<Point> setofpoints = new ArrayList();
        void addpoint(int low,int high)
        {
            Point dummy = new Point();
            dummy.high = high;
            dummy.low= low;
            setofpoints.add(dummy);
        }

    }
    public static void main(String[] args)
    {
        Point obj = new Point();
        obj.addpoint(1,4);
        obj.addpoint(2,5);
        obj.addpoint(6,7);
        int lowest = Integer.MIN_VALUE;
        int highest = Integer.MAX_VALUE;
        for(int i =0;i<obj.setofpoints.size();++i)
        {
            if(obj.setofpoints.get(i).low > lowest)
                lowest = obj.setofpoints.get(i).low;
            if(obj.setofpoints.get(i).high < highest)
                highest = obj.setofpoints.get(i).high;
        }
        if(lowest < highest)
            System.out.println(" the max interval is "+ lowest +"  to "+highest);
        else
            System.out.println(" the max interval is "+ highest +"  to "+lowest);
    }
}
