// Last updated: 5/25/2026, 8:20:15 AM
1class Solution {
2    public String addStrings(String num1, String num2) {
3        int n1 = num1.length();
4        int n2 = num2.length();
5
6        StringBuilder sb = new StringBuilder();
7
8        int i = n1-1;
9        int j = n2-1;
10        
11        int carry = 0;
12        while(i>=0 || j>=0 || carry > 0){
13            int ch1 = 0;
14            int ch2 = 0;
15
16            if(i >= 0 ){
17                ch1 = num1.charAt(i) - '0';
18                i--;
19            }
20            
21            if(j >= 0){
22                ch2 = num2.charAt(j) - '0';
23                j--;
24            }
25            
26            int temp = ch1 + ch2 + carry;
27            
28            carry = temp/10;
29
30            sb.append(temp%10);
31        }
32
33        return sb.reverse().toString();
34    }
35}