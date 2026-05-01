// Last updated: 5/1/2026, 10:14:53 AM
1class Solution {
2    public String sortVowels(String s) {
3        int n = s.length();
4
5        Map<Character, Integer> map = new HashMap<>();
6        Map<Character, Integer> firstOccur = new HashMap<>();
7        
8        for(int i = 0; i<n; i++){
9            char ch = s.charAt(i);
10            if(isVowel(ch)){
11                map.put(ch, map.getOrDefault(ch, 0) + 1);
12                if(!firstOccur.containsKey(ch)){
13                    firstOccur.put(ch, i);
14                }
15            }
16        }
17
18        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
19        Collections.sort(list, (a,b) -> {
20            if(!a.getValue().equals(b.getValue())) return b.getValue() - a.getValue();
21
22            return firstOccur.get(a.getKey()) - firstOccur.get(b.getKey());
23            
24        });
25
26        StringBuilder vowel = new StringBuilder();
27        for(Map.Entry<Character, Integer> entry : list){
28            char ch = entry.getKey();
29            int freq = entry.getValue();
30             while(freq > 0){
31                 vowel.append(ch);
32                 freq--;
33             }
34        }
35
36        int idx = 0;
37        StringBuilder sb = new StringBuilder();
38
39        for(int i = 0; i<n; i++){
40            char ch = s.charAt(i);
41            if(!isVowel(ch)) sb.append(ch);
42            else{
43                sb.append(vowel.charAt(idx++));
44            }
45        }  
46
47        return sb.toString();
48    }
49
50    private boolean isVowel(char ch){
51        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
52
53        return false;
54    }
55}