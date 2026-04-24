// Last updated: 4/24/2026, 10:36:12 AM
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }
        
        ListNode current = head;
        ListNode prev = null;

        for(int i = 1; current!=null && i<left; i++){
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;
        ListNode then = current.next;

        for(int i = 0;current!= null && i<=right-left; i++){
            current.next = prev;
            prev = current;
            current = then;
            if(then!=null){
                then = then.next;
            }
        }
        
        if(last!=null){
            last.next = prev;
        }else{
            head = prev;
        }

        newEnd.next = current;
        return head;
    }
}