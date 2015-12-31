/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

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
    public void reorderList(ListNode head) {
        /*
        1.reverse the second half of the list
        2.combine
        */
        if(head==null)  return ;
        ListNode fast=head;
        ListNode slow=head;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode oneStepslow=dummyHead;
        while(fast!=null){
           fast=fast.next;
           if(fast!=null)
                fast=fast.next;
           slow=slow.next;
           oneStepslow=oneStepslow.next;
        }
        
        /*
        0 return null   0-1 return 1    0-1-2   return 2
        0-1-2-3 return 2    0-1-2-3-4   return 3
        0->1->2<-3<-4
        */
        oneStepslow.next=null;
        ListNode second=reverse(slow);
        ListNode tmp1,tmp2;
        tmp1=tmp2=null;
        while(second!=null){
            tmp1=head.next;
            tmp2=second.next;
            head.next=second;
            second.next=tmp1;
            head=tmp1;
            second=tmp2;
        }

        
    }
    
    private ListNode reverse(ListNode node){
        //return the head of the reversed list
        /*if(node==null||node.next==null)
            return node;
        ListNode tmp=reverse(node.next);
        node.next.next=node;
        node.next=null;
        return tmp;*/
       if(node==null||node.next==null)
            return node;
        ListNode prev=null;
        while(node!=null){
            ListNode next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
    
    
}