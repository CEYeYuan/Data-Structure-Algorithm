/*
Implement a function to check if a linked list is a palindrome.

Pass by value or pass by reference??
Java is always pass by value. Even for an object, the copied pointer is
passed in (not the original pointer)

*/
import java.util.*;
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

	public Node(){
	}
	public void toStringPrint(){
		Node current=this;
		while(true){
			if(current!=null){
				System.out.print(current.item+" ");
				current=current.next;
			}
			else
				break;
		}
	}

	//if a linked list is palindrome, it should be exactly the same when 
	//walk it through forward and backword

	public static Boolean isPalindrome(Node input){
	
		Node reversed= reverse(input);
		input.toStringPrint();
		System.out.println("\n");
		reversed.toStringPrint();
		while (input!=null){
			if(input.item!=reversed.item)
				return false;
			input=input.next;
			reversed=reversed.next;
		}
		return true;
	}
	static Node head;

	public static Node reverse_inplace(Node input){
		if(input==null || input.next==null){
			head=input;
			return input;
		}
		else{
			reverse_inplace(input.next);
			/*When walk through the second last Node, reverse function gets returned
			We need to set the input.next's pointer to be input it self. And then change
			input's pointer to be null*/
			input.next.next=input;
			input.next=null;
			return head;
		}
	}
	static Node flag;
	public static Node reverse(Node input){
		if(input==null){
			return null;
		}
		else if(input.next==null){
			head=new Node(input.item);
			flag=head;
			return head;
		}
		else{
			reverse(input.next);
			flag.next=new Node(input.item);
			flag=flag.next;
			return head;
		}

	}
	public static void main(String [] args){
		Node a=new Node(3);
		Node b=new Node(4);
		Node c=new Node(5);
		Node d=new Node(3);
		a.next=b;
		b.next=c;
		c.next=d;
		//d.next=c;
		boolean tf=isPalindrome(a);
		if (tf)
			System.out.println("Is Palindrome!");
		else
			System.out.println("Not Palindrome");
	}



}