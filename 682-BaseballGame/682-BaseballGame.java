// Last updated: 4/24/2026, 10:33:15 AM
class Solution {
    public int calPoints(String[] operations) {
        if(operations.length == 0) return 0;
        Stack<Integer> q = new Stack<>();
        for(String op : operations){
            if(isInteger(op)){
                q.push(Integer.parseInt(op));
            }else if(!q.isEmpty() && op.equals("C")){
                q.pop();
            }else if(!q.isEmpty() && op.equals("D")){
                q.push(q.peek()*2);
            }else if(!q.isEmpty() && op.equals("+")){
                if(q.size()>=2){
                    int top = q.pop();
                    int next = q.peek();
                    q.push(top);
                    q.push(top+next);
                }else if(q.size() == 1){
                    q.push(q.peek());
                }
            }
        }

        int total =0;
        for(int i : q) total+=i;
        return total;
    }

    private boolean isInteger(String s) {
        if (s == null || s.isEmpty()) return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}