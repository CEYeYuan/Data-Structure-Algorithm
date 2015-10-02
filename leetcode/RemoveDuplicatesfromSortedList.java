/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solutiona {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead=new ListNode(-1);
        fakeHead.next=head;
        ListNode cur=fakeHead;
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int tmp=cur.next.val;
                ListNode diff=cur.next;
                while(diff!=null&&diff.val==tmp){
                    diff=diff.next;
                }
                cur.next=diff;
            }
            else{
                cur=cur.next;
            }
        }
        return fakeHead.next;
    }
}