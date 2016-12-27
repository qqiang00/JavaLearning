/*
 * 双端队列接口
 */
package dsa;
import dsa.exceptions.*;

public interface Deque{
	public int getSize();	//返回队列中的元素
	public boolean isEmpty();
	public Object first() throws QueueEmptyException; //取首元素(不删除)
	public Object last() throws QueueEmptyException; //取尾元素(不删除)
	public void insertFirst(Object obj);	//将新元素作为首元素插入
	public void insertLast(Object obj);		//将新元素作为末元素插入
	public Object removeFirst() throws QueueEmptyException;
	public Object removeLast() throws QueueEmptyException;
	public void traversal();		//遍历
}

