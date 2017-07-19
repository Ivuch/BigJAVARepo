
import java.io.IOException;

import joystick.Joystick;
import joystick.JoystickListener;

public class JoystickControl implements JoystickListener 
{ 
       // Class Constants 
    public final int UP            = 0, 
                     DOWN        = 1, 
                     LEFT        = 2, 
                     RIGHT        = 3, 
                     BUTTON1    = 0, 
                     BUTTON2    = 1, 
                     BUTTON3    = 2, 
                     BUTTON4    = 3,
                     BUTTON5    = 4,
                     BUTTON6    = 5, 
                     BUTTON7    = 6,
                     BUTTON8    = 7,
                     BUTTON9    = 8,
                     BUTTON10    = 9,
                     BUTTON11    = 10,
                     BUTTON12    = 11;
                     
    // Variable members 
    private Joystick pJoy; 
    private int nNumDevices; 
    private boolean abAxis[] = {false, false, false, false}; 
    private boolean abButtons[] = {false, false, false, false, false, false, false, false, false, false,false,false}; 

    //--------------------------------------------------------------- 
    // CONSTRUCTOR 
    //--------------------------------------------------------------- 
    public JoystickControl() 
    { 
        super(); 
        this.pJoy = null; 
        this.nNumDevices = Joystick.getNumDevices(); 
        if (this.nNumDevices > 0) 
        { 
            try 
            { 
                this.pJoy = Joystick.createInstance(); 
                this.pJoy.addJoystickListener(this); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
                this.pJoy = null; 
            } 
        } 
    } 

    //--------------------------------------------------------------- 
    // Is Available 
    //--------------------------------------------------------------- 
    public boolean isAvailable () 
    { 
        return (this.pJoy != null); 
    } 

    //--------------------------------------------------------------- 
    // getAxis (UP, DOWN, LEFT, RIGHT) 
    //--------------------------------------------------------------- 
    public boolean getAxis (int nDir) 
    { 
        return isAvailable() && this.abAxis[nDir]; 
    } 

    //--------------------------------------------------------------- 
    // getAxisAlt (UP, DOWN, LEFT, RIGHT) resets the direction  
    //--------------------------------------------------------------- 
    public boolean getAxisAlt (int nDir) 
    { 
        boolean bRet = isAvailable() && this.abAxis[nDir]; 
        if (bRet) 
            this.abAxis[nDir] = false; 
        return bRet; 
    } 

     
    //--------------------------------------------------------------- 
    // getButton (BUTTON1..4) 
    //--------------------------------------------------------------- 
    public boolean getButton (int nButton) 
    { 
        return isAvailable() && this.abButtons[nButton]; 
    } 

    //--------------------------------------------------------------- 
    // getButtonAlt (BUTTON1..4) resets the button 
    //--------------------------------------------------------------- 
    public boolean getButtonAlt (int nButton) 
    { 
        boolean bRet = isAvailable() && this.abButtons[nButton]; 
        if (bRet) 
            this.abButtons[nButton] = false; 
        return bRet; 
    } 

    //--------------------------------------------------------------- 
    // Event: joystickAxisChanged 
    //--------------------------------------------------------------- 
    public void joystickAxisChanged(Joystick pJoy) 
    { 
        if (this.pJoy != pJoy) 
            return; 
        this.abAxis[UP] = this.pJoy.getY()==-1.0; 
        this.abAxis[DOWN] = this.pJoy.getY()==1.0; 
        this.abAxis[RIGHT] = this.pJoy.getX() == 1.0; 
        this.abAxis[LEFT] = this.pJoy.getX() == -1.0; 
    } 

    //--------------------------------------------------------------- 
    // Event: joystickButtonChanged 
    //--------------------------------------------------------------- 
    public void joystickButtonChanged(Joystick pJoy) 
    { 
        if (this.pJoy != pJoy) 
            return; 
        this.abButtons[BUTTON1] = (this.pJoy.getButtons() & Joystick.BUTTON1) != 0; 
        this.abButtons[BUTTON2] = (this.pJoy.getButtons() & Joystick.BUTTON2) != 0; 
        this.abButtons[BUTTON3] = (this.pJoy.getButtons() & Joystick.BUTTON3) != 0; 
        this.abButtons[BUTTON4] = (this.pJoy.getButtons() & Joystick.BUTTON4) != 0; 
        this.abButtons[BUTTON5] = (this.pJoy.getButtons() & Joystick.BUTTON5) != 0; 
        this.abButtons[BUTTON6] = (this.pJoy.getButtons() & Joystick.BUTTON6) != 0; 
        this.abButtons[BUTTON7] = (this.pJoy.getButtons() & Joystick.BUTTON7) != 0; 
        this.abButtons[BUTTON8] = (this.pJoy.getButtons() & Joystick.BUTTON8) != 0; 
        this.abButtons[BUTTON9] = (this.pJoy.getButtons() & Joystick.BUTTON9) != 0; 
        this.abButtons[BUTTON10] = (this.pJoy.getButtons() & Joystick.BUTTON10) != 0;
        this.abButtons[BUTTON11] = (this.pJoy.getButtons() & Joystick.BUTTON11) != 0;
        this.abButtons[BUTTON12] = (this.pJoy.getButtons() & Joystick.BUTTON12) != 0;
        
    } 

}  