// Last updated: 8/13/2026, 9:59:35 AM
1class Solution {
2    public String[] findWords(String[] words) {
3        List<Character> r1 = new ArrayList<>(
4            Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p')
5        );
6
7        List<Character> r2 = new ArrayList<>(
8            Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l')
9        );
10
11        List<Character> r3 = new ArrayList<>(
12            Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm')
13        );
14
15        List<String> ans = new ArrayList<>();
16
17        for (String word : words) {
18            String s = word.toLowerCase();
19
20            char ch = s.charAt(0);
21
22            int curr;
23
24            if (r1.contains(ch)) {
25                curr = 1;
26            } else if (r2.contains(ch)) {
27                curr = 2;
28            } else {
29                curr = 3;
30            }
31
32            boolean valid = true;
33
34            for (int j = 1; j < s.length(); j++) {
35                char c = s.charAt(j);
36
37                if ((curr == 1 && !r1.contains(c)) ||
38                    (curr == 2 && !r2.contains(c)) ||
39                    (curr == 3 && !r3.contains(c))) {
40
41                    valid = false;
42                    break;
43                }
44            }
45
46            if (valid) {
47                ans.add(word);
48            }
49        }
50
51        return ans.toArray(new String[0]);
52    }
53}