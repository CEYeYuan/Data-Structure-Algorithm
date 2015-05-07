/*
standard I/O of java:
how can we call a readLine method? -> we need a BufferedReader,which compose 
	characters into a line
how can we construct a BufferedReader ?-> we need a InputStreamReader, which 
	compose raw data into characters
how can we construct a InputStreamReader, we need a InputStream, which read 
	the raw data from sourse (e.g keyboard, URL)
how can we find a InputStream?  System.in or url.openStream

*/
import java.io.*;
import java.net.*;
class readWWW{
	public static void main (String[] args) throws Exception{
		URL url=new URL("http://www.google.ca");
		BufferedReader bf=new BufferedReader(new InputStreamReader(url.openStream()));
		while(true){
			String s=bf.readLine();
			if (s!=null)
				System.out.println(s);
			else
				break;
		}
	}
}