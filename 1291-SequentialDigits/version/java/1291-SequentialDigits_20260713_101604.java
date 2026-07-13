// Last updated: 7/13/2026, 10:16:04 AM
1class Solution {
2    public List<Integer> sequentialDigits(int low, int high) {
3        int lowLen = String.valueOf(low).length();
4        int highLen = String.valueOf(high).length();
5
6        return helper(low, high, lowLen, highLen);
7    }
8
9    public List<Integer> helper(int low, int high, int lowLen, int highLen){
10        List<Integer> temp = new ArrayList<>();
11
12        while(lowLen <= highLen){
13            int lastDigit = 9-lowLen+1;
14
15            for(int start = 1; start <= lastDigit; start++){
16                int num = 0;
17
18                int i = 0;
19                while(i < lowLen){
20                    num = num*10 + (start + i);
21                    i++;
22                }
23
24                if(num >= low && num <= high){
25                    temp.add(num);
26                }else if(num > high) return temp; 
27            }
28
29            lowLen++;
30        }
31
32        return temp;
33    }
34}