package lab8.pi;

public class MonteCarloPIView {

	public void showPI(double pi, int threads, int iterations, int ms) {
		System.out.println("PI: " + pi);
		System.out.println("THREADS: " + threads);
		System.out.println("ITERATIONS: " + iterations);
		System.out.println("TIME: " + ms + "ms");
	}
}
