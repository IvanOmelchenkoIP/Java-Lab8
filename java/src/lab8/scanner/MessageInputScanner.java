package lab8.scanner;

import java.util.Scanner;

public class MessageInputScanner {

	private Scanner scanner;

	public MessageInputScanner() {
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