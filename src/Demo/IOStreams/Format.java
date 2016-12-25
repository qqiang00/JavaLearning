package Demo.IOStreams;

public class Format{

	public void root2(){
		int i = 2;
		double r = Math.sqrt(i);
		System.out.format("The square of %d is %f.%n", i, r);
	}
	
	public static void main(String[] args){
		Format fmt = new Format();
		fmt.root2();
		System.out.format("%f, %1$+020.10f %n", Math.PI);
	}
}