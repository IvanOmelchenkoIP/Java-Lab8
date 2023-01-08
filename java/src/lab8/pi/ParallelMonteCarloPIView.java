package lab8.pi;

public class ParallelMonteCarloPIView {

	public void showPI(double pi, int threads, int iterations) {
		System.out.println("PI: " + pi);
		System.out.println("THREADS: " + threads);
		System.out.println("ITERATIONS: " + iterations);
	}
	
	public void showException(Exception exception) {
		System.out.println("An Error Occurred!\n" + exception.getMessage());
	}
}
