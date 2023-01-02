package lab8.pi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelMonteCarloPIController {

	private final int ITERATIONS = 10000000;
	
	private ParallelMonteCarloPIModel model;
	private ParallelMonteCarloPIView view;
	
	public ParallelMonteCarloPIController(ParallelMonteCarloPIModel model, ParallelMonteCarloPIView view) {
		this.model = model;
		this.view = view;
	}
	
	public void count(int threads) {
		CountDownLatch countdown = new CountDownLatch(threads);
		model.setParameters(ITERATIONS, threads, countdown);
		for (int i = 0; i < threads; i++) {
			new Thread(model.newPointThread()).start();
		}
		try {
			double pi = model.getPI();
			view.showPI(pi, threads, ITERATIONS);
		} catch (InterruptedException exception) {
			view.showException(exception);
		}
	}
}