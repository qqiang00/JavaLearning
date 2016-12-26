package dsa.test;

import dsa.*;

/* Josephus 环
 * 一群小孩围成圈，一个山芋在其间传递。有一个计数器，每计数一次，拿着山芋的孩子把山芋交给
 * 右边的邻居，当数到某特定的数暂停，此时拿着山芋的小孩退出。然后重新开始数数。如此不断
 * 重复，直到剩下最后一个孩子 * 
 */
public class TestQueue_Josephus{
	public static Object Josephus(Queue q, int k){
		if (q.isEmpty())	return null;
		while (q.getSize() > 1){	//不断迭代
			q.traversal();	//显示当前的环
			for (int i = 0; i < k; i++){	//将山芋向前传递k次
				q.enqueue(q.dequeue());
			}
			Object e = q.dequeue(); //拿着山芋的孩子退出
			System.out.println("  " + e + " 退出");
		}
		return q.dequeue();	//最后剩下的那个孩子
	}
	
	//将一组对象组织为一个队列
	public static Queue buildQueue(Object a[]){
		Queue q = new Queue_Array();
		for (int i = 0; i < a.length; i++){
			q.enqueue(a[i]);
		}
		return q;
	}
	
	//测试方法
	public static void main(String[] args){
		String[] kids = {"Alice", "Bob", "Cindy", "Fred", "Gene", "Hope", "Kim",
			"Lance", "Mike", "Doug", "Irene", "Nancy", "Ed", "Jack", "Ollie"};
		Object luckiest_kid = Josephus(buildQueue(kids),5);
		System.out.println("最终的幸运者是: " + luckiest_kid);
	}
}