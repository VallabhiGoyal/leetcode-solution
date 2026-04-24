// Last updated: 4/24/2026, 10:36:16 AM
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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode pres = head;
        ListNode temp = dummy;
        while(pres!=null){
            
            if(pres.val<x){
                if(temp==prev){
                    temp = pres;
                    prev = pres;
                    pres = pres.next;
                }else{
                    prev.next = pres.next;
                    pres.next = temp.next;
                    temp.next = pres;

                    temp = pres;
                    pres = pres.next;
                }    
            }else{
                prev = pres;
                pres = pres.next;
            }    
        }

        return dummy.next;
    }
}