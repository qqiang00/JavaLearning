package Demo;
import java.util.Calendar;
import java.util.Locale;

public class TestNumber {
	public static void showBuiltinClass(){
		int x = 5;
		byte b = 'A';
		double d = 3.14;
		short t = 3;
		float f = 3.14F;
		long l = 3L;
		//x = x + 10;
		System.out.println("Using builtin type to declare a number");
		System.out.println(x);
		System.out.println("x: " + x);
		System.out.println("b: " + b);
		System.out.println("d: " + d);
		System.out.println("t: " + t);
		System.out.println("f: " + f);
		System.out.println("l: " + l);
	}
	
	public static void showBasicClass(){
		Integer x = 5;
		Byte b = 'A';
		Double d = 3.14;
		Short t = 3;
		Float f = 3.14F;
		Long l = 3L;
		//x = x + 10;
		System.out.println("Using Class to declare a Number without using 'new'");
		System.out.println(x);
		System.out.println("x: " + x);
		System.out.println("b: " + b);
		System.out.println("d: " + d);
		System.out.println("t: " + t);
		System.out.println("f: " + f);
		System.out.println("l: " + l);
	}
	
	public static void showBasicClass(boolean box){
		
		Integer x = new Integer(5);
		Byte b = new Byte((byte) 'A');
		Double d = new Double(3.14);
		Short t = new Short((short) 3);
		Float f = new Float(3.14);
		Long l = new Long(3);
		System.out.println("Using Class to declare a Number");
		System.out.println(x);
		System.out.println("x: " + x);
		System.out.println("b: " + b);
		System.out.println("d: " + d);
		System.out.println("t: " + t);
		System.out.println("f: " + f);
		System.out.println("l: " + l);	
	}
	
	public static void XXXValue(){
		Float i = 15.0F;
		System.out.println("int value of i: " + i.intValue());
		System.out.println("float value of i: " + i.floatValue());	
		System.out.println("double value of i: " + i.doubleValue());
		System.out.println("short value of i: " + i.shortValue());
		System.out.println("long value of i: " + i.longValue());
		System.out.println("byte value of i: " + i.byteValue());
	}

	
	public static void main(String[] args){
		long n = 461012;
		System.out.format("%d%n", n);
		System.out.format("%08d%n", n);
		System.out.format("%+8d%n", n);
		System.out.format("%,8d%n", n);
		System.out.format("%+,8d%n%n", n);
		
		double pi = Math.PI;
		System.out.format("%f%n", pi);
		System.out.format("%.3f%n", pi);
		System.out.format("%10.3f%n", pi);
		System.out.format("%-10.3f%n", pi);
		System.out.format(Locale.FRANCE, "%-10.4f%n%n",pi);
		
		Calendar c = Calendar.getInstance();
		System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
		System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"
		System.out.format("%tD%n", c);    // -->  "05/29/06"
		


	}
}
