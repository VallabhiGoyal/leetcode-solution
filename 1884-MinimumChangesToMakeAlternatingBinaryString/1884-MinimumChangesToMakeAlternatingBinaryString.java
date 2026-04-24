// Last updated: 4/24/2026, 10:31:28 AM
class Solution {
    public int minOperations(String s) {
        int n = s.length(); 
        if( n == 1) return 0;

        int even0 = 0;
        int even1 = 0;
        int odd0 = 0;
        int odd1 = 0;

        //even 0 odd 1 ---> 01
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(i%2 == 0){
                if(ch == '0') even0++;
                else even1++;
            }else{
                if(ch == '0') odd0++;
                else odd1++;
            }

        }

        return n - Math.max(even0+odd1, odd0 + even1);
    }
}