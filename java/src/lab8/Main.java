package lab8;

import lab8.pi.*;
import scanner.InputScanner;

public class Main {

	public static void main(String[] args) {
		InputScanner scanner = new InputScanner();
		int threads = Integer.parseInt(scanner.scanInput("Input amount of threads: "));
		scanner.close();

		ParallelMonteCarloPIModel model = new ParallelMonteCarloPIModel();
		ParallelMonteCarloPIView view = new ParallelMonteCarloPIView();
		ParallelMonteCarloPIController parallelPI = new ParallelMonteCarloPIController(model, view);
		
		parallelPI.count(threads);
		//long start = System.currentTimeMillis();
		
		//long ms = System.currentTimeMillis() - start;
	}
}