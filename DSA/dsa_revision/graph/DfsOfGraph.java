package dsa_revision.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsOfGraph {

  static void dfsGraph(List<List<Integer>> adj,boolean vis[],int node,List<Integer> traversal) {
    vis[node] = true;
    traversal.add(node);
    for (int n : adj.get(node)) {
      if (!vis[n]) {
        dfsGraph(adj, vis, n, traversal);
      }
    }
  }

  public static void main(String[] x) {
    List<List<Integer>> adjList = GraphCreateAdjList.createAdjList();
    boolean vis[] = new boolean[adjList.size()];
    List<Integer> traversal = new ArrayList<>();
    dfsGraph(adjList, vis, 1, traversal);
    System.out.println(traversal);
    // will look other problems like connected compos and all
  }
}
