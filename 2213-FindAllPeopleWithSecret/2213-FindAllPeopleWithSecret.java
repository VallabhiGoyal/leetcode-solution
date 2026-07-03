// Last updated: 7/3/2026, 11:37:23 AM
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> map = new TreeMap<>();

        Set<Integer> secret = new HashSet<>();
        secret.add(0);
        secret.add(firstPerson);

        for(int[] meeting : meetings){
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time = meeting[2];

            map.putIfAbsent(time, new ArrayList<>());
            map.get(time).add(new int[]{person1, person2});
        }

        for(List<int[]> list : map.values()){
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> participants = new HashSet<>();
        
            for(int[] edge : list){
                int u = edge[0];
                int v = edge[1];

                graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);

                participants.add(u);
                participants.add(v);
            }

            Deque<Integer> stack = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();

            for(int person : participants){
                if(secret.contains(person)){
                    stack.push(person);
                    visited.add(person);
                }
            }

            while(!stack.isEmpty()){
                int curr = stack.pop();

                if(!graph.containsKey(curr)) continue;

                List<Integer> temp = graph.get(curr);
                for (int x : temp) {
                    if (!visited.contains(x)) {
                        visited.add(x);
                        stack.push(x);
                    }
                }
            }
            secret.addAll(visited);
        }

        return new ArrayList<>(secret);
    }
}