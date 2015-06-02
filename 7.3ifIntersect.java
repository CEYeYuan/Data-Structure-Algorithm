/*Given two lines on a Cartesian plane, determine whether the two lines would
intersect*/
class Line{
	double yintersect;
	double slope;
	public Line(double y,double s){
		yintersect=y;
		slope=s;
	}
	public boolean ifIntersect(Line a){
		if (this.yintersect==a.yintersect&&this.slope==a.slope)
			return true;
		return (this.slope!=a.slope);
	}
}
class test{
	public static void main (String[] args){
		Line line1=new Line(2,1);
		Line line2=new Line(2,1);
		if (line1.ifIntersect(line2))
			System.out.println("We'll intersect at some point");
	}
}