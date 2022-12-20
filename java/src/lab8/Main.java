package lab8;

import lab8.pi.MonteCarloPI;
import scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		InputScanner scanner = new InputScanner();
		int threads = Integer.parseInt(scanner.scanInput("Input amount of threads: "));
		scanner.close();

		MonteCarloPI pi = new MonteCarloPI();
		long start = System.currentTimeMillis();
		double value = pi.count();
		long ms = System.currentTimeMillis() - start;
		
		System.out.println("PI:" + value);
		System.out.println("THREADS: " + threads);
		System.out.println("ITERATIONS: " + 1000);
		System.out.println("TIME: " + ms + "ms");
	}

}
