/*A monochrome screen is stored as a single array of bytes, allowing eight 
consecutive pixels to be stored in one byte. The screen has width w, where w
is divisible by 8 (that is, no byte will be split across rows). The height of
the screen, of course, can be derived from the length of the array and the 
width. Implement a function drawHorizontalLine(byte[] screen, int width, int x1,
int x2,int y) which draws a horizontal line from (x1,y) to (x2,y).*/
class test{
	public static byte[] drawHorizontalLine(byte[] screen,int width,int x1,int x2,int y){
		//x1, x2, y all starts from 1;x1, x2 inclusive
		int start=(y-1)*width+x1-1;
		int end=(y-1)*width+x2-1;
		for (int i=start;i<=end;i++){
			setBit(screen,i);
		}
		return screen;
	}
	public static void drawScreen(byte[] screen, int width){
		for (int i=0;i<(screen.length*8)/width;i++){
			StringBuffer buffer=new StringBuffer();
			for (int j=i*width;j<(i+1)*width;j++){
				buffer.append(getBit(screen,j)+" ");
			}
			System.out.println(buffer.toString());
		}
	}
	public static int getBit(byte[] input,int index){
		int quotient=index/8;
		int remainder=index%8;
		if((input[quotient]&(1<<remainder))>0)
			return 1;
		else 
			return 0;
	}

	public static void setBit(byte[] input,int index){
		int quotient=index/8;
		int remainder=index%8;
		input[quotient]=input[quotient]|((byte) (1<<remainder));
	}
	public static void main (String[] args){
		int width=8*2;
		int height=10;
		byte[] screen=new byte[width*height/8];
		//screen[1]=(byte)0b11111111;
		int x1=1;
		int x2=10;
		int y=5;
		screen=drawHorizontalLine(screen,width,x1,x2,y);
		drawScreen(screen,width);
	}
}