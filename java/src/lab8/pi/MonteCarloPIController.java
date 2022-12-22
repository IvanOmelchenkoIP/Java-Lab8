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
		int threadIterations = Math.round(ITERATIONS / threads);
		SyncPoints syncPoints = new SyncPoints();
		ParallelMonteCarloPIModel counter = new ParallelMonteCarloPIModel(threadIterations, syncPoints, countdown);
		for (int i = 0; i < threads; i++) {
			new Thread(counter.newPointThread()).start();
		}
		double pi = counter.getPI();
		view.showPI(pi, threads, ITERATIONS, threadIterations)
	}
	
	public int iterations() {
		return ITERATIONS;
	}
}