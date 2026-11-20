package dsa_revision.graph.basics;

// https://leetcode.com/problems/get-watched-videos-by-your-friends/

class Pair {

  int level;
  int node;

  Pair(int l, int n) {
    level = l;
    node = n;
  }

  public String toString() {
    return "[level = " + level + " node = " + node + "]";
  }
}

public class GetWatchedVideosByFriend {

  public List<String> watchedVideosByFriends(
    List<List<String>> watchedVideos,
    int[][] friends,
    int id,
    int level
  ) {
    boolean vis[] = new boolean[friends.length];
    Queue<Pair> q = new LinkedList<>();
    List<Pair> levelNodes = new LinkedList<>();
    vis[id] = true;
    q.offer(new Pair(0, id));

    while (!q.isEmpty()) {
      Pair p = q.poll();

      if (p.level == level) levelNodes.add(p);
      //we could put inside map here only but lets not make it complex

      for (int node : friends[p.node]) {
        if (!vis[node]) {
          vis[node] = true;
          Pair newPair = new Pair(p.level + 1, node);
          q.offer(newPair);
        }
      }
    }

    Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
      if (a.getValue() != b.getValue()) return a.getValue() - b.getValue();
      return a.getKey().compareTo(b.getKey());
    });

    Map<String, Integer> map = new HashMap<>();

    for (Pair p : levelNodes) {
      for (String t : watchedVideos.get(p.node))
        map.put(t, map.getOrDefault(t, 0) + 1);
    }

    pq.addAll(map.entrySet());

    List<String> list = new LinkedList<>();

    while (!pq.isEmpty()) {
      list.add(pq.poll().getKey());
    }

    // System.out.println(levelNodes + "    "+pq);
    return list;
  }
}
