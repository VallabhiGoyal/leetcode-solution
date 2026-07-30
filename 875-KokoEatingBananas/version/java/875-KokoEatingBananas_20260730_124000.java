// Last updated: 7/30/2026, 12:40:00 PM
1class Solution {
2    
3    public int search(int[] arr, int target) {
4        int start = 0;
5        int end = arr.length -1;
6        
7        int pivot = findPivot(arr);
8
9        if(pivot  == -1){
10            return binarySearch(arr, target, 0, arr.length -1);
11        }
12        if(arr[pivot] == target){
13            return pivot;
14        }
15        if(target >= arr[start]){
16            return binarySearch(arr, target, 0, pivot -1);
17        }else{
18            return binarySearch(arr, target, pivot + 1, end);
19        }
20    }
21    static int findPivot(int[] arr){
22        int start = 0;
23        int end = arr.length -1;
24        while(start <= end){
25            int mid = start + (end-start)/2;
26            // case 1
27            if(mid <end && arr[mid]>arr[mid+1]){
28                return mid;
29            }//case 2
30            if(mid>start && arr[mid]<arr[mid-1]){
31                return mid -1;
32            }//case 3
33            if(arr[mid]>=arr[start]){
34                start = mid + 1;
35            }else{ //case 4
36                end = mid - 1;
37            }
38        }
39        return -1;
40    }
41    public static int binarySearch(int[] arr, int target, int start, int end){
42        if(start > end) return -1;
43
44        int mid = start + (end-start)/2;
45        
46        if(target<arr[mid]){
47            return binarySearch(arr, target, start, mid - 1);
48        }else if(target> arr[mid]){
49            return binarySearch(arr, target, mid + 1, end);
50        }else{
51            return mid;
52        }
53    }
54}