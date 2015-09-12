/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        else if(l1==null&&l2!=null)
            return l2;
        else if(l1!=null&&l2==null)
            return l1;
        else{
            ListNode ls,head;
            if(l1.val<l2.val)      { 
                head=ls=new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                head=ls=new ListNode(l2.val);
                l2=l2.next;
            } 
            while(l1!=null && l2!=null){
                 if(l1.val<l2.val)      { 
                    ls.next=new ListNode(l1.val);
                    l1=l1.next;
                    ls=ls.next;
                  }
                else{
                    ls.next=new ListNode(l2.val);
                    l2=l2.next;
                    ls=ls.next;
                } 
            }
            while(l1!=null){
                ls.next=new ListNode(l1.val);
                l1=l1.next;
                ls=ls.next;
            }
            while(l2!=null){
                ls.next=new ListNode(l2.val);
                l2=l2.next;
                ls=ls.next;
            }
            return head;
        }
        
    }
}