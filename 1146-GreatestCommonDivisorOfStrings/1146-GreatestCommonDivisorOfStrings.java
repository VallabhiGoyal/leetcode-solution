// Last updated: 4/24/2026, 10:32:15 AM
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int a = str1.length();
        int b = str2.length();

        if(!(str1+str2).equals(str2+str1)) return "";
        int length = gcd(a, b);
        return str1.substring(0,length); 
    }

    private int gcd(int a, int b){
        if(a == 0 || b == 0) return 0;
        if(a == b) return a;

        int min = Math.min(a,b);
        int n = 0;
        for(int i = min; i>0; i--){
            if(a%i == 0 && b%i == 0) return i;
        }

        return 1;
    }
}