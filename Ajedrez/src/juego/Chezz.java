package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JPanel;


public class Chezz extends JPanel {

	//i siempre será el numero de la ficha seleccionada.
	private int i=-1;
	boolean isSelected=false;//Booleano que determina cuando se clickea o no.
	public int x;
	public int y;
	boolean isWhite;
	Ficha[] fWhite, fBlack;
	
	public Chezz(Ficha[] fWhite, Ficha[] fBlack)
	{
		this.fWhite=fWhite;
		this.fBlack=fBlack;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(Color.GRAY);
		int c=0;
		for(int i=0;i<400;i+=50)
		{
			if(c%2==0)
			{
				for(int n=0;n<400;n+=100)
				{
					g2d.fillRect(n,i,50,50);
				}
			}
			else
			{
				for(int n=50;n<351;n+=100)
				{
					g2d.fillRect(n, i, 50, 50);
				}
			}
			c++;
		}
		for(int i=0;i<fWhite.length;i++)
		{
			fWhite[i].paint(g2d);
			fBlack[i].paint(g2d);
		}
	}
	
	public int geti()
	{
		return this.i;
	}
	public void seti(int i)
	{
		this.i=i;
	}
	
}
