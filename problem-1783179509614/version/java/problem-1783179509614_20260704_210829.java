// Last updated: 7/4/2026, 9:08:29 PM
1class Solution {
2    public int minOperations(String s1, String s2) {
3        int n = s1.length();
4
5        StringBuilder sb1 = new StringBuilder(s1);
6        int op = 0;
7        
8        for(int i = 0; i<n; i++){
9            if(sb1.charAt(i) == s2.charAt(i)) continue;
10
11            if(sb1.charAt(i) == '0'){
12                op++;
13                sb1.setCharAt(i, '1');
14            }else{
15                if(i<n-1){
16                    if(sb1.charAt(i+1) == '1'){
17                        op++;
18                        sb1.setCharAt(i, '0');
19                        sb1.setCharAt(i+1, '0');
20                    }else{
21                        op += 2;
22                        sb1.setCharAt(i, '0');
23                    }
24                }else if(i > 0){
25                    op += 2;
26                    sb1.setCharAt(i, '0');
27                }else return -1;
28            }
29        }
30
31        return s2.equals(sb1.toString()) ? op : -1;
32    }
33}