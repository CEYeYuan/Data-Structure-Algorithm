/*How would you design a stack which, in additon to push and pop, also has a 
function min which returns the minimum elmenet? push, pop and min should all
operate in O(1) time                                                

Java Comparable interface:
  a.compareTo(b)  <0 =0 >0

Traditional way: Keep track of min of ecah layer in a separte field

Better way: If we pop off an elment, when will the min elment change ?
Answer: If it's now the minimum elment and the last element of that value
How can we find that value: ?
Think backward, it's when we push an elment in, and coincidently it's the 
new minimum value !
*/

import java.util.*;
class Node{
	int item;
	int min;
	Node next;
	Node (int input){
		item=input;
	}
}
class minStack{
	Node top;
	void push(int input){ 
		if (top==null){
			top=new Node(input);	
			top.min=input;
		}
		else{
			Node newTop=new Node(input);
			
			if(input<top.min){	
				newTop.min=input;
			}	
			else{
				newTop.min=top.min;
			}
			newTop.next=top;
			top=newTop;
		}
	}
	Object pop(){
		if (top==null)
			return null;
		else{
			Node result=top;
			top=top.next;
			return result;
		}	
	}
	Object peek(){
		return top;
	}
	Object min(){
		return top.min;
	}


	public static void main(String [] args){
		minStack stack=new minStack();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(stack.min());
		System.out.println(stack.pop());

		stack.push(-1);

		System.out.println(stack.min());
		System.out.println(stack.pop());

		System.out.println(stack.min());
		System.out.println(stack.pop());

	}
}