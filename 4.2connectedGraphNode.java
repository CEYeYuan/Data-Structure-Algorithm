/*Given a directed graph, design an algorithm to find out whether there us a 
route between two node.*/
import java.util.*;
class Graph{
	public boolean[][] connected;
	public boolean[] visited;

	Graph(int n){
		connected=new boolean[n][n];
		visited=new boolean[n];
	}


	static boolean isConnected(int a, int b,Graph graph){
		HashSet<Integer> set=new HashSet<Integer>();
		depthFirstSearch(a,set,graph);
		if (set.contains(b))
			return true;
		else
			return false;

	}

	static void depthFirstSearch(int a,HashSet<Integer> set,Graph graph){
		set.add(a);
		graph.visited[a]=true;
		for (int i=0;i<graph.visited.length;i++){
			if (graph.connected[a][i]==true){
				if (graph.visited[i]==false){
					depthFirstSearch(i,set,graph);
				}
			}
		}
	}
}
class test{
	public static void main(String[] args){
		Graph graph=new Graph(5);
		graph.connected[1][2]=true;
		graph.connected[1][0]=true;
		graph.connected[2][4]=true;
		graph.connected[4][0]=true;
		graph.connected[0][3]=true;
		if (Graph.isConnected(1,3,graph))
			System.out.println("we are connected !");
		else {
			System.out.println("we are not connected !");
		}

	}
}