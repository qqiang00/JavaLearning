/**
 * 
 */
package Demo;

/**
 * @author qiang
 * 演示了泛型、在类内部定义内部类及使用内部类的方法
 *
 */
public class GenericDemo {
	public class Box<T>{
		private T t;
		
		public void set(T t){
			this.t= t;
		}
		
		public T get(){
			return t;
		}
		
		public <U extends Number> void inspect(U u){
			System.out.println("T: " + t.getClass().getName());
			System.out.println("U: " + u.getClass().getName());
		}
		
	}
	
	public class NaturalNumber<T extends Integer>{
		private T n;
		public NaturalNumber(T n){ this.n = n;}
		public boolean isEven(){
			return n.intValue() % 2 == 0;
		}
		public T get(){
			return (T)n;
		}
	}
	
	public static void main(String[] args){
		GenericDemo demo = new GenericDemo();
		Box<Integer> integerBox = demo.new Box<Integer>();
		integerBox.set(new Integer(10));
		//integerBox.inspect("some text"); //error : this is still String
		integerBox.inspect(3.1315926d);	
		
		NaturalNumber<Integer> num = demo.new NaturalNumber(34);
		System.out.printf("is %s even? %s! ",num.get(), num.isEven());
		
	}
}
