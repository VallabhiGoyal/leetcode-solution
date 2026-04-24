// Last updated: 4/24/2026, 10:36:36 AM
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }

        ListNode curr = head;
        int len = 1;
        while(curr.next!=null){
            curr = curr.next;
            len++;
        }
        ListNode tail = curr;
        tail.next = head;
        
        k = k%len;
        int steps = len-k;
        ListNode newTail = head;
        for(int i =1; i<steps; i++){
            newTail = newTail.next;
        }
        
        ListNode newhead = newTail.next;
        newTail.next = null;

        return newhead;   
    }
}