// Last updated: 4/24/2026, 10:36:47 AM
class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        int[] ans = new int[n1 + n2];

        for(int i = n1-1; i>=0; i--){
            for(int j = n2-1; j>=0; j--){
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';

                int mul = d1*d2;
                int sum = mul + ans[i+j+1];

                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : ans){
            if(!(sb.length() == 0 && num == 0)) sb.append(num);
        }

        return sb.toString();
    }
}