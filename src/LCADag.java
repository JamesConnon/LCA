
import java.util.ArrayList;


public class DAG {

    private int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v
    private boolean marked[];		//Checks visited vertices
    private boolean hasCycle;		//check cyle in graph
    private boolean stack[];		//Order that vertices visited
    private int[] edgeTo;      // edgeTo[v] = final edge shortest s->v path
    private int[] distTo;      // distTo[v] = shortest s->v path

    public DAG(int V)
    {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be greater than 0");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        marked = new boolean[V];
        stack = new boolean[V];
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    //Returns current vertex
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    //Adds a directed edge from v->w
    public void addEdge(int v, int w)
    {
        if((checkVertex(v)>0)&&(checkVertex(w)>0))
        {
            adj[v].add(w);
            indegree[w]++;
            E++;
        }
        else{
            System.out.println("Enter vertices between 0 & n-1");
        }

    }

    private int checkVertex(int v) {
        if (v < 0 || v >= V)
            return -1;
        else
            return 1;}


    //Returns amount of directed edges incident to vertex v
    public int indegree(int v) {
        if(checkVertex(v)<0){
            return -1;
        }
        else{
            return indegree[v];
        }
    }

    //Returns amount of directed edges from vertex v
    public int outdegree(int v) {
        if(checkVertex(v)<0){
            return -1;
        }
        else{
            return adj[v].size();
        }
    }

}
