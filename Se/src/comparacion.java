import java.util.Scanner;
public class comparacion 
{
    public static void main(String[]args)
    {double f=4;
      /*  int [] num =new int[20];
        Scanner ent=new Scanner(System.in);
        
         //Asignación de valores al Array num[];
        for(int i=0;i<num.length;i++)
        {
            num[i]=ent.nextInt();
        }
        
        //ordenar Array usando Method "ArrayOrdenada.nextArray"
        num = ArrayOrdenada.deMayorAMenor(num);
        
        for(int i=0;i<num.length;i++)
        {
            System.out.println("Posición "+(i+1)+": "+num[i]);
        }
  */
        Cuadratica c =new Cuadratica(5,4,2);
        f=c.x;
        System.out.println(f);
        c.getVertx();
        c.printFunction(-6, 4);
        c.getVertx();
        c.getRaiz();
    }
}
