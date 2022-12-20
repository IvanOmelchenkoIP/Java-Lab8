package lab8.pi;


public class ParallelMonteCarloPI {

	private final int ITERATIONS = 1000000;
	
	public double count(int threads) throws InterruptedException {
		SyncPoints syncPoints = new SyncPoints();
		int iterations = ITERATIONS / threads;
		ThreadPointCounter mc = new ThreadPointCounter(Math.round(ITERATIONS / threads), syncPoints);
		for (int i = 0; i < threads; i++) {
			Thread thread = new Thread(mc);
			thread.start();
			thread.join();
		}
		double pi = (syncPoints.getPoints() / Double.valueOf(ITERATIONS)) * 4;
		return pi;
	}
	
	public int iterations() {
		return ITERATIONS;
	}
}