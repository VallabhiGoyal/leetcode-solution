// Last updated: 4/24/2026, 10:30:05 AM
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            List<Integer> list;
            if(map.containsKey(nums[i])){
                list = map.get(nums[i]);
            }else{
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i], list);
        }

        int min = Integer.MAX_VALUE;
        for(int key : map.keySet()){
            if(map.get(key).size() >= 3){
                List<Integer> list = map.get(key);
                int size = list.size();

                int curr = Integer.MAX_VALUE;
                for(int i = 0; i<size-2; i++){
                    int temp = list.get(i+2) - list.get(i);
                    curr = Math.min(temp ,curr);
                }

                min = Math.min(min, curr);
            }
        }

        if(min == Integer.MAX_VALUE) return -1;
        return 2*min;
    }
}