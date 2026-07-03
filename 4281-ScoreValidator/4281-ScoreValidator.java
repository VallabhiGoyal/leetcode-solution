// Last updated: 7/3/2026, 11:35:04 AM
class Solution {
    public int[] scoreValidator(String[] events) {
        int n = events.length;

        int score = 0;
        int counter = 0;

        for(int i = 0; i<n; i++){
            String s = events[i];
            if(Character.isDigit(events[i].charAt(0))){
                score += events[i].charAt(0) - '0';
            }else if(events[i].equals("W")) counter++;
            else score++;

            if(counter >= 10) break;
        }

        return new int[]{score, counter};
    }
}