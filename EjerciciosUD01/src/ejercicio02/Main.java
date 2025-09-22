package ejercicio02;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd= new Random(System.nanoTime());
		
		int tam=10, numSusp=0, numApr=0;
		float sumNota=0, notaMedia, nota;
		
		float [] listadoNotas= new float[tam];
		
		for (int i = 0; i < listadoNotas.length; i++) {
			listadoNotas[i]=rnd.nextFloat()*10;
			System.out.printf("Nota alumno %d: %.2f\n", (i+1), listadoNotas[i]);
			if(listadoNotas[i]<5) {
				numSusp++;
			}else {
				numApr++;
			}
			sumNota+=listadoNotas[i];
		}
		
		notaMedia=sumNota/listadoNotas.length;
		
		System.out.printf("Aprobados: %d\n",numApr);
		System.out.printf("Suspensos: %d\n",numSusp);
		System.out.printf("Media de alumnos: %.2f\n",notaMedia);
		
	}

}
