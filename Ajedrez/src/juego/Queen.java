package juego;

import java.awt.Color;
import java.awt.Graphics2D;


public class Queen extends Ficha {

	public Queen(boolean isWhite)
	{
		this.isAlive=true;
		this.isSelected=false;
		this.isWhite=isWhite;
		this.position=new Position();
		this.lastPosition=new Position();
		if(isWhite==true)
		{
			this.position.y=1;
			this.position.x=5;
			this.name="-QW*-";
		}
		else
		{
			this.position.y=8;
			this.position.x=5;
			this.name="-QB*-";
			
		}
	}

	@Override
	public boolean[] isValidPosition(Tablero tablero, Position pos) 
	{
		boolean areYouKilling=false;
		boolean isValid=false;
		
		Alfil a=new Alfil(this.isWhite, this.position.x, this.position.y);
		Torre t=new Torre(this.isWhite, this.position.x, this.position.y);
		boolean[] cont1=new boolean[2];
		boolean[] cont2=new boolean[2];
		cont1=t.isValidPosition(tablero, pos);
		cont2=a.isValidPosition(tablero, pos);
		a=null;
		t=null;
		if(cont1[0]||cont2[0])
		{
			isValid=true;
		}
		if(cont1[1]||cont2[1])
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
			g.fillOval((this.position.x-1)*50+40, (this.position.y-1)*50+12, 7, 7);
			g.fillOval((this.position.x-1)*50, (this.position.y-1)*50+11, 7, 7);
			g.fillOval((this.position.x-1)*50+31, (this.position.y-1)*50+8, 7, 7);
			g.fillOval((this.position.x-1)*50+10, (this.position.y-1)*50+8, 7, 7);
			g.fillOval((this.position.x-1)*50+20, (this.position.y-1)*50+7, 7, 7);
			g.fillArc((this.position.x-1)*50+24, (this.position.y-1)*50+10, 20, 30, 24, 20);
			g.fillArc((this.position.x-1)*50+18, (this.position.y-1)*50+10, 20, 28, 45, 20);
			g.fillArc((this.position.x-1)*50+17, (this.position.y-1)*50+11, 15, 30, 90, 30);
			g.fillArc((this.position.x-1)*50+10, (this.position.y-1)*50+10, 15, 30, 105, 20);
			g.fillArc((this.position.x-1)*50+4, (this.position.y-1)*50+10, 15, 30, 135, 20);
			g.fillRoundRect((this.position.x-1)*50+8, (this.position.y-1)*50+20, 30, 20, 180, 180);
			g.fillRect((this.position.x-1)*50+8, (this.position.y-1)*50+35, 30, 6);	
		}		
		
	}


}
