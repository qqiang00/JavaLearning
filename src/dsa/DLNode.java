/*
 * 基于位置接口实现的双向链表节点类
 */
package dsa;

public class DLNode implements Position{
	private Object elem;	//数据对象
	private DLNode prev;	//指向前驱节点
	private DLNode next;	//指向后继节点
	
	public DLNode()	{	this(null, null, null);	}
	
	public DLNode(Object e, DLNode p, DLNode n){
		elem = e;	prev = p; next = n;
	}
	
	public Object getElem() {	return elem;	}
	public Object setElem(Object e){
		Object oldElem = elem; elem = e; return oldElem;
	}
	public DLNode getNext() {	return next;	}
	public DLNode getPrev()	{	return prev;	}
	public void setNext(DLNode newNext) {	next = newNext;	}
	public void setPrev(DLNode newPrev)	{	prev = newPrev;	}
}