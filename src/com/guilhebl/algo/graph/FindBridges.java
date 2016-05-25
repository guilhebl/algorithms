package com.guilhebl.algo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
 
/**
 * 
 * http://www.geeksforgeeks.org/bridge-in-a-graph/
 *
 */
public class FindBridges {
    public static void main(String args[])
    {
        // Create graphs given in above diagrams
        System.out.println("Bridges in first graph ");
        GraphObj g1 = new GraphObj(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        
        g1.bridge();
        System.out.println();

        g1.bridge2();
        System.out.println();
 
        System.out.println("Bridges in Second graph");
        GraphObj g2 = new GraphObj(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);

        g2.bridge();
        System.out.println();

        g2.bridge2();
        System.out.println();
 
        System.out.println("Bridges in Third graph ");
        GraphObj g3 = new GraphObj(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.bridge();

        System.out.println();
        g3.bridge2();
    }

}
// This class represents a undirected graph using adjacency list
// representation
class GraphObj
{
    private int V;   // No. of vertices
 
    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;
 
    // Constructor
    GraphObj(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);  //Add v to w's list
    }
 
    // A recursive function that finds and prints bridges
    // using DFS traversal
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    void bridgeUtil(int u, boolean visited[], int disc[],
                    int low[], int parent[])
    {
 
        // Count of children in DFS Tree
        int children = 0;
 
        // Mark the current node as visited
        visited[u] = true;
 
        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;
 
        // Go through all vertices aadjacent to this
        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext())
        {
            int v = i.next();  // v is current adjacent of u
 
            // If v is not visited yet, then make it a child
            // of u in DFS tree and recur for it.
            // If v is not visited yet, then recur for it
            if (!visited[v])
            {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);
 
                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u
                low[u]  = Math.min(low[u], low[v]);
 
                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge
                if (low[v] > disc[u])
                    System.out.println(u+" "+v);
            }
 
            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u]  = Math.min(low[u], disc[v]);
        }
    }
 
 
    // DFS based function to find all bridges. It uses recursive
    // function bridgeUtil()
    void bridge()
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
 
 
        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++)
        {
            parent[i] = NIL;
            visited[i] = false;
        }
 
        // Call the recursive helper function to find Bridges
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                bridgeUtil(i, visited, disc, low, parent);
    }
    
 
    // DFS based function to find all bridges. It uses recursive
    // function bridgeUtil() version 2.
    void bridge2()
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        Map<Integer, Set<Integer>> mapParents = new HashMap<>(); 
 
        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++)
        {
            visited[i] = false;
        }
 
        // Call the recursive helper function to find Bridges
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                bridgeUtil(i, visited, mapParents);
                
        boolean hasMore = true;
        Integer parent = null;
        Set<Integer> intSet = null;
        
        while(hasMore) {
        	hasMore = false;
            for (Map.Entry<Integer, Set<Integer>> e : mapParents.entrySet()) {
    			if (e.getValue() != null && e.getValue().size() == 1) {
    				parent = e.getValue().iterator().next();    				
    				System.out.println(parent + " - " + e.getKey());
    				    			    			
    				intSet = mapParents.get(parent);
    				intSet.remove(e.getKey());
    				
    				mapParents.put(e.getKey(), null);    				
    				mapParents.put(parent, intSet);
    				
    				hasMore = true;
    			}
    		}        	
        }
        
    }

	void bridgeUtil(int u, boolean visited[], Map<Integer, Set<Integer>> mapParents) {
		// Mark the current node as visited
		visited[u] = true;

		// Go through all vertices aadjacent to this
		Iterator<Integer> i = adj[u].iterator();
		while (i.hasNext()) {
			int v = i.next(); // v is current adjacent of u

			setParent(mapParents, u, v);
			setParent(mapParents, v, u);

			// If v is not visited yet, then make it a child
			// of u in DFS tree and recur for it.
			// If v is not visited yet, then recur for it
			if (!visited[v]) {								
				bridgeUtil(v, visited, mapParents);
			}
		}
	}

	private void setParent(Map<Integer, Set<Integer>> mapParents, int u, int v) {
		Set<Integer> parents = null;
		
		if (!mapParents.containsKey(u)) {
			parents = new HashSet<>();
			parents.add(v);
			mapParents.put(u, parents);
		} else {
			parents = mapParents.get(u);
			parents.add(v);
			mapParents.put(u, parents);					
		}		
	}

}