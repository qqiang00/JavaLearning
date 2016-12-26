package dsa;
import dsa.exceptions.*;

public class Queue_Array implements Queue{
	public static final int CAPACITY = 1000;
	protected int capacity;	//数组实际容量
	
	protected Object[] Q;	//对象数组
	
	protected int f = 0;	//队首元素位置
	protected int r = 0;	//队尾元素位置
	
	//缺省构造方法
	public Queue_Array()	{	this(CAPACITY);	}
	
	//带参数构造方法
	public Queue_Array(int cap){
		capacity = cap;
		Q = new Object[capacity];
	}
	
	//查询当前队列的规模
	public int getSize(){
		return (capacity-f+r) % capacity;
	}
	
	//判断队列是否为空
	public boolean isEmpty(){
		return (f==r);
	}
	
	//入队
	public void enqueue(Object obj) throws QueueFullException{
		if (getSize() == capacity-1){
			throw new QueueFullException(DSAExceptionMsg.FullQueue);
		}
		Q[r] = obj;
		r = (r+1) % capacity;
	}
	
	//出队
	public Object dequeue() throws QueueEmptyException {
		Object ele;
		if (isEmpty()){
			throw new QueueEmptyException(DSAExceptionMsg.EmptyQueue);
		}
		ele = Q[f];
		Q[f] = null;
		f = (f+1) % capacity;
		return ele;
	}
	
	//取（并不删除）队首元素
	public Object peek() throws QueueEmptyException {
		if (isEmpty()){
			throw new QueueEmptyException(DSAExceptionMsg.EmptyQueue);
		}
		return Q[f];
	}
	
	//遍历（不属于ADT）
	public void traversal(){
		System.out.print("Queue: ");
		for (int i = f; i < r; i++){
			System.out.print(Q[i] + " ");
		}
		System.out.println();
	}
}