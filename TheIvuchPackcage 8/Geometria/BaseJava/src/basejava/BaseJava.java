
package basejava;
import javax.swing.JOptionPane;

public class BaseJava {

   
    public static void main(String[] args) {
      Taxi taxi1 = new Taxi();
      Taxi taxi2 = new Taxi();
      taxi1.setDistrito("federal");
      taxi1.setTipoMotor(1341);
      System.out.println(taxi1.distrito+"\n"+taxi1.getTipoMotor()+"\n"+taxi2.distrito);
      JOptionPane.showMessageDialog(null,"hola men : "+taxi1.distrito);
      int z, y;
      double c;
      z= (int) Math.cos(Math.PI);
      System.out.println(z+" "+Math.E);
      Jardín_imaginario uno = new Jardín_imaginario();
      c= uno.atributo1;
String de = "REQUENOBOLUOOOO";
z=de.length();
        Jardín_imaginario rand =new Jardín_imaginario();
        y=rand.getRandom();
                c=Math.random();
       
      System.out.println(z+" \nTu Random es muy Random y es: "+y+" y "+c);
}
}