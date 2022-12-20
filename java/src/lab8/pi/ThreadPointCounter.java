package lab8.pi;

import java.util.Random;

public class ThreadPointCounter implements Runnable{
	
	private final int CENTER_DISTANCE = 1;
	
	private final int iterations;
	private final SyncPoints syncPoints;
	
	public ThreadPointCounter(int iterations, SyncPoints pPoints) {
		this.iterations = iterations;
		this.syncPoints = pPoints;
	}
	
	@Override
	public void run() {
		int points = 0;
		for (int i = 0; i < iterations; i++) {
			double x = Math.random();
			double y = Math.random();
			if ((x*x + y*y) < CENTER_DISTANCE) {
				points += 2;
			}
		}
		syncPoints.add(points);
	}
	
}
