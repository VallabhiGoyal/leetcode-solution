// Last updated: 8/4/2026, 8:33:48 AM
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int[] arr=new int[101];
        List<Integer> li=new ArrayList<>();
        for(int i:nums){
            max=Math.max(max,i);
            min=Math.min(min,i);
            arr[i]+=1;
        }
        while(min<=max){
            if(arr[min]==0){
                li.add(min);
            }
            min++;
        }
        return li;
    }
}