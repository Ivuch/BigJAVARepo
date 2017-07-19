
package basejava;

public class Taxi { 
 
    String ciudad; //Ciudad de cada objeto taxi
    String matricula; //Matrícula de cada objeto taxi
    String distrito; //Distrito asignado a cada objeto taxi
    int tipoMotor; //tipo de motor asignado a cada objeto taxi. 0 = desconocido, 1 = gasolina, 2 = diesel
 
    //Constructor: cuando se cree un objeto taxi se ejecutará el código que incluyamos en el constructor
    public Taxi () {
        ciudad = "Mexico D.F.";       
        matricula = "";
        distrito = "Distrito Desconocido";
        tipoMotor = 0;
    } 
 
    //Método para establecer la matrícula de un taxi
    public void setMatricula (String valorMatricula) {
        matricula = valorMatricula;  } 
 
    //Método para establecer el distrito de un taxi
    public void setDistrito (String valorDistrito) {
        distrito = "Distrito " + valorDistrito; 
    } 
   
    public void setTipoMotor (int valorTipoMotor) {
        tipoMotor = valorTipoMotor; 
    } 
   
    //Método para obtener la matrícula del objeto taxi
    public String getMatricula () { return matricula; } 
   
    //Método para obtener el distrito del objeto taxi
    public String getDistrito () { return distrito; } 
   
    //Método para obtener el tipo de motor del objeto taxi
    public int getTipoMotor () { return tipoMotor; } 
 
} 