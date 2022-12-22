package lab8.pi;

import java.util.concurrent.CountDownLatch;

public class MonteCarloPIManager {

	private final int ITERATIONS = 10000000;
	
	public double count(int threads) throws InterruptedException {
		CountDownLatch countdown = new CountDownLatch(threads);
		int threadIterations = Math.round(ITERATIONS / threads);
		SyncPoints syncPoints = new SyncPoints();
		ParallelMonteCarloPI counter = new ParallelMonteCarloPI(threadIterations, syncPoints, countdown);
		for (int i = 0; i < threads; i++) {
			new Thread(counter.newPointThread()).start();
		}
		return counter.getPI();
	}
	
	public int iterations() {
		return ITERATIONS;
	}
}