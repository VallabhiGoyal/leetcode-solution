// Last updated: 4/24/2026, 10:35:07 AM
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if(n == 1) return true;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for(int i = 0; i<n; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.get(ch1) == null && map2.get(ch2) == null){
                map1.put(ch1, ch2);
                map2.put(ch2,ch1);
            }else if(map1.get(ch1) != null && map2.get(ch2) != null){
                if(map1.get(ch1) != ch2 || map2.get(ch2) != ch1) return false;
            }else return false;
        }

        return true;
    }

}