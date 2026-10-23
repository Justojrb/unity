package ejerciciosJava;

import java.util.Random;

public class Ejercicio {

	public static void main(String[] args) {

		Random generador = new Random();

		int[] numeros = new int[1000];

		for (int indice = 0; indice < numeros.length; indice++) {
			numeros[indice] = generador.nextInt(1000);
		}

		int objetivo = 500;

		Thread buscador = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("Número seleccionado: " + objetivo);

				System.out.println("Buscando en el array...");

				boolean hallado = false;

				for (int pos = 0; pos < numeros.length; pos++) {

					if (numeros[pos] == objetivo) {
						System.out.println("Se encontró el número " + objetivo + " en la posición " + pos);

						hallado = true;
					}
				}

				if (!hallado) {
					System.out.println("El número no se ha encontrado");
				}
			}
		});

		buscador.start();
	}
}