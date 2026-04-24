// Last updated: 4/24/2026, 10:30:57 AM
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
    public ListNode removeNodes(ListNode head) {
        if(head==null || head.next==null) return head;

        head =reverse(head);
        
        int max = head.val;
        ListNode temp = head;

        while(temp!=null && temp.next!=null){
            if(max>temp.next.val){
                temp.next = temp.next.next;
            }else{
                max = temp.next.val;
                temp = temp.next;
            }
            
        }
        
        return reverse(head);
    } 

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode pres = head;
        ListNode fut = null;
        while(pres != null){
            fut = pres.next;
            pres.next = prev;
            prev = pres;
            pres = fut; 
        }
        head = prev;
        return head;
    }

}