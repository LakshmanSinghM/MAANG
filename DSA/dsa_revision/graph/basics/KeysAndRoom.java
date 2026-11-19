package dsa_revision.graph.basics;

public class KeysAndRoom{ 
     
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       
       boolean vis[] = new boolean[rooms.size()];
       vis[0] = true;
       Queue<Integer> q = new LinkedList<>();
       q.add(0);
        
        while(!q.isEmpty()){
         Integer node = q.poll();
         for(int n : rooms.get(node)){
            if(!vis[n]){
                vis[n]=true;
                q.add(n);
            }
         }
        }
        boolean isVisitedAll = true;
        for(int i=0; i<vis.length; i++){
            if(vis[i]==false) isVisitedAll = false;
        }
        return isVisitedAll;
    }
}