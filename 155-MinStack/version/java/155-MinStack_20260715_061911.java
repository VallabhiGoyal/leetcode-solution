// Last updated: 7/15/2026, 6:19:11 AM
1class MinStack {
2    Stack<Integer> stack;
3    Stack<Integer> temp;
4    
5    public MinStack() {
6        stack = new Stack<>();
7        temp = new Stack<>();
8    }
9    
10    public void push(int val) {
11        stack.push(val);
12        
13        if(temp.isEmpty()){
14            temp.push(val);
15        }else{
16            int min = Math.min(temp.peek(), val);
17            temp.push(min);
18        }
19    }
20    
21    public void pop() {
22        temp.pop();
23        stack.pop();
24    }
25    
26    public int top() {
27        return stack.peek();
28    }
29    
30    public int getMin() {
31        return temp.peek();
32    }
33}
34
35/**
36 * Your MinStack object will be instantiated and called as such:
37 * MinStack obj = new MinStack();
38 * obj.push(val);
39 * obj.pop();
40 * int param_3 = obj.top();
41 * int param_4 = obj.getMin();
42 */