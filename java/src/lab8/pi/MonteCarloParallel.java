package lab8.pi;

public class MonteCarloParallel implements Runnable{

	private final double CENTER_X = 0;
	private final double CENTER_Y = 0;

	private final int CENTER_DISTANCE = 1;
	private final int iterations;
	
	public MonteCarloParallel(int iterations) {
		this.iterations = iterations;
		
	}
	
	@Override
	public void run() {
		int points = 0;
		for (int i = 0; i < iterations; i++) {
			double x = Math.random();
			double y = Math.random();
			double distance = Math.pow((x - CENTER_X), 2) + Math.pow((y - CENTER_Y), 2);
			if (distance < Double.valueOf(CENTER_DISTANCE)) {
				points += 1;
			}
		}
		double pi = (points / Double.valueOf(iterations)) * 4;
	}
	
}
