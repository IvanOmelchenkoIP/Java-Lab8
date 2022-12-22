package lab8.pi;


public class ParallelMonteCarloPI {

	private final int ITERATIONS = 100000000;
	
	public double count(int threads) throws InterruptedException {
		int threadIterations = Math.round(ITERATIONS / threads);
		SyncPoints syncPoints = new SyncPoints();
		ThreadPointCounter counter = new ThreadPointCounter(threadIterations, syncPoints);
		for (int i = 0; i < threads; i++) {
			Thread thread = new Thread(counter);
			thread.start();
			thread.join();
		}
		return (syncPoints.getPoints() / Double.valueOf(ITERATIONS)) * 4;
	}
	
	public int iterations() {
		return ITERATIONS;
	}
}