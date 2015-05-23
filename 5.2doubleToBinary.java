/*Given a real number between 0 and 1(e.g.0.72) that is passed in as a double,
print the binary representation. If the number cannot be represented accurately 
in binary with at most 32 characters, print "Error" */
class doubleToBinary{
	public static void toBinary(double input){
		double binary=0.5;
		StringBuffer str=new StringBuffer();
		str.append("0.");
		for (int i=0;i<32;i++){
			if (input==0){
				break;
			}
			else{
				if (input>=binary){
					input-=binary;
					binary/=2;
					str.append("1");
				}
				else{
					binary/=2;
					str.append("0");
				}
			}
		}
		if (input==0){
			System.out.println(str.toString());
		}else{
			System.out.println("Error");
		}
	}

	public static void main(String [] args){
		double input=(Math.pow(2,32)-1.0-5466248)/(Math.pow(2,32));
		toBinary(input);
	}
}