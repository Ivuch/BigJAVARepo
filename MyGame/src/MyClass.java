import java.applet.Applet;
import java.awt.Graphics;


public class MyClass extends Applet
{	
		
 
		public void init()
		{
			setSize(845,480);
		}

		public void paintup(Graphics g)
		{
			
			g.fillOval(100, 100, 20, 20);
		}
		
		


}