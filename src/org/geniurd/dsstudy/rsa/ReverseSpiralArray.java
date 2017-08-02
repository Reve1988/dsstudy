package org.geniurd.dsstudy.rsa;

public class ReverseSpiralArray {
	private static void print(int[][] array) {
		for (int[] x : array) {
			for (int num : x) {
				System.out.print(String.format("%3d", num));
			}
			System.out.print("\n");
		}
	}

	public static void print(int xSize, int ySize) {
		int[][] rsa = new int[ySize][xSize];
		Point point = new Point(xSize, ySize);

		for (int num = (xSize * ySize) - 1; num >= 0; num--) {
			rsa[point.y][point.x] = num;
			point.move();
		}

		print(rsa);
	}

	private static class Point {
		private int xSize;
		private int ySize;

		private int x;
		private int y;

		private int leftBoundary;
		private int rightBoundary;
		private int topBoundary;
		private int bottomBoundary;
		private int add;
		private boolean isXMove;

		Point(int xSize, int ySize) {
			this.xSize = xSize;
			this.ySize = ySize;

			this.x = 0;
			this.y = ySize - 1;

			this.leftBoundary = -1;
			this.rightBoundary = xSize;
			this.topBoundary = -1;
			this.bottomBoundary = ySize;
			this.add = 1;
			this.isXMove = true;
		}

		void move() {
			if (isXMove) {
				x += add;
				if (x == rightBoundary) {
					x--;
					y--;
					bottomBoundary--;
					add = -1;
					isXMove = false;
				}

				if (x == leftBoundary) {
					x++;
					y++;
					topBoundary++;
					add = 1;
					isXMove = false;
				}
			} else {
				y += add;
				if (y == topBoundary) {
					y++;
					x--;
					rightBoundary--;
					isXMove = true;
				}

				if (y == bottomBoundary) {
					y--;
					x++;
					leftBoundary++;
					isXMove = true;
				}
			}
		}
	}
}
