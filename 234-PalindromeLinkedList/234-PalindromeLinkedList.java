// Last updated: 4/24/2026, 10:34:51 AM
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
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        ListNode midNode = mid(head);
        ListNode rev = reverse(midNode);

        while(rev!=null){
            if(head.val == rev.val){
                head = head.next;
                rev = rev.next;
            }else{
                return false;
            }
        }

        return true;
    }

    public ListNode mid(ListNode head){
        ListNode s = head;
        ListNode f = head;
        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

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