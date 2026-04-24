// Last updated: 4/24/2026, 10:29:22 AM
class Solution {
    public List<Integer> findGoodIntegers(int n) {
        int a = (int)Math.cbrt(n);
        int b = (int)Math.cbrt(a);

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 1; i<=a; i++){
            for(int j = i; j<=a; j++){
                int temp = (int)Math.pow(i, 3) + (int)Math.pow(j, 3);
                if(temp > n) break;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) >= 2) list.add(key);
        }
        Collections.sort(list);
        return list;
    }
}