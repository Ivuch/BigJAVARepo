package snake;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class Grafica extends JPanel{
    int x=0;
    int y=0;
    Serpiente serpiente=new Serpiente();

   
    public Grafica()
    {
       KeyListener kl=new KeyListener() {
    
        @Override
        public void keyTyped(KeyEvent e) {
            serpiente.keyPressed(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
             serpiente.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            serpiente.keyReleased(e);
        }
        
    };
       
    addKeyListener(kl);
    setFocusable(true);
    }
    
    public void move()
    {
        serpiente.move();
        x++;
        y++;
    }
    @Override
    public void paint (Graphics g)
    {
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        g.fillOval(x, y, 6, 6);
        g.fillOval(x+1, y, 8, 10);
        serpiente.paint(g2d);
    }
   
}

   
     
   