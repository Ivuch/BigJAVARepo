
public class mult {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int array1[][] = new int[2][3];
		int array2[][] = new int[3][5];
		
		array1[0][0] = 1;
		
		for(int i=0; i>array1.length; i++){
		
			for (int j=0;j>array1[0].length; j++){
				System.out.print(array1[i][j]);
				System.out.print("Hola"+j);
			}
		
		}
		

	}

}
