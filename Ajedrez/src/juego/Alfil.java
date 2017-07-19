package juego;

import java.awt.Color;
import java.awt.Graphics2D;


public class Alfil extends Ficha {

	private static int posW=3;
	private static int posB=3;
	private static int contadorW=0;
	private static int contadorB=0;
	
	public Alfil(boolean isWhite)
	{
		this.isAlive=true;
		this.isSelected=false;
		this.isWhite=isWhite;
		this.position=new Position();
		this.lastPosition=new Position();
		if(isWhite==true)
		{
			this.position.setPosition(posW, 1);
			posW=6;
			contadorW++;
			this.name="-AW"+contadorW+"-";
		}
		else
		{
			this.position.setPosition(posB, 8);
			posB=6;
			contadorB++;
			this.name="-AB"+contadorB+"-";
			
		}
	}
	
	public Alfil(boolean isWhite, int x, int y)
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
		boolean isValid=false;
		int x=this.position.x;
		int y=this.position.y;
		boolean aux=true;
		for(int i=1;i<=8;i++)
		{
			if(x+i==pos.x)
			{
				if(y+i==pos.y)
				{
					isValid=true;
					for(int j=1;j<i;j++)
					{
						if(tablero.tablero[x+j][y+j])
						{
							aux=false;
						}
					}
				}
				else if(y-i==pos.y)
				{
					isValid=true;
					for(int j=1;j<i;j++)
					{
						if(tablero.tablero[x+j][y-j])
						{
							aux=false;
						}
					}
				}
			}
			else if(x-i==pos.x)
			{
				if(y+i==pos.y)
				{
					isValid=true;
					for(int j=1;j<i;j++)
					{
						if(tablero.tablero[x-j][y+j])
						{
							aux=false;
						}
					}
				}
				else if(y-i==pos.y)
				{
					isValid=true;
					for(int j=1;j<i;j++)
					{
						if(tablero.tablero[x-j][y-j])
						{
							aux=false;
						}
					}
				}
			}
			
		}
		if(!aux)
		{
			isValid=false;
		}
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
			/*if(!tablero.tablero[x+i][y+i]&&!tablero.tablero[x-i][y+i]&&!tablero.tablero[x-i][y-i]&&!tablero.tablero[x+i][y-i])
			{
				
			}
			if((pos.x==(x+i)&&pos.y==(y+i))||(pos.x==(x-i)&&pos.y==(y+i))||(pos.x==(x-i)&&pos.y==(y-i))||(pos.x==(x+i)&&pos.y==(y-i)))
			{
				
				isValid=true;
			}
			*/
			
		
		
		//oooooooooooooooooooooooooooooooooooooooooooooooooooooooo
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
			g.fillOval((this.position.x-1)*50+20, (this.position.y-1)*50+5, 6, 6);
			g.fillOval((this.position.x-1)*50+14, (this.position.y-1)*50+10, 18, 20);
			g.fillOval((this.position.x-1)*50+18, (this.position.y-1)*50+20, 10, 20);
			g.fillOval((this.position.x-1)*50+8, (this.position.y-1)*50+35, 30, 10);
		}		
		
	}


}
