// Last updated: 4/24/2026, 10:29:19 AM
class Solution {
    public int mirrorFrequency(String s) {
        int n = s.length();
        Map<Character, Integer> cMap = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            char mirror;

            if(ch >= 'a' && ch <= 'z'){
                mirror = (char)('a' + ('z' - ch));    
            }else{
                mirror = (char)('9' - (ch - '0'));
            }
            
            if(cMap.getOrDefault(mirror, 0) > 0){
                cMap.put(mirror, cMap.get(mirror) - 1);
                continue;
            }

            cMap.put(ch, cMap.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;
        for(char key : cMap.keySet()){
            ans += cMap.get(key);
        }
        return ans;
    }
}