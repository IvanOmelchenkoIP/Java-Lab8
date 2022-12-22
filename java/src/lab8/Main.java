package lab8;

import lab8.pi.ParallelMonteCarloPI;
import scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		InputScanner scanner = new InputScanner();
		int threads = Integer.parseInt(scanner.scanInput("Input amount of threads: "));
		scanner.close();

		ParallelMonteCarloPI parallelPI = new ParallelMonteCarloPI();
		long start = System.currentTimeMillis();
		double pi;
		try {
			pi = parallelPI.count(threads);
		} catch(Exception exception) {
			System.out.print(exception);
			return;
		}
		long ms = System.currentTimeMillis() - start;
		
		System.out.println("PI: " + pi);
		System.out.println("THREADS: " + threads);
		System.out.println("ITERATIONS: " + parallelPI.iterations());
		System.out.println("TIME: " + ms + "ms");
	}

}