package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// this finds out the shortest path in an unweighted graph
public class ShortestDistUnweightedDirected extends Graph {
    int shortestPath(Graph node,int start,int end)
    {
         // this can be achieved through bfs
        // thorugh dfs it cannot be achieved because if there is a cycle , it will result in maximum
        // we maintain an array with distances and increment 1 whenever we encounter a new vertex
        // bfs approach
        int[] visited = new int[node.vertex.length];
        int[] distances = new int[node.vertex.length];
        distances[start-1] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(start-1);
        visited[start-1]=1;
        while(!que.isEmpty())
        {
            int top = que.poll();
            Iterator<Integer> itr = node.vertex[top].iterator();
            while(itr.hasNext())
            {
                int next = itr.next();
                if(visited[next] == 0)
                {
                    visited[next] =1;
                    distances[next] = 1 + distances[top];
                    que.add(next);
                }

            }
        }
        return distances[end-1];
    }
    public static void main(String[] args)
    {
        System.out.println("enter the number of vertices and edges");
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        ShortestDistUnweightedDirected obj = new ShortestDistUnweightedDirected();
        Graph node = obj.constructgraph(v,e);
        System.out.println(" enter the two vertices between which shortest path is required");
        v = in.nextInt();
        e = in.nextInt();
        int shortest = obj.shortestPath(node,v,e);
        System.out.println("the shortest path is "+ shortest);
    }
}
