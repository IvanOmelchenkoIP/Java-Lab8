package lab8.pi;

import java.util.concurrent.CountDownLatch;

public class ParallelMonteCarloPIModel {

	private final int CENTER_DISTANCE = 1;

	private boolean canRun = false;
	
	private int iterations;
	private int threadIterations;
	private SyncPoints syncPoints;
	private CountDownLatch countdown;

	public void setParameters(int iterations, int threads, SyncPoints syncPoints, CountDownLatch barrier) {
		if (this.canRun) return;
		this.canRun = true;
		this.iterations = iterations;
		this.threadIterations = (int) Math.ceil(iterations / threads);
		this.syncPoints = syncPoints;
		this.countdown = barrier;
	}

	public Runnable newPointThread() {
		return new Runnable() {
			@Override
			public void run() {
				int points = 0;
				double distance = Double.valueOf(CENTER_DISTANCE);
				for (int i = 0; i < threadIterations; i++) {
					double x = Math.random();
					double y = Math.random();
					if (points % 100000 == 0)
						System.out.println(Thread.currentThread().getName());
					if (x * x + y * y < distance)
						points += 1;
				}
				syncPoints.add(points);
				countdown.countDown();
			}
		};
	}

	public double getPI() throws InterruptedException {
		try {
			countdown.await();
			return (syncPoints.getPoints() / Double.valueOf(iterations)) * 4;
		} catch (InterruptedException exception) {
			throw exception;
		}
	}
}