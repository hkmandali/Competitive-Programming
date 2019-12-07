package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// this is a directed graph
public class Graph {
    int edges;
    List<Integer>[] vertex;

    Graph constructgraph(int v, int e)
    {
        Graph node = new Graph();
        node.vertex = new List[v];
        for(int i=0;i<v;++i)
        {
            node.vertex[i] = new LinkedList();
        }
        node.edges = e;
        Scanner in = new Scanner(System.in);
        for(int i=0;i<e;++i)
        {
            System.out.println("enter the start and end vertex");
            int start = in.nextInt();
            int end = in.nextInt();
            node.vertex[start-1].add(end-1);
            // for an undirected graph , add the below line
            // node.vertex[end-1].add(start-1);
        }
        return node;
    }
}
