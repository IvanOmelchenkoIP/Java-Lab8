package lab8.pi;

import java.util.concurrent.CountDownLatch;

public class MonteCarloPIController {

	private final int ITERATIONS = 10000000;
	
	private ParallelMonteCarloPIModel model;
	private MonteCarloPIView view;
	
	public MonteCarloPIController(ParallelMonteCarloPIModel model, MonteCarloPIView view) {
		this.model = model;
		this.view = view;
	}
	
	public void count(int threads) {
		CountDownLatch countdown = new CountDownLatch(threads);
		int threadIterations = (ITERATIONS / threads);
		SyncPoints syncPoints = new SyncPoints();
		model.setParameters(ITERATIONS, threads, syncPoints, countdown);
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