class LRUCache {
    int cap;
    List1 list;
    HashMap<Integer,ListNode> map;//store the listnode
    public LRUCache(int capacity) {
        cap=capacity;
        list=new List1();
        map=new HashMap<Integer,ListNode>();
    }
    
    public int get(int key) {
        if(map.get(key)!=null){
        	ListNode tmp= map.get(key);
        	list.remove(tmp);
        	list.addFirst(tmp);
        	return tmp.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1){
            //set does not change the priority?
            ListNode exist=map.get(key);
            exist.val=value;
        }
        else{
            ListNode tmp=new ListNode(key,value);
        	map.put(key,tmp);
        	list.addFirst(tmp);
            if(list.size>=cap+1){	
            	ListNode last=list.removeLast();
            	map.remove(last.key);
            }
        }
    
    }
}

class ListNode{
    int key;
    int val;
    ListNode next;
	ListNode prev;
    public ListNode(int k,int v){
        key=k;
        val=v;
    }
}

class List1{
	ListNode head;
	int size;
	public List1(){
		size=0;
		head=new ListNode(-1,-1);
		head.prev=head;
		head.next=head;
	}

	public void addFirst(ListNode node){
		ListNode tmp=head.next;
		head.next=node;
		node.next=tmp;
		node.prev=head;
		tmp.prev=node;
		size++;
	}

	public void remove(ListNode node){
		size--;
		node.prev.next=node.next;
		node.next.prev=node.prev;
		node.next=null;
		node.prev=null;
	}

	public ListNode getFirst(){
		return head.next;
	}

	public ListNode removeLast(){
		ListNode tmp=head.prev;
		tmp.prev.next=head;
		head.prev=tmp.prev;
		tmp.prev=null;
		tmp.next=null;
		size--;
		return tmp;
	}

}
