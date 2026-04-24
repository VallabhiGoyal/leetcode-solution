// Last updated: 4/24/2026, 10:30:25 AM
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        
        // Fixed order buckets
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        map.put("electronics",new ArrayList<>());
        map.put("grocery",new ArrayList<>());
        map.put("pharmacy",new ArrayList<>());
        map.put("restaurant",new ArrayList<>());

        for(int i = 0; i<code.length; i++){
            if(!isActive[i]) continue;

            String bl = businessLine[i].trim();
            String c = code[i];

            if(!map.containsKey(bl)) continue;
            if(c.isEmpty()) continue;
            if(!c.matches("[a-zA-Z0-9_]+")) continue;

            map.get(bl).add(c);
        }

        List<String> result = new ArrayList<>();
        for(String key : map.keySet()){
            Collections.sort(map.get(key));   // sort within bucket
            result.addAll(map.get(key));
        }

        return result;

    }

}