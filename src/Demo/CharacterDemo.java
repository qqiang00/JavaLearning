package Demo;

public class CharacterDemo {
	public static void main(String[] args){
		
		//char ch = 'a';
		//char uniChar = '\u03A9';
		char[] charArray = 
			{ 'a', 'b', 'c', 'd', 'e', ' ', '3', '0', 'A', 'B' };
		
		//Character chr = new Character('a');
		
		
		for(int i=0;i<charArray.length;i++){
			char c = charArray[i];
			if(Character.isLetter(c)){
				System.out.printf("%c is a letter%n", c);
			}
			else if(Character.isDigit(c)){
				System.out.printf("%c is a digit%n",c);
			}
			else if(Character.isWhitespace(c)){
				System.out.printf("%c is a white space%n", c);
			}
			
			if(Character.isLowerCase(c)){
				System.out.printf("%c is lowercase, its upper case is %c%n",
						c,Character.toUpperCase(c));
			}	
			else if (Character.isUpperCase(c)){
				System.out.printf("%c is uppercase, its lower case is %c%n",
						c, Character.toLowerCase(c));
			}
			System.out.printf("String format of \'%c\' is \"%s\"%n%n", c, Character.toString(c));
		}
		System.out.println("\t\tabcdefg \b\nhijklmn\ropqrst\f\\");
	}
}
