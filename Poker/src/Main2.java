
public class Main2 {

	

	public static void main(String[] args) 
	{
		int x;
	System.out.println("Hola Nathu:\n\n ingresá un numero");
	try {
		x=System.in.read();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
	
	System.out.println("bueno nada, que se yo, la suma con tu numro y 14 es:"+(x+14));
	}

}
