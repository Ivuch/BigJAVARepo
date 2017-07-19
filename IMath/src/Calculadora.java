
public class Calculadora {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Welcome to the assombrous and marvelous Calculator of Dr. Ivuch:\n " +
					"No apto para niños enfermos o con sindrome de dawn...\n\n");
		System.out.print("Elija su operación:\n\n1-Recta\n2-Cuadrática\n" +
					"3-Trigonométrica\n4-Homogenea\n5-Derivadas\n6-Integrales");
		
		Recta r = new Recta(5,2);
	}

}
