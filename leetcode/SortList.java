/*
Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)  return head;
        ListNode slow,fast;
        fast=head.next.next;
        slow=head;
        while(fast!=null){
            fast=fast.next;
            if(fast==null)
                break;
            fast=fast.next;
            slow=slow.next;
        }
       ListNode list1=slow.next;
       slow.next=null;
       ListNode list2=head;
       list1=sortList(list1);
       list2=sortList(list2);
       return merge(list1,list2);
    }
    
    private ListNode merge(ListNode head1,ListNode head2){
        //linear time merge 
        ListNode dummyHead=new ListNode(-1);
        ListNode head=dummyHead;
        while(head1!=null&&head2!=null){
            if(head1.val<=head2.val){
                head.next=new ListNode(head1.val);
                head=head.next;
                head1=head1.next;
            }else{
                head.next=new ListNode(head2.val);
                head=head.next;
                head2=head2.next;
            }   
        }
        while(head1!=null){
             head.next=new ListNode(head1.val);
             head=head.next;
             head1=head1.next;
        }
         while(head2!=null){
             head.next=new ListNode(head2.val);
             head=head.next;
             head2=head2.next;
        }
        return dummyHead.next;
    }   
    
}