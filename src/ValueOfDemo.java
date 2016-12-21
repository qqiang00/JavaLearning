/**
 * 
 */
//package Demo;

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

	}

}
