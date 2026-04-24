// Last updated: 4/24/2026, 10:35:37 AM
class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        solve(s, 0,curr , result);

        return result;
    }

    public void solve(String s, int start, List<String> curr, List<List<String>> result){
        int n = s.length();
        if(start == n){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = start; i<n; i++){
            if(isPalindrome(s, start, i)){ 
                curr.add(s.substring(start, i+1));
                solve(s, i+1, curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}