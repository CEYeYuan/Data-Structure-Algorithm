/*In the classic problem of the Towers of Hanoi, you have 3 towers and N disks 
of different sizes which can slide onto any tower. The puzzle starts 
with disks sorted in asscending order of size from top to bottom. (i.e
each disk sits on top of an even larger one). You have the following
constraints:
1. Only one disk can be moved at a time
2. A disk is slid off the top of one tower onto the next tower
3. A disk can only be placed on top of a larger disk
Write a program to move the disks from the first tower to the last usign stacks*/
class Node {
	int item;
	Node next;
	Node (int input){
		item=input;
	}
	Node(){

	}
}

class Stack extends Node{
	Node top;

	public boolean ordered(){
		if (top==null || top.next==null) {
			return true;	
		}
		else{
			Node current=top;
			while (current.next!=null){
				if (current.next.item<current.item)
					return false;
				else
					current=current.next;
			}
			return true;
		}
	}

	public void toStringPrint(){
		 Node current=top;
		while(true){
			if(current!=null){
				System.out.print(current.item+" ");
				current=current.next;
			}
			else
				break;
		}
	}

	public void push(int input){
		if (top==null){
			top=new Node(input);
		}
		else{
			Node newTop=new Node(input);
			newTop.next=top;
			top=newTop;
		}	
	}

	public Node pop(){
		if(top==null)
			return null;
		else{
			Node result = top;
			top=top.next;
			return result;
		}
	}

	public int peek(){
		if (top==null)
			return -1;
		else
			return top.item;
	}
}
class Towers{
	static final int N=5;
	Stack first=new Stack();
	Stack second=new Stack();
	Stack third=new Stack();
	void init(){
		int i=N;
		while(i>=0){
			first.push(i);
			i--;
		}
	}

	static void move(int num,Stack source,Stack tmp,Stack dest){
		if (num==1){
			tmp.push(source.pop().item);
			if (!checkOrder(source,tmp,dest))
				System.out.println("You can not move like this");
			dest.push(tmp.pop().item);
			if (!checkOrder(source,tmp,dest))
				System.out.println("You can not move like this");
		}
		else{
			move(num-1,source,tmp,dest);
			if (!checkOrder(source,tmp,dest))
				System.out.println("You can not move like this");
			tmp.push(source.pop().item);
			if (!checkOrder(source,tmp,dest))
				System.out.println("You can not move like this");
			move(num-1,dest,tmp,source);
			if (!checkOrder(source,tmp,dest))
				System.out.println("You can not move like this");
			dest.push(tmp.pop().item);
			if (!checkOrder(source,tmp,dest))
				System.out.println("You can not move like this");
			move(num-1,source,tmp,dest);
			if (!checkOrder(source,tmp,dest))
				System.out.println("You can not move like this");
		}
	}

	static boolean checkOrder(Stack first, Stack second, Stack third){
		return first.ordered() && second.ordered() && third.ordered();
	}
}

class test{


	public static void main(String [] args){
		Towers towers=new Towers();
		towers.init();
		towers.first.toStringPrint();
		System.out.println();
		towers.second.toStringPrint();
		System.out.println();
		towers.third.toStringPrint();
		System.out.println();

		Towers.move(6,towers.first,towers.second,towers.third);
		towers.first.toStringPrint();
		System.out.println();
		towers.second.toStringPrint();
		System.out.println();
		towers.third.toStringPrint();
		System.out.println();
		
	}	
}