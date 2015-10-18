// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.Scanner;
import java.util.*;
class TreeNode{
    int item;
    TreeNode left;
    TreeNode right;
    TreeNode(int i){
        item=i;
    }
}
class test{
    public static void main(String[] args){
         //Scanner sc=new Scanner(System.in);
         //String s=sc.nextLine();
         TreeNode root=new TreeNode(1);
         root.left=new TreeNode(2);
         root.left.left=new TreeNode(4);
         root.right=new TreeNode(3);
         root.right.right=new TreeNode(5);
         levelOrder(root);
        
    } 
    
    private static void levelOrder(TreeNode root){
        if(root==null) return;
        LinkedList<TreeNode> cur=new LinkedList<TreeNode>();
        LinkedList<TreeNode> next=new LinkedList<TreeNode>();
        int i=1;
        cur.add(root);
        while(!cur.isEmpty()){
            TreeNode node=cur.removeFirst();
            System.out.println(node.item);
            if(node.left!=null)
                next.add(node.left);
            if(node.right!=null)
                next.add(node.right);
            if(cur.isEmpty()){
                  System.out.println("level"+ i+" end");
                  i++;
                  cur=next; 
                  next=new LinkedList<TreeNode>();
            }
        }
    }
  
    

}

