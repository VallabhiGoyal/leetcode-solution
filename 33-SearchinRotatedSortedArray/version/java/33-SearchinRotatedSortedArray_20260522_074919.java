// Last updated: 5/22/2026, 7:49:19 AM
1class Solution {
2    
3    public int search(int[] arr, int target) {
4        int start = 0;
5        int end = arr.length -1;
6        int pivot = findPivot(arr);
7        if(pivot  == -1){
8            return binarySearch(arr, target, 0, arr.length -1);
9        }
10        if(arr[pivot] == target){
11            return pivot;
12        }
13        if(target >= arr[start]){
14            return binarySearch(arr, target, 0, pivot -1);
15        }else{
16            return binarySearch(arr, target, pivot + 1, end);
17        }
18    }
19    static int findPivot(int[] arr){
20        int start = 0;
21        int end = arr.length -1;
22        while(start <= end){
23            int mid = start + (end-start)/2;
24            // case 1
25            if(mid <end && arr[mid]>arr[mid+1]){
26                return mid;
27            }//case 2
28            if(mid>start && arr[mid]<arr[mid-1]){
29                return mid -1;
30            }//case 3
31            if(arr[mid]>=arr[start]){
32                start = mid + 1;
33            }else{ //case 4
34                end = mid - 1;
35            }
36        }
37        return -1;
38    }
39    public static int binarySearch(int[] arr, int target, int start, int end){
40        while(start<=end){
41            int mid = start + (end-start)/2;
42            if(target<arr[mid]){
43                end = mid -1;
44            }else if(target> arr[mid]){
45                start = mid +1;
46            }else{
47                return mid;
48            }
49        }
50        return -1;
51    }
52}