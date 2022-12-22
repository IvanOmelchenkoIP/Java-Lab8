package lab8.pi;

import java.util.concurrent.CountDownLatch;

public class ParallelMonteCarloPIModel {
	private final int ITERATIONS = 10000000;

	private final int CENTER_DISTANCE = 1;

	private final int iterations;
	private final SyncPoints syncPoints;

	private final CountDownLatch countdown;

	public ParallelMonteCarloPIModel(int iterations, SyncPoints pPoints, CountDownLatch countdown) {
		this.iterations = iterations;
		this.syncPoints = pPoints;
		this.countdown = countdown;
	}

	public Runnable newPointThread() {
		return new Runnable() {
			@Override
			public void run() {
				int points = 0;
				double distance = Double.valueOf(CENTER_DISTANCE);
				for (int i = 0; i < iterations; i++) {
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

	public double getPI() {
		try {
			countdown.await();
			return (syncPoints.getPoints() / Double.valueOf(ITERATIONS)) * 4;
		} catch (InterruptedException exception) {
			return 0;
		}
	}
}