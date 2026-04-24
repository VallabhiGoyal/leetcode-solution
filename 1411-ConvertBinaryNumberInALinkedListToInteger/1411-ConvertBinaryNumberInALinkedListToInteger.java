// Last updated: 4/24/2026, 10:32:02 AM
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
    public int getDecimalValue(ListNode head) {
        head = reverse(head);
        int decimal = 0;
        int count  = 0;
        while(head!=null){
            decimal+= head.val * Math.pow(2,count);
            count++;
            head = head.next;
        }

        return decimal;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode pres = head;
        ListNode fut = null;

        while(pres!=null){
            fut = pres.next;
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