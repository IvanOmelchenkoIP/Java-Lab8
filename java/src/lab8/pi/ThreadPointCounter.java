package lab8.pi;

import java.util.concurrent.CountDownLatch;

public class ThreadPointCounter implements Runnable {

	private final int CENTER_DISTANCE = 1;

	private final int iterations;
	private final SyncPoints syncPoints;
	
	private final CountDownLatch countdown;

	public ThreadPointCounter(int iterations, SyncPoints pPoints, CountDownLatch countdown) {
		this.iterations = iterations;
		this.syncPoints = pPoints;
		this.countdown = countdown;
	}
	
	@Override
	public void run() {
		int points = 0;
		double distance = Double.valueOf(CENTER_DISTANCE);
		for (int i = 0; i < iterations; i++) {
			double x = Math.random();
			double y = Math.random();
			if (points % 100000 == 0) System.out.println(Thread.currentThread().getName());
			if (x*x + y*y < distance) points += 1;  
			/*if (Math.pow(Math.random(), 2) + Math.pow(Math.random(), 2) <= Double.valueOf(CENTER_DISTANCE)) {
				syncPoints.add(1);
			}*/
		}
		syncPoints.add(points);
		countdown.countDown();
	}
}