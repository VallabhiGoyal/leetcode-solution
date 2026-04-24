// Last updated: 4/24/2026, 10:35:31 AM
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next==null) return null;

        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                
                ListNode ptr = head;
                while(ptr!=slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }   
        }
        return null;
    }
}