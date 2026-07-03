// Last updated: 7/3/2026, 12:17:56 PM
1class Solution {
2    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
3        Arrays.sort(products);
4
5        int n = searchWord.length();
6        int m = products.length;
7
8        List<List<String>> list = new ArrayList<>();
9
10        for(int i = 0; i<n; i++){
11            String str = searchWord.substring(0, i+1);
12            List<String> subList = new ArrayList<>();
13            for(int j = 0; j<m; j++){
14                if(products[j].startsWith(str) && subList.size() < 3){
15                    subList.add(products[j]);
16                }
17            }
18
19            list.add(subList);
20        }
21
22        return list;
23    }
24}