// Last updated: 4/24/2026, 10:35:06 AM
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
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        
        while(pres != null){
            ListNode fut = pres.next;
            pres.next = prev;
            prev = pres;
            pres = fut;
            if(fut!=null){
                fut = fut.next;
            }
            
        }
        head = prev;
        
        return head;
    }
}