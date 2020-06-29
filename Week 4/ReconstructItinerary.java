class ReconstructItinerary{
    //ACCEPTED SOLTUION
    
    //Since Duplicate keys are present, we have a list of values made for each key and then DFS is applied.
    //The list of values needs to be sorted in ascending order and so we use Min Heap: Priority Queue.
    
    HashMap<String, PriorityQueue<String>> map=new HashMap<>();
    LinkedList<String> res=new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets.isEmpty())
            return res;
        
        for(List<String> pair:tickets){
            PriorityQueue<String> pq;   //declaring a queue
            
            //Getting the priority Queue that might already be existing for a particular key; 
            //if not, creating a new one
            
            pq=map.getOrDefault(pair.get(0), new PriorityQueue<String>());
            
            pq.offer(pair.get(1));  //adding value to priority queue
           
            map.put(pair.get(0), pq);   //adding this pair to the map
        }
        
        if(map.containsKey("JFK"))    //checking if the map contains starting point (from) given: JFK
            dfs("JFK");
        return res;
    }
    
    public void dfs(String s){
        PriorityQueue<String> q=map.getOrDefault(s, new PriorityQueue<String>());   //all the "to" (values) from "from" (keys)
        while(!q.isEmpty() && q!=null)
            dfs(q.poll());  //every first value in q is taken into dfs and removed from q using poll()
        res.addFirst(s);
    }
}
