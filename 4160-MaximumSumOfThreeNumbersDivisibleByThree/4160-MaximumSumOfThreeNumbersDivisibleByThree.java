// Last updated: 4/24/2026, 10:29:56 AM
class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;

        List<Integer> g0 = new ArrayList<>();
        List<Integer> g1 = new ArrayList<>();
        List<Integer> g2 = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(nums[i]%3==0){
                g0.add(nums[i]);
            }else if(nums[i]%3==1){
                g1.add(nums[i]);
            }
            else{
                g2.add(nums[i]);
            }
        }

        Comparator<Integer> cmp = (a,b) -> b-a;
        Collections.sort(g0, cmp);
        Collections.sort(g1, cmp);
        Collections.sort(g2, cmp);

        int ans = 0; 

        // case 1 3 from grp 3
        if(g0.size()>=3){
            ans = Math.max(ans, g0.get(0)+ g0.get(1)+ g0.get(2));
        }

        // case 2 3 from grp 2
        if(g1.size()>=3){
            ans = Math.max(ans, g1.get(0)+ g1.get(1)+ g1.get(2));
        }

        // case 3 3 from grp 3
        if(g2.size()>=3){
            ans = Math.max(ans, g2.get(0)+ g2.get(1)+ g2.get(2));
        }

        // case 4  ig0, 1g2 1g3
        if(g0.size()>=1 && g1.size()>=1 && g2.size()>=1){
            ans = Math.max(ans, g0.get(0)+ g1.get(0) + g2.get(0));
        }


        return ans;
        
    }
}