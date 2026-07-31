// Last updated: 7/31/2026, 5:45:39 AM
1class Solution {
2    public int minimumPushes(String word) {
3        int ans=0;
4        int[] fre=new int[26];
5        int n=word.length();
6        for(int i=0;i<n;i++){
7            char ch=word.charAt(i);
8            fre[ch-'a']++;
9        }
10        Arrays.sort(fre);
11        for(int i=25;i>=0;i--){
12            ans+=fre[i]*((25-i)/8+1);
13        }
14        return ans;
15    }
16}