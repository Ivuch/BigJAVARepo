package juego;


public class Tablero {

	protected boolean[][] tablero;
	protected boolean[][] tableroW;
	protected boolean[][] tableroB;
	protected String[][] names;
	private Position tPos;
	
	public Tablero()
	{
		tablero=new boolean[10][10];
		tableroW=new boolean[10][10];
		tableroB=new boolean[10][10];
		names=new String[10][10];
		tPos=new Position();
		
		for(int i=0;i<10;i++)
		{
			for(int n=0;n<10;n++)
			{
				tablero[n][i]=false;
				names[n][i]="  .  ";	//Toda la matriz iniciara en "false" para this.tablero y en "  .  " para this.name
				
			}
			tablero[0][i]=true;
			names[0][i]="|";
			names[9][i]="|";
			tablero[9][i]=true;

		}							//Los Bordes serán "true" para this.tablero y Lineas delimitadoras para this.name.
		for(int i=0;i<10;i++)
		{
			names[i][0]="____";
			names[i][9]="____";
			tablero[i][0]=true;
			tablero[i][9]=true;

		}
		
	}
	
	public void insertFicha(Ficha fich)
	{
		tPos=fich.position.getPosition();//Atributos x,y de "Position" ENCAPSULADOS;
		int x=tPos.getX();
		int y=tPos.getY();
		if(!this.tablero[x][y]==true)
		{
			this.tablero[x][y]=fich.isAlive;
			this.names[x][y]=fich.name;
		}
		if(fich.isWhite)
		{
			tableroW[x][y]=true;
		}
		else
		{
			tableroB[x][y]=true;
		}
	}
	
	public void deleteFicha(Ficha fich)
	{
		int x=fich.position.getX();
		int y=fich.position.getY();
		this.tablero[x][y]=false;
		this.names[x][y]="  .  ";
		if(tableroW[x][y])
		{
			tableroW[x][y]=false;
		}
		else if(tableroB[x][y])
		{
			tableroB[x][y]=false;
		}
		fich.isAlive=false;
		fich.position.x=-1;
		fich.position.y=-1;
		
	}
	
	public void changePosition(Position ini, Position fin)
	{
		
		this.tablero[ini.getX()][ini.getY()]=false;
		this.tablero[fin.getX()][fin.getY()]=true;
		String s=this.names[ini.getX()][ini.getY()];
		this.names[ini.getX()][ini.getY()]="  .  ";
		this.names[fin.getX()][fin.getY()]=s;
		if(tableroW[ini.x][ini.y])//Atributos x,y de "Position" NO ENCAPSULADOS.
		{
			tableroW[ini.x][ini.y]=false;
			tableroW[fin.x][fin.y]=true;
		}
		else if(tableroB[ini.x][ini.y])
		{
			tableroB[ini.x][ini.y]=false;
			tableroB[fin.x][fin.y]=true;
		}
	}
	
	
	public void toStringDarkSideOfTheMoon()
	{                                                    
		
		for(int i=0;i<10;i++)
		{
			for(int n=0;n<10;n++)
			{
				System.out.print(this.names[n][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void toStringWhiteSide()
	{
		for(int i=9;i>-1;i--)
		{
			for(int n=0;n<10;n++)
			{
				System.out.print(this.names[n][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printTab()
	{                                                    
		
		for(int i=0;i<10;i++)
		{
			for(int n=0;n<10;n++)
			{
				System.out.print(this.tablero[n][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printWhites()
	{                                                    
		
		for(int i=0;i<10;i++)
		{
			for(int n=0;n<10;n++)
			{
				System.out.print(this.tableroW[n][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printBlacks()
	{                                                    
		
		for(int i=0;i<10;i++)
		{
			for(int n=0;n<10;n++)
			{
				System.out.print(this.tableroB[n][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
