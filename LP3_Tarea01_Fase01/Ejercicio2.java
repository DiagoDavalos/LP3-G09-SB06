package PrimeroT1.LP3_Tarea01_Fase01;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args ) {
		int nums=0;
		System.out.println("ingrese 10 numeros, uno mayor que otro: ");
		ArrayList<Integer> numeros = new ArrayList<>();
		Scanner variable= new Scanner(System.in);
		for (int i=1; i <=10; i++ ) {
			System.out.println("ingrese el " +i+" numero ");
			nums = variable.nextInt();
			while (i>1 && numeros.get(numeros.size()-1)>=nums) {
				System.out.println("ingrese el " +i+" numero de nuevo ");
				nums = variable.nextInt();
			}
			numeros.add(nums);
			
		}
		System.out.println(numeros);
	}
}