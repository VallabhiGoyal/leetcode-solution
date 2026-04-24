// Last updated: 4/24/2026, 10:37:06 AM
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch =='{' || ch=='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(ch ==')' && top != '(') return false;
                else if(ch =='}' &&  top != '{') return false;
                else if(ch ==']' &&  top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}