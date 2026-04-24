// Last updated: 4/24/2026, 10:31:11 AM
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
    public int pairSum(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = head;
        //find the middle node
        while(fast != null && fast.next != null){
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //break from the middle
        mid.next = null;

        //reverse the second half
        ListNode prev = null;
        ListNode nextNode = null;
        while(slow != null){
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        //sum of both the nodes
        int maxSum = 0;
        while(head != null && prev != null){
            int sum = head.val + prev.val;
            maxSum = Math.max(sum, maxSum);
            head = head.next;
            prev = prev.next;
        } 

        return maxSum;
    }
}