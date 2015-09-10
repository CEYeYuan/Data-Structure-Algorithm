/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp=head;
        int total=0;
        while(tmp!=null){
            total+=1;
            tmp=tmp.next;
        }
        tmp=head;
        if(total==n)
            return head.next;//Sometimes, we need to change the head !!
        for(int i=1;i<total-n;i++){
            tmp=tmp.next;
        }
        tmp.next=tmp.next.next;
        return head;
    }
}
/*
one pass solution:

use two pointers. Move one of them n steps foward, then move the  two pointers 
simultiniously. When the fast pointer reaches the end, the next node of the slower
pointer is the node to be deleted.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow,fast;
        slow=fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null)//in other words n==number of nodes
            return slow.next;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}

*/