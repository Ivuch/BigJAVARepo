package juego;

import java.awt.Color;
import java.awt.Graphics2D;


public class Rey extends Ficha {

	public Rey (boolean isWhite)
	{
		this.isAlive=true;
		this.isSelected=false;
		this.isWhite=isWhite;
		this.position=new Position();
		this.lastPosition=new Position();
		if(isWhite==true)
		{
			this.position.y=1;
			this.position.x=4;
			this.name="-KW*-";
		}
		else
		{
			this.position.y=8;
			this.position.x=4;
			this.name="-KB*-";
			
		}
	}

	@Override
	public boolean[] isValidPosition(Tablero tablero, Position pos) 
	{
		boolean areYouKilling=false;
		boolean isValid=false;
		int x=this.position.x;
		int y=this.position.y;
		
		if((pos.x==(x+1)&&(pos.y==y||pos.y==(y+1)||pos.y==(y-1)))||(pos.x==(x-1)&&(pos.y==y||pos.y==(y+1)||pos.y==(y-1)))||(pos.x==x&&(pos.y==(y+1)||pos.y==(y-1))))
		{
			isValid=true;
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
			g.fillRect((this.position.x-1)*50+20, (this.position.y-1)*50+4, 7, 7);
			g.fillRect((this.position.x-1)*50+11, (this.position.y-1)*50+11, 25, 7);
			g.fillRect((this.position.x-1)*50+18, (this.position.y-1)*50+11, 10, 30);
			g.fillOval((this.position.x-1)*50+8, (this.position.y-1)*50+35, 30, 10);
		}		
		
	}

}
