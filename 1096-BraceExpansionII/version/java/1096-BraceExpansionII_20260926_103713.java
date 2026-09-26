// Last updated: 9/26/2026, 10:37:13 AM
1class Solution {
2    private String s;
3    private int i;
4
5    public List<String> braceExpansionII(String expression) {
6        s = expression;
7        i = 0;
8
9        Set<String> set = parseExpression();
10        List<String> ans = new ArrayList<>(set);
11        Collections.sort(ans);
12        return ans;
13    }
14
15    private Set<String> parseExpression() {
16        Set<String> res = parseTerm();
17
18        while (i < s.length() && s.charAt(i) == ',') {
19            i++;
20            res.addAll(parseTerm());
21        }
22        return res;
23    }
24
25    private Set<String> parseTerm() {
26        Set<String> res = new HashSet<>();
27        res.add("");
28
29        while (i < s.length()
30                && s.charAt(i) != '}'
31                && s.charAt(i) != ',') {
32
33            Set<String> next = parseFactor();
34            Set<String> temp = new HashSet<>();
35
36            for (String a : res) {
37                for (String b : next) {
38                    temp.add(a + b);
39                }
40            }
41            res = temp;
42        }
43
44        return res;
45    }
46
47    private Set<String> parseFactor() {
48        if (s.charAt(i) == '{') {
49            i++;
50
51            Set<String> res = parseExpression();
52            i++;
53            return res;
54        }
55
56        Set<String> res = new HashSet<>();
57        res.add(String.valueOf(s.charAt(i)));
58        i++;
59        return res;
60    }
61}