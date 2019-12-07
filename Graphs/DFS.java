package Graphs;

import java.util.Iterator;
import java.util.Scanner;

public class DFS extends Graph {
    // in DFS when we visit a vertex , we keep propogating till the next of that vertex consecutively
    void DFSUtil(Graph node ,int vertex,int[] visited)
    {
        visited[vertex] =1;
        System.out.println(vertex+1);
        Iterator<Integer> itr =node.vertex[vertex].iterator();
        while(itr.hasNext())
        {
            int ele = itr.next();
            if(visited[ele] == 0)
            {
                DFSUtil(node,ele,visited);
            }
        }
    }
    void DFS(Graph node)
    {
        int[] visited = new int[node.vertex.length];
        DFSUtil(node,0,visited);
    }

    public static void main(String[] args)
    {
        System.out.println("enter the number of vertices and edges");
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        DFS obj = new DFS();
        Graph node = obj.constructgraph(v,e);
        obj.DFS(node);
    }
}
