package Demo;

public class StringDemo {
	
	public static void stringDemo(){
		//String greeting = "Hello World!";
		char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
		String helloString = new String(helloArray);
		System.out.println(helloString);

		String palindrome = "Dot saw I was Tod";
		int len = palindrome.length();
		char[] tempCharArray = new char[len];
		char[] charArray = new char[len];

		//put original string in an array of chars
		for (int i = 0; i < len; i++){
			tempCharArray[i] = palindrome.charAt(i);
		}
		System.out.println(tempCharArray);

		//reverse array of chars
		for (int j = 0; j < len; j++){
			charArray[j] = tempCharArray[len-1-j];
		}
		String reversPalindrome = new String(charArray);
		System.out.println(reversPalindrome);

		//create format strings
		String fs;
		float floatVar = 3.14f;
		int intVar = 314;
		String stringVar = "Hello World.";
		fs = String.format("The value of the float " +
				"variable is %f, \nwhile " +
				"the value of the " + 
				"integer variable is %d, \n" +
				"and the string is %s",
				floatVar, intVar, stringVar);
		System.out.println(fs);
	}
	public static <T> void appendPrint(StringBuilder sb, T b){
		sb.append(" ");
		sb.append((T)b);
		System.out.println(sb);
	}
	public static void stringBuilderDemo(){
		String palindrome = "Dot saw I was Tod";
		StringBuilder sb = new StringBuilder(palindrome);
		sb.reverse();
		System.out.println(sb);
		appendPrint(sb,true);
		appendPrint(sb,'c');
		char[] arr = {'a', 'r', 'r', 'a', 'y'};
		appendPrint(sb, arr);
		appendPrint(sb, 3.4124D);
		appendPrint(sb, 23);
		appendPrint(sb, 3.13f);
		appendPrint(sb, 123412l);
		appendPrint(sb, "string");
		sb.reverse();
		appendPrint(sb, " ");
	}
	public static void main(String[] args){
		stringBuilderDemo();
	}

}
