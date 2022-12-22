package lab8.pi;

public class ParallelMonteCarloPIView {

	public void showPI(double pi, int threads, int iterations, int ms) {
		System.out.println("PI: " + pi);
		System.out.println("THREADS: " + threads);
		System.out.println("ITERATIONS: " + iterations);
		System.out.println("TIME: " + ms + "ms");
	}
	
	public void showException(InterruptedException exception) {
		System.out.println("An Error Occurred!\n" + exception.getMessage());
	}
}
