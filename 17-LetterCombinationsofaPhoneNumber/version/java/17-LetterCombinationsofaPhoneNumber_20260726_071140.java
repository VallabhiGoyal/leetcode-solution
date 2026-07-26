// Last updated: 7/26/2026, 7:11:40 AM
1class Solution {
2    public List<String> letterCombinations(String digits) {
3        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
4
5        StringBuilder sb = new StringBuilder();
6
7        List<String> list = new ArrayList<>();
8
9        helper(digits, sb, list, map, 0);
10
11        return list;
12    }
13
14    public void helper(String digits, StringBuilder sb, List<String> list, String[] map, int currIdx){
15        
16        if(digits.length() == 0) return;
17
18        if(digits.length() == sb.length()){
19            list.add(sb.toString());
20            return;
21        }
22
23        int currDigit = digits.charAt(currIdx) - '0';
24        String currString = map[currDigit];
25        int size = currString.length();
26
27        for(int i = 0; i<size; i++){
28            sb.append(currString.charAt(i));
29            helper(digits, sb, list, map, currIdx + 1);
30            sb.deleteCharAt(sb.length()-1);
31        }
32    }
33}