package dsa_revision.graph.basics;

// https://leetcode.com/problems/find-if-path-exists-in-graph/
public class FindPathExistsOrNotInGraph {

  private List<List<Integer>> buildAdj(int n, int[][] edges) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int arr[] = edges[i];
      adj.get(arr[0]).add(arr[1]);
      adj.get(arr[1]).add(arr[0]);
    }
    return adj;
  }

  private boolean dfs(List<List<Integer>> adj, int s, int d, boolean vis[]) {
    Queue<Integer> q = new LinkedList<>();
    vis[s] = true;
    q.add(s);
    while (!q.isEmpty()) {
      int node = q.poll();
      if (node == d) return true;

      for (int n : adj.get(node)) {
        if (!vis[n]) {
          vis[n] = true;
          q.add(n);
        }
      }
    }
    return false;
  }

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    List<List<Integer>> adj = buildAdj(n, edges);
    boolean vis[] = new boolean[n];

    return dfs(adj, source, destination, vis);
  }
}
