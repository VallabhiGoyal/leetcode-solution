// Last updated: 4/24/2026, 10:29:23 AM
class EventManager {
    public static Map<Integer, Integer> map;
    public static PriorityQueue<int[]> pq;
    public EventManager(int[][] events) {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b) -> {
            if(a[1] !=  b[1]) return b[1]-a[1];
            return a[0] - b[0];
        });
        
        for(int i = 0; i<events.length; i++){
            int id = events[i][0];
            int priority = events[i][1];
            
            map.put(id, priority);
            pq.add(new int[]{id, priority});
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        pq.add(new int[]{eventId, newPriority});
    }
    
    public int pollHighest() {
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int id = top[0];
            int priority = top[1];

            if(map.containsKey(id) && map.get(id) == priority){
                map.remove(id);
                return id;
            }
        }

        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */