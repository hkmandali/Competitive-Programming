package DynamicProgramming;

import java.util.Scanner;

// given n chords , find the number of ways in which the chords can be drawn using 2*n points without any chord intersecting
public class CircleNonIntersectingChords {
    static void numways(int numchords) {
        int num_points = 2 * numchords;
        // we can observe that the num of ways with 2 points is 1 and with 4 points is 2
        // note we need to draw the n chords mandatorily
        // we can see that a recurrence is observed if we divide the points into two sets ,
        // then the num of ways is number of ways on left side * right side
        int[] num_ways = new int[num_points + 1];
        num_ways[0] = 1;// just for recursion
        num_ways[2] = 1; // as there is only one way
        // now we need to find out the number of ways we can divide the points into two sets and sum up all of them
        for (int i = 4; i <= num_points; i = i + 2) // i is always even as the num points cannot be odd
        {    for (int j = 0; j < i; j = j + 2) {
                num_ways[i] += num_ways[j] * num_ways[i - 2 - j]; // 2 because we have already used those 2 points to draw a chord and
                // i-2-j gives the remaining points as j is used in other segment and i is the total number of points
            }
        }
        System.out.println("the number of ways using "+num_points+ "  points are "+ num_ways[num_points]);
    }
    public static void main(String[] args)
    {
        System.out.println("enter the num of chords");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        numways(n);
    }
}
