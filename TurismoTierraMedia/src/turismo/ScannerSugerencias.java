package turismo;
import java.util.Scanner;

public class ScannerSugerencias {
	public static void main(String[] args) {
		String opcion = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Desea añadir esta sugerencia a su itinerario? Si/No");
		opcion = sc.next();
		while (!opcion.toLowerCase().equals("si") &&
				!opcion.toLowerCase().equals("no")) {
			System.out.println("¿Desea añadir esta sugerencia a su itinerario? Si/No");
			opcion = sc.next();
			System.out.println();			
		}
	}
}
