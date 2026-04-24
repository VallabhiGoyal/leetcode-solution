// Last updated: 4/24/2026, 10:30:55 AM
class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        for(int i = 0; i<words.length-1; i++){
            Map<Character, Boolean> map = new HashMap<>();
            for(int j = 0; j<words[i].length(); j++){
                char ch = words[i].charAt(j);
                map.put(ch, false);
            }

            for(int j = i+1; j<words.length; j++){
                int flag = 0;
                for(int k = 0; k<words[j].length(); k++){
                    char ch = words[j].charAt(k);
                    if(!map.containsKey(ch)){
                        flag = 1;
                        break;
                    }
                    map.put(ch, true);
                }
                if(!map.containsValue(false) && flag == 0) count++;
                for (Character key : map.keySet()) {
                    map.put(key, false);
                }
            }
        }

        return count;
    }
}