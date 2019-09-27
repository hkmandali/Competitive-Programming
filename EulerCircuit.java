/* the algorithm works in this way , in an undirected graph there exists a euler circuit or path if
1. no of vertices with odd degree i.e no of vertices it is connected to is *zero* --> euler cycle
2. no of vertices with odd degree i.e no of vertices it is connected to is *two* --> euler path exists
3. more than 2 , euler path doesnt exist
4. In an undirected graph there wont be a case of one odd degree because it is connected both ways

Note: there is one problem with the initial implementation i.e if there are 8 vertices and they are divided into two sets of 4 and 4 and they form a euler cycle , the end graph need
not form a euler cycle because all the edges are not visited by starting at any vertex , so we have got to upgrade our algo by applying traversal and verifying accordingly

*/
package src;
import javafx.util.Pair;
import java.util.*;
class GraphEuler{
    int v; // num vertices
    LinkedList<Pair<Integer,Integer>>[] adjlist;
    GraphEuler(int v)
    {
        this.v =v;
        this.adjlist = new LinkedList[v];
        for(int i=0;i<v;++i)
        {
            adjlist[i] = new LinkedList<>();
        }
    }
    int getV()
    {
        return this.v;
    }
    LinkedList<Pair<Integer,Integer>>[] getAdjlist()
    {
        return this.adjlist;
    }
    void addEdge(int src,int dest,int weight) {
        adjlist[src].add(new Pair(dest, weight)); // add specifically because it maintains the order of insertion , where as push basically does add first
        adjlist[dest].add(new Pair(src, -1 * weight));
    }
}
public class EulerCircuit {

    private static void dfs(GraphEuler g,int i, int[] visited)
    {
        visited[i] =1;
        LinkedList<Pair<Integer,Integer>>[] adjList = g.getAdjlist();
        Iterator<Pair<Integer,Integer>> adjListfori = adjList[i].listIterator();
        while(adjListfori.hasNext()){
            Pair<Integer,Integer> val = adjListfori.next();
            int nextvertex = val.getKey(); // get key gives the dest and get val gives weight
            if(visited[nextvertex] != 1)
            {
                dfs(g,nextvertex,visited);
            }
        }
        return;
    }

    private static void IsEuler(GraphEuler g)
    {
        LinkedList<Pair<Integer,Integer>>[] adjlist = g.getAdjlist();
        int v = g.getV();
        int visited[] = new int[v]; // maintaining a visited array to verify all the vertices
        int num_odd =0;
        for(int i=0;i<v;++i)
        {
            visited[i] =-1;
            int numconnected = adjlist[i].size(); // gives the number of vertices it is connected to
            if(numconnected %2 != 0) // checking if it is odd or even
            {
                num_odd++;
            }
        }
        dfs(g,0,visited); // this can be even extended to find the first vertex with non zero edges i.e degree >0

        for(int i=0;i<v;++i) // through this we can check if all the vertices which have edges are visited through bfs
        {
            if(adjlist[i].size() > 0 && visited[i] != 1)
            {
                System.out.println("found through dfs that all components are not connected");
                num_odd = 5 ; // because all the nodes are not visited but they have edges, assigning a rand value
            }
        }

        if(num_odd > 2)
        {
            System.out.println("euler path or cycle doesn't exist");
        }
        else if(num_odd == 0)
        {
            System.out.println("euler cycle exists");
        }
        else if(num_odd == 2)
        {
            System.out.println("euler path exists");
        } // there wont be a case of num_odd == 1 as discussed above as it is an undirected graph
        return ;
    }

    public static void main(String[] args)
    {
        // weight doesnt hold any significance in any of the below use cases
        GraphEuler g1 = new GraphEuler(5); // examples taken from gfg
        g1.addEdge(1, 0,5);
        g1.addEdge(0, 2,5);
        g1.addEdge(2, 1,5);
        g1.addEdge(0, 3,5);
        g1.addEdge(3, 4,5);
        IsEuler(g1);

        GraphEuler g2 = new GraphEuler(5);
        g2.addEdge(1, 0,5);
        g2.addEdge(0, 2,5);
        g2.addEdge(2, 1,5);
        g2.addEdge(0, 3,5);
        g2.addEdge(3, 4,5);
        g2.addEdge(4, 0,5);
        IsEuler(g2);

        GraphEuler g3 = new GraphEuler(5);
        g3.addEdge(1, 0,5);
        g3.addEdge(0, 2,5);
        g3.addEdge(2, 1,5);
        g3.addEdge(0, 3,5);
        g3.addEdge(3, 4,5);
        g3.addEdge(1, 3,5);
        IsEuler(g3);

        // Let us create a graph with 3 vertices
        // connected in the form of cycle
        GraphEuler g4 = new GraphEuler(3);
        g4.addEdge(0, 1,5);
        g4.addEdge(1, 2,5);
        g4.addEdge(2, 0,5);
        IsEuler(g4);

        // Let us create a graph with all veritces
        // with zero degree
        GraphEuler g5 = new GraphEuler(3);
        IsEuler(g5);

        GraphEuler g6 = new GraphEuler(8);
        g6.addEdge(0, 1,5);
        g6.addEdge(1, 2,5);
        g6.addEdge(2, 3,5);
        g6.addEdge(3, 0,5);
        g6.addEdge(4, 5,5);
        g6.addEdge(5, 6,5);
        g6.addEdge(6, 7,5);
        g6.addEdge(7, 4,5);
        IsEuler(g6);
    }
}
