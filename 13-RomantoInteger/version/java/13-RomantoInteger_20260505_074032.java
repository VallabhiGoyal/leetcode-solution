// Last updated: 5/5/2026, 7:40:32 AM
1class Solution {
2    public int romanToInt(String s) {
3        int n = s.length();
4
5        int ans = 0;
6        for(int i = 0; i<n; i++){
7            char ch = s.charAt(i);
8
9            if(ch == 'I'){
10                if(i+1<n && s.charAt(i+1) == 'V'){
11                    ans += 4;
12                    i++;
13                }
14                else if(i+1<n && s.charAt(i+1) == 'X'){
15                    ans += 9;
16                    i++;
17                }else{
18                    int count = 0;
19                    while(i<n && s.charAt(i) == 'I' && count != 3){
20                        count++;
21                        i++;
22                    }
23                    i--;
24                    ans += count;
25                }
26            }else if(ch == 'V'){
27                ans += 5;
28            }else if(ch == 'X'){
29                if(i+1<n && s.charAt(i+1) == 'L'){
30                    ans+=40;
31                    i++;
32                }else if(i+1 < n && s.charAt(i+1) == 'C'){
33                    ans += 90;
34                    i++;
35                }else{
36                    ans += 10;
37                } 
38            }else if(ch == 'L'){
39                ans += 50;
40            }else if(ch == 'C'){
41                if(i+1<n && s.charAt(i+1) == 'D'){
42                    ans+=400;
43                    i++;
44                }else if(i+1 < n && s.charAt(i+1) == 'M'){
45                    ans += 900;
46                    i++;
47                }else{
48                    ans += 100;
49                } 
50            }else if(ch == 'D'){
51                ans += 500;
52            }else if(ch == 'M'){
53                ans += 1000;
54            }
55
56        }
57
58        return ans;
59    }
60}