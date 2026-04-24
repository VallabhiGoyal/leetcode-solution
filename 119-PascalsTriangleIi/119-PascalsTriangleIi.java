// Last updated: 4/24/2026, 10:35:47 AM
class Solution {
    public List<Integer> getRow(int rowIndex) {
        long ans=1;
        List<Integer> ansrow=new ArrayList<>();
        ansrow.add(1);
        if(rowIndex == 0) return ansrow;
        for(int col=1;col<=rowIndex;col++){
            ans*=(rowIndex+1)-col;
            ans/=col;
            ansrow.add((int)ans);
        }
        return ansrow;
    }
}