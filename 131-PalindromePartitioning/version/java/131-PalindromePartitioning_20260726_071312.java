// Last updated: 7/26/2026, 7:13:12 AM
1class Solution {
2    public List<List<String>> partition(String s) {
3        int n = s.length();
4        List<List<String>> result = new ArrayList<>();
5        List<String> curr = new ArrayList<>();
6        solve(s, 0,curr , result);
7
8        return result;
9    }
10
11    public void solve(String s, int start, List<String> curr, List<List<String>> result){
12        int n = s.length();
13        if(start == n){
14            result.add(new ArrayList<>(curr));
15            return;
16        }
17        
18        for(int i = start; i<n; i++){
19            if(isPalindrome(s, start, i)){ 
20                curr.add(s.substring(start, i+1));
21                solve(s, i+1, curr, result);
22                curr.remove(curr.size()-1);
23            }
24        }
25    }
26
27    public boolean isPalindrome(String s, int i, int j){
28        while(i<j){
29            if(s.charAt(i) != s.charAt(j)) return false;
30            i++;
31            j--;
32        }
33
34        return true;
35    }
36}