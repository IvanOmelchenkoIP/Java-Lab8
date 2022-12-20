package scanner;

import java.util.Scanner;

public class InputScanner {

	private Scanner scanner;

	public InputScanner() {
		scanner = new Scanner(System.in);
	}

	public String scanInput(String message) {
		System.out.print(message);
		return scanner.nextLine();
	}

	public void close() {
		scanner.close();
	}
}