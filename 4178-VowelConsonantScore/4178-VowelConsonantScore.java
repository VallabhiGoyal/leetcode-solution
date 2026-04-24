// Last updated: 4/24/2026, 10:29:52 AM
class Solution {
    public int vowelConsonantScore(String s) {
        s = s.replaceAll("[^a-z]", "");

        int size = s.length();
        if(size == 0) return 0;
        int v = 0;
        for(int i = 0; i<size; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                v++;
            }
        }

        int c = size-v;
        if(c!=0){
            return (int)v/c;
        }

        return 0;
    }
}