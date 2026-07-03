// Last updated: 7/3/2026, 11:34:44 AM
class Solution {
    public int passwordStrength(String password) {
        int n = password.length();

        Set<Character> set = new HashSet<>();

        int ans = 0;
        for(int i = 0; i<n; i++){
            char curr = password.charAt(i);
            if(set.contains(curr)) continue;

            set.add(curr);
            if(curr >= 'a' && curr <= 'z') ans+=1;
            else if(curr >='A' && curr <= 'Z') ans+=2;
            else if(curr >= '0' && curr <= '9') ans+=3;
            else ans += 5;
        }

        return ans;
    }
}