// Last updated: 4/24/2026, 10:35:41 AM
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        visited.add(beginWord);

        int length = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i<size; i++){
                String current = q.poll();
                char[] arr = current.toCharArray();

                for(int j = 0; j<current.length(); j++){
                    char original = arr[j];

                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == original) continue;
                        
                        arr[j] = c;
                        String newWord = new String(arr);

                        if(newWord.equals(endWord)){
                            return length + 1;
                        }

                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    arr[j] = original;
                }
            }
            length++;
        }

        return 0;
    }
}