package lab8;

import lab8.pi.MonteCarloPI;
import lab8.pi.MonteCarloParallel;
import scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		InputScanner scanner = new InputScanner();
		int threads = Integer.parseInt(scanner.scanInput("Input amount of threads: "));
		scanner.close();

		MonteCarloPI pi = new MonteCarloPI();
		long start = System.currentTimeMillis();
		//double value = pi.count();
		long ms = System.currentTimeMillis() - start;
		
		MonteCarloParallel mc = new MonteCarloParallel();
		
		for (int i = 0; i < threads; i++) {
			Thread thread = new Thread(mc);
			thread.start();
			System.out.println(mc.getPi());
		}
		
		//System.out.println("PI:" + value);
		System.out.println("THREADS: " + threads);
		System.out.println("ITERATIONS: " + 1000);
		System.out.println("TIME: " + ms + "ms");
	}

}
