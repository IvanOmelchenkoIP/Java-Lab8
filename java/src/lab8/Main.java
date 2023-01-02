package lab8;

import lab8.pi.*;
import lab8.scanner.MessageInputScanner;
import lab8.timer.TimeCounter;

public class Main {

	public static void main(String[] args) {
		MessageInputScanner scanner = new MessageInputScanner();
		int threads = Integer.parseInt(scanner.scanInput("Input amount of threads: "));
		scanner.close();

		ParallelMonteCarloPIModel model = new ParallelMonteCarloPIModel();
		ParallelMonteCarloPIView view = new ParallelMonteCarloPIView();
		ParallelMonteCarloPIController parallelPI = new ParallelMonteCarloPIController(model, view);
		
		TimeCounter<Integer> timer = new TimeCounter<Integer>();
		long ms = timer.countTime(threadCount -> parallelPI.count(threadCount), threads);
		System.out.println("TIME: " + ms + "ms");
	}
}