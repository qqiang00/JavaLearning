package dsa;

public class Node implements Position {
	private Object elem;	//数据对象
	private Node next;		//指向后继节点
	
	public Node(){
		this(null, null);
	}
	
	//构造一个节点，指定该节点的元素和后继节点
	public Node(Object e, Node n){
		elem = e;
		next = n;
	}
	
	//返回存放于该位置的元素
	public Object getElem() { return elem; }
	
	//将给定元素存放至该位置，返回此前存放的元素
	public Object setElem(Object e){
		Object oldElem = elem;
		elem = e;
		return oldElem;
	}
	
	//获取当前节点的后继节点
	public Node getNext(){
		return next;
	}
	
	//修改当前节点的后继节点
	public void setNext(Node newNext){
		next = newNext;
	}
}