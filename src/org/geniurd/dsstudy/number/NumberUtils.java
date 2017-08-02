package org.geniurd.dsstudy.number;

public class NumberUtils {
	private static final int ASCII_ZERO = 48;
	private static final int ASCII_A = 65;

	/**
	 * 숫자를 n진법으로 바꿔주는 함수
	 *
	 * @param number       변경할 숫자
	 * @param numberSystem 2 ~ 16 진법
	 * @return 진법 변환된 숫자
	 */
	public static String toNumberSystem(int number, int numberSystem) {
		if (number == 0) {
			return "0";
		}

		return new String(div(number, numberSystem, 0));
	}

	private static char[] div(int number, int numberSystem, int depth) {
		if ((number / numberSystem) == 0) {
			char[] result = new char[depth + 1];
			result[0] = intToString(number);

			return result;
		}

		char[] result = div((number / numberSystem), numberSystem, depth + 1);
		result[result.length - depth - 1] = intToString(number % numberSystem);

		return result;
	}

	private static char intToString(int digit) {
		if (digit < 10) {
			return (char) (digit + ASCII_ZERO);
		}

		return (char) ((digit - 10) + ASCII_A);
	}
}
