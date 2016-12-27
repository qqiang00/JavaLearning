package dsa;
import dsa.exceptions.*;

public class Stack_List implements Stack{
	protected Node top;	//指向栈顶元素
	protected int size;	//栈中的元素数目
	
	//构造方法(空栈)
	public Stack_List(){
		top = null;
		size = 0;
	}
	
	//查询当前栈的规模
	public int getSize(){
		return size;
	}
	
	//判断是否栈空
	public boolean isEmpty(){
		return (top == null) ? true : false;
	}
	
	//压栈
	public void push(Object elem){
		Node v = new Node(elem, top);	//创建一个新节点，将其作为首节点插入
		top = v;	//更新节点引用
		size++;		//更新规模记录
	}
	//读取（但不删除）栈顶
	public Object top() throws StackEmptyException{
		if (isEmpty()){
			throw new StackEmptyException(DSAExceptionMsg.EmptyStack);
		}
		return top.getElem();
	}
	//弹出栈顶
	public Object pop() throws StackEmptyException{
		if (isEmpty()){
			throw new StackEmptyException(DSAExceptionMsg.EmptyStack);
		}
		Object tmp = top.getElem();
		top = top.getNext();	//更新首节点引用
		size--;		//更新规模记录
		return tmp;
	}
}