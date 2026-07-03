// Last updated: 7/3/2026, 11:34:58 AM
class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(0, n, 0, 0, sb, list, k);

        return list;
    }

    public void dfs(int pos, int n, int prevOne, int count, StringBuilder currString, List<String> list, int k){
        if(count > k) return;
        
        if(pos == n){
            list.add(currString.toString());
            return;
        }

        currString.append("0");
        dfs(pos + 1, n, 0, count, currString, list, k);
        currString.deleteCharAt(currString.length()-1);

        if(prevOne == 0){
            currString.append("1");
            dfs(pos + 1, n, 1, count + pos, currString, list, k);
            currString.deleteCharAt(currString.length()-1);
        }
    }
}