// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.Scanner;
import java.util.*;
class ListNode{
    int item;
    ListNode next;
    ListNode(int i){
        item=i;
    }
}
class test{
    static int carry=0;
    public static void main(String[] args){
         //Scanner sc=new Scanner(System.in);
         //String s=sc.nextLine();
       ListNode l1=new ListNode(3);
       l1.next=new ListNode(9);
       ListNode l2=new ListNode(9);
       l2.next=new ListNode(8);
       l2.next.next=new ListNode(7);
       int i1,i2;
       i1=len(l1);
       i2=len(l2);
       if(i1!=i2){
           int diff=Math.abs(i1-i2)-1;
           ListNode head,cur;
           head=new ListNode(0);
           cur=head;
           while(diff>0){
               cur.next=new ListNode(0);
               cur=cur.next;
               diff--;            
           }
           cur.next=i1>i2?l2:l1;
           if(i1>i2)
                l2=head;
           else
                l1=head;
       }
       ListNode l3=add(l1,l2);
       if(carry==1){
           ListNode head=new ListNode(1);
           carry=0;
           head.next=l3;
           l3=head;
       }
       printlist(l1);
       printlist(l2);
       printlist(l3);
        
    } 
    private static int len(ListNode l){
        int i=0;
        while(l!=null){
            i++;
            l=l.next;
        }
        return i;
    }
    private static void printlist(ListNode l){
        StringBuffer buffer=new StringBuffer();
        while(l!=null){
            buffer.append(l.item);
            l=l.next;
        }
        String s=buffer.toString();
        System.out.println(s);
    }
    private static ListNode add(ListNode l1,ListNode l2){
        if(l1==null&&l2==null)      return null;
        ListNode ret=add(l1.next,l2.next);
        ListNode head=new ListNode((l1.item+l2.item+carry)%10);
        head.next=ret;
       if(l1.item+l2.item+carry>=10)
            carry=1;
       else
            carry=0;
       return head;
          
    }

}

