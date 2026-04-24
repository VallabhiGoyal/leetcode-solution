// Last updated: 4/24/2026, 10:33:42 AM
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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) return head;
    
        ListNode kThNode = head;
        ListNode kBack = head;
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 1; i<k; i++){
            kThNode = kThNode.next;
        }
        fast = kThNode;
        
        while(fast.next!=null){
            fast = fast.next;
            kBack=kBack.next;
        }

        int temp = kThNode.val;
        kThNode.val = kBack.val;
        kBack.val = temp;

        return head;
    }

}