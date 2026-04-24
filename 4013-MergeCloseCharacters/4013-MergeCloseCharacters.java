// Last updated: 4/24/2026, 10:30:19 AM
class Solution {
    public String mergeCharacters(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            Integer index = map.get(ch);
            
            if(index == null){
                str.append(ch);
                map.put(ch, str.length() - 1);
                continue;
            }

            int currLen = str.length();
            if(currLen - index <= k){
                continue;
            }else{
                str.append(ch);
                map.put(ch, str.length() - 1);
            }
        }

        return str.toString();
    }
}