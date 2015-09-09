/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null;
        ListNode head=null;
        int buffer=0;
        boolean tf=true;
        while(l1!=null&&l2!=null){
            if(tf){
                 result=new ListNode((l1.val+l2.val)%10);
                 head=result;
                 tf=false;
                 buffer=(l1.val+l2.val)/10;
                 
                 l1=l1.next;
                 l2=l2.next;
            }else{
                 result.next=new  ListNode((l1.val+l2.val+buffer)%10);
                 buffer=(l1.val+l2.val+buffer)/10;
                 l1=l1.next;
                 l2=l2.next;
                 result=result.next;
            }
        }
        if(l1==null&&l2==null){
            if(buffer==1)
                result.next=new ListNode(1);
                
        }
        else{
            if(tf){//the very first node
                if(l1!=null)
                    return l1;
                else
                    return l2;
                
            }else{
                while(l1!=null){
                     result.next=new  ListNode((l1.val+buffer)%10);
                     buffer=(l1.val+buffer)/10;
                     l1=l1.next;
                     result=result.next;
                
                }
                 while(l2!=null){
                     result.next=new  ListNode((l2.val+buffer)%10);
                     buffer=(l2.val+buffer)/10;
                     l2=l2.next;
                     result=result.next;
                     
                }
                if(buffer==1)
                     result.next=new ListNode(1);
            }
        }
        return head;
        
    }
}