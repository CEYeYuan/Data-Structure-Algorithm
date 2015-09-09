/*Image a robot sitting on the upper left corner of an X by Y grid. The robot can 
only move in two directionsL right and down. How many possible paths are there for
the robot to go frome (0,0) to (x,y)
Follow up:
Image certain spots are "off limits", such that the robot cannot step on them. Design
an algorithm to find a path for the robot from the top left to the bottom right.   

1.when we call the contains() method in hashset, it actually means identical, i.e, one 
same object in the same memory address.
2.To make things work, we need to overide the .equals() method:
### Important: we need to use the exactly the same siginature: Object
Alse, we need overide the hashCode method 

The way contains work is first check if two objects has the same hashCode, if it do have,
then we check if they satisfy the condition in equals

*/
import java.util.*;
class point{
	public int x;
	public int y;
	public point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public boolean equals(Object p){
		point x=(point) p;
		return (this.x==x.x&&this.y==x.y);
	}
	public int hashCode(){
		return x+281+y*112;
	}
}
class test{
	/*public static int possiblePaths(int x,int y){
		if ((x==0) && (y!=0)){
			return 1;
		}
		else if ((y==0) && (x!=0)){
			return 1;
		}

		else {
			return possiblePaths(x-1,y)+possiblePaths(x,y-1);
		}
	}*/
	public static int possiblePaths(int x,int y,int startx,int starty,HashSet<point> set){
		if (startx==x)
			return 1;
		if (starty==y)
			return 1;
		else {
			point p1=new point(startx+1,starty);
			point p2=new point(startx,starty+1);
			if (!set.contains(p1)&&!set.contains(p2))
				return possiblePaths(x,y,startx+1,starty,set)+possiblePaths(x,y,startx,starty+1,set);
			else if (set.contains(p1)&&!set.contains(p2))
				return possiblePaths(x,y,startx,starty+1,set);	
			else if (!set.contains(p1)&&set.contains(p2))
				return possiblePaths(x,y,startx+1,starty,set);	
			else 
				return 0;
		}

	}
	public static void main (String[] args){
		int x=3;
		int y=3;
		HashSet<point> set=new HashSet<point>();
		point p1=new point(1,1);
		set.add(p1);
		point p2=new point(1,1);
		if (set.contains(p2))
		System.out.println("There're "+possiblePaths(x,y,0,0,set)+" possible paths");
	}
}