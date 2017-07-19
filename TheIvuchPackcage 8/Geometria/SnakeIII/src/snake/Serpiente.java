
package snake;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Serpiente {

    int x;
    int y;
    int xH=330;
    int yH;
   public void paint(Graphics2D g) {
		g.fillRect(xH, yH, 7, 7);
                g.fillRect(x-7,yH-y,7,5);
                g.fillRect(x-14,yH-y,7,5);
                g.fillRect(x-21,yH-y,7,5);
	}
    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) 
                {
                     x = x-7;
                }
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
                {
                    x = x+7;
                }
                if(e.getKeyCode()  == KeyEvent.VK_DOWN) 
                {
                     y= y+7;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP)
                {
                    y= y-7;
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE)
                {
                    y=y-15;
                }
                
    }
    public void keyReleased(KeyEvent e) {
    if(e.getKeyCode()==KeyEvent.VK_SPACE)
                {
                    y=y+15;
                }
        
    }
              
    public void move() {
        this.x=x;
        this.y=y;
    }
}
