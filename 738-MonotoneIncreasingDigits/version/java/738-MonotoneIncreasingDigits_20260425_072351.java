// Last updated: 4/25/2026, 7:23:51 AM
/*
 * Approach
 * ->Convert number → char array
 * ->Traverse right → left
 * ->If digit[i] < digit[i-1]:
 * ->decrement digit[i-1]
 * ->mark index
 * ->Set all digits after mark → '9'
 * 
 * Time complexity O(d)
 * Space complexity O(d)
*/

1class Solution {
2    public int monotoneIncreasingDigits(int n) {
3        char[] digit = String.valueOf(n).toCharArray();
4
5        int m = digit.length;
6        
7        int mark = m;
8        for(int i = m-1; i>0; i--){
9            if(digit[i] < digit[i-1]){
10                digit[i-1]--;
11                mark = i;
12            }
13        }
14
15        for(int i = mark; i<m; i++){
16            digit[i] = '9';
17        }
18        System.out.println(Arrays.toString(digit));
19
20        int ans = 0;
21        for(int i = 0; i<m; i++){
22            ans = ans*10 + (digit[i]-'0');
23        }
24
25        return ans;
26    }
27}