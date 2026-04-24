// Last updated: 4/24/2026, 10:29:18 AM
class Solution {
    public String trafficSignal(int timer) {
        if(timer == 0) return "Green";
        else if(timer == 30) return "Orange";
        else if(timer>30 && timer<=90) return "Red";
        return "Invalid";
    }
}