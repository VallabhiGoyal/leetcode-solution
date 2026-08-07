// Last updated: 8/7/2026, 6:58:24 AM
1class Solution {
2    public String simplifyPath(String path) {
3        String[] temp = path.split("/+");
4
5        Deque<String> stack = new ArrayDeque<>();
6
7        for (String s : temp) {
8            if (s.equals("") || s.equals(".")) {
9                continue;
10            } else if (s.equals("..")) {
11                if (!stack.isEmpty()) stack.removeLast();
12            } else {
13                stack.addLast(s);
14            }
15        }
16
17        if (stack.isEmpty()) return "/";
18
19        StringBuilder sb = new StringBuilder();
20        for (String s : stack) {
21            sb.append("/").append(s);
22        }
23
24        return sb.toString();
25    }
26}