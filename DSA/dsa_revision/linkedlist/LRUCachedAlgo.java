class Node {
    int key,val;
    Node(int k, int v){
        key = k;
        val = v;
    }
}

class LRUCachedAlgo {
    int cap;
    List<Node> list;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        // made a mistake here int cap = capacity then tried alot always failed
        cap = capacity;
        list = new LinkedList<>();
        cache = new HashMap<>();
    }
    
    public int get(int key) {
      Node node = cache.get(key);
       
    //    System.out.println(list + " "+cache +" GETKEY = "+ key +" "+node);

      if(node==null) return -1;
          System.out.println(node.val);
          int val = node.val;
          list.remove(node);
          list.addFirst(node);
          return val;
    }
    
    public void put(int key, int value) {

        if(cache.size()>=cap && !cache.containsKey(key)){
         Node node = list.removeLast();
         cache.remove(node.key); 
       }

       if(cache.containsKey(key)){
         Node node = cache.get(key);
         node.val = value; 
         cache.put(key, node);
         get(key);
       }
       else{
        Node node = new Node(key, value);
        cache.put(key, node);
        list.addFirst(node);
       }
    
    //    System.out.println(list + " put "+cache +" "+ key +" "+value);
    }
}