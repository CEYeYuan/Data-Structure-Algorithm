/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        ListNode low,high,curl,curh;
        low=high=curl=curh=null;
        boolean initlow,inithigh;
        initlow=inithigh=false;
        if(head==null)  return head;
        while(head!=null){
            if(head.val<x&&!initlow){
                low=new ListNode(head.val);
                curl=low;
                initlow=true;
            }
            else if(head.val<x&&initlow){
                curl.next=new ListNode(head.val);
                curl=curl.next;
            }
            else if(head.val>=x&&!inithigh){
                high=new ListNode(head.val);
                curh=high;
                inithigh=true;
            }
            else{
                curh.next=new ListNode(head.val);
                curh=curh.next;
            }
            
            head=head.next;
        }
        if(curl==null)  return high;
        curl.next=high;
        return low;
    }
}