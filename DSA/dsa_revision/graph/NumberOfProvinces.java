package dsa_revision.graph;

public class NumberOfProvinces {
 
    private List<List<Integer>> createAdjList(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        return adj;
    }

    void dfs(int node, List<List<Integer>> adj,  boolean vis[] ){
        vis[node]=true;

        for(int i : adj.get(node)){
            if(!vis[i]){
                dfs(i,adj,vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = createAdjList(isConnected);
        System.out.println(adj);
        boolean vis[] = new boolean[adj.size()];
        int cnt = 0;

        for (int i = 0; i < adj.size(); i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, adj, vis);
            }
        }

        return cnt;
    }
  public static void main(String[] args) {
    
  }
}
