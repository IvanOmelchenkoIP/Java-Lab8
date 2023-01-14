package lab8.pi;

import java.util.SplittableRandom;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import lab8.exceptions.ThreadAmountException;

public class ParallelMonteCarloPIModel {

	private final int CENTER_DISTANCE = 1;

	private final SplittableRandom random = new SplittableRandom();
	
	private AtomicInteger points = new AtomicInteger(0);
	private CountDownLatch barrier;
			
	private Runnable newPointThread(int threadIterations) {
		return new Runnable() {
			
			@Override
			public void run() {
				int threadPts = 0;
				for (int i = 0; i < threadIterations; i++) {
					double x = random.nextDouble();
					double y = random.nextDouble();
					if (x * x + y * y < CENTER_DISTANCE) {
						++threadPts;
					}
				}
				points.addAndGet(threadPts);
				barrier.countDown();
				
			}
		};
	}

	public double countPI(int iterations, int threads) throws InterruptedException, ThreadAmountException {		
		if (threads > iterations) {
			throw new ThreadAmountException("Specified thread amount is more than possible points to throw!");
		}
		int threadIterations = (int) Math.ceil(iterations / threads);
		
		barrier = new CountDownLatch(threads);
		for (int i = 0; i < threads; i++) {
			new Thread(newPointThread(threadIterations)).start();
		}

		barrier.await();
		return (points.intValue() / Double.valueOf(iterations)) * 4;
	}
}