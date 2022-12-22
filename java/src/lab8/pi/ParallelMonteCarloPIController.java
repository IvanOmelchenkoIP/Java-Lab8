package lab8.pi;

import java.util.concurrent.CountDownLatch;

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
		int threadIterations = (ITERATIONS / threads);
		model.setParameters(ITERATIONS, threads, countdown);
		for (int i = 0; i < threads; i++) {
			new Thread(model.newPointThread()).start();
		}
		double pi;
		try {
			pi = model.getPI();
		} catch (InterruptedException exception) {
			view.showException(exception);
			return;
		}
		view.showPI(pi, threads, ITERATIONS, threadIterations);
	}
	
	public int iterations() {
		return ITERATIONS;
	}
}