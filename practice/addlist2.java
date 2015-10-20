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
       printlist(l1);
       printlist(l2);
      
       ListNode l3=add(l1,l2);
       
      
       printlist(l3);
        
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
        l1=reverse(l1);
        l2=reverse(l2);
        int sum=0;
        if(l1!=null)
            sum+=l1.item;
        if(l2!=null)
            sum+=l2.item;
        int carry=(sum)/10;
        ListNode l3,tmp;
        tmp=l3=new ListNode(sum%10);
        if(l1!=null)    l1=l1.next;
        if(l2!=null)    l2=l2.next;
        while(l1!=null||l2!=null||carry!=0){
            int cur=0;
            if(l1!=null)
                cur+=l1.item;
            if(l2!=null)
                cur+=l2.item;
            cur+=carry;
            carry=cur/10;
            tmp.next=new ListNode(cur%10);
            tmp=tmp.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        return reverse(l3);
          
    }
    
    private static ListNode reverse(ListNode node){
        if(node==null||node.next==null)  return node;
        ListNode cur=node.next;
        ListNode ret=reverse(node.next);
        cur.next=node;
        node.next=null;
        return ret;
    }

}

