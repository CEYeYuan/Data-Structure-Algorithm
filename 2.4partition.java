/*Write code to partition a linked list around a value x, such that all nodes 
less than x come before all nodes greater than or equal to x.*/
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

	public Node partition(int num){
		if (this==null||next==null){
			return this;
		}
		else{
			Node current=this;
			Node bar=new Node(item);
			Node head=bar;
			while(current.next!=null){
				if (current.next.item<num){
					head=new Node(current.next.item,head);
				}
				else{
					bar.next=new Node(current.next.item);
					bar=bar.next;
				}
				current=current.next;
			}
			return head;
		}
		
	}


	public static void main(String [] args){
		Node head=new Node(6,new Node(2,new Node(4,new Node(5,new Node(1)))));
		Node flag=head;
		while (true){
			System.out.print(flag.item+" ");
			if (flag.next==null)
				break;
			flag=flag.next;
		}
		System.out.println("\n");
		flag=head.partition(3);
		while (true){
			System.out.print(flag.item+" ");
			if (flag.next==null)
				break;
			flag=flag.next;
		}
	}
}