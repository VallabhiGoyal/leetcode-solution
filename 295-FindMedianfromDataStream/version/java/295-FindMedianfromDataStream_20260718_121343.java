// Last updated: 7/18/2026, 12:13:43 PM
1class MedianFinder {
2
3    PriorityQueue<Integer> left;
4    PriorityQueue<Integer> right;
5
6    public MedianFinder() {
7        left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
8        right = new PriorityQueue<>();
9    }
10
11    public void addNum(int num) {
12        if (left.isEmpty() || num <= left.peek()) {
13            left.offer(num);
14        } else {
15            right.offer(num);
16        }
17
18        if (left.size() > right.size() + 1) {
19            right.offer(left.poll());
20        } else if (right.size() > left.size()) {
21            left.offer(right.poll());
22        }
23    }
24
25    public double findMedian() {
26        if (left.size() == right.size()) {
27            return (left.peek() + right.peek()) / 2.0;
28        }
29
30        return left.peek();
31    }
32}
33
34/**
35 * Your MedianFinder object will be instantiated and called as such:
36 * MedianFinder obj = new MedianFinder();
37 * obj.addNum(num);
38 * double param_2 = obj.findMedian();
39 */