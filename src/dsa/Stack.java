package dsa;

import dsa.exceptions.*;

public interface Stack{
	public int getSize();
	public boolean isEmpty();
	public Object top() throws StackEmptyException;
	public void push(Object ele);
	public Object pop() throws StackEmptyException;
}