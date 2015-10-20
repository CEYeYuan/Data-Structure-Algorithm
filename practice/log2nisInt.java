// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.Scanner;
import java.util.*;

class test{
   
    public static void main(String[] args){
        
         Scanner sc=new Scanner(System.in);
         //String s=sc.nextLine();
         int num=sc.nextInt();
         if(isInt(num))
            System.out.println("I'm Int");
        else
             System.out.println("I'm NOT Int");
        
    } 
    
    private static boolean isInt(int num){
        //test if log2(n) is int
        int count =0;
        int mask=1;
        while(num>0){
            if((num&mask)>0){
                 count++;
                 num-=mask;
            }
            mask=mask<<1;
            if(count>=2)
                return false;
        }
        return true;
       
    }
    
}
