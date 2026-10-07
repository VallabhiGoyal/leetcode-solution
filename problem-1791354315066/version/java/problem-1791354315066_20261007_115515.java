// Last updated: 10/7/2026, 11:55:15 AM
1class Solution {
2    public List<String> removeInvalidParentheses(String s) {
3        List<String> ans = new ArrayList<>();
4        Queue<String> queue = new LinkedList<>();
5        Set<String> visited = new HashSet<>();
6
7        queue.offer(s);
8        visited.add(s);
9
10        boolean found = false;
11
12        while (!queue.isEmpty()) {
13
14            int size = queue.size();
15
16            for (int k = 0; k < size; k++) {
17
18                String curr = queue.poll();
19
20                if (isValid(curr)) {
21                    ans.add(curr);
22                    found = true;
23                }
24
25                if (found) {
26                    continue;
27                }
28
29                for (int i = 0; i < curr.length(); i++) {
30
31                    char ch = curr.charAt(i);
32
33                    if (ch != '(' && ch != ')') {
34                        continue;
35                    }
36
37                    String next = curr.substring(0, i)
38                            + curr.substring(i + 1);
39
40                    if (!visited.contains(next)) {
41                        visited.add(next);
42                        queue.offer(next);
43                    }
44                }
45            }
46
47            if (found) {
48                break;
49            }
50        }
51
52        return ans;
53    }
54
55    private boolean isValid(String s) {
56        int balance = 0;
57        for (char ch : s.toCharArray()) {
58            if (ch == '(') {
59                balance++;
60            } 
61            else if (ch == ')') {
62                balance--;
63                if (balance < 0) {
64                    return false;
65                }
66            }
67        }
68
69        return balance == 0;
70    }
71}