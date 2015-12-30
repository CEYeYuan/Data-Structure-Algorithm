/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)  return null;
        ListNode fast=head;
        ListNode slow=head;
        while(true){
            fast=fast.next;
            if(fast!=null)  
                fast=fast.next;
            slow=slow.next;
            if(fast==null)  return null;
            if(fast==slow)  break;
        }
        
        while(head!=slow){
            //there is a cycle
          head=head.next;
          slow=slow.next;
        }
        return head;
    }
}