/*
 * 基于双向链表实现双端队列结构
*/
package dsa;
import dsa.exceptions.*;

public class Deque_DLNode implements Deque{
	protected DLNode header;	//指向头节点(哨兵)
	protected DLNode trailer;	//指向尾节点(哨兵)
	protected int size;			//队列中元素的数目
	
	//构造函数
	public Deque_DLNode(){
		header = new DLNode();
		trailer = new DLNode();
		header.setNext(trailer);
		trailer.setPrev(header);
		size = 0;
	}
	
	//返回队列中元素数目
	public int getSize(){
		return size;
	}
	
	//判断队列是否为空
	public boolean isEmpty(){
		return (0 == size) ? true : false;
	}
	
	//取首元素(但不删除)
	public Object first() throws QueueEmptyException {
		if (isEmpty()) 
		{	throw new QueueEmptyException(DSAExceptionMsg.EmptyQueue);}
		return header.getNext().getElem();
	}
	
	//取末元素(但不删除)
	public Object last() throws QueueEmptyException {
		if (isEmpty()){
			throw new QueueEmptyException(DSAExceptionMsg.EmptyQueue);
		}
		return trailer.getPrev().getElem();			
	}
	
	//在队列前段插入新节点
	public void insertFirst(Object obj){
		DLNode second = header.getNext();
		DLNode first = new DLNode(obj, header, second);
		second.setPrev(first);
		header.setNext(first);
		size++;
	}
	
	//在队列后端插入新节点
	public void insertLast(Object obj){
		DLNode second = trailer.getPrev();
		DLNode first = new DLNode(obj, second, trailer);
		second.setNext(first);
		trailer.setPrev(first);
		size++;
	}
	
	//删除首节点
	public Object removeFirst() throws QueueEmptyException{
		if (isEmpty()){
			throw new QueueEmptyException(DSAExceptionMsg.EmptyQueue)
		}
		DLNode first = header.getNext();
		DLNode second = first.getNext();
		Object obj = first.getElem();
		header.setNext(second);
		second.setPrev(header);
		size--;
		return obj;
	}
	
	//删除末节点
	public Object removeLast() throws QueueEmptyException{
		if(isEmpty()){
			throw new QueueEmptyException(DSAExceptionMsg.EmptyQueue);
		}
		DLNode first = trailer.getPrev();
		DLNode second = first.getPrev();
		Object obj = first.getElem();
		trailer.setPrev(second);
		second.setNext(trailer);
		size--;
		return obj;
	}
	
	//遍历
	public void traversal(){
		DLNode p = header.getNext();
		while (p != trailer){
			System.out.print(p.getElem() + " ");
			p = p.getNext();
		}
		System.out.println();
	}
	
}