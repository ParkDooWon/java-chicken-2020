package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static String input() {
		String input = SCANNER.nextLine();
		validateNumber(input);
		return input;
	}

	private static void validateNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
		}
	}
}
