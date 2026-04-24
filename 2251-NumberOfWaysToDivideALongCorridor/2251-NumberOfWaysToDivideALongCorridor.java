// Last updated: 4/24/2026, 10:31:10 AM
class Solution {
    public int numberOfWays(String corridor) {

        int totalSeats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }
        if (totalSeats < 2 || totalSeats % 2 != 0) return 0;
        if(totalSeats == 2) return 1;
        return countP(countS(corridor));
    }

    public int countP(List<Integer> placeS){

        long dist = 1;
        int MOD = 1_000_000_007; 
        for (int i = 1; i < placeS.size() - 1; i += 2) {
            dist = (dist * (placeS.get(i + 1) - placeS.get(i))) % MOD;
        }
        return (int) dist; 

    }

    public List<Integer> countS(String corridor){

        List<Integer> placeS = new ArrayList<>();

        for(int i = 0; i<corridor.length(); i++){
            char ch = corridor.charAt(i);
            if(ch == 'S'){
                placeS.add(i);
            }
        }
        return placeS;   
    }
}