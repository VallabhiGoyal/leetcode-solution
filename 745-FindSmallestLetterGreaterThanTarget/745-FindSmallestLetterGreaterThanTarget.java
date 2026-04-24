// Last updated: 4/24/2026, 10:33:08 AM
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        
        while(start<=end){
            int mid = start + (end - start)/2;    
            if(target<letters[mid]){
                end = mid - 1;
                    
            }else{
                start = mid + 1;
            }

        }
        
        return letters[start%letters.length];
    }
}