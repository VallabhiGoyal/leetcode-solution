// Last updated: 4/24/2026, 10:35:30 AM
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode midNode = mid(head);

        ListNode second = reverse(midNode.next);
        midNode.next = null;

        ListNode first = head;
        while(first!=null && second!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        return;

    }

    public ListNode mid(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode s = head;
        ListNode f = head;

        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode pres = head;

        while(pres != null){
            ListNode fut = pres.next;
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