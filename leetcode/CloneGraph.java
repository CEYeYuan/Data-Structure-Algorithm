/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
Nodes are labeled uniquely.
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)  return null;
        HashMap<Integer,UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set=new HashSet<UndirectedGraphNode>();
        UndirectedGraphNode start=new UndirectedGraphNode(node.label);
        map.put(node.label,start);
        dfs(map,set,node);
        return start;
    }
    
    private void dfs(HashMap<Integer,UndirectedGraphNode> map,HashSet<UndirectedGraphNode> set,UndirectedGraphNode node){
    //in the hashmap => this node has been created, but the neighbor list has not been initialized
    //in the hashset => all set,include it's neighbor list-->visited
    //recursion invariance: node is not visited yet, but has been initialized
        UndirectedGraphNode copy=map.get(node.label);
        for(UndirectedGraphNode tmp:node.neighbors){
            //copy all the neighbors, store in the copied node
            if(map.get(tmp.label)==null){
                UndirectedGraphNode neighborcp=new UndirectedGraphNode(tmp.label);
                map.put(neighborcp.label,neighborcp);
                copy.neighbors.add(neighborcp);
            }
            else{
                copy.neighbors.add(map.get(tmp.label));
            }
          
        }
        set.add(copy);//set as visited
        for(UndirectedGraphNode tmp:node.neighbors){
            if(set.contains(map.get(tmp.label))==false)
                dfs(map,set,tmp);
        }
    }
    
    
    
}