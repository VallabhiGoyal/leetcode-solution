// Last updated: 7/26/2026, 7:06:55 AM
1class Solution {
2    public List<List<Integer>> generate(int numRows) {
3        List<List<Integer>> list = new ArrayList<>();
4
5        List<Integer> sub1 = new ArrayList<>();
6        sub1.add(1);
7        list.add(sub1);
8        if(numRows == 1)  return list;
9
10        for(int i = 1; i<numRows; i++){
11            List<Integer> subList = new ArrayList<>();
12            subList.add(1);
13            for(int j = 1; j<i; j++){
14                int curr = list.get(i-1).get(j-1) + list.get(i-1).get(j);
15                subList.add(curr);
16            }
17            subList.add(1);
18            list.add(subList);
19        }
20
21        return list;
22    }
23}