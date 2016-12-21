package Demo;

//import java.lang.Math;

public class MathDemo {
	public static void main(String[] args){
		
		System.out.println("Basic Math Demo");
		double a = -191.635;
		double b = 43.74;
		int c = 16, d = 45;
		System.out.printf("The absolute value of %.3f is %.3f%n",
				a, Math.abs(a));
		System.out.printf("The ceiling value of %.2f is %.0f%n",
				b, Math.ceil(b));
		System.out.printf("The floor value of %.2f is %.0f%n",
				b, Math.floor(b));
		System.out.printf("The rint value of %.2f is %.0f%n",
				b, Math.rint(b));
		System.out.printf("The max of %d and %d is %d%n",
				c, d, Math.max(c, d));
		System.out.printf("The min of %d and %d is %d%n",
				c, d, Math.min(c, d));		
		
		System.out.println("\n\nExponential Demo");
		double x = 11.635;
		double y = 2.76;
		System.out.printf("The value of e is %.4f%n", Math.E);
		System.out.printf("exp(%.3f) is %.3f%n", x, Math.exp(x));
		System.out.printf("log(%.3f) is %.3f%n", x, Math.log(x));
		System.out.printf("pow(%.3f, %.3f) is %.3f%n", x, y, Math.pow(x, y));
		System.out.printf("sqrt(%.3f) is %.3f%n", x, Math.sqrt(x));
		
		System.out.println("\n\nTrigonometric Methods Demo");
		double degrees = 45.0;
		double radians = Math.toRadians(degrees);
		System.out.format("The value of pi is %.4f%n", Math.PI);
        System.out.format("The sine of %.1f " + "degrees is %.4f%n",
                degrees, Math.sin(radians));
        System.out.format("The cosine of %.1f " + "degrees is %.4f%n",
                degrees, Math.cos(radians));
        System.out.format("The tangent of %.1f " + "degrees is %.4f%n",
                degrees, Math.tan(radians));
        System.out.format("The arcsine of %.4f " + "is %.4f degrees %n", 
                Math.sin(radians), 
                Math.toDegrees(Math.asin(Math.sin(radians))));
        System.out.format("The arccosine of %.4f " + "is %.4f degrees %n", 
                Math.cos(radians),  
                Math.toDegrees(Math.acos(Math.cos(radians))));
        System.out.format("The arctangent of %.4f " + "is %.4f degrees %n", 
                Math.tan(radians), 
                Math.toDegrees(Math.atan(Math.tan(radians))));		
	}

}
