/*Given two squares on a two-dimensional plane, find a line that would cut these
two squares in half. Assume that the top and the bottom sides of the square run 
parallel to the x-axis.
###
If a line divide a square into two half, it must pass the middle point*/
class point {
	public int x;
	public int y;
	public point(int a,int b){
		x=a;
		y=b;
	}
}
class square{
	public point leftTop;
	public int edge;
	public square(point a,int length){
		leftTop=a;
		edge=length;
	}
}
class line{
	public double yintersect;
	public double slope;
}
class test{
	public static line getLine(square a,square b){
		line result=new line();
		point acenter=new point (a.leftTop.x+a.edge/2,a.leftTop.y-a.edge/2);
		point bcenter=new point (b.leftTop.x+b.edge/2,b.leftTop.y-b.edge/2);
		double slope=(bcenter.y-acenter.y)*1.0/(bcenter.x-acenter.x);
		double yintersect=acenter.y*1.0-slope*acenter.x;
		result.slope=slope;
		result.yintersect=yintersect;
		return result;
	}
	public static void main(String[] args){
		square a=new square(new point(4,3),8);
		square b=new square(new point(1,1),2);
		line result=getLine(a,b);
		System.out.println("The slope of the line is "+result.slope+" and the y intersect is"
			+result.yintersect);
	}
}