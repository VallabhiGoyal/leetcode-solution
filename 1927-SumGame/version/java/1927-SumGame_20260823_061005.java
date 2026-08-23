// Last updated: 8/23/2026, 6:10:05 AM
1class Solution {
2    public boolean sumGame(String num) {
3        int n = num.length();
4
5        int leftHalf = 0;
6        int rightHalf = 0;
7
8        int leftSum = 0;
9        int rightSum = 0;
10        
11        for(int i = 0; i < n/2; i++){
12            int ch = num.charAt(i);
13            if(ch == '?') leftHalf++;
14            else leftSum += ch - '0';
15        }
16
17        for(int i = n/2; i < n; i++){
18            int ch = num.charAt(i);
19            if(ch == '?') rightHalf++;
20            else rightSum += ch - '0';
21        }
22
23        if(leftHalf == 0 && rightHalf == 0){
24            return leftSum != rightSum;
25        }
26
27        if((leftHalf + rightHalf) % 2 != 0) return true;
28
29        int minSum = Math.min(leftSum, rightSum);
30        leftSum -= minSum;
31        rightSum -= minSum;
32
33        int minHalf = Math.min(leftHalf, rightHalf);
34        leftHalf -= minHalf;
35        rightHalf -= minHalf;
36
37        if(leftSum == 0 && rightSum == 0 && leftHalf == 0 && rightHalf == 0) return false;
38
39        if(leftSum == 0 && leftHalf == 0) return true;
40        if(rightSum == 0 && rightHalf == 0) return true;
41
42        leftSum += rightSum;
43        leftHalf += rightHalf;
44
45        return leftHalf * 9 != leftSum * 2;
46    }
47}