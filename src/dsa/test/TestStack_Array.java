package dsa.test;

import dsa.*;
import dsa.exceptions.*;

public class TestStack_Array{
	//使用List实现的栈来反转数组
	public static void reverseArray2(){
		Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Stack_List s = new Stack_List();
		Integer[] b = new Integer[a.length];
		for (int i = 0; i<a.length; i++){ s.push(a[i]); }
		for (int i = 0; i<a.length; i++){ b[i] = (Integer)s.pop(); }
		for (int i = 0; i<b.length; i++){ System.out.print(b[i] + " "); }
		System.out.println();		
	}
	public static void reverseArray(){
		Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Stack_Array s = new Stack_Array(a.length);
		Integer[] b = new Integer[a.length];
		for (int i = 0; i<a.length; i++){ s.push(a[i]); }
		for (int i = 0; i<a.length; i++){ b[i] = (Integer)s.pop(); }
		for (int i = 0; i<b.length; i++){ System.out.print(b[i] + " "); }
		System.out.println();
	}
	public static void main(String[] args){
		reverseArray();
		reverseArray2();
	}
}