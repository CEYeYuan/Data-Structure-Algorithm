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
	public static final int threshold=3;
	static int index=0;
	int current_index;
	Node top;
	ArrayList<Node> stacksList=new ArrayList<Node>();
	HashMap<Node,Integer> stacksHash=new HashMap<Node,Integer>();
	int current_size;

	void push(int input){
		if(top==null){

			current_index=0;
			current_size=1;
			top=new Node(input);
			stacksList.add(top);
			stacksHash.put(top,1);
		}
		else{
			if (current_size<threshold){
				Node newNode=new Node(input);
				newNode.next=top;
				top=newNode;
				current_size++;
				stacksList.set(index,top);
			}else{
				Node oldTop=top;
				top=new Node(input);
				top.next=oldTop;
				current_size=1;
				index++;
				stacksList.add(top);
			}
			stacksHash.put(top,current_size);
		}
	}

	Node pop(){
		if(top==null)
			return null;
		else{
			Node result=top;
			top=top.next;
			if(current_size>=1){
				current_size--;
			}
			else{
				current_size=threshold-1;
				index--;
			}
			return result;		
		}
		
	}

	Node popAt(int input){
		if(stacksList.get(input)==null)
			return null;
		else{
			Node topAt=stacksList.get(input);
			int current_size=stacksHash.get(topAt);
			if(current_size==0)
				return null;
			else{

				Node result=topAt;
				if (current_size==1){
					topAt=null;
				}
				topAt.item=topAt.next.item;
				topAt=topAt.next;
				stacksList.set(input,topAt);
				return result;
			}
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
			" sub stacks, and the current_size of the stack is "+stacks.current_size);
		stacks.top.toStringPrint();
		System.out.println("");

		stacks.pop();
		stacks.top.toStringPrint();
		System.out.println("");

		stacks.pop();
		stacks.top.toStringPrint();


	}
}