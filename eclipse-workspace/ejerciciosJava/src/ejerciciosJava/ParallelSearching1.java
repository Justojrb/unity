package ejerciciosJava;
 
import java.util.Random;
 
public class ParallelSearching1 {
 
	// Variable compartida por los dos hilos: avisa cuando alguien ya encontró el número.
	// static  -> es una sola para toda la clase (ambos hilos ven la misma)
	// volatile -> el cambio hecho por un hilo es visible de inmediato para el otro
	private static volatile boolean encontrado = false;
 
	public static void main(String[] args) throws InterruptedException {
 
		Random generador = new Random();
 
		int[] numeros = new int[1000];
 
		for (int indice = 0; indice < numeros.length; indice++) {
			numeros[indice] = generador.nextInt(1000);
		}
 
		int objetivo = 500;
 
		// Punto medio: el hilo 1 recorre [0, mitad) y el hilo 2 recorre [mitad, length)
		int mitad = numeros.length / 2;
 
		System.out.println("Número seleccionado: " + objetivo);
		System.out.println("Buscando en el array con dos hilos...");
 
		Thread buscador1 = new Thread(new Runnable() {
 
			@Override
			public void run() {
				buscar("Hilo 1", numeros, objetivo, 0, mitad);
			}
		});
 
		Thread buscador2 = new Thread(new Runnable() {
 
			@Override
			public void run() {
				buscar("Hilo 2", numeros, objetivo, mitad, numeros.length);
			}
		});
 
		buscador1.start();
		buscador2.start();
 
		// El main espera a que ambos hilos terminen antes de dar el resultado final
		buscador1.join();
		buscador2.join();
 
		if (!encontrado) {
			System.out.println("El número no se ha encontrado");
		}
	}
 
	// Lógica de búsqueda de SequentialSearching, ahora limitada a un rango [inicio, fin)
	private static void buscar(String nombre, int[] numeros, int objetivo, int inicio, int fin) {
 
		System.out.println(nombre + " recorre desde la posición " + inicio + " hasta la " + (fin - 1));
 
		for (int pos = inicio; pos < fin; pos++) {
 
			// Si el otro hilo ya encontró el número, este hilo se detiene
			if (encontrado) {
				System.out.println(nombre + " se detiene porque el otro hilo ya encontró el número (iba en la posición " + pos + ")");
				return;
			}
 
			if (numeros[pos] == objetivo) {
				encontrado = true; // avisa al otro hilo
				System.out.println(nombre + " encontró el número " + objetivo + " en la posición " + pos);
				return;
			}
		}
 
		System.out.println(nombre + " terminó su mitad sin encontrar el número");
	}
}
