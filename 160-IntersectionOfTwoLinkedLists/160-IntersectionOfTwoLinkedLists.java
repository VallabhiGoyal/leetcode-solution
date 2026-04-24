// Last updated: 4/24/2026, 10:35:24 AM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB == null){
            return null;
        }

        ListNode listA = headA;
        ListNode listB = headB;
        
        while(listA!=listB){
            listA = (listA == null) ? headB:listA.next;
            listB = (listB == null) ? headA:listB.next;
        }
        return listA;
    }
}