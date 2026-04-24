// Last updated: 4/24/2026, 10:37:02 AM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newLL = new ListNode();
        ListNode head = newLL;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(int i = 0; i<lists.length; i++){
            if(lists[i]!=null){
                queue.add(lists[i]);
            }
        }

        while(!queue.isEmpty()){
            ListNode smallest = queue.poll();
            newLL.next = smallest;
            newLL = newLL.next;
            if(smallest.next != null){
                queue.add(smallest.next);
            }
            
        }

        return head.next;
    }
}