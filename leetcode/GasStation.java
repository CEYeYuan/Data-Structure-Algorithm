/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] destination=new int[gas.length];
        int[] remain=new int[gas.length];
        //remain record the unused gas at the destination
        for(int i=0;i<gas.length;i++){
            //-1 means not initialized; 
            destination[i]=-1;
        }
        for(int i=gas.length-1;i>=0;i--){
            if(cost[i]>gas[i]){
                //not enough gas to move even one step
                remain[i]=gas[i];
                destination[i]=i;
            }
            else if(destination[(i+1)%gas.length]==-1){
                //the next index has not been initialized
                int index=i;
                int cur=gas[index];
                while(true){
                    if(cur>=cost[index]){
                        cur=cur-cost[index]+gas[(index+1)%gas.length];
                        index=(index+1)%gas.length;
                        if(index==i)
                            return i;
                    }
                    else
                        break;
                }
                destination[i]=index;
                remain[i]=cur;
            }
            else{
               //recurrence case---next index has been set
               int unused=gas[i]-cost[i]+remain[(i+1)%gas.length];
               int index=destination[(i+1)%gas.length];
               while(true){
                   if(unused>=cost[index]){
                       unused=unused-cost[index]+gas[(index+1)%gas.length];
                       index=(index+1)%gas.length;
                       if(index==i) return i;
                   }else{
                       //not enough gas
                       break;
                   }
               }
               remain[i]=unused;
               destination[i]=index;
            }
        }
        
        return -1;
    }
}