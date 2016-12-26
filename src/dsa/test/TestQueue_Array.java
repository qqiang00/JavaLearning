package dsa.test;

import dsa.Queue_Array;

public class TestQueue_Array{

	public static void buildQueue(Queue_Array q){
		//构造一个长度为20的队列
		try{
		q.enqueue(9);
		q.enqueue(3);
		q.dequeue();
		q.enqueue(5);
		q.dequeue();
		q.peek();
		q.dequeue();
		//q.dequeue();	# QueueEmptyException
		q.enqueue(8);
		q.enqueue(4);
		q.enqueue(11);
		q.enqueue(9);
		q.dequeue();
		q.enqueue(15);
		q.enqueue(17);
		}catch(RuntimeException e){
			System.out.println(e);
		}
		q.traversal();
	}
	static void Serve(Object e){
		System.out.println("Serve: "+ e);
	}
	//循环分配器
	public static void roundRobin(Queue_Array q){
		Object e = q.dequeue();
		Serve(e);
		q.enqueue(e);
	}
	
	public static void main(String[] args){
		Queue_Array q = new Queue_Array(10);
		buildQueue(q);
		for (int i = 0; i < 20; i++){
			roundRobin(q);
		}
	}
}
