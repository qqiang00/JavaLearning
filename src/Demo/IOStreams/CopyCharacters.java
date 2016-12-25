package Demo.IOStreams;
//if compile with command in a shell. comment the package statement.

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
	public static void main(String[] args) throws IOException{
		
		FileReader inputStream = null;
		FileWriter outputStream = null;
		
		try{
			inputStream = new FileReader("xanadu.txt");
			outputStream = new FileWriter("characteroutput.txt");
			
			int c;			
			while ((c = inputStream.read()) != -1){
				outputStream.write(c);
				System.out.print(c + " ");
			}
			System.out.println();
			
		} finally {
			if (inputStream != null){
				inputStream.close();
			}
			if (outputStream != null){
				outputStream.close();
			}
		}
	}
}