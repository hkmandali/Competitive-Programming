// this code has been implemented after going through the concepts from geeksforgeeks and tushar roy's video
import javafx.util.Pair;

import java.util.*;

class Graph{
    private int v;
    private LinkedList<Pair<Integer,Integer>> adj[]; // pair is for destination and weight
    // didn't use list because list is abstract class in java
    int time =0;

    Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for(int i=0;i<v;++i)
        {
            adj[i] = new LinkedList();
        }
    }
    public int numvertices()
    {
        return this.v;
    }
    public LinkedList<Pair<Integer, Integer>>[] getadjList()
    {
        LinkedList<Pair<Integer, Integer>>[] adj = this.adj;
        return adj;
        //return this.adj;
    }
    void newEdge(int src,int dest,int weight)
    {
        adj[src].add(new Pair(dest,weight)); // I have added weight only for dummy purpose and it doesn't hold any significance in this use case
        adj[dest].add(new Pair(src,-1 * weight));
    }
    void iterate()
    {
        System.out.println("the lists passes are");
        for(int i=0;i<v;++i)
        {
            System.out.println();
            System.out.print(i);
            for(Pair<Integer,Integer> test: adj[i])
            {
                //Pair<Integer,Integer> test = temp.get(i);
                System.out.print(" -> "+test.getKey()+" : " + test.getValue());
            }
        }
    }

}
public class TarjansAlgo {
    static int NIL = -1;
    static int time =0;
    /* we use two times called visited time and low time for finding out the articulation points
    a vertex is an articulation point if either of the below two holds
    1. it is the root of dfs and children > 1 , because for dfs it again needs to go through that point and children wont be more than 1 in that case
    2. low time of any of it s child > its visited time
     */

    static void recur(int i,int[] visited,int[] artpoints,int[] visitedtime,int[] lowtime,int[] parent,LinkedList<Pair<Integer,Integer>> adjList) // this function is recursively called until all the vertices are exhausted and we find the min low time
    {
        int child =0; // child for a specific vertex
        visited[i] = 1;
        System.out.println("the value of time is "+time);
        visitedtime[i] =lowtime[i]  = ++time;
        for(Pair<Integer,Integer> test: adjList)
        {
                int key = test.getKey(); // taking the next list item i.e whichever it is connected to
                if(visited[key] == -1) // not yet visited
                {
                    child++;
                    parent[key] = i;
                    recur(key,visited,artpoints,visitedtime,lowtime,parent,adjList);
                    lowtime[i] = Math.min(lowtime[i],lowtime[key]);

                    if(parent[i] == NIL && child > 1)
                    {
                        System.out.println("came in the dirst one");
                        artpoints[i] =1;
                    }
                    if(parent[i] != NIL && lowtime[key] >= visitedtime[i])
                    {
                        System.out.println("came in the second one");
                        artpoints[i] =1;
                    }
                }
                else if ( key != parent[i])
                {
                    lowtime[i] = Math.min(lowtime[i],visitedtime[key]);
                }
        }
        return;

    }
    static void articulate(Graph g)
    {
        int v = g.numvertices();
        LinkedList<Pair<Integer, Integer>>[] adjList = g.getadjList();
        System.out.println("the number of vertices are "+ v);
        int[] visited = new int[v];
        int[] artpoints = new int[v]; // articulate points
        int[] visitedtime = new int[v];
        int[] lowtime = new int[v];
        int[] parent = new int[v];
        for(int i=0;i<v;++i)
        {
            visited[i] = -1; // used in dfs traversal
            artpoints[i] = NIL;
            visitedtime[i] = 0;
            lowtime[i] = 0;
            parent[i] = NIL;
        }
        for(int i=0;i<v;++i) {
            if(visited[i] == -1) // node not yet visited ,call dfs traversal
            {
                recur(i,visited,artpoints,visitedtime,lowtime,parent,adjList[i]);
            }
        }
        System.out.println("the articulation points are");
        for(int i=0;i<v;++i) {
            //System.out.print("test "+artpoints[i]);
            if(artpoints[i] == 1)
            System.out.print(" "+i);
        }
        return;
    }
    public static void main(String[] args)
    {
        /*
        Graph g = new Graph(5);
        g.newEdge(0,1,2);
        g.newEdge(0,2,3);
        g.newEdge(0,4,4);
        g.newEdge(1,2,3);
        g.newEdge(2,3,4);
        g.newEdge(3,4,5);
        g.newEdge(1,3,7);
        g.newEdge(1,4,8);
        g.newEdge(2,4,9);
        g.iterate();
        articulate(g);
        */
        Graph g1 = new Graph(3);
        g1.newEdge(0,1,2);
        g1.newEdge(1,2,3);
        g1.iterate();
        articulate(g1);

        Graph g2 = new Graph(4);
        g2.newEdge(0, 1,5);
        g2.newEdge(1, 2,5);
        g2.newEdge(2, 3,5);
        articulate(g2);
        Graph g3 = new Graph(7);
        g3.newEdge(0, 1,5);
        g3.newEdge(1, 2,5);
        g3.newEdge(2, 0,5);
        g3.newEdge(1, 3,5);
        g3.newEdge(1, 4,5);
        g3.newEdge(1, 6,5);
        g3.newEdge(3, 5,5);
        g3.newEdge(4, 5,5);
        articulate(g3);
    }
}
