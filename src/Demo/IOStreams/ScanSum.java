package Demo.IOStreams;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

public class ScanSum {
	public static void main(String[] args) throws IOException{
		Scanner s = null;
		double sum = 0;
		
		try{
			s = new Scanner(new BufferedReader(new FileReader("usnumber.txt")));
			s.useLocale(Locale.US);
			
			while (s.hasNext()){
				if (s.hasNextDouble()){
					double d = s.nextDouble();
					System.out.println("Find a double number: " + d );
					sum += d;
				} else {
					System.out.println("Find a non-double object: " + s.next());
				}
			}
		} finally {
			s.close();
		}
		System.out.println(sum);
	}
}