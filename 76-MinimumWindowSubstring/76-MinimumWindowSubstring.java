// Last updated: 4/24/2026, 10:36:23 AM
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(n>m) return "";

        Map<Character, Integer> tmap = new HashMap<>();
        for(int i = 0; i<n; i++){
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0;
        int count = tmap.size();


        int left = -1;
        int right = -1;
        int minLen = Integer.MAX_VALUE;

        for(int j = 0; j<m; j++){
            char ch = s.charAt(j);
            if(tmap.containsKey(ch)){
                tmap.put(ch, tmap.get(ch)-1);
                if(tmap.get(ch) == 0) count--;
            }

            if(count == 0){
                while(!tmap.containsKey(s.charAt(i)) || tmap.get(s.charAt(i)) < 0){
                    char ch2 = s.charAt(i);
                    if(tmap.containsKey(ch2)){
                        tmap.put(ch2, tmap.get(ch2) + 1);
                    }
                    i++;
                }
                if(minLen > j-i+1){
                    left = i;
                    right = j;
                    minLen = j-i+1;
                }
                char start = s.charAt(i);
                if(tmap.containsKey(start)){
                    tmap.put(start, tmap.get(start) + 1);
                }
                count++;
                i++;
            }
        }
        if(left == -1 || right == -1) return "";
        return s.substring(left, right+1);
    }
}