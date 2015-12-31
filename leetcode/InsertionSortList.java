/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
       if(head==null)   return null;
       ListNode node=new ListNode(head.val);
       ListNode cur=null;
       head=head.next;
       while(head!=null){
           //insert node "head"
           if(head.val<node.val){
               ListNode tmp=new ListNode(head.val);
               tmp.next=node;
               node=tmp;
           }
           
           else{
                cur=node;
                while(cur.next!=null&&head.val>=cur.next.val){
                   cur=cur.next;
               }
               ListNode tmp=cur.next;
               cur.next=new ListNode(head.val);
               cur.next.next=tmp;
           }
            head=head.next;
       }
       return node;
    }
}