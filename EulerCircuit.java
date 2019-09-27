/* the algorithm works in this way , in an undirected graph there exists a euler circuit or path if
1. no of vertices with odd degree i.e no of vertices it is connected to is *zero* --> euler cycle
2. no of vertices with odd degree i.e no of vertices it is connected to is *two* --> euler path exists
3. more than 2 , euler path doesnt exist
4. In an undirected graph there wont be a case of one odd degree because it is connected both ways
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

    private static void IsEuler(GraphEuler g)
    {
        LinkedList<Pair<Integer,Integer>>[] adjlist = g.getAdjlist();
        int v = g.getV();
        int num_odd =0;
        for(int i=0;i<v;++i)
        {
            int numconnected = adjlist[i].size(); // gives the number of vertices it is connected to
            if(numconnected %2 != 0) // checking if it is odd or even
            {
                num_odd++;
            }
        }
        if(num_odd > 2)
        {
            System.out.println("euler path or cycle doesnt exist");
        }
        else if(num_odd == 0)
        {
            System.out.println("euler cycle exists");
        }
        else if(num_odd == 2)
        {
            System.out.println("euler path exists");
        } // there wont be a case of num_odd == 1 as discussed above as it is an undirected graph
    }

    public static void main(String[] args)
    {
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
    }
}
