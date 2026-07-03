// Last updated: 7/3/2026, 11:36:26 AM
class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            if(isPrime(nums[i])){
                map.put(nums[i], map.getOrDefault(nums[i], new ArrayList<>()));
                map.get(nums[i]).add(i);
            }
        }

        for(int i = 0; i<n; i++){
            if(isPrime(nums[i])) continue;
            List<Integer> list = primeFactors(nums[i]);

            int size = list.size();
            for(int j = 0; j<size; j++){
                if(map.containsKey(list.get(j))){
                    map.get(list.get(j)).add(i);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i<size; i++){
                int idx = q.poll();

                if(idx == n-1) return steps;

                if(idx+1 < n && !visited[idx+1]){
                    visited[idx+1] = true;
                    q.add(idx+1);
                }
                if(idx-1 >=0 && !visited[idx-1]){
                    visited[idx-1] = true;
                    q.add(idx-1);
                }

                if (isPrime(nums[idx])) {

                    List<Integer> list = map.get(nums[idx]);

                    if (list != null) {

                        for (int next : list) {

                            if (!visited[next]) {
                                visited[next] = true;
                                q.add(next);
                            }
                        }

                        map.remove(nums[idx]);
                    }
                }

            }
            steps++;
        }

        return steps;
    }

    private List<Integer> primeFactors(int n){
        List<Integer> list = new ArrayList<>();
        if(n == 1) return list;
        for(int i = 2; i*i<=n; i++){
            if(n%i == 0){
                if(isPrime(i)) list.add(i);
                while(n%i == 0) n/=i;
            }
        }
        if(n > 1) list.add(n);
        return list;
    }

    private boolean isPrime(int n){
        if(n == 1) return false;
        if(n == 2) return true;
        for(int i = 2; i*i<=n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}