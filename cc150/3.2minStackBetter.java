/*How would you design a stack which, in additon to push and pop, also has a 
function min which returns the minimum elmenet? push, pop and min should all
operate in O(1) time                                                

Java Comparable interface:
  a.compareTo(b)  <0 =0 >0

Traditional way: Keep track of min of ecah layer in a separte field

Better way: If we pop off an elment, when will the min elment potentially change ?
Answer: If it's now the minimum elment 
Think backward, it's when we push an elment in, and coincidently it's the 
minimum value !

this time, we only keep track of when min potentially changes, otherwise, we do not
care the influence of pop
*/

import java.util.*;
class Node{
	int item;
	Node next;
	Node (int input){
		item=input;
	}
}
class minStack{
	Node top;
	Node minStack;// this time, min is also a stack
	void push(int input){ 
		if (top==null){
			top=new Node(input);	
			minStack=new Node(input);
		}
		else{
			Node newTop=new Node(input);
			
			if(input<=minStack.item){	
				Node newMin=new Node(input);
				newMin.next=minStack;
				minStack=newMin;
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
			if(result.item==minStack.item){
				minStack=minStack.next;
			}
			top=top.next;
			return result;
		}	
	}
	Object peek(){
		return top;
	}
	Object min(){
		return minStack.item;
	}


	public static void main(String [] args){
		minStack stack=new minStack();
		stack.push(5);
		stack.push(3);
		stack.push(5);
		stack.push(3);
	

		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());

	}
}