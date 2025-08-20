package PrimeroT1.LP3_Tarea01_Fase01;
import java.util.ArrayList;

public class Ejercicio1 {
  public static int suma(int[] arreglo) {
	  int suma = 0;
	  for (int i=0; i< arreglo.length; i++) {
		  suma += arreglo[i];
		  
	  }
	  return suma;
	  
  }
  public static void main(String[] args ) {
	  int[ ]  nums = {1,2,3,4,5};
	  System.out.println(suma(nums));
	  
  }
}
