// Last updated: 7/16/2026, 7:44:38 AM
1class Solution {
2    public int largestRectangleArea(int[] heights) {
3        int n = heights.length;
4
5        Stack<Node> stack = new Stack<>();
6        stack.push(new Node(heights[0], 1));
7
8        int maxArea = 0;
9        int stackTop = heights[0];
10
11        for(int i = 1; i<n; i++){
12            int width = 0;
13            while(!stack.isEmpty() && stack.peek().height >= heights[i]){
14                Node curr = stack.pop();
15                maxArea = Math.max(maxArea, curr.height*(curr.width + width));
16
17                width += curr.width;
18            }
19            stack.push(new Node(heights[i], width + 1));
20        }
21
22        int prevWidth = 0;
23        while(!stack.isEmpty()){
24            Node curr = stack.pop();
25            maxArea = Math.max(maxArea, curr.height * (curr.width + prevWidth));
26            prevWidth += curr.width;
27        }
28
29        return maxArea;
30    }
31
32    public class Node{
33        int height;
34        int width;
35
36        Node(int height, int width){
37            this.height = height;
38            this.width = width;
39        }
40    }
41}