package org.geniurd.dsstudy;

import org.geniurd.dsstudy.number.AddTwoNumbers;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();

		a.add(2);
		a.add(4);
		a.add(3);
		b.add(5);
		b.add(6);
		b.add(4);

		LinkedList<Integer> result = AddTwoNumbers.add(a, b);
		System.out.println(result.toString());
	}
}
