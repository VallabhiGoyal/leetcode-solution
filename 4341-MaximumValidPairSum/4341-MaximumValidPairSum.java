// Last updated: 7/10/2026, 6:54:58 PM
class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;

        int max = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
            return b.val - a.val;
        });
        
        for(int i = k; i<n; i++){
            queue.add(new Node(nums[i], i));
        }

        for(int i = 0; i<=n-k; i++){

            while(!queue.isEmpty() && queue.peek().idx - i < k) queue.remove();

            if(!queue.isEmpty()){
                max = Math.max(max, nums[i] + nums[queue.peek().idx]);
            }
        }

        return max;
    }

    public class Node{
        int val;
        int idx;

        Node(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
}