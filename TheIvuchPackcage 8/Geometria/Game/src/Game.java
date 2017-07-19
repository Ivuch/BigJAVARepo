
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{
    
    int x,y,c=0;
    
 
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        int c=0;
        for(int i=0;i<400;i+=50)
        {
            if(c%2==0)
            {
                for(int n=0;n<400;n+=100)
                {
                  g2d.fillRect(n, i, 50, 50);
                }
            }

            if(c%2!=0)
            {
                for(int n=50;n<351;n+=100)
                {
                    g2d.fillRect(n, i, 50, 50);
                }
                
            }
            c++;
           
        }
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Hello!");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
                
      
    }
   

        
    
 
  public static void main(String[] args){
      JFrame frame=new JFrame("Ajedrez");
      frame.setSize(409, 435);
      frame.setVisible(true);
      for(int i=0;i<=64;i++)
      {
          frame.add(new Game());
      }
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      MiHilo elHilo = new MiHilo();
    elHilo.start();





     JoystickControl joystick=new JoystickControl();  
       int i=0;
       while (i<1){
     
     //joystick.joystickButtonChanged(null); 
     if (joystick.getButton(0)){System.out.println("▲"); joystick.getButtonAlt(0);}
          else if(joystick.getButton(1)){System.out.println("O"); joystick.getButtonAlt(1);}  
          else if(joystick.getButton(2)){System.out.println("X"); joystick.getButtonAlt(2);}
          else if(joystick.getButton(3)){System.out.println("|_|"); joystick.getButtonAlt(3);}
          else if(joystick.getButton(4)){System.out.println("L1"); joystick.getButtonAlt(4);}
          else if(joystick.getButton(5)){System.out.println("R1"); joystick.getButtonAlt(5);}
          else if(joystick.getButton(6)){System.out.println("L2"); joystick.getButtonAlt(6);}
          else if(joystick.getButton(7)){System.out.println("R2"); joystick.getButtonAlt(7);}
          else if(joystick.getButton(8)){System.out.println("SELECT"); joystick.getButtonAlt(8);}
          else if(joystick.getButton(9)){System.out.println("START"); joystick.getButtonAlt(9);}
          else if(joystick.getButton(10)){System.out.println("L3"); joystick.getButtonAlt(10);}
          else if(joystick.getButton(11)){System.out.println("R3"); joystick.getButtonAlt(11);}
    
    if (joystick.getAxis(0)){System.out.println("↑"); joystick.getAxisAlt(0);}
    else if(joystick.getAxis(1)){System.out.println("↓");joystick.getAxisAlt(1);}
    else if(joystick.getAxis(2)){System.out.println("←");joystick.getAxisAlt(2);}
    else if(joystick.getAxis(3)){System.out.println("→");joystick.getAxisAlt(3);}
          }
/*}
catch(Exception e){System.out.println(e);}
*/

  

 
        }}
 
    
