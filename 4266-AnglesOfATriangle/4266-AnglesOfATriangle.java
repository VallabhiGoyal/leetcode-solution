// Last updated: 4/24/2026, 10:29:24 AM
class Solution {
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);

        if(sides[0] + sides[1] <= sides[2]) return new double[]{};
        
        double[] ans = new double[3];
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        
        ans[0] =  getAngle(a, b, c);
        ans[1] =  getAngle(b, a, c);
        ans[2] =  getAngle(c, a, b);

        return ans;
    }

    public double getAngle(int a, int b, int c){
        return Math.toDegrees(Math.acos((double)(b*b + c*c - a*a)/(2*b*c)));
    }
}