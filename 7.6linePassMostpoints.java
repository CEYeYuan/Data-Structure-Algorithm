/*Given a two-dimensional graph with points on it, find a line which pases the 
most number of points.*/
class line{
	public double slope;
	public double yintersect;
	public line(double a,double b){
		slope=a;
		yintersect=b;
	}
}
class point {
	public int x;
	public int y;
	public point(int a,int b){
		x=a;
		y=b;
	}
	public boolean isOnline(line a){
		return (y==a.slope*x+a.yintersect);
	}
}
class test{
	public static line getLine(point[] input){
		point a;
		point b;
		int numOfPoints=2;
		line max=null;
		int maxnum=2;
		for (int i=0;i<input.length;i++){
			for (int j=i+1;j<input.length;j++){
				//System.out.println("input.length="+input.length);
				//System.out.println("i="+i+"j="+j);
				double x1=input[i].x;
				double x2=input[j].x;
				double y1=input[i].y;
				double y2=input[j].y;
				double slope=(y1*1.0-y2)/(x1-x2);
				double yintersect=y1*1.0-x1*slope;
				line tmp=new line(slope,yintersect);
				int current=2;
				for (int k=0;k<input.length;k++){
					if ((k!=i)&&(k!=j)){
						if (input[k].isOnline(tmp)){
							current++;
						}
					}
				}
				if (current>=maxnum){
					maxnum=current;
					max=tmp;
				}
			}
		}
		return max;
	}
	public static void main(String[] args){
		point[] arr=new point[4];
		arr[0]=new point(0,0);
		arr[1]=new point(1,1);
		arr[2]=new point(3,3);
		arr[3]=new point(3,4);
		line result=getLine(arr);
		System.out.println("y="+result.slope+"x+"+result.yintersect);
	}
}