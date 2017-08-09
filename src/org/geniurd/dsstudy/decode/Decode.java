package org.geniurd.dsstudy.decode;

/**
 * https://algospot.com/judge/problem/read/DECODE
 */
public class Decode {
	private static final String SPLIT_CHAR = " ";
	private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public String decode(String code) {
		if (code == null) {
			return null;
		}

		String[] splitedCode = code.split(SPLIT_CHAR);
		if (splitedCode.length != 3) {
			throw new IllegalArgumentException("Invalid code : " + code);
		}

		int x = Integer.parseInt(splitedCode[0]);
		int y = Integer.parseInt(splitedCode[1]);
		char[] body = splitedCode[2].toCharArray();

		return decode(y, x, body);
	}

	private String decode(int xSize, int ySize, char[] code) {
		char[][] metrix = createMetrix(xSize, ySize, code);

		StringBuffer sb = new StringBuffer();
		char[] charBinary = new char[5];
		Point point = new Point(xSize, ySize);
		for (int i = 0; i < code.length; i++) {
			charBinary[i % 5] = metrix[point.y][point.x];
			point = point.next();
			if (i % 5 == 4) {
				sb.append(binaryToChar(charBinary));
			}
		}

		return sb.toString();
	}

	private char binaryToChar(char[] charBinary) {
		int alphabetIndex = 0;
		int p = 1;
		for (int i = 4; i >= 0; i--) {
			alphabetIndex += (charBinary[i] - '0') * p;
			p *= 2;
		}

		return ALPHABET.charAt(alphabetIndex);
	}

	private char[][] createMetrix(int xSize, int ySize, char[] code) {
		char[][] metrix = new char[ySize][xSize];

		int codeIndex = 0;
		for (int y = 0; y < ySize; y++) {
			for (int x = 0; x < xSize; x++) {
				metrix[y][x] = code[codeIndex++];
			}
		}

		return metrix;
	}

	private class Point {
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
			this.y = 0;

			this.leftBoundary = -1;
			this.rightBoundary = xSize;
			this.topBoundary = -1;
			this.bottomBoundary = ySize;
			this.add = 1;
			this.isXMove = true;
		}

		Point next() {
			if (isXMove) {
				x += add;
				if (x == rightBoundary) {
					x--;
					y++;
					topBoundary++;
					isXMove = false;
				}
				if (x == leftBoundary) {
					x++;
					y--;
					bottomBoundary--;
					isXMove = false;
				}
			} else {
				y += add;
				if (y == topBoundary) {
					y++;
					x++;
					leftBoundary++;
					add = 1;
					isXMove = true;
				}
				if (y == bottomBoundary) {
					y--;
					x--;
					rightBoundary--;
					add = -1;
					isXMove = true;
				}
			}

			return this;
		}
	}
}
