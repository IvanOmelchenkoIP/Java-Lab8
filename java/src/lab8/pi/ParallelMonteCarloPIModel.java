package lab8.pi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelMonteCarloPIModel {

	private final int CENTER_DISTANCE = 1;

	public AtomicInteger points = new AtomicInteger(0);
	
	private boolean canRun = false;
	
	private int iterations;
	private int threadIterations;
	private CountDownLatch countdown;

	public void setParameters(int iterations, int threads, CountDownLatch barrier) {
		if (this.canRun) return;
		this.canRun = true;
		this.iterations = iterations;
		this.threadIterations = (int) Math.ceil(iterations / threads);
		this.countdown = barrier;
	}
	
	public Runnable newPointThread() {
		return new Runnable() {
			@Override
			public void run() {
				//double distance = Double.valueOf(CENTER_DISTANCE);
				for (int i = 0; i < threadIterations; i++) {
					double x = Math.random();
					double y = Math.random();
					/*if (points.intValue() % 100000 == 0)
						System.out.println(Thread.currentThread().getName());*/
					if (x * x + y * y < CENTER_DISTANCE) {
						points.addAndGet(1);
					}
				}
				countdown.countDown();
			}
		};
	}

	public double getPI() throws InterruptedException {
		try {
			countdown.await();
			return (points.intValue() / Double.valueOf(iterations)) * 4;
		} catch (InterruptedException exception) {
			throw exception;
		}
	}
}