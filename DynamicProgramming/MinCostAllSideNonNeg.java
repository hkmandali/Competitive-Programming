package src.DynamicProgramming;
// given an array with weights in each cell , find the min cost required to go to that cell from (0,0)
// it can go either up or down or left or right
// for any cell the min cost can be thought of as MinCost[i,j] = Min(MinCost[i+1,j] , MinCost[i,j-1],MinCost[i-1,j],MinCost[i,j+1]) + cost(i,j)
// arr contains the weights of those respective cells
// The idea is simple , we need to find dijkstra min path for all the blocks , so it can be thought of as a graph with num vertices = row * col

import java.util.*;

public class MinCostAllSideNonNeg {

    // block approach has been checked from gfg i.e to add the distance
    public static class Block{
        int x_cord; // x coordinate
        int y_cord; // y co ordinate
        int distance;
        Block(int x,int y,int z)
        {
            x_cord = x;
            y_cord =y;
            distance =z;
        }
    }

    static boolean checkInsideGrid(int x,int y,int row,int col)
    {
        if(x >= 0 && x < row && y>=0 && y< col)
            return true;
        else return false;
    }

    static int mincost(int[][] srcarr,int row,int col)
    {
        int[][] dist = new int[row][col]; // this array has the final results
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
                dist[i][j] = Integer.MAX_VALUE; // becuase for the first time , we check the value for comparision if it is greater
        }

        dist[0][0] = srcarr[0][0];
        // from any vertex we can go to either up or down or left or right
        Set<Block> list_ofblocks = new LinkedHashSet<Block>(); // Hashset can also be used , as we are only taking one element
        list_ofblocks.add(new Block(0,0,dist[0][0]));  // adding the initial block // left most
        while(!list_ofblocks.isEmpty()) // we keep pushing the blocks into the set till there is no block with a min value than the current one
        {

            Iterator<Block> itr = list_ofblocks.iterator();
            Block curr = itr.next();
            list_ofblocks.remove(curr); // we need to remove the current block after storing it


            int x_adj;
            int y_adj;

            // we need to consider four possibilities i.e four neighbours similar to dijkstra

            // case 1
            // [i][j+1]
            x_adj = curr.x_cord ;
            y_adj = curr.y_cord + 1;

            if (checkInsideGrid(x_adj, y_adj, row, col)) // checking if the point is inside grid
            {
                System.out.println("not empoty x adj is " + x_adj + " y adj is " + y_adj);
                if (dist[x_adj][y_adj] > dist[curr.x_cord][curr.y_cord] + srcarr[x_adj][y_adj]) // checking if the sum of previous and current value is greater than the value at final array , we update it
                {
                    Block curr_block = new Block(x_adj, y_adj, dist[x_adj][y_adj]);
                    //if it is already in the set delete it
                    if (list_ofblocks.contains(curr_block) ){
                        System.out.println("deleting the curr block");
                        list_ofblocks.remove(curr_block);
                    }
                    dist[x_adj][y_adj] = dist[curr.x_cord][curr.y_cord] + srcarr[x_adj][y_adj];
                    curr_block.distance =dist[x_adj][y_adj] ;
                    list_ofblocks.add(curr_block); // adding the current block to the set
                }
            }



            // case 2
            // [i][j-1]
            x_adj = curr.x_cord ;
            y_adj = curr.y_cord -1;

            if (checkInsideGrid(x_adj, y_adj, row, col)) // checking if the point is inside grid
            {
                System.out.println("not empoty x adj is " + x_adj + " y adj is " + y_adj);
                if (dist[x_adj][y_adj] > dist[curr.x_cord][curr.y_cord] + srcarr[x_adj][y_adj]) // checking if the sum of previous and current value is greater than the value at final array , we update it
                {
                    Block curr_block = new Block(x_adj, y_adj, dist[x_adj][y_adj]);
                    //if it is already in the set delete it
                    if (list_ofblocks.contains(curr_block) ){
                        System.out.println("deleting the curr block");
                        list_ofblocks.remove(curr_block);
                    }
                    dist[x_adj][y_adj] = dist[curr.x_cord][curr.y_cord] + srcarr[x_adj][y_adj];
                    curr_block.distance =dist[x_adj][y_adj] ;
                    list_ofblocks.add(curr_block); // adding the current block to the set
                }
            }



            // case 3
            // [i-1][j]
            x_adj = curr.x_cord -1;
            y_adj = curr.y_cord ;

            if (checkInsideGrid(x_adj, y_adj, row, col)) // checking if the point is inside grid
            {
                System.out.println("not empoty x adj is " + x_adj + " y adj is " + y_adj);
                if (dist[x_adj][y_adj] > dist[curr.x_cord][curr.y_cord] + srcarr[x_adj][y_adj]) // checking if the sum of previous and current value is greater than the value at final array , we update it
                {
                    Block curr_block = new Block(x_adj, y_adj, dist[x_adj][y_adj]);
                    //if it is already in the set delete it
                    if (list_ofblocks.contains(curr_block) ){
                        System.out.println("deleting the curr block");
                        list_ofblocks.remove(curr_block);
                    }
                    dist[x_adj][y_adj] = dist[curr.x_cord][curr.y_cord] + srcarr[x_adj][y_adj];
                    curr_block.distance =dist[x_adj][y_adj] ;
                    list_ofblocks.add(curr_block); // adding the current block to the set
                }
            }



            // case 4
            // [i+1][j]
            x_adj = curr.x_cord + 1;
            y_adj = curr.y_cord ;

            if (checkInsideGrid(x_adj, y_adj, row, col)) // checking if the point is inside grid
            {
                System.out.println("not empoty x adj is " + x_adj + " y adj is " + y_adj);
                if (dist[x_adj][y_adj] > dist[curr.x_cord][curr.y_cord] + srcarr[x_adj][y_adj]) // checking if the sum of previous and current value is greater than the value at final array , we update it
                {
                    Block curr_block = new Block(x_adj, y_adj, dist[x_adj][y_adj]);
                    //if it is already in the set delete it
                    if (list_ofblocks.contains(curr_block) ){
                        System.out.println("deleting the curr block");
                        list_ofblocks.remove(curr_block);
                    }
                    dist[x_adj][y_adj] = dist[curr.x_cord][curr.y_cord] + srcarr[x_adj][y_adj];
                    curr_block.distance =dist[x_adj][y_adj] ;
                    list_ofblocks.add(curr_block); // adding the current block to the set
                }
            }

        }



        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
                System.out.print(dist[i][j]+"   ");
            System.out.println();
        }


        return dist[row-1][col-1];
    }

    public static void main(String[] args)
    {
        int[][] arr = {
                {1,2,131,4},
                {5,161,7,8},
                {9,15,1,2}
        };
        int numrows = arr.length;
        int numcol = arr[0].length;
        int res = mincost(arr,numrows,numcol);
        System.out.println("value is "+res);
    }
}
