package Graphs;

// https://www.geeksforgeeks.org/snake-ladder-problem-2/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// find out the min number of dice moves required to go from start to end vertices provided
public class SnakeandLadder extends Graph{
    int minMoves(Graph node,int first,int last,int[] snakeandlad)
    {
        // in this every vertex is connected to the next 6 vertices
        // and if a ladder or snake is visited , it is handled accordingly
        // we handle a snakeandlad array which maintains snakes or the ladders associated with each block
        // we need to find the min distance between start and end vertex
        // we maintain a min dice array which maintains the min number of moves required to go from start to end
        int[] mindice = new int[node.vertex.length];
        int[] visited = new int[node.vertex.length]; // this holds the info reg whether a block is visited or not
        Queue<Integer> que = new LinkedList<>();
        que.add(first-1);
        mindice[first-1] =0;
        visited[first-1] =1;
        while(!que.isEmpty())
        {
            int top = que.poll();
            if(top+1 == last)
            {
                System.out.println("top + 1 reached is "+last);
                break;
            }
            for(int i=1;i<=6;++i)
            {
                if(top+1+i > last) // because we dont want vertices more than last index
                    break;
                if(visited[top+i] == 0) // in case the block isnt visited yet ,
                    // it gurantees that the shortest distance is being achieved for that block as well as bottom for ladder
                    // in case of snake only if the bottom is unvisited then we need to update
                    // so it works for both ladder as well as snake
                {

                    if(snakeandlad[top+i] != 0)
                    {
                        if(visited[snakeandlad[top+i]] == 0)
                        {
                            visited[snakeandlad[top+i]] =1;
                            mindice[snakeandlad[top+i]] = 1 + mindice[top];
                            que.add(snakeandlad[top+i]);
                        }
                    }
                    else
                    {
                        que.add(top+i);
                    }
                    visited[top+i] =1;
                    mindice[top+i] = 1 + mindice[top];

                }
            }
        }
        // note in this scenario all the vertices may not be visited as we terminate once the last vertex is seen
        System.out.println("the min dices required for every vertex are");
        for(int i=0;i<node.vertex.length;++i)
        {
            int j = i+1;
            System.out.println(" i  "+j+"   "+mindice[i]);
        }
        return mindice[last-1];
    }
    public static void main(String[] args)
    {
        System.out.println("enter the number of vertices and edges");
        Scanner in = new Scanner(System.in);
        int v = 36;//in.nextInt();
        int e = 0;//in.nextInt();
        int[] snakeandlad = new int[v];
        SnakeandLadder obj = new SnakeandLadder();
        Graph node = obj.constructgraph(v,e);
        System.out.println(" enter the two vertices between which shortest path is required");
        v = 1;//in.nextInt();
        e = 36;//in.nextInt();

        // Ladders
        snakeandlad[2] = 15;
        snakeandlad[14] = 24;
        snakeandlad[20] = 31;

        // Snakes
        snakeandlad[11] = 1;
        snakeandlad[29] = 5;
        int shortest = obj.minMoves(node,v,e,snakeandlad);
        System.out.println("the min dice moves is "+ shortest);
    }
}
