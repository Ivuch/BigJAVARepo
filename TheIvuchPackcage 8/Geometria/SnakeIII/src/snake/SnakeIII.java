
package snake;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class SnakeIII {

  
    
    public static void main(String[] args) throws InterruptedException {
    
        Grafica g= new Grafica();
        JFrame frame=new JFrame("SnakeIII");
        frame.setSize(840, 450);
        frame.add(g);
       
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Music music=new Music();
        music.start(); 
        while(true)
        {
            g.move();
            g.repaint(); 
            Thread.sleep(5);
        }
       
    }
}
