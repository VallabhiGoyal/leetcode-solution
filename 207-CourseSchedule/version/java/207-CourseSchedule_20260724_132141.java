// Last updated: 7/24/2026, 1:21:41 PM
1class Solution {
2
3    ArrayList<Integer> graph[];
4
5    public boolean canFinish(int numCourses, int[][] prerequisites) {
6        
7        createGraph(numCourses, prerequisites);
8        Stack<Integer> stack = new Stack<>();
9        boolean[] visit = new boolean[numCourses];
10        boolean[] rec = new boolean[numCourses];
11
12        for(int i = 0; i<numCourses; i++){
13            if(!visit[i]){
14                if(topSort(visit, i, rec, stack)) return false;
15            }
16        }
17
18        return true;
19    }
20
21    private boolean topSort(boolean visit[], int curr, boolean rec[], Stack<Integer> stack){
22        visit[curr] = true;
23        rec[curr] = true;
24        
25        for(int i = 0; i<graph[curr].size(); i++){
26            int edge = graph[curr].get(i);
27
28            if(rec[edge]){
29                return true;
30            }else if(!visit[edge]){
31                if(topSort(visit, edge, rec, stack)){
32                    return true;
33                }
34            }
35        }
36        stack.push(curr);
37        rec[curr] = false;
38        return false;
39    }
40
41    private void createGraph(int numCourses, int[][] pre){
42        graph = new ArrayList[numCourses];
43
44        for(int i = 0; i<numCourses; i++){
45            graph[i] = new ArrayList<>();
46        }
47
48        for(int i = 0; i<pre.length; i++){
49            graph[pre[i][1]].add(pre[i][0]);
50        }
51    }
52
53}