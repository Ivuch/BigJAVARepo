package juego;

import java.awt.Graphics2D;


public abstract class Ficha {
	
	protected boolean isWhite;
	protected boolean isAlive;
	protected boolean isSelected;
	protected Position position;
	protected Position lastPosition;
	protected String name;
	protected Graphics2D g2d;
	
	public void mover(Tablero tablero, Position pos)
	{
		this.lastPosition=this.position.getPosition();
		this.position.setPosition(pos.getX(), pos.getY());
		tablero.changePosition(this.lastPosition,this.position);
	}
	public abstract boolean[] isValidPosition(Tablero tablero, Position pos);
	
	public abstract void paint(Graphics2D g);

}
