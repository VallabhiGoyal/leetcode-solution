// Last updated: 8/23/2026, 8:35:41 AM
1class Solution {
2    public boolean isPalindromic(String s) {
3        int n = s.length();
4
5        int i = 0; 
6        int j = n-1;
7
8        while(i < j){
9            String temp1 = String.format("%8s", Integer.toBinaryString(s.charAt(i))).replace(' ', '0');
10
11            String temp2 = String.format("%8s", Integer.toBinaryString(s.charAt(j))).replace(' ', '0');
12
13            int p = 0;
14            int q = 7;
15
16            while(p < 8){
17                if(temp1.charAt(p) != temp2.charAt(q)) return false;
18                p++;
19                q--;
20            }
21            i++;
22            j--;
23        }
24
25        if(n%2 != 0){
26            int k = n/2;
27
28            String temp = String.format("%8s", Integer.toBinaryString(s.charAt(k))).replace(' ', '0');
29
30            i = 0;
31            j = 7;
32
33            while(i < j){
34                if(temp.charAt(i++) != temp.charAt(j--)) return false;
35            }
36            
37        }
38
39        return true;
40    }
41}