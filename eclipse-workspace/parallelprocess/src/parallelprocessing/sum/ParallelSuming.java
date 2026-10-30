package parallelprocessing.sum;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelSuming {
	
	public static void main(String[] args) {
		ExecutorService executorService =
		
		Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		Runnable taskRunnable = () -> {
			System.out.println("thread name is : " + Thread.currentThread().getName());
		};
		
		executorService.submit(taskRunnable);
		executorService.submit(taskRunnable);
		executorService.submit(taskRunnable);
		executorService.submit(taskRunnable);

		
		Thread thread;
	}

}
