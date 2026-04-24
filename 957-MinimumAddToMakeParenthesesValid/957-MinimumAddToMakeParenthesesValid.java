// Last updated: 4/24/2026, 10:32:40 AM
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();


        for(char ch : s.toCharArray()){
           if(ch==')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
           }else{
            stack.push(ch);
           } 
        }

        return stack.size();
    }
}