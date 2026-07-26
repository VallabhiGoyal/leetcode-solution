// Last updated: 7/26/2026, 7:11:57 AM
1class Solution {
2    public List<String> generateParenthesis(int n) {
3        List<String> list = new ArrayList<>();
4        StringBuilder sb = new StringBuilder();
5
6        generate(n, 0, 0, sb , list);
7
8        return list;
9    }
10
11    private void generate(int n, int open, int close, StringBuilder s, List<String> list){
12        if(s.length() == 2*n){
13            list.add(s.toString());
14            return;
15        }
16
17        if(open < n){
18            s.append("(");
19            generate(n, open+1, close, s, list);
20            s.deleteCharAt(s.length()-1);
21        }
22
23        if(close < open){
24            s.append(")");
25            generate(n, open, close+1, s, list);
26            s.deleteCharAt(s.length()-1);
27        }
28    }
29}