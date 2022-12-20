package lab8;

import lab8.pi.MonteCarloPI;
import scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		InputScanner scanner = new InputScanner();
		int threads = Integer.parseInt(scanner.scanInput("Input amount of threads: "));
		scanner.close();

		MonteCarloPI pi = new MonteCarloPI();
		System.out.println(pi.count());

	}

}
