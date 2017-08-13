package org.geniurd.dsstudy;

import org.geniurd.dsstudy.number.AddTwoNumbers;

public class Main {
	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		a.next = new ListNode(4);
		a.next.next = new ListNode(3);

		ListNode b = new ListNode(5);
		b.next = new ListNode(6);
		b.next.next = new ListNode(4);

		ListNode sum = new AddTwoNumbers().addTwoNumbers(a, b);

		a.print();
		b.print();
		sum.print();
	}
}
