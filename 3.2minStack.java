/*How would you design a stack which, in additon to push and pop, also has a 
function min which returns the minimum elmenet? push, pop and min should all
operate in O(1) time                                                

Java Comparable interface:
  a.compareTo(b)  <0 =0 >0
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
	HashMap
	Node top;
	int min;
	int secondMin;
	int times;
	void push(int input){ 
		if (top==null){
			top=new Node(input);	
			min=input;
			times=1;
		}
		else{
			
			if(input<min){
				secondMin=min;
				min=input;
				times=1;
			}	

			if (input==min)
				times++;
			Node newTop=new Node(input);
			newTop.next=top;
			top=newTop;
		}
	}
	Object pop(){
		if (top==null)
			return null;
		int result=top.item;
		if(result==min&&times>=2)
			times--;
		else if(result==min && times=1)


		top=top.next;
		return result;
	}
	Object peek(){
		if (top==null)
			return null;
		else
			return top.item;
	}
	Object min(){
		return min;
	}


	public static void main(String [] args){

	}
}