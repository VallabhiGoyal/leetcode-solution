// Last updated: 5/12/2026, 6:35:40 AM
1class Solution {
2    public int[] countWordOccurrences(String[] chunks, String[] queries) {
3        int m = chunks.length;
4        StringBuilder s1 = new StringBuilder();
5
6        for(int i = 0; i<m; i++){
7            s1.append(chunks[i]);
8        }
9
10        String s = s1.toString();
11        int size = s.length();
12        
13        List<String> words = new ArrayList<>();
14        
15        for(int i = 0; i<size; i++){
16            
17            if(!isLower(s, i)) continue;
18            
19            StringBuilder str = new StringBuilder();
20            int j = i;
21            while(j<size && (isLower(s, j) || s.charAt(j) == '-')){
22                
23                if(isLower(s, j)){
24                    str.append(s.charAt(j));
25                    j++;
26                }else{
27                    if(j-1>=0 && j+1 < size && isLower(s, j-1) && isLower(s, j+1)){
28                        str.append(s.charAt(j));
29                        j++;
30                    }else{
31                        j++;
32                        break;
33                    }
34                }
35            }
36            if(str.length() > 0){
37                words.add(str.toString());
38            }
39            i = j - 1;
40        }
41        
42        Map<String, Integer> map = new HashMap<>();
43
44        int len = words.size();
45
46        for(int i = 0; i<len; i++){
47            map.put(words.get(i), map.getOrDefault(words.get(i), 0) + 1);
48        }
49
50        int n = queries.length;
51        int[] ans = new int[n];
52
53        for(int i = 0; i<n; i++){
54            ans[i] = map.getOrDefault(queries[i], 0);
55        }
56
57        return ans;
58    }
59
60    public boolean isLower(String s, int idx){
61        if(s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') return true;
62        return false;
63    }
64}