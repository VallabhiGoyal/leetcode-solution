// Last updated: 4/24/2026, 10:35:48 AM
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> sub1 = new ArrayList<>();
        sub1.add(1);
        list.add(sub1);
        if(numRows == 1)  return list;

        for(int i = 1; i<numRows; i++){
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            for(int j = 1; j<i; j++){
                int curr = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                subList.add(curr);
            }
            subList.add(1);
            list.add(subList);
        }

        return list;
    }
}