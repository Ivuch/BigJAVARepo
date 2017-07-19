package basejava;
import java.util.Random;

 //inicialización de la clase Pública (de mismo nombre q' el archivo .java)
public class Jardín_imaginario {
    
    int atributo1;
    String cadenaimaginaria; //definición de atributos
    boolean atributov_f;
   //se inicia el Constructor(mismo id que public class), los objetos tendrán los valores del constructor x defecto
    public Jardín_imaginario(){
        
        atributo1=214;
        cadenaimaginaria="Hola mundo!";
        atributov_f = false;                }
    
    //Méeeeeeetodos
    public int getAtributo1(){return atributo1;}
    
    
    public void setAtributo1(int a){
        atributo1=a;    }


    public int getRandom(){ 
int z; 
Random caca =new Random();
 z=caca.nextInt(atributo1); 
    return (z);}

}
