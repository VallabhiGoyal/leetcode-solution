// Last updated: 4/24/2026, 10:30:06 AM
class RideSharingSystem {

    LinkedHashSet<Integer> riders = new LinkedHashSet<>();
    LinkedHashSet<Integer> drivers = new LinkedHashSet<>();
    
    public RideSharingSystem() {
        
    }
    
    public void addRider(int riderId) {
        riders.add(riderId);
    }
    
    public void addDriver(int driverId) {
        drivers.add(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if(riders.isEmpty() || drivers.isEmpty()){
            return new int[]{-1,-1};
        }
        int rider = riders.iterator().next();
        riders.remove(rider);
        
        int driver = drivers.iterator().next();
        drivers.remove(driver);
        
        return new int[]{driver, rider};
    }
    
    public void cancelRider(int riderId) {
        riders.remove(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */