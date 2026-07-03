// Last updated: 7/3/2026, 11:35:03 AM
class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> firstOccur = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(!firstOccur.containsKey(ch)){
                    firstOccur.put(ch, i);
                }
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a,b) -> {
            if(!a.getValue().equals(b.getValue())) return b.getValue() - a.getValue();

            return firstOccur.get(a.getKey()) - firstOccur.get(b.getKey());
            
        });

        StringBuilder vowel = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : list){
            char ch = entry.getKey();
            int freq = entry.getValue();
             while(freq > 0){
                 vowel.append(ch);
                 freq--;
             }
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(!isVowel(ch)) sb.append(ch);
            else{
                sb.append(vowel.charAt(idx++));
            }
        }  

        return sb.toString();
    }

    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;

        return false;
    }
}