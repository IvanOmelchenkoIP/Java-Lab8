package lab8.pi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelMonteCarloPIModel {

	private final int CENTER_DISTANCE = 1;

	private AtomicInteger points = new AtomicInteger(0);
		
	private int iterations;
	private int threadIterations;
	private CountDownLatch barrier;

	public void setParameters(int iterations, int threads) {
		this.iterations = iterations;
		this.threadIterations = (int) Math.ceil(iterations / threads);
		this.barrier = new CountDownLatch(threads);
	}
		
	public Runnable newPointThread() {
		return new Runnable() {
			
			@Override
			public void run() {
				int threadPts = 0;
				for (int i = 0; i < threadIterations; i++) {
					double x = Math.random();
					double y = Math.random();
					if (x * x + y * y < CENTER_DISTANCE) {
						++threadPts;
					}
				}
				points.addAndGet(threadPts);
				barrier.countDown();
			}
		};
	}

	public double getPI() throws InterruptedException {
		try {
			barrier.await();
			return (points.intValue() / Double.valueOf(iterations)) * 4;
		} catch (InterruptedException exception) {
			throw exception;
		}
	}
}