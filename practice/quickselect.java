// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.util.Scanner;
import java.util.*;

class test{
   
    public static void main(String[] args){
        
         Scanner sc=new Scanner(System.in);
         //String s=sc.nextLine();
         int[] arr=new int[]{7,8,6,4,2,3,1,5,0};
         int kth=quickselect(arr,3,0,arr.length-1);
         for(int i=0;i<arr.length;i++){
              System.out.println(quickselect(arr,i,0,arr.length-1));
         }
        
    } 
    
    private static int quickselect(int[] arr,int k,int start,int end){
        //randomly choose a pivot;
    
        int index=(start+end)/2;
        int pivot=arr[index];
        swap(arr,index,end);
        int i=start;
        int j=end-1;
        while(true){
            while(arr[i]<pivot)
                i++;
            while(arr[j]>=pivot&&(j>i))
                j--;
            if(i<j)
                swap(arr,i,j);
            else
                break;
        }
        swap(arr,i,end);
        if(i==k)    return arr[i];
        if(i>k)     return quickselect(arr,k,start,i-1);
        else        return quickselect(arr,k,i+1,end);
    }
    
    private static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    
   
    
}
