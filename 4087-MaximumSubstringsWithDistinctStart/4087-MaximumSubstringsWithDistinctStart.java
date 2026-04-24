// Last updated: 4/24/2026, 10:30:08 AM
class Solution {
    public int maxDistinct(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0;
        int count = 0;
        while(i<n){
            int val = arr[i];
            int j = i;
            while(j<n && arr[j] == val) j++;
            count++;
            i=j;
        }

        return count;
    }
}