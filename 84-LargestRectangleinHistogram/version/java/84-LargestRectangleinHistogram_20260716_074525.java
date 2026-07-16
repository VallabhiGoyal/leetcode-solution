// Last updated: 7/16/2026, 7:45:25 AM
1class Solution {
2    public int largestRectangleArea(int[] heights) {
3        int n = heights.length;
4
5        Stack<Node> stack = new Stack<>();
6        stack.push(new Node(heights[0], 1));
7
8        int maxArea = 0;
9
10        for(int i = 1; i<n; i++){
11            int width = 0;
12            while(!stack.isEmpty() && stack.peek().height >= heights[i]){
13                Node curr = stack.pop();
14                maxArea = Math.max(maxArea, curr.height*(curr.width + width));
15
16                width += curr.width;
17            }
18            stack.push(new Node(heights[i], width + 1));
19        }
20
21        int prevWidth = 0;
22        while(!stack.isEmpty()){
23            Node curr = stack.pop();
24            maxArea = Math.max(maxArea, curr.height * (curr.width + prevWidth));
25            prevWidth += curr.width;
26        }
27
28        return maxArea;
29    }
30
31    public class Node{
32        int height;
33        int width;
34
35        Node(int height, int width){
36            this.height = height;
37            this.width = width;
38        }
39    }
40}