// Last updated: 4/24/2026, 10:36:15 AM
class Solution {
    static Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {

        // base cases
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;

        String key = s1 + "_" + s2;
        if(map.containsKey(key)) return map.get(key);

        if(!isAnagram(s1, s2)){
            map.put(key, false);
            return false;
        }
        
        int n = s1.length();
        boolean flag = false;

        for(int i = 1; i < n; i++){

            // case 1: swap
            if(isScramble(s1.substring(0, i), s2.substring(n-i, n)) &&
               isScramble(s1.substring(i, n), s2.substring(0, n-i))){
                flag = true;
                break;
            }

            // case 2: no swap
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) &&
               isScramble(s1.substring(i, n), s2.substring(i, n))){
                flag = true;
                break;
            }
        }
        map.put(key, flag);
        return flag;
    }

    private boolean isAnagram(String a, String b){
        int[] freq = new int[26];
        for(char c : a.toCharArray()) freq[c - 'a']++;
        for(char c : b.toCharArray()) freq[c - 'a']--;
        for(int x : freq) if(x != 0) return false;
        return true;
    }
}