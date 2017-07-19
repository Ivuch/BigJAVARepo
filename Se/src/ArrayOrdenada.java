public class ArrayOrdenada 
{
    public static int[] nextArray(int [] num)
    {   //Definición de variables y objetos a utilizar;
        int x=num.length;
        int max=0,menor,posicion;
        int[] array=new int[x];
       
        /////////////////////////////////////////////////////////////////////
        
        //Asignación de num Max
        for(int i=0;i<x;i++)
        {
           max+=Math.abs(num[i]);
        }
        
        /////////////////////////////////////////////////////////////////////
        
        //Ordenados:
        for(int m=0;m<x;m++)//Siendo m desde 0 a "num.length"
        {
            menor=num[0];               //se inicia el calculo del Menor desde el numero 0
            posicion=0;                 // y la posicion 0.
            for (int i=0;i<x;i++)
            {
                if(num[i]<menor)
                {
                    menor=num[i];   //Se calcula el menor valor de Todos
                    posicion = i;   // Y la posicion donde se encuentra
                }
            }
            array[m]=menor;  //En la posicion array[m] se asigna el menor valor
            num[posicion]=max;//El valor ya asignado se elimina del listado de numeros, con la asignacion max.
        }
        /////////////////////////////////////////////////////////////////////
        return(array);
    }
    
    public static int[] deMayorAMenor(int [] num)
    { //Definición de variables y objetos a utilizar;
        int x=num.length;
        int max=0,menor,posicion;
        int[] array=new int[x];
       
        
        //Asignación de num Max
        for(int i=0;i<x;i++)
        {
           max+=Math.abs(num[i]);
        }
        
        
        //Ordenados:
        for(int m=(x-1);m>=0;m--)
        {
            menor=num[0];
            posicion=0;
            for (int i=0;i<x;i++)
            {
                if(num[i]<menor)
                {
                    menor=num[i];
                    posicion = i;
                }
            }
            array[m]=menor;
            num[posicion]=max;
        }
        
    return(array);}
           
}
    

