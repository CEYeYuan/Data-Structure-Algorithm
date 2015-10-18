// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

import java.util.Scanner;
import java.util.*;
class test{
    public static void main(String[]args){
         //Scanner sc=new Scanner(System.in);
         //String s=sc.nextLine();
         int [] arr=new int[]{1, 3, 5, -2, 24, 10, -39};
         split(arr);
         for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
        
    } 
    private static void split(int[] arr){
        if(arr==null||arr.length<=1)    return;
        int neg_pos=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                int tmp=arr[i];
                shift(arr,neg_pos,i-1);
                arr[neg_pos]=tmp;
                neg_pos++;
            }
        }
    }
    
    private static void shift(int[] arr,int start,int end){
        if(end<start)   return;
       
        for(int i=end;i>=start;i--){
            arr[i+1]=arr[i];
        }
    }
}

