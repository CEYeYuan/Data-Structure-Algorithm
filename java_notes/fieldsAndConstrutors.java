/*
1.instance variables= fields
2.class variables =static fields, shared by the who class
3.if you wrote a constructor, and even that constructor takes parameters, 
  the default constructor will go away, unless you explictly write both 
4.static methods doesn't pass an object implictly 
  Also: class.staticMethod() good style; object.staticMethod() //works, but bad style


##lifetimes of variables:
	1.local variable (declared in a method or even inside a for loop) is gone forever
	  as soon as the method in which it's declared finishes executing
	2.instance variables(non-static fields) last as long as the object exists. An object
	  lasts as long as there's a reference to it
	3.A class variable (static field) lasts as long as the program runs
*/

class Human{
	//public static int numOfHuman=0;
	public static int numOfHuman;// that works too.
	public String name;
	public int age;
	public Human(){
		numOfHuman++;
	}
	public Human(String s){
		name=s;
		numOfHuman++;
	}

	public Human(String s, int age){
		name=s;
		this.age=age;
		numOfHuman++;
		// if local variables/parameters have the same name with fields, 
		//the former one has the priority
	}
	public void introduce(){
		System.out.println("I'm "+name+" and I'm "+age+" year's old. There are now "+
			numOfHuman+" human object");
	}

	public static void introduceNums(){
		System.out.println("There are now "+
			numOfHuman+" human object");
	}

	public static void main(String[] args){
		/*int i;
		for (i=0;i<5;i++){

		}
		System.out.println(i); works,cuz i is defined inside main method
		*/ 
		/*
		for (int i=0;i<5;i++){

		}
		System.out.println(i); not work, i already get garbage collected
		*/
		/*int i;
		for (i=0;i<5;i++){
			int j=0;
		}
		System.out.println(j); not work. */
		Human ye=new Human("ye");
		ye.introduce();
		//ye.introduceNums(); bad style
		Human.introduceNums();
		Human yeyuan=new Human("ye yuan",22);
		yeyuan.introduce();
		Human human=new Human();
		human.introduce();
		System.out.println("There are now "+Human.numOfHuman+" human objects");
		System.out.println("There are now "+ye.numOfHuman+" human objects");//bad style

		/*
		I'm ye and I'm 0 year's old. There are now 1 human object
		I'm ye yuan and I'm 22 year's old. There are now 2 human object
		I'm null and I'm 0 year's old. There are now 3 human object

		*/


	}
}