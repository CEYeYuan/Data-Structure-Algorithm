/*Given a circular linked list, implement an algorithm which returns the node at
the begining of the loop.
Definition
Circular linked list: A(corrupt) linked list in which a node's next pointer points
to an earlier node, so as to make a loop in the linked list
Example
Input:a->b->c->d->e->c[the same c as earlier]
Output:c
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
// we need to make sure the node has a loop, otherwise,null is returned
	public static Node beginingOfLoop(Node input){
		if(input==null || input.next==input)
			return input;
		else{
			Node flag=input;
			HashSet<Node> set= new HashSet<Node>();
			while(true){
				if (flag==null)
					return null;
				else if (set.contains(flag)){
					return flag;
				}
				else{
					set.add(flag);
					flag=flag.next;
				}
			}
		}
	}

	public static void main(String [] args){
		Node a=new Node(9);
		Node b=new Node(8);
		Node c=new Node(7);
		Node d=new Node(8);
		a.next=b;
		b.next=c;
		c.next=b;
		//d.next=c;
		Node begining=beginingOfLoop(a);
		if (begining==null)
			System.out.println("No loop is found");
		else
			System.out.println(begining.item);
	}




}