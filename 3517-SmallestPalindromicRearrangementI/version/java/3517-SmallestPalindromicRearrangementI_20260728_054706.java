// Last updated: 7/28/2026, 5:47:06 AM
1class Solution {
2    public String smallestPalindrome(String s) {
3        int n = s.length();
4
5        int[] freq = new int[26];
6
7        for(int i = 0; i<n; i++){
8            freq[s.charAt(i) - 'a']++;
9        }
10
11        StringBuilder sb = new StringBuilder();
12        int ch = -1;
13
14        for(int i = 0; i<26; i++){
15            int temp = freq[i];
16            if(temp % 2 == 0){
17                while(freq[i]/2 != temp){
18                    sb.append((char)('a' + i));
19                    temp--;
20                }
21                freq[i] = temp;
22            }else{
23                ch = i;
24                temp--;
25                while(freq[i]/2 != temp){
26                    sb.append((char)('a' + i));
27                    temp--;
28                }
29                freq[i] = temp;
30            }
31        }
32
33        StringBuilder sb2 = new StringBuilder(sb).reverse();
34
35        if(ch != -1) sb.append((char)('a' + ch));
36
37        sb.append(sb2);
38
39        return sb.toString();
40    }
41}