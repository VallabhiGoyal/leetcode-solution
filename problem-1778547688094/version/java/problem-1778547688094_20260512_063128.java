// Last updated: 5/12/2026, 6:31:28 AM
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
17            if(!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) continue;
18            
19            StringBuilder str = new StringBuilder();
20            int j = i;
21            while(j<size && ((s.charAt(j) >= 'a' && s.charAt(j)<='z') || s.charAt(j) == '-')){
22                
23                if(s.charAt(j) >= 'a' && s.charAt(j) <= 'z'){
24                    str.append(s.charAt(j));
25                    j++;
26                }else{
27                    if(j-1>=0 && j+1 < size && s.charAt(j+1) >= 'a' && s.charAt(j+1) <= 'z' && s.charAt(j-1) >= 'a' && s.charAt(j-1) <= 'z'){
28                        str.append(s.charAt(j));
29                        j++;
30                    }else{
31                        j++;
32                        break;
33                    }
34                }
35            }
36            words.add(str.toString());
37            i = j - 1;
38        }
39        
40        Map<String, Integer> map = new HashMap<>();
41
42        int len = words.size();
43
44        for(int i = 0; i<len; i++){
45            map.put(words.get(i), map.getOrDefault(words.get(i), 0) + 1);
46        }
47
48        int n = queries.length;
49        int[] ans = new int[n];
50
51        for(int i = 0; i<n; i++){
52            ans[i] = map.getOrDefault(queries[i], 0);
53        }
54
55        return ans;
56    }
57}