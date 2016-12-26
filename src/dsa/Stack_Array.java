package dsa;
import dsa.exceptions.*;

public class Stack_Array implements Stack{
	public static final int CAPACITY = 1024; //默认容量
	protected int capacity;	//数组实际容量
	protected Object[] S;	//对象数组
	protected int top = -1;
	
	public Stack_Array(){
		this(CAPACITY);
	}
	
	public Stack_Array(int cap){
		capacity = cap;
		S = new Object[capacity];
	}
	
	public int getSize(){
		return (top + 1);
	}
	
	public boolean isEmpty(){
		return (top < 0);
	}
	
	public void push(Object obj) throws StackFullException {
		if (getSize() == capacity){
			throw new StackFullException(DSAExceptionMsg.FullStack);
		}
		S[++top] = obj;
	}
	
	public Object top() throws StackEmptyException {
		if (isEmpty()){
			throw new StackEmptyException(DSAExceptionMsg.EmptyStack);
		}
		return S[top];
	}
	
	public Object pop() throws StackEmptyException {
		Object ele;
		if (isEmpty()){
			throw new StackEmptyException(DSAExceptionMsg.EmptyStack);
		}
		ele = S[top];
		S[top--] = null;
		return ele;
	}
}