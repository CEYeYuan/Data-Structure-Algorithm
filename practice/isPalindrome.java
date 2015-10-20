// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.Scanner;
import java.util.*;

class test{
    static int carry=0;
    public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         //String s=sc.nextLine();
         int num=sc.nextInt();
         if(isPalindrome(num))
            System.out.println("I'm palindrome");
        else
             System.out.println("I'm NOT palindrome");
        
    } 
    
    private static boolean isPalindrome(int num){
        if(num>=0&&num<=9)
            return true;
        else{
            int len=len(num);
            int high=(int)Math.pow(10,len-1);
            int low=1;
            for(int i=0;i<len/2;i++){
                if((num/low)%10==(num/high)%10) {
                    high/=10;
                    low*=10;
                }
                    
                else
                    return false;
            }
            return true;
        }
    }
    
    private static int len(int num){
        int i=1;
        while(num/10!=0){
            i++;
            num=num/10;
        }
        return i;
    }
    
    
}
