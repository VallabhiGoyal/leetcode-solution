// Last updated: 4/24/2026, 10:29:53 AM
class Solution {
    public String reversePrefix(String s, int k) {

        char[] arr = s.toCharArray();
        
        for(int i = 0; i<k/2;i++){
            char temp = arr[i];
            arr[i] = arr[k-i-1];
            arr[k-i-1] = temp;
        }

        return new String(arr);
    }
}