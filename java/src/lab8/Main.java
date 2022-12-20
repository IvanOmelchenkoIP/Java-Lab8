package lab8;

import lab8.pi.MonteCarloPI;
import lab8.pi.MonteCarloPIManager;
import scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		InputScanner scanner = new InputScanner();
		int threads = Integer.parseInt(scanner.scanInput("Input amount of threads: "));
		scanner.close();

		MonteCarloPIManager mc = new MonteCarloPIManager();
		long start = System.currentTimeMillis();
		mc.count(threads);
		long ms = System.currentTimeMillis() - start;
		
		
		
		
		
		//System.out.println("PI:" + value);
		System.out.println("THREADS: " + threads);
		System.out.println("ITERATIONS: " + 1000);
		System.out.println("TIME: " + ms + "ms");
	}

}
