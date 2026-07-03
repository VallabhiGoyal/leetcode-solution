// Last updated: 7/3/2026, 11:37:02 AM
class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            int curr = nums[i];

            List<Integer> subList = new ArrayList<>();

            while(curr > 0){
                int remain = curr % 10;
                subList.add(remain);
                curr /= 10;
            }

            int size = subList.size();
            for(int j = size - 1; j>=0; j--){
                list.add(subList.get(j));
            }
        }

        int size = list.size();
        int[] answer = new int[size];

        for(int i = 0; i<size; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}