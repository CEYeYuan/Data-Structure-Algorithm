/* Implement an algorithm to find the kth to last element of a singly linked list*/
import java.util.*;
class Index{
	public static int value=0;
}
class Node{
	int item;
	Node next;
	public Node(int i){
		item=i;
		next=null;
	}
	public Node(int i,Node n){
		item=i;
		next=n;
	}

	public Node kthLast(int k){
		int size=1;
		Node flag=this;
		while (flag.next!=null){
			size++;
			flag=flag.next;
		}
		int index=size+1-k;
		flag=this;
		for (int i=1;i<index;i++){
			flag=flag.next;
		}
		return flag;
	}


	public static int kthLastRecursive(int k,Node input){
		if (input.next==null){
			System.out.println(input.item);
			return 0;
		}
		else{
			int i=kthLastRecursive(k,input.next)+1;
			if(i<=k-1)
				System.out.println(input.item);
			return i;
		}
	}

	public static Node kthLastRecursiveNode(int k,Node input,Index num){
		if (input==null){
			return null;
		}
	
		Node list=kthLastRecursiveNode(k,input.next,num);
		num.value++;
		if(num.value==k)
			return input;
		return list;//return null before we find kth. after that always return the
		//kth last; num is always the same reference, num never change, what changed
		//is it's value. So the stack frame goes from the first element to last elment
		// then return back until to the first elment again
	}

	public static void main(String[] args){
		Node head=new Node(1,new Node(2,new Node(4,new Node(5,new Node(6)))));
		Node flag=head;
		while (true){
			System.out.print(flag.item+" ");
			if (flag.next==null)
				break;
			flag=flag.next;
		}
		Index num=new Index();
		System.out.println("\n");
		//kthLastRecursive(3,head);
		flag=kthLastRecursiveNode(2,head,num);
		while (true){
			System.out.print(flag.item+" ");
			if (flag.next==null)
				break;
			flag=flag.next;
		}

	} 
}