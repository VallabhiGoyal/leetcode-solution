// Last updated: 4/24/2026, 10:32:05 AM
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;

        Set<Integer> set1 = new HashSet<>();
        for(int i = 0; i<a; i++){
            set1.add(nums1[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i<b; i++){
            set2.add(nums2[i]);
        }

        List<List<Integer>> answer = new ArrayList<>();
        
        List<Integer> l1 = new ArrayList<>();
        for(int x : set1){
            if(!set2.contains(x)) l1.add(x);
        }
        answer.add(l1);

        List<Integer> l2 = new ArrayList<>();
        for(int x : set2){
            if(!set1.contains(x)) l2.add(x);
        }
        answer.add(l2);

        return answer;
    }
}