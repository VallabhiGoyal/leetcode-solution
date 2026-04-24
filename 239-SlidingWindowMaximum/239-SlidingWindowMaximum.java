// Last updated: 4/24/2026, 10:34:45 AM
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 || k == 1) return nums;

        //step 1 make the result window
        int size = n - k + 1;
        int[] result = new int[size];
        int idx  =  0;

        //step 2 use a dequeu to track the curr max
        Deque<Integer> dq = new ArrayDeque<>(); //stores index

        //step 3 create, expand, shrink window
       

        for(int j = 0; j<n; j++){
            //elements outside the window
            while(!dq.isEmpty() && dq.peekFirst() < j - k + 1){
                dq.pollFirst();
            }

            //before inserting new element remove extra one
            while(!dq.isEmpty() && nums[j] > nums[dq.peekLast()]){
                dq.pollLast();
            }

            //add new element
            dq.addLast(j);

            //record result
            if(j>=k-1){
                result[idx++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}