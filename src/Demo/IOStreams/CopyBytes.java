package Demo.IOStreams;
//if compile with command in a shell. comment the package statement.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	public static void main(String[] args) throws IOException{
		
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try{
			in = new FileInputStream("xanadu.txt");
			out = new FileOutputStream("outagain.txt");
			int c;
			
			while ((c = in.read()) != -1){
				out.write(c);
				System.out.print(c + " ");
			}
			System.out.println();
			
		} finally {
			if (in != null){
				in.close();
			}
			if (out != null){
				out.close();
			}
		}
	}
}