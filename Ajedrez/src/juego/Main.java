package juego;


import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Main {
	
	public static void main(String[] args) throws InterruptedException
	{
		Ficha[] fWhite = new Ficha[16];
		Ficha[] fBlack = new Ficha[16];
		Tablero tablero = new Tablero();
		
		//Creacion Fichas Blancas
		boolean isWhite=true;
		for(int i=0;i<8;i++)
		{
			fWhite[i]=new Peon(isWhite,(i+1));
		}
		fWhite[8]=new Torre(isWhite);
		fWhite[9]=new Torre(isWhite);
		fWhite[10]=new Caballo(isWhite);
		fWhite[11]=new Caballo(isWhite);
		fWhite[12]=new Alfil(isWhite);
		fWhite[13]=new Alfil(isWhite);
		fWhite[14]=new Queen(isWhite);
		fWhite[15]=new Rey(isWhite);
		
		for(int i=0;i<fWhite.length;i++)
		{
			tablero.insertFicha(fWhite[i]);
			
		}
		
		
		//Creacion Fichas Negras
		isWhite=false;
		for(int i=0;i<8;i++)
		{
			fBlack[i]=new Peon(isWhite,(i+1));
		}
		fBlack[8]=new Torre(isWhite);
		fBlack[9]=new Torre(isWhite);
		fBlack[10]=new Caballo(isWhite);
		fBlack[11]=new Caballo(isWhite);
		fBlack[12]=new Alfil(isWhite);
		fBlack[13]=new Alfil(isWhite);
		fBlack[14]=new Queen(isWhite);
		fBlack[15]=new Rey(isWhite);
		
		for(int i=0;i<fBlack.length;i++)
		{
			tablero.insertFicha(fBlack[i]);
		}
		
		//Creacion de Interfaz
		final Chezz myChezz = new Chezz(fWhite, fBlack);
		MouseListener ml = new MyMListener(myChezz);
		myChezz.addMouseListener(ml);
			
		JFrame frame=new JFrame("Ajedrez");
		frame.setSize(409,435);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(myChezz);
		//tablero.toStringDarkSideOfTheMoon();
		//tablero.toStringWhiteSide();
		//tablero.printTab();
		//tablero.printWhites();
		//tablero.printBlacks();
		
		
		//Comienzo del Juego.--------------------------------------------------------------------
		Position myPos = new Position();
		int x, y, i;
		boolean[] cont = new boolean[2];
		boolean isPosible, kill, validFicha;
		
		isPosible = kill = validFicha = false;
		i = x = y = -1;
		myPos.setPosition(x, y);
		cont = null;
		
		while(fWhite[15].isAlive&&fBlack[15].isAlive)
		{
		//Turno BLANCAS.---------------------------------------------------------
			System.out.println("TURNO BLANCAS:");
			System.out.println("Ingrese nro de Ficha a mover:");
			while(!validFicha)
			{
				myChezz.isSelected=false;
				while(!myChezz.isSelected||i<0||i>15)
				{
					i=myChezz.geti();//INGRESO DE LA FICHA!OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO(POR AWT)
				}
				validFicha=true;
				if(!fWhite[i].isAlive||!myChezz.isWhite)
				{
					System.err.println("Error: Ficha NO válida.");
					validFicha=false;
				}
			}
			System.out.println("Ficha: "+i);
			
				
				//Mientras la jugada No sea posible: Repetir ingreso.
				
			while(!isPosible)
			{
				System.out.println("*palo.ivi.gatito(); Ingrese posicion x, y:");
				myChezz.isSelected=false;
				while(!myChezz.isSelected)
				{
					x=myChezz.x;
					y=myChezz.y;
				}
				myPos.setPosition(x, y);
				cont = fWhite[i].isValidPosition(tablero,myPos);
				isPosible=cont[0];
				kill=cont[1];
				if(!isPosible)
				{
					int h=myChezz.geti();
					if(h!=i)
					{
						if(fWhite[h].isAlive&&myChezz.isWhite)
						{
							i=myChezz.geti();
							System.out.println("Ficha: "+(i+1));
						}
					}
					else
					{
						System.err.print("Posicion x: "+x+" - y:"+y+" no válida, Intente nuevamente..\n");
					}
				}
			} 

			if(kill)
			{	int j = 0;
				for(int z=0;z<fBlack.length;z++)
				{
					if(fBlack[z].position.getX()==myPos.x&&fBlack[z].position.y==myPos.y)
					{
						j=z;
					}
				}
				tablero.deleteFicha(fBlack[j]);
			}
			fWhite[i].mover(tablero,myPos);
			myChezz.repaint();
			Thread.sleep(10);
			System.out.println("La Ficha "+(i+1)+"Se movió Exitosamente a\nx: "+x+"\ty: "+y);
	
		//Reinicio de Componentes.
			isPosible = kill = validFicha = false;
			i = x = y = -1;
			myPos.setPosition(x, y);
			cont = null;
			
		//Turno NEGRAS.-----------------------------------------------------------------------
			System.out.println("TURNO NEGRAS:");
			System.out.println("Ingrese nro de Ficha a mover:");
			while(!validFicha)
			{
				myChezz.isSelected=false;
				while(!myChezz.isSelected)
				{
					i=myChezz.geti();//INGRESO DE LA FICHA!OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO(POR AWT)
				}
				validFicha=true;
				if(!fBlack[i].isAlive||myChezz.isWhite)
				{
					System.err.println("Error: Ficha NO válida."+i);
					validFicha=false;
				}
			}
			System.out.println("Ficha: "+i);
				//Mientras la jugada No sea posible: Repetir ingreso.
				
			while(!isPosible)
			{
				System.out.println("Ingrese posicion x, y:");
				myChezz.isSelected=false;
				while(!myChezz.isSelected)
				{
					x=myChezz.x;
					y=myChezz.y;
				}
				myPos.setPosition(x, y);
				cont = fBlack[i].isValidPosition(tablero,myPos);
				isPosible=cont[0];
				kill=cont[1];
				if(!isPosible)
				{
					int h=myChezz.geti();
					if(h!=i)
					{
						if(fBlack[h].isAlive&&!myChezz.isWhite)
						{
							i=myChezz.geti();
							System.out.println("Ficha: "+i);
						}
					}
					else
					{
						System.err.print("Posicion no válida, Intente nuevamente..\n");
					}
				}
			}

			if(kill)          
			{	
				int j=0;
				for(int z=0;z<fWhite.length;z++)
				{
					if(fWhite[z].position.x==myPos.x&&fWhite[z].position.y==myPos.y)
					{
						j=z;
					}
				}
				tablero.deleteFicha(fWhite[j]);
			}
			fBlack[i].mover(tablero,myPos);
			myChezz.repaint();
			Thread.sleep(10);
			
		//Reinicio de Componentes.
			isPosible = kill = validFicha = false;
			i = x = y = -1;
			myPos.setPosition(x, y);
			cont = null;
		}
		String c=null;
		if(fWhite[15].isAlive)
		{
			c="Blancas";
		}
		else if(fBlack[15].isAlive)
		{
			c="Negras";
		}
		JOptionPane pane = new JOptionPane("Ganan las "+c);
	    JDialog dialog = pane.createDialog(new JFrame(), "Fin del Juego");
	    dialog.setVisible(true);
		
	}
}

