// Last updated: 4/24/2026, 10:37:00 AM
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(countNode(head)<k || head == null || k==1){
            return head;
        }
        
        ListNode prev = null;
        ListNode pres = head;
        ListNode fut = null;

        int c = 0;
        while(pres != null && c<k){
            fut = pres.next;
            pres.next = prev;
            prev = pres;
            pres = fut;
            c++;
        }
        if(fut!=null){
            head.next = reverseKGroup(fut,k);
        }
        return prev;
    }

    public int countNode(ListNode head){
        int i = 1;
        while(head.next!=null){
            head = head.next;
            i++;
        }

        return i;
    }
}