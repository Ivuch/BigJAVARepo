package juego;

import java.awt.Color;
import java.awt.Graphics2D;


public class Peon extends Ficha {

	protected boolean firstTimeMove;
	private static int contadorW=0;
	private static int contadorB=0;
	
	
	public Peon(boolean isWhite,int x)
	{
		this.isAlive=true;
		this.isSelected=false;
		this.isWhite=isWhite;
		this.position=new Position();
		this.lastPosition=new Position();
		this.firstTimeMove=true;
		if(this.isWhite==true)
		{
			this.position.setPosition(x,2);
			contadorW++;
			this.name="-PW"+contadorW+"-";
		}
		else
		{
			this.position.setPosition(x,7);
			contadorB++;
			this.name="-PB"+contadorB+"-";
		}

		
	}

	@Override
	public boolean[] isValidPosition(Tablero tablero, Position pos) 
	{
		boolean areYouKilling=false;
		boolean isValid=false;
		int x=this.position.x;
		int y=this.position.y;
		if(this.isWhite)
		{	
			if(!tablero.tableroW[pos.x][pos.y])
			{
				if(pos.x==x&&pos.y==(y+1)&&!tablero.tablero[pos.x][pos.y])
				{
					if(this.firstTimeMove)
					{
						this.firstTimeMove=false;
					}
					isValid=true;
				}
				if(pos.x==x&&pos.y==(y+2)&&this.firstTimeMove&&!tablero.tablero[pos.x][pos.y]&&!tablero.tablero[pos.x][(pos.y-1)])
				{
					this.firstTimeMove=false;
					isValid=true;
				}
				if((pos.x==(x-1)||pos.x==(x+1))&&pos.y==(y+1)&&tablero.tableroB[pos.x][pos.y])
				{
					if(this.firstTimeMove)
					{
						this.firstTimeMove=false;
					}
					areYouKilling=true;
					isValid=true;
				}
			}
			else
			{
				isValid=false;
			}
		}
		else //if(!isWhite)
		{
			if(!tablero.tableroB[pos.x][pos.y])
			{
				if(pos.x==x&&pos.y==(y-1)&&!tablero.tablero[pos.x][pos.y])
				{
					if(this.firstTimeMove)
					{
						this.firstTimeMove=false;
					}
					isValid=true;
				}
				if(pos.x==x&&pos.y==(y-2)&&this.firstTimeMove&&!tablero.tablero[pos.x][pos.y]&&!tablero.tablero[pos.x][(pos.y+1)])
				{
					this.firstTimeMove=false;
					isValid=true;
				}
				if((pos.x==(x-1)||pos.x==(x+1))&&pos.y==(y-1)&&tablero.tableroW[pos.x][pos.y])
				{
					if(this.firstTimeMove)
					{
						this.firstTimeMove=false;
					}
					areYouKilling=true;
					isValid=true;
				}
			}
			else
			{
				isValid=false;
			}
		}
		boolean[] ans=new boolean[2];
		ans[0]=isValid;
		ans[1]=areYouKilling;
		return ans;
	}

	@Override
	public void paint(Graphics2D g) {
		
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
		g.fillOval((this.position.x-1)*50+12, (this.position.y-1)*50+10, 20, 20);
		g.fillRect((this.position.x-1)*50+18, (this.position.y-1)*50+20, 10, 20);
		g.fillOval((this.position.x-1)*50+8, (this.position.y-1)*50+35, 30, 10);
		}
		
	}
	
}
