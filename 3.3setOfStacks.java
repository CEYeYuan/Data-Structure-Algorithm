/*
Image a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous 
stack exceeds some threshold. Implement a data structure SetOfStacks that mimics 
this. SetOfStacks should be composed of several stacks and should create a new 
stack once the previous one exceeds capacity. SetOfStacks.push() and 
SetOfStacks.pop() should behave identically to a single stack(that is, pop() should)
return the same values as it would if there were just a single stack.

FOLLOW UP:
Implement a function popAt(int index) which performs a pop operation on a specific
sub-stack.
*/
import java.util.*;

class Node{
	int item;
	int size;
	Node next;
	Node(int input){
		item=input;
	}
	public void toStringPrint(){
		Node current=this;
		while(true){
			if(current!=null){
				System.out.print(current.item+" ");
				current=current.next;
			}
			else
				break;
		}
	}
}
class SetOfStacks{
	public static final int threshold=2;
	static int index=0;
	Node top;
	ArrayList<Node> stacksList=new ArrayList<Node>();
	

	void push(int input){
		if(top==null){
			
			top=new Node(input);
			top.size=1;
			stacksList.add(top);
		
		}
		else{
			if (top.size<threshold){
				Node newNode=new Node(input);
				newNode.size=top.size+1;
				newNode.next=top;
				top=newNode;
				stacksList.set(index,top);
			}else{
				Node oldTop=top;
				top=new Node(input);
				top.next=oldTop;
				top.size=1;
				index++;
				stacksList.add(top);
			}

		}
	}

	Node pop(){
		if(top==null)
			return null;
		else{

			Node result=top;
			top=top.next;
		
			return result;		
		}
		
	}

	Node popAt(int input){
		if(stacksList.get(input)==null)
			return null;
		else{
			Node topAt=stacksList.get(input);
			int current_size=topAt.size;
			if(current_size==0)
				return null;
			else{

				Node result=topAt;
				if(current_size!=1 && findTail(input+1)!=null){
					topAt=topAt.next;
					findTail(input+1).next=topAt;
					stacksList.set(input,topAt);
				}
				if (current_size!=1 && findTail(input+1)==null){
					top=topAt.next;
					topAt=topAt.next;
				}
				if (current_size==1){
					if(findTail(input+1)==null){
						top=topAt.next;
						stacksList.set(input,topAt);
					}else{
						findTail(input+1).next=topAt.next;
						topAt=null;
					}
				}
				return result;
			}
		}
	}

	Node findTail(int input){
		if (stacksList.get(input)==null)
			return null;
		else{
			Node current_top=stacksList.get(input);
			while (current_top.size!=1){
				current_top=current_top.next;
			}
			return current_top;
		}
	}
}
class test{
	public static void main(String[] args){
		SetOfStacks stacks=new SetOfStacks();
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		System.out.println("There're now "+stacks.index+
			" sub stacks, and the current_size of the stack is "+stacks.top.size);
		stacks.top.toStringPrint();
		System.out.println("");

		stacks.popAt(1);
		stacks.top.toStringPrint();
		System.out.println("");

		stacks.popAt(1);
		stacks.top.toStringPrint();
		System.out.println("");

		stacks.popAt(0);
		stacks.top.toStringPrint();
		System.out.println("");

		

	}
}