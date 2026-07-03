// Last updated: 7/3/2026, 11:37:07 AM
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        long ans = 0;

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int i = 0;
        int j = n-1;

        while(i < candidates && i <= j){
            left.add(costs[i]);
            i++;
        }

        while(i <= j && n-j-1 < candidates){
            right.add(costs[j]);
            j--;
        }

        int count = 0;
        while(!left.isEmpty() && !right.isEmpty() && count != k){
            if(left.peek() <= right.peek()){
                ans += left.poll();
                if(i <= j){
                    left.add(costs[i]);
                    i++;
                }
            }else{
                ans += right.poll();
                if(i <= j){
                    right.add(costs[j]);
                    j--;
                }
            }
            count++;
        }

        while(!left.isEmpty() && count < k){
            ans += left.poll();
            count++;
        }

        while(!right.isEmpty() && count < k){
            ans += right.poll();
            count++;
        }

        return ans;
    }
}