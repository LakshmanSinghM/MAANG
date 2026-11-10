package dsa_revision.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsOfGraph {

  // Working on the graph revision
  // writing the post on linkedin
  // Fine working on the new things
  // DFS and BFS will do tomorrow both together
  // will resume impl of the bfs traversal of the graph at home
  // diwali ka nasha just anaylsing the investing stocks blabla to get richer faster

  //supposing that only one component as connected graph
  static List<Integer>  bfsGraph(List<List<Integer>> adj, boolean vis[]) {
    Queue<Integer> q = new LinkedList<>();
    List<Integer> traversal = new LinkedList<>();
    q.offer(1);
    vis[1] = true;
    while (!q.isEmpty()) {
      Integer node = q.poll();
      traversal.add(node);
      for (int n : adj.get(node)) {
        if (!vis[n]) {
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
