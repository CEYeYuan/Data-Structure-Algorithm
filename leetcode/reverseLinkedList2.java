/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead=new ListNode(0);
        fakeHead.next=head;
        ListNode pre,cur,ne,tmp;
        tmp=pre=cur=ne=fakeHead;
        for(int i=1;i<m;i++){
            pre=pre.next;
        }
        int j=n-m;
        cur=pre.next;
        ne=pre.next.next;
        while(j>0){
            tmp=ne.next;
            ne.next=cur;
            cur=ne;
            ne=tmp;
            j--;
        }
        pre.next.next=ne;
        pre.next=cur;
        return fakeHead.next;
        
        
    }
}