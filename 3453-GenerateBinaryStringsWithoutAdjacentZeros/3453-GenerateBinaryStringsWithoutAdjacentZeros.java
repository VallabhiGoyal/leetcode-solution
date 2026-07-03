// Last updated: 7/3/2026, 11:36:38 AM
class Solution {
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(0, n, 0, sb, list);

        return list;
    }

    public void dfs(int pos, int n, int prevZero, StringBuilder currString, List<String> list){
        
        if(pos == n){
            list.add(currString.toString());
            return;
        }

        currString.append("1");
        dfs(pos + 1, n, 0, currString, list);
        currString.deleteCharAt(currString.length()-1);

        if(prevZero == 0){
            currString.append("0");
            dfs(pos + 1, n, 1,currString, list);
            currString.deleteCharAt(currString.length()-1);
        }
    }
}