package juego;

public class Position{

	protected int x;
	protected int y;
	
	
	
	public Position()
	{
		
	}
	
	public Position(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void setPosition(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Position getPosition()
	{
		Position p=new Position(this.x,this.y);
		return p;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
}
