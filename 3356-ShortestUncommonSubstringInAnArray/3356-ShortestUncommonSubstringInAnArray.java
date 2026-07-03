// Last updated: 7/3/2026, 11:36:43 AM
class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;

        Map<String, Integer> map = new HashMap<>();
        List<String>[] temp = new ArrayList[n];

        for(int i = 0; i<n; i++){
            Set<String> seen = new HashSet<>();

            String s = arr[i];
            int len = s.length();

            for(int j = 0; j<len; j++){
                for(int k = j; k<len; k++){
                    String sub = s.substring(j, k+1);

                    if(!seen.contains(sub)){
                        seen.add(sub);
                        map.put(sub, map.getOrDefault(sub ,0) + 1);
                    }
                }
            }

            temp[i] = new ArrayList<>(seen);
        }

        String[] ans = new String[n];

        for(int i = 0; i<n; i++){
            List<String> list = temp[i];
            int len = list.size();
            String min_str = "";

            for(int j = 0; j<len; j++){
                String curr = list.get(j);

                if(map.get(curr) == 1){
                    if(min_str.isEmpty() ||  min_str.length() > curr.length()){
                        min_str = curr;
                    }else if(min_str.length()  == curr.length() && curr.compareTo(min_str) < 0){
                        min_str = curr;
                    }
                }
            }
            ans[i] = min_str;
        }

        return ans;
    }
}