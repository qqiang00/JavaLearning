package dsa;
import dsa.exceptions.*;

public interface Queue {
	public int getSize();		//获取队列尺寸
	public boolean isEmpty();	//是否空队列
	public Object peek() throws QueueEmptyException;	//瞥一眼(不取出)
	public void enqueue(Object obj)	throws QueueFullException;	//入队
	public Object dequeue() throws QueueEmptyException;	//出队
	public void traversal();	//遍历
}