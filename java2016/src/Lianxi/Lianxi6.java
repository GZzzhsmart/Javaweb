package Lianxi;

import java.io.*;
public class Lianxi6 {
	public static void main(String[] args) {
		int[] myArray = {10,20,30,40};
		try{
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("this.dat"));
			for(int i=0;i<myArray.length;i++)
				dos.writeInt(myArray[i]);
			dos.close();
			System.out.println("Having a written binary file ints.dat");
		}catch(IOException ioe){
			System.out.println("IOException");
		}
	}
}
