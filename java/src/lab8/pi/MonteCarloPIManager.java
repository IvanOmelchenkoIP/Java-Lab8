package lab8.pi;


public class MonteCarloPIManager {

	private final int ITERATIONS = 1000000;
	
	public void count(int threads) throws InterruptedException {
		PIPoints pPoints = new PIPoints();
		int iterations = ITERATIONS / threads;
		MonteCarloParallel mc = new MonteCarloParallel(Math.round(ITERATIONS / threads), pPoints);
		for (int i = 0; i < threads; i++) {
			Thread thread = new Thread(mc);
			thread.start();
			thread.join();
		}
		double pi = (pPoints.getPoints() / Double.valueOf(ITERATIONS)) * 4;
		System.out.println(pi);
	}
}