/*An animal shelter holds only dogs and cats, and operates on a strictly "first 
in, first out" basis. People must adopt either the "oldest" (based on arrival 
time) of all animals at the shellter, or they can select whether they would prefer
a dog or a cat (and will receive the oldest animal of that type). They cannot select
which specific animal they would like. Create the data structures to maintain this 
system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
You may use the built-in LinkedList data structure.*/
import java.util.*;
class Animal{
	int index;
	boolean type;// true for cats, false for dogs;
	public Animal(int num,boolean isCat){
		index=num;
		type=isCat;
	}
}

class Shelter{
	LinkedList<Animal> shelter = new LinkedList<Animal>();
	void enqueue(Animal animal){
		shelter.add(animal);
	}
	Animal dequeueAny(){
		Animal result=shelter.getFirst();
		shelter.removeFirst();
		return result;
	}
	Animal dequeueCat(){
		Animal animal=shelter.getFirst();
		int index=shelter.indexOf(animal);
		while(!animal.type && index< shelter.size()){
			index++;
			animal=shelter.get(index);
		}
		if (animal!=null)
			shelter.remove(index);
		return animal;
	}

	Animal dequeueDog(){
		Animal animal=shelter.getFirst();
		int index=shelter.indexOf(animal);
		while(animal.type && index< shelter.size()){
			index++;
			animal=shelter.get(index);
		}
		if (animal!=null)
			shelter.remove(index);
		return animal;
	}


}
class test{
	public static void main(String [] args){
		Animal a=new Animal(1,true);
		Animal b=new Animal(2,false);
		Animal c=new Animal(3,false);
		Animal d=new Animal(4,true);
		Animal e=new Animal(5,false);
		Shelter shelter = new Shelter();
		shelter.enqueue(a);
		shelter.enqueue(b);
		shelter.enqueue(c);
		shelter.enqueue(d);
		shelter.enqueue(e);

		System.out.println(shelter.dequeueAny().index);
		System.out.println(shelter.dequeueCat().index);
		System.out.println(shelter.dequeueDog().index);
		shelter.enqueue(a);
		System.out.println(shelter.dequeueCat().index);
		


	}
}