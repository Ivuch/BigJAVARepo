

public class mainn {

	public static void main(String[] args)
	{
		JoystickControl joystick=new JoystickControl();  
		int i=0;
		
		MyClass a= new MyClass();
		a.init();
		a.print(null);
		
		while (i<1)
		{

			//joystick.joystickButtonChanged(null); 
			if (joystick.getButton(0)){System.out.println("TR"); joystick.getButtonAlt(0);}
			else if(joystick.getButton(1)){System.out.println("O"); joystick.getButtonAlt(1);}  
			else if(joystick.getButton(2)){System.out.println("X"); joystick.getButtonAlt(2);}
			else if(joystick.getButton(3)){System.out.println("|_|"); joystick.getButtonAlt(3);}
			else if(joystick.getButton(4)){System.out.println("L1"); joystick.getButtonAlt(4);}
			else if(joystick.getButton(5)){System.out.println("R1"); joystick.getButtonAlt(5);}
			else if(joystick.getButton(6)){System.out.println("L2"); joystick.getButtonAlt(6);}
			else if(joystick.getButton(7)){System.out.println("R2"); joystick.getButtonAlt(7);}
			else if(joystick.getButton(8)){System.out.println("SELECT"); joystick.getButtonAlt(8);}
			else if(joystick.getButton(9)){System.out.println("START"); joystick.getButtonAlt(9);}
			else if(joystick.getButton(10)){System.out.println("L3"); joystick.getButtonAlt(10);}
			else if(joystick.getButton(11)){System.out.println("R3"); joystick.getButtonAlt(11);}

			if (joystick.getAxis(0)){System.out.println("Up"); joystick.getAxisAlt(0);}
			else if(joystick.getAxis(1)){System.out.println("Dw");joystick.getAxisAlt(1);}
			else if(joystick.getAxis(2)){System.out.println("Lf");joystick.getAxisAlt(2);}
			else if(joystick.getAxis(3)){System.out.println("Rh");joystick.getAxisAlt(3);}
		}
	}
}
