/*Design the data structures for a generic deck of cards. Explain how you would 
subclass the datastructures to implement blackjack*/
class cards{
	public static final int Club=0;
	public static final int Diamond=1;
	public static final int Heart=2;
	public static final int Spade=3;
	private int suit;//0~3
	private int value;//1-13
	public cards(int a,int b){
		suit=a;
		value=b;
	}
	public int getSuit(){
		return suit;
	}
	public int getValue(){
		return value;
	}
}