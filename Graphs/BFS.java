package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// we've created a base class graph which handles the creation of graph
// given a graph , find the bfs , in bfs we visit all the vertices adjacent to that vertex and then go to next vertex
public class BFS extends Graph{
    // printing the nodes of a graph , all the adjacent ones are printed and then the next ones
    void BFS(Graph node)
    {
        int[] visited = new int[node.vertex.length]; // visited array which states whether a node is visted or not
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // starting with the first one
        visited[0]=1;
        // keep pushing elements into the queue till all are exhausted
        while(!q.isEmpty())
        {
            int top = q.poll();
            System.out.println(top+1);
            Iterator<Integer> i = node.vertex[top].iterator();
            while(i.hasNext())
            {
                int next = i.next();
                //System.out.println(" the curr element is "+next);
                if(visited[next] == 0)
                {
                    visited[next] =1;
                    q.add(next);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        System.out.println("enter the nnumber of vertices and edges");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        BFS obj = new BFS();
        Graph node = obj.constructgraph(v,e);
        System.out.println(" the bfs of graphs is");
        obj.BFS(node);

    }
}
