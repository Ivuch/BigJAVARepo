package juego;

import java.awt.Color;
import java.awt.Graphics2D;


public class Caballo extends Ficha {

	private static int posW=2;
	private static int posB=2;
	private static int contadorW=0;
	private static int contadorB=0;
	
	public Caballo(boolean isWhite)
	{ 
		this.isAlive=true;
		this.isSelected=false;
		this.isWhite=isWhite;
		this.position=new Position();
		this.lastPosition=new Position();
		if(isWhite==true)
		{
			this.position.setPosition(posW, 1);
			posW=7;
			contadorW++;
			this.name="-CW"+contadorW+"-";
		}
		else
		{
			this.position.setPosition(posB, 8);
			posB=7;
			contadorB++;
			this.name="-CB"+contadorB+"-";
			
		}
	}

	@Override
	public boolean[] isValidPosition(Tablero tablero, Position pos) 
	{
		boolean areYouKilling=false;
		boolean isValid=false;
		int x=this.position.x;
		int y=this.position.y;
		
		if((pos.x==(x+2)&&(pos.y==(y+1)||pos.y==(y-1)))||(pos.x==(x-2)&&(pos.y==(y+1)||pos.y==(y-1)))||(pos.x==(x+1)&&(pos.y==(y+2)||pos.y==(y-2)))||(pos.x==(x-1)&&(pos.y==(y+2)||pos.y==(y-2))))
		{
			if(this.isWhite&&!tablero.tableroW[pos.x][pos.y])
			{
				isValid=true;
			}
			if(!this.isWhite&&!tablero.tableroB[pos.x][pos.y])
			{
				isValid=true;
			}
		}
				
		if(this.isWhite&&tablero.tableroB[pos.x][pos.y]&&isValid)
		{
				areYouKilling=true;
		}
		else if(!this.isWhite&&tablero.tableroW[pos.x][pos.y]&&isValid)
		{
				areYouKilling=true;
		}
		
		boolean[] ans=new boolean[2];
		ans[0]=isValid;
		ans[1]=areYouKilling;
		return ans;	
	}

	@Override
	public void paint(Graphics2D g) {
		String s="Caballo";
		if(isWhite)
		{
			g.setColor(Color.WHITE);
		}
		else
		{
			g.setColor(Color.BLACK);
		}
		if(this.position!=null)
		{
			g.drawString(s, (this.position.x-1)*50, (this.position.y-1)*50+25);
			g.fillArc((this.position.x-1)*50+5, (this.position.y-1)*50+28, 30, 30,0,180);
	/*	g.setColor(Color
		g.fillArc((this.position.x-1)*50, (this.position.y-1)*50, 20, 20,45,45);
		*/
		}		
	}

	

}
