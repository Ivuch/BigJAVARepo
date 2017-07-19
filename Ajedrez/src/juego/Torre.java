package juego;

import java.awt.Color;
import java.awt.Graphics2D;


public class Torre extends Ficha {

	private static int contadorW=0;
	private static int contadorB=0;
	private static int posW=1;
	private static int posB=1;
	
	
	public Torre(boolean isWhite)
	{
		this.isAlive=true;
		this.isSelected=false;
		this.isWhite=isWhite;
		this.position=new Position();
		this.lastPosition=new Position();
		if(isWhite==true)
		{
			this.position.setPosition(posW, 1);
			posW=8;
			contadorW++;
			this.name="-TW"+contadorW+"-";
		}
		else
		{
			this.position.setPosition(posB, 8);
			posB=8;
			contadorB++;
			this.name="-TB"+contadorB+"-";
			
		}
	}
	
	public Torre(boolean isWhite, int x, int y)
	{
		this.isWhite=isWhite;
		this.position=new Position();
		this.position.x=x;
		this.position.y=y;
	}

	@Override
	public boolean[] isValidPosition(Tablero tablero, Position pos) 
	{
		boolean areYouKilling=false;
		boolean isValid=true;
		int x=this.position.x;
		int y=this.position.y;
		
		if(x==pos.x)
		{
			if(y>pos.y)
			{
				for(int i=(y-1);i>pos.y;i--)
				{
					if(tablero.tablero[x][i])
					{
						isValid=false;
					}
				}
			}
			else if(y<pos.y)
			{
				for(int i=(y+1);i<pos.y;i++)
				{
					if(tablero.tablero[x][i])
					{
						isValid=false;
					}
				}
			}
			else{isValid=false;}
			
		}
		else if(y==pos.y)
		{
			if(x>pos.x)
			{
				for(int i=(x-1);i>pos.x;i--)
				{
					if(tablero.tablero[i][y])
					{
						isValid=false;
					}
				}
			}
			else if(x<pos.x)
			{
				for(int i=(x+1);i<pos.x;i++)
				{
					if(tablero.tablero[i][y])
					{
						isValid=false;
					}
				}
			}
			else{isValid=false;}
		}
		else{isValid=false;}//Si x!=pos.x y y!=pos.y (se moveria en diagonal)
		
		if(this.isWhite&&isValid)
		{
			if(!tablero.tableroW[pos.x][pos.y])
			{
				isValid=true;
			}
			else
			{
				isValid=false;
			}
			
		}
		else if(!this.isWhite&&isValid)
		{
			if(!tablero.tableroB[pos.x][pos.y])
			{
				isValid=true;
			}
			else
			{
				isValid=false;
			}
		}
		
		//Se establece la muerte si coincide la posición a la que se quiere mover con ficha del otro color.
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
			g.fillRect((this.position.x-1)*50+32, (this.position.y-1)*50+10, 6, 6);
			g.fillRect((this.position.x-1)*50+21, (this.position.y-1)*50+10, 6, 6);
			g.fillRect((this.position.x-1)*50+8, (this.position.y-1)*50+10, 6, 6);
			g.fillRect((this.position.x-1)*50+8, (this.position.y-1)*50+15, 30, 8);
			g.fillRect((this.position.x-1)*50+14, (this.position.y-1)*50+20, 18, 20);
			g.fillRect((this.position.x-1)*50+8, (this.position.y-1)*50+35, 30, 8);		
		}
		
	}
}
