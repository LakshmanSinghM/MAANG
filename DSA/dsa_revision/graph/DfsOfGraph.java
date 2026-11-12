package dsa_revision.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsOfGraph {

  static List<Integer> dfsGraph(List<List<Integer>> adj, boolean vis[]) {
    Queue<Integer> q = new LinkedList<>();
    List<Integer> traversal = new LinkedList<>();
    q.offer(1);
    vis[1] = true;

    while(!q.isEmpty()){    
      Integer node = q.poll();
      traversal.add(node);
      for (int n : adj.get(node)) {
        if(!vis[n]) {
          vis[n] = true;
          q.offer(n);
        }
      }
    }
    return traversal;
  }

  public static void main(String[] x) {
    List<List<Integer>> adjList = GraphCreateAdjList.createAdjList();
    boolean vis[] = new boolean[adjList.size()];
    System.out.println(bfsGraph(adjList, vis));
  }
}
