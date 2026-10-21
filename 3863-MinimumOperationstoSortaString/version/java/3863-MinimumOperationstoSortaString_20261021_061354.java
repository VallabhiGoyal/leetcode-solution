// Last updated: 10/21/2026, 6:13:54 AM
1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        if(n == 1) return 0;
5
6        //impossible case -> -1
7        if(n == 2 && s.charAt(0) > s.charAt(1)) return -1;
8        
9        char[] arr = s.toCharArray();
10        Arrays.sort(arr);
11        
12        //already sorted -> 0
13        int i = 0;
14        while(i<n && s.charAt(i) == arr[i]) i++;
15        if(i == n) return 0;
16
17        //possible answer is 1
18        if(s.charAt(0) == arr[0] || s.charAt(n-1) == arr[n-1]) return 1;
19
20        //possible answer is 3 
21        if(s.charAt(0) == arr[n-1] && s.charAt(n-1) == arr[0]){
22            if(arr[0] == arr[1] || arr[n-1] == arr[n-2]) return 2;
23            return 3;
24        } 
25        return 2;
26    }
27}