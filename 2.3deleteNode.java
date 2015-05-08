/*
Implement an algorithm to delete a node in the middle of a singly linked list,
given only access to that node.
Example
Input:the node from the linked list a->b->c->d->e
Result:nothing is returned, but the new linked list looks like a->b->d->e
*/

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

	public void removeNode(){
		// check if this is an legal condition
		if(this!=null &&this.next!=null){
			item=next.item;
			next=next.next;
		}	
	}


	public static void main(String [] args){
		Node a=new Node(1);
		Node b=new Node(2);
		Node c=new Node(3);
		Node d=new Node(4);
		Node e=new Node(5);
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		Node flag=a;
		while (true){
			System.out.print(flag.item+" ");
			if (flag.next==null)
				break;
			flag=flag.next;
		}
		System.out.println("\n");
		c.removeNode();
		flag=a;
		while (true){
			System.out.print(flag.item+" ");
			if (flag.next==null)
				break;
			flag=flag.next;
		}
	}
}