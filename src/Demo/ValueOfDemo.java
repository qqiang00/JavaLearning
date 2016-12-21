/**
 * 
 */
package Demo;

/**
 * @author qiang
 *
 */
public class ValueOfDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// this program requires two arguments on the command line
		if (args.length == 2){
			//convert two strings to numbers
			float a = (Float.valueOf(args[0])).floatValue();
			float b = (Float.valueOf(args[1])).floatValue();
			
			System.out.println("a + b = " + (a + b));
			System.out.println("a - b = " + (a - b));
			System.out.println("a * b = " + (a * b));
			System.out.println("a / b = " + (a / b));
			System.out.println("a % b = " + (a % b));
		}else{
			System.out.println("Tihs program requeires two command-line arguments.");
		}

		double d = 858.48;
		String s = Double.toString(d);
		
		int dot = s.indexOf('.');
		System.out.println(dot + " digits " + "before decimal point.");
		System.out.println((s.length() - dot - 1) + " digits after decimal points.");
		
	}

}
