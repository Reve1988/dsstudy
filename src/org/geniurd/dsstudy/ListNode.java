package org.geniurd.dsstudy;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public void print() {
		ListNode node = this;
		while (node != null) {
			System.out.print(node.val);
			node = node.next;
			if (node != null) {
				System.out.print(" -> ");
			}
		}

		System.out.println();
	}
}
