/*Implement a MyQueue class which implements a queue using two stacks*/
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

class MyQueue{
	Stack s1=new Stack();
	Stack s2=new Stack();
}