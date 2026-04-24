// Last updated: 4/24/2026, 10:29:54 AM
class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;

        List<Integer> index = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(nums[i]>=0){
                index.add(i);
                values.add(nums[i]);
            }
        }

        int m = index.size();
        if(m <= 1) return nums;
        k = k%m;

        List<Integer> l3 = values.subList(k,m);
        List<Integer> l4 = values.subList(0,k);
        List<Integer> value = new ArrayList<>();
        value.addAll(l3);
        value.addAll(l4);

        int j = 0; 
        for(int i = 0; i<n; i++){
            if(nums[i]>=0){
                nums[i] = value.get(j);
                j++;
            }
        }    

        return nums;
    }


}