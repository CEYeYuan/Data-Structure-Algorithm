/*
1. for the iterative solution, remember to set head.next==null, otherwise, you're
creating a infinite loop
2.recursion
*/
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)  return head;
        ListNode p,q,tmp;
        p=head;
        q=head.next;
        tmp=null;
        p.next=null;
        while(q!=null){
            tmp=q.next;
            q.next=p;
            p=q;
            q=tmp;
        }
        return p;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res=null;
        if(head==null||head.next==null)  {
            return head;
        }
        res=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return res;
    }
}