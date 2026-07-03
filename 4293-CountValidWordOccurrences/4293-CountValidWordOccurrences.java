// Last updated: 7/3/2026, 11:34:53 AM
class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        int m = chunks.length;
        StringBuilder s1 = new StringBuilder();

        for(int i = 0; i<m; i++){
            s1.append(chunks[i]);
        }

        String s = s1.toString();
        int size = s.length();
        
        List<String> words = new ArrayList<>();
        
        for(int i = 0; i<size; i++){
            
            if(!isLower(s, i)) continue;
            
            StringBuilder str = new StringBuilder();
            int j = i;
            while(j<size && (isLower(s, j) || s.charAt(j) == '-')){
                
                if(isLower(s, j)){
                    str.append(s.charAt(j));
                    j++;
                }else{
                    if(j-1>=0 && j+1 < size && isLower(s, j-1) && isLower(s, j+1)){
                        str.append(s.charAt(j));
                        j++;
                    }else{
                        j++;
                        break;
                    }
                }
            }
            if(str.length() > 0){
                words.add(str.toString());
            }
            i = j - 1;
        }
        
        Map<String, Integer> map = new HashMap<>();

        int len = words.size();

        for(int i = 0; i<len; i++){
            map.put(words.get(i), map.getOrDefault(words.get(i), 0) + 1);
        }

        int n = queries.length;
        int[] ans = new int[n];

        for(int i = 0; i<n; i++){
            ans[i] = map.getOrDefault(queries[i], 0);
        }

        return ans;
    }

    public boolean isLower(String s, int idx){
        if(s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') return true;
        return false;
    }
}