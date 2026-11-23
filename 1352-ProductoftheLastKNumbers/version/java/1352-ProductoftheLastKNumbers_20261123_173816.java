// Last updated: 11/23/2026, 5:38:16 PM
1class ProductOfNumbers {
2    List<Integer> stack;
3
4    public ProductOfNumbers() {
5        stack = new ArrayList<>();
6    }
7    
8    public void add(int num) {
9        stack.add(num);
10    }
11    
12    public int getProduct(int k) {
13        int n = stack.size();
14        int ans = 1;
15        for(int i = n-1; i >=0 && i >= n-k; i--){
16            ans *= stack.get(i);
17        }
18
19        return ans;
20    }
21}
22
23/**
24 * Your ProductOfNumbers object will be instantiated and called as such:
25 * ProductOfNumbers obj = new ProductOfNumbers();
26 * obj.add(num);
27 * int param_2 = obj.getProduct(k);
28 */