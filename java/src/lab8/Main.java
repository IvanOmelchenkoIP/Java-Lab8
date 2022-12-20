package lab8;

import lab8.pi.MonteCarloPIManager;
import scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		InputScanner scanner = new InputScanner();
		int threads = Integer.parseInt(scanner.scanInput("Input amount of threads: "));
		scanner.close();

		MonteCarloPIManager mc = new MonteCarloPIManager();
		long start = System.currentTimeMillis();
		double pi;
		try {
			pi = mc.count(threads);
		} catch(Exception ex) {
			System.out.print(ex);
			return;
		}
		long ms = System.currentTimeMillis() - start;
		
		System.out.println("PI:" + pi);
		System.out.println("THREADS: " + threads);
		System.out.println("ITERATIONS: " + mc.iterations());
		System.out.println("TIME: " + ms + "ms");
	}

}
