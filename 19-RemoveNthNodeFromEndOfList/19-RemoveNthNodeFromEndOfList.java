// Last updated: 4/24/2026, 10:37:07 AM
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){
            return null;
        }
        if(n==0){
            return head;
        }

        //count total nodes
        int count = 0;
        ListNode tail = head;
        while(tail!=null){
            tail=tail.next;
            count++;
        }

        //delete first
        if(count == n){
            head = head.next;
            return head;
        }

        //delete between        
        int index = count - n ;
        ListNode prev = head;
        for(int i = 1; i<index; i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return head;
    }
    
}