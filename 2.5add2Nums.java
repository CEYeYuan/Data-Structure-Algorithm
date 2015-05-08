/*
You have two numbers represented by a linked list, where each node contains
a single digit. The digits are stored in reversed order, such that 1's digit 
is at the head of the list. Write a function that adds the two numbers and returns
the sum as a linked list.

Example
Input: 7->1->6 + 5->9->2 .That is. 617+295
Output:2->1->9 That is, 912
Follow up
Suppose the digits are stored in forward order. Repeat the above problem.
Example:
Input 6->1->7+2->9->5. That is , 617+295.
Output:9->1->2, That is 912
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

	public Node(){

	}

	public static Node add_reverse(Node a,Node b){
		int buffer=0;
		Node answer=null;
		Node prev=null;
		while(a!=null || b!=null||buffer!=0){
			if (a!=null && b!=null){
				if (prev==null){
					prev=answer=new Node((a.item+b.item+buffer)%10);
				}
				else{
					prev.next=new Node((a.item+b.item+buffer)%10);
					prev=prev.next;
				}
				
				buffer=(a.item+b.item+buffer)/10;
				a=a.next;
				b=b.next;
			}
			else if (a==null&&b!=null){
				if (prev==null){
					prev=answer=new Node((b.item+buffer)%10);
				}
				else{
					prev.next=new Node((b.item+buffer)%10);
					prev=prev.next;
				}
				buffer=(b.item+buffer)/10;
				b=b.next;
			}
			else if (b==null&&a!=null){

				if (prev==null){
					prev=answer=new Node((a.item+buffer)%10);
				}
				else{
					prev.next=new Node((a.item+buffer)%10);
					prev=prev.next;
				}
				buffer=(a.item+buffer)/10;
				a=a.next;
			}
			else{
				prev.next=new Node(1);
				break;
			}		
		}
		return answer;
	}

	public static Node add(Node a, Node b){
		return reverse(add_reverse(reverse(a),reverse(b)));
	}

	public static Node reverse(Node input){
		Node flag=input, prev=input;
		Node nextone;
		
		if(input==null||input.next==null)
			return input;
		
		else{
			nextone=flag.next;
			flag.next=null;
			flag=nextone;
			while(flag!=null){
				nextone=flag.next;
				flag.next=prev;
				prev=flag;
				flag=nextone;
			}
			return prev;
		}

	}

	public static void main(String [] args){
		Node a1=new Node(9);
		Node b1=new Node(9);
		Node c1=new Node(6);
		Node d1=new Node(9);
		Node a2=new Node(5);
		Node b2=new Node(9);
		Node c2=new Node(4);
		a1.next=b1;
		b1.next=c1;
		c1.next=d1;
		a2.next=b2;
		b2.next=c2;
		//Node flag=a2;
		//Node flag=add_reverse(a1,a2);
		Node flag=add(a1,a2);
		while (true){
			if (flag!=null){
				System.out.print(flag.item+" ");
				flag=flag.next;
			}
			else
			break;			
		}
	}
}