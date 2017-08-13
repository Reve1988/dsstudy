package org.geniurd.dsstudy.number;

import org.geniurd.dsstudy.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode nextResultNode = new ListNode(0);
		ListNode rootResultNode = nextResultNode;

		int up = 0;
		while (true) {
			int l1Value = l1 != null ? l1.val : 0;
			int l2Value = l2 != null ? l2.val : 0;

			int sum = l1Value + l2Value + up;
			nextResultNode.val = sum % 10;
			up = sum / 10;

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
			if (l1 == null && l2 == null && up == 0) {
				break;
			}

			nextResultNode.next = new ListNode(0);
			nextResultNode = nextResultNode.next;
		}

		return rootResultNode;
	}
}
