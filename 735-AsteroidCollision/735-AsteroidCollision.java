// Last updated: 4/24/2026, 10:33:10 AM
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        int[] stack = new int[asteroids.length];
        int top = -1;

        for(int num : asteroids){
            boolean destroyed = false;

            while(top>=0 && stack[top] > 0 && num < 0){
                int curr = stack[top];

                if(Math.abs(curr) < Math.abs(num)){
                    top--;
                    continue;
                } 
                else if(Math.abs(curr) == Math.abs(num)){
                    top--;
                    destroyed = true;
                    break;
                } 
                else {
                    destroyed = true;
                    break;
                }
            }

            if(!destroyed) stack[++top] = num;
        }

        return Arrays.copyOf(stack, top + 1);
    }
}