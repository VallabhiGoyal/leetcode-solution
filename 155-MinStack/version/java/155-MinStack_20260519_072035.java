// Last updated: 5/19/2026, 7:20:35 AM
1class MinStack {
2    Stack<Integer> stack;
3    Stack<Integer> temp;
4    public MinStack() {
5        stack = new Stack<>();
6        temp = new Stack<>();
7    }
8    
9    public void push(int val) {
10        stack.push(val);
11        
12        if(temp.isEmpty()){
13            temp.push(val);
14        }else{
15            int min = Math.min(temp.peek(), val);
16            temp.push(min);
17        }
18    }
19    
20    public void pop() {
21        if(!stack.isEmpty()){
22            temp.pop();
23            stack.pop();
24        }
25    }
26    
27    public int top() {
28        if(!stack.isEmpty()) return stack.peek();
29        else return -1;
30    }
31    
32    public int getMin() {
33        if(!temp.isEmpty()) return temp.peek();
34        return -1;
35    }
36}
37
38/**
39 * Your MinStack object will be instantiated and called as such:
40 * MinStack obj = new MinStack();
41 * obj.push(val);
42 * obj.pop();
43 * int param_3 = obj.top();
44 * int param_4 = obj.getMin();
45 */