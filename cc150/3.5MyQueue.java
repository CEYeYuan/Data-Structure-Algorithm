/*Implement a MyQueue class which implements a queue using two stacks
When an element gets enqueued, the only operation can happen to it is dequeue;
So when we can use an addtional stack to keep track of these already enqueued 
elements. In other words, ther're now on the "dequeue-waitting list".  When we 
want to dequeue these element, we first check our "dequeue-waitting list". If that
list is empty, we can pop off the current stack to the "dequeue-waitting list". since
the order gets reversed twice, we can now dequeue element using the normal order */
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

	public boolean isEmpty(){
		return top==null ;
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

	public int pop(){
		if(top==null)
			return -1;
		else{
			int result = top.item;
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
	Stack latest=new Stack();
	Stack old=new Stack();
	void enqueue(int input){
		latest.push(input);
	}

	int dequeue(){
		if (latest.top == null && old.top== null)
			return -1;
		else{
			if (old.top != null){
				int result=old.top.item;
				old.pop();
				return result;
			}

			else{
				while (!latest.isEmpty()){
					old.push(latest.pop());
				}
				int result=old.top.item;
				old.pop();
				return result;
			}
		}
	}
} 

class test{
	public static void main(String [] args){
		MyQueue queue=new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		for (int i=0;i<=5;i++){
			System.out.println(queue.dequeue());
		}

	} 
}