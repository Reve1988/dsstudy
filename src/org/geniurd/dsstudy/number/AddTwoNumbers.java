package org.geniurd.dsstudy.number;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
	public static LinkedList<Integer> add(LinkedList<Integer> a, LinkedList<Integer> b) {
		LinkedList<Integer> result = new LinkedList<Integer>();

		int up = 0;
		ListIterator<Integer> aIter = a.listIterator();
		ListIterator<Integer> bIter = b.listIterator();
		while(aIter.hasNext() || bIter.hasNext() || up != 0) {
			int x = aIter.hasNext() ? aIter.next() : 0;
			int y = bIter.hasNext() ? bIter.next() : 0;

			int z = x + y + up;
			result.add(z % 10);
			up = z / 10;
		}

		return result;
	}
}
