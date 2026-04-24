// Last updated: 4/24/2026, 10:30:43 AM
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        List<String> list = new ArrayList<>();
        list.add(words[0]);
        int lastGroup = groups[0];

        for(int i = 1; i<n; i++){
            if(groups[i] != lastGroup){
                list.add(words[i]);
                lastGroup = groups[i];
            }
        }

        return list;
    }
}