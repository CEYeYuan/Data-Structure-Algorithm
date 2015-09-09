/*Write code to remove duplicates from an unsorted linked list. Follow up, how 
would you solve this problem if a temporary buffer is not allowed 

###
HashSet:
	HashSet<type> set=new HashSet<type>();
	set.add(item);
	set.contains(item);
	similiar to hashmap, but only store a key, not a key-value pair.
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

	/*
	cuz we do not have a pointer to the previous node, which means we can not go 
	back, we must make sure next node is not a duplicates of previous node before 
	we change the current pointer. if it's a duplicates, we just change current.next
	to current.next.next, but we don not change current, until we find some node has 
	the different value, we can set current.next to that node and change the current 
	pointer to that node.
	*/
	public void removeDuplicates(){
		//HashMap<Integer,Integer> hash= new HashMap<Integer,Integer>();
		HashSet<Integer> set=new HashSet<Integer>();
		Node flag=this;
		while(flag.next!=null){
			//if (!hash.containsKey(flag.next.item)){
			if (!set.contains(flag.next.item)){
				//hash.put(flag.next.item,flag.next.item);
				set.add(flag.next.item);
				flag=flag.next;	
			}
			else{
				if(flag.next.next!=null)
					flag.next=flag.next.next;
				else
					flag.next=null;
			}
			
		}
	}

	//If no additional space is allowed, we can use nested loop to implement 
	//this operation
	public void removeDuplicatesInplace(){
		Node pointer1=this;
		// some times all the node after pointer1 are deleted, so after execute
		//pointer1=pointer1.next, pointer1 can be set to null
		while (pointer1!=null && pointer1.next!=null){
			Node pointer2=pointer1;
			while (pointer2.next!=null){
				if(pointer1.item!=pointer2.next.item){
					pointer2=pointer2.next;
				}
				else{
					if (pointer2.next.next!=null)
						pointer2.next=pointer2.next.next;
					else
						pointer2.next=null;
				}
			}
			pointer1=pointer1.next;
		}

	}

	public static void main(String[] args){
		Node head=new Node(1,new Node(2,new Node(3,new Node(3,new Node(3)))));
		Node flag=head;
		while (true){
			System.out.print(flag.item+" ");
			if (flag.next==null)
				break;
			flag=flag.next;
		}
		System.out.println("\n");

		//head.removeDuplicates();
		head.removeDuplicatesInplace();
		flag=head;
		while (true){
			System.out.print(flag.item+" ");
			if (flag.next==null)
				break;
			flag=flag.next;
		}

	} 


}


	
