// Last updated: 4/24/2026, 10:36:50 AM
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, 0, 0, candidates.length, temp);
        return ans;
    }

    public void helper(int[] arr, int target, int sum, int idx, int n, List<Integer> temp){
        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx == n|| sum > target) return;

        //take
        temp.add(arr[idx]);
        helper(arr, target, sum+arr[idx], idx, n, temp);
        temp.remove(temp.size()-1);
        

        //remove
        helper(arr, target, sum, idx+1, n, temp);
    }
}