package lab8.pi;

import java.util.concurrent.CountDownLatch;

public class ParallelMonteCarloPI {

	private final int ITERATIONS = 100000000;
	
	public double count(int threads) throws InterruptedException {
		CountDownLatch countdown = new CountDownLatch(threads);
		int threadIterations = Math.round(ITERATIONS / threads);
		SyncPoints syncPoints = new SyncPoints();
		//ThreadPointCounter counter = new ThreadPointCounter(threadIterations, syncPoints);
		for (int i = 0; i < threads; i++) {
			new Thread(new ThreadPointCounter(threadIterations, syncPoints, countdown)).start();
		}
		try {
			countdown.await();
			return (syncPoints.getPoints() / Double.valueOf(ITERATIONS)) * 4;
		} catch(InterruptedException exception) {
			throw exception;
		}
	}
	
	public int iterations() {
		return ITERATIONS;
	}
}