package lab8;

import lab8.pi.*;
import scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		InputScanner scanner = new InputScanner();
		int threads = Integer.parseInt(scanner.scanInput("Input amount of threads: "));
		scanner.close();

		ParallelMonteCarloPIModel model = new ParallelMonteCarloPIModel();
		MonteCarloPIView view = new MonteCarloPIView();
		MonteCarloPIController parallelPI = new MonteCarloPIController(model, view);
		
		parallelPI.count(threads);
		//long start = System.currentTimeMillis();
		
		//long ms = System.currentTimeMillis() - start;
	}
}