package parallelprocessing;

import models.Aparcamiento;
import models.Empresa;

public class ParallelParkAcess {

	public static void main(String[] args) {

		Aparcamiento parking1 = new Aparcamiento("madrid", "Aparcamiento 1", 100000000);
		Aparcamiento parking2 = new Aparcamiento("barcelona", "Aparcamiento 2", 100000000);
		Empresa empresaValen = new Empresa("Valen");
		empresaValen.registrarAparcamiento(parking1);
		empresaValen.registrarAparcamiento(parking2);

		/* int numOfThreads = 2;
		Thread[] threads = new Thread[numOfThreads];
		for (int i = 0; i < numOfThreads; i++) {
			Thread t = new EntranceJob(parking1, "Justo" + i);
			threads[i] = t;
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < threads.length; i++) {

		}
		*/
		t1.start();
		t2.start();

		Thread t1 = new EntranceJob(parking1, "Justo");
		Thread t2 = new EntranceJob(parking1, "Camicha");
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			//e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		System.out.println(parking1.getCochesAparcados());

	}

}