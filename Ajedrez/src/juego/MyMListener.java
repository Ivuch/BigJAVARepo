package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMListener implements MouseListener{
	
	Chezz myChezz;
	public MyMListener(Chezz myChezz)
	{
		this.myChezz=myChezz;
	}
	
	/*Clickear en una casilla devuelve el n° de pos de ficha dentro del array "fWhite[i]" como el entero i;
	como tambien si esa ficha es negra o blanca. (Boolean isWhite;)
	Y en general, Tambien devuelve el valor por defecto de x e y siendo dentro del tablero valores del 1 al 8
	*/
	@Override
	public void mouseClicked(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		boolean xAsignado =false, yAsignado=false;
		for(int i=0;i<450;i+=50)
		{
			if(x<i&&!xAsignado)
			{
				x=(i-50)/50+1;
				myChezz.x=x;
				xAsignado=true;
			}
			if(y<i&&!yAsignado)
			{
				y=(i-50)/50+1;
				myChezz.y=y;
				yAsignado=true;
				
			}
		}
		
		for(int i=0;i<myChezz.fWhite.length;i++)
		{
			if(y==myChezz.fWhite[i].position.y&&x==myChezz.fWhite[i].position.x)
			{
				myChezz.seti(i);
				myChezz.isWhite=true;
			}
			else if(y==myChezz.fBlack[i].position.y&&x==myChezz.fBlack[i].position.x)
			{
				myChezz.seti(i);
				myChezz.isWhite=false;
			}
		}
		myChezz.isSelected=true;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
