package Demo.IOStreams;

import java.io.*;
import java.util.Scanner;

public class ScanXan {
	public static void main(String[] args) throws IOException {
		Scanner s = null;
		
		try{
			s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));
			s.useDelimiter(",\\s*");	//设置分隔符，默认分隔符是空格
			while (s.hasNext()){
				System.out.println(s.next());
			}
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}