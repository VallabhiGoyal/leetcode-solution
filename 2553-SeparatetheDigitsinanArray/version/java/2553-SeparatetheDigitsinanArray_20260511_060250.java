// Last updated: 5/11/2026, 6:02:50 AM
class Solution {
    public int[] separateDigits(int[] nums) {

        ArrayList<Integer> l1 = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            ArrayList<Integer> l2 = new ArrayList<>();
            if(num==0){
                l1.add(0);
            }
            while(num>0){
                int rem=num%10;
                l2.add(rem);
                num/=10;
            }

            for(int j=l2.size()-1;j>=0;j--){
                l1.add(l2.get(j));
            }
        }
        
        int ans[] = new int[l1.size()];
        for(int i=0;i<l1.size();i++){
            ans[i] = l1.get(i);
        }

        return ans;                
    }
}